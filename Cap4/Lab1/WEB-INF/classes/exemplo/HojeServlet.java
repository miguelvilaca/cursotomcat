package exemplo;

import java.io.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HojeServlet extends HttpServlet
{
    // a assinatura do método deve ser exatamente esta!    
    public void doGet(
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // formata a data de hoje
        DateFormat df = DateFormat.getDateInstance();
        String hoje = df.format(new Date());
        
        // gera a página
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><head>");
        out.println("<meta http-equiv=\"content-type\" "+
            " content=\"text/html; charset=UTF-8\">");
        out.println("</head><body>");
        out.println("<h1>Servlet</h1>");
        out.println("<h1>Hoje é dia " + hoje + "</h1>");
        out.println("</body></html>");
        out.close();
    }
}
