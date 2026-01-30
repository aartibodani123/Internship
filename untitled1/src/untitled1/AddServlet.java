package untitled1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class AddServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int a = Integer.parseInt(req.getParameter("num1"));
        int b = Integer.parseInt(req.getParameter("num2"));

        int sum = a + b;

        PrintWriter out = resp.getWriter();
        out.println("<h1>Sum is: " + sum + "</h1>");
    }
}
