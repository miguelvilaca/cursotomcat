package exemplo;

import java.io.*;
import java.sql.*;
import javax.sql.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;

public class ContatosServlet extends HttpServlet
{
    public void doGet(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DataSource ds = null;
        try {
            InitialContext ctx = new InitialContext();
            ds = (DataSource)ctx.lookup(
                "java:comp/env/jdbc/ContatosLocal");
        }
        catch (NamingException ex) {
            throw new ServletException(ex);
        }
        
        List<String[]> contatos = new ArrayList<String[]>();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            con = ds.getConnection();
            String sql = "select nome, email from contatos order by nome";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            
            while (rs.next()) {
                String[] umContato = new String[] {
                    rs.getString("nome"),
                    rs.getString("email"),
                };
                contatos.add(umContato);
            }
        }
        catch (SQLException ex) {
            throw new ServletException(ex);
        }
        finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (con != null) con.close();
            }
            catch (SQLException ex) {
                throw new ServletException(ex);
            }
        }
        
        request.setAttribute("contatos", contatos);
        request.getRequestDispatcher("/contatos.jsp")
            .forward(request, response);
    }
}
