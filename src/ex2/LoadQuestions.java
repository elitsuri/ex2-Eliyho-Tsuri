package ex2;
import javax.json.JsonObject;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

/**
 * The type Load Questions .
 * This class getting the vectors questions from text file and transform to questions vector
 */
@WebServlet(name = "LoadQuestions", urlPatterns = {"/LoadQuestions"},
        initParams={@WebInitParam(name="fileText", value="questions.txt")})
public class LoadQuestions extends HttpServlet
{
    private String fileQuestions;
    @Override
    public void init()
    {
        fileQuestions = this.getServletContext().getInitParameter("fileText");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        ServletContext sc = getServletContext();
        log("sadasdasdasd");
        sc.log("sssssss");
        log("jsonA: " + sc.getAttribute("jsonA"));;
        PrintWriter toClient = response.getWriter();
        toClient.println("<HTML>");
        toClient.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
        toClient.print("Your Questions: </br> </br>");
        JsonObject jsonObject = (JsonObject) sc.getAttribute("jsonQ");
        Iterator<String> keys = jsonObject.keySet().iterator();

        while(keys.hasNext())
        {
            String key = keys.next();
            key.replaceAll(" ","");
            toClient.println("<div id='q" + key+ "' > " + key + ". " + jsonObject.get(key) + "</div>");
            String s = String.valueOf(jsonObject.get(key));
            toClient.println("<form method=\"get\" action=\"addAnswer\" >\n" +
                    " <button id=\"addAnswer" + key + "\" >Add Answer</button>\n" +
                    " <input type=\"hidden\" name=\"Number\" value=\"" + key + "\">\n" +
                    " <input type=\"hidden\" name=\"Question\" value=\""
                    + s.replaceAll("\"","") + "\">\n" + " </form>\n" + "<button id=\"show" + key +
                    "\" name=\"n" + key + "\" onclick=myfunction('" + key + "')>Show Answers</button>\n" +
                    "<div style=\"display: none;\" id=\"divAnswers" + key + "\" ></div>\n" + "<br>" + "</br>");
        }
        toClient.println("<br/>");
        toClient.println("</body></html>");
    }
}