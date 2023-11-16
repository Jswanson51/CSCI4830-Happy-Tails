import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Info;
import util.UtilDB;

@WebServlet("/SimpleInsertHB")
public class SimpleInsertHB extends HttpServlet implements Info {
   private static final long serialVersionUID = 1L;

   public SimpleInsertHB() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String name = request.getParameter("name").trim();
      String age = request.getParameter("age").trim();
      String species = request.getParameter("species").trim();
      String breed = request.getParameter("breed").trim();
      String temperament = request.getParameter("temperament").trim();
      String weight = request.getParameter("weight").trim();
      
      UtilDB.createPets(name, age, species, breed, temperament, weight);

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Database Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");
      out.println("<li> Name: " + name);
      out.println("<li> Age: " + age);
      out.println("<li> Species: " + species);
      out.println("<li> Breed: " + breed);
      out.println("<li> Temperament: " + temperament);
      out.println("<li> Weight: " + weight);
      out.println("</ul>");
      out.println("<a href=/" + projectName + "/" + searchWebName + ">Search Pets</a> <br>");
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
