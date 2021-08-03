package ex2;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * The type Json answers.
 * This class getting the vectors answers and transform to json
 */
@WebServlet( name="JsonAnswers", urlPatterns = "/JsonAnswers")
public class JsonAnswers extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String number = request.getParameter("Number");
        JsonObject jsonObject = (JsonObject) getServletContext().getAttribute("jsonA");
        JsonObject jo = (JsonObject) jsonObject.get(number);
        log("JsonAnswers" + jo);
        try (OutputStream out = response.getOutputStream())
        {
            JsonWriter jsonw = Json.createWriter(out);
            jsonw.write(jo);
            jsonw.close();
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doGet(request, response);
    }
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }
}
