package exemplo;

import java.io.*;
import java.sql.*;
import javax.sql.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import java.util.logging.*;


public class ContatosServlet extends HttpServlet
{
    private static Logger log = Logger.getLogger("exemplo.ContatosServlet");
 
    public void doGet(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        log.info("Requsitada lista de contatos");
        
        DataSource ds = null;
        try {
            log.fine("Buscando datasource");
            InitialContext ctx = new InitialContext();
            ds = (DataSource)ctx.lookup(
                "java:comp/env/jdbc/ContatosLocal");
        }
        catch (NamingException ex) {
            log.log(Level.SEVERE, "Erro na busca JNDI", ex);
            throw new ServletException(ex);
        }
        
        List<String[]> contatos = new ArrayList<String[]>();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            log.fine("Conectando ao banco");
            con = ds.getConnection();
            String sql = "select nome, email from contatos order by nome";
            log.fine("Executando consulta SQL");
            st = con.createStatement();
            rs = st.executeQuery(sql);
            
            log.fine("Percorrendo resultado");
            while (rs.next()) {
                log.finest("Acessando registro");
                String[] umContato = new String[] {
                    rs.getString("nome"),
                    rs.getString("email"),
                };
                if (log.isLoggable(Level.FINEST)) {
                    log.finest("Lido contato: "
                        + umContato[0] + "," + umContato[1]);
                }
                contatos.add(umContato);
            }
        }
        catch (SQLException ex) {
            log.log(Level.SEVERE, "Erro de banco na consulta", ex);
            throw new ServletException(ex);
        }
        finally {
            try {
                log.fine("Fechando conexão ao banco");
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (con != null) con.close();
            }
            catch (SQLException ex) {
                log.log(Level.SEVERE, "Erro ao fechar conexão", ex);
                throw new ServletException(ex);
            }
        }
        
       log.fine("Exibindo página de contatos");
       request.setAttribute("contatos", contatos);
        request.getRequestDispatcher("/contatos.jsp")
            .forward(request, response);
    }
}
