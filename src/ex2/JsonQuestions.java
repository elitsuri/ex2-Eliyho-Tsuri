package ex2;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The type Json questions.
 * This class getting the vectors questions and transform to json
 */
@WebServlet(name = "JsonQuestions", urlPatterns = {"/JsonQuestions"})
public class JsonQuestions extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        ServletContext sc = getServletContext();
        int numline = 1;
        JsonObjectBuilder builder = Json.createObjectBuilder();
        sc.log("asdasdsa");
        try (BufferedReader br = new BufferedReader(new FileReader(sc.getRealPath("fileText/questions.txt"))))
        {
            for (String line; (line = br.readLine()) != null;  )
            {
                builder.add(numline+"",line);
                numline++;
            }
        }
        JsonObject jsonObject = builder.build();
        sc.setAttribute("jsonQ",jsonObject);
        log("jsonQ: "+ jsonObject.toString());
        resp.sendRedirect("listQuestions.html");
    }
}
