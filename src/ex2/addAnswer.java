package ex2;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * The type Add answer.
 * This class getting the answer from the text
 * file and transform the text to URL
 */
@WebServlet( name="addAnswer", urlPatterns = "/addAnswer/*")
public class addAnswer extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String q = request.getParameter("Question");
        String n = request.getParameter("Number");
        getServletContext().setAttribute("Number",n);
        if (n == null)
            out.println("Hmm... seems like you visited this Servlet directly ");
        else
            out.println("<div>" + n + ". " + q + "<br> <br/>");
        if (q == null)
            out.println("Hmm... seems like you visited this Servlet directly ");
        else
            request.setAttribute("q",q);
        request.setAttribute("n",n);
        request.getRequestDispatcher("addAnswer.html").include(request, response);
        out.close();
    }
}
