import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
    public LoginServlet(){
        System.out.println("LoginServlet 构造方法 被调用");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String password = request.getParameter("password");


        if ("admin".equals(name) && "123".equals(password))
            request.getRequestDispatcher("success.html").forward(request, response);
        else
            response.sendRedirect("fail.html");

    }

}