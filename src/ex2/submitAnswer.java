package ex2;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * The type Submit answer.
 * This class submit the answer's from the user's to URL web
 */
@WebServlet( name="submitAnswer", urlPatterns = "/submitAnswer")
public class submitAnswer extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("listQuestions.html").include(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String num = req.getParameter("num");
        String ans = req.getParameter("ans");
        String name = req.getParameter("name");
        String Number = (String) getServletContext().getAttribute("Number");
        log("msgggg do post" + Number);
        JsonObject jo = (JsonObject) getServletContext().getAttribute("jsonA");
        Answer answer = new Answer(ans,name);
        JsonObject jsonObject = answerToJson(answer).build();
        jo = jsonObjectToBuilder(jo).add(Number, jsonObject).build();
        getServletContext().setAttribute("jsonA",jo);
        log("msgggg" + jo.toString());
        req.getRequestDispatcher("./listQuestions.html").forward(req,resp);
    }
    private JsonObjectBuilder jsonObjectToBuilder(JsonObject jo)
    {
        JsonObjectBuilder job = Json.createObjectBuilder();
        if(jo != null)
        {
            for (Map.Entry<String, JsonValue> entry : jo.entrySet())
                job.add(entry.getKey(), entry.getValue());
        }
        return job;
    }
    /**
     * Answer to json json object builder.
     *
     * @param answer the answer
     * @return the json object builder
     */
    public JsonObjectBuilder answerToJson(Answer answer)
    {
        JsonObjectBuilder job = Json.createObjectBuilder();
        job.add("name",answer.getName())
                .add("theAnswer",answer.getTheAnswer())
                .add("idQ",answer.getIdQ());
        return job;
    }
}