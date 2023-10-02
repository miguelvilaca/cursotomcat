package exemplo;

import java.io.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;

public class SaudacaoServlet extends HttpServlet
{
    // a assinatura do método deve ser exatamente esta!    
    public void doGet(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // gera a página
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head>");
        out.println("<meta http-equiv=\"content-type\" "+
            " content=\"text/html; charset=UTF-8\">");
        out.println("</head><body>");

        // obtém o nome da torcida via JNDI
        String saudacao = "";
        try {
            InitialContext ctx = new InitialContext();
            saudacao = (String)ctx.lookup(
                "java:comp/env/saudacao");
        }
        catch (NamingException ex) {
            throw new ServletException(ex);
        }

        // gera o restante da página
        out.println("<h1>Saudações " + saudacao + "!</h1>");
        out.println("</body></html>");
        out.close();
    }
}
