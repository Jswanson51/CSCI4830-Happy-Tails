import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Pet;
import util.Info;
import util.UtilDB;

@WebServlet("/SimpleSearchHB")
public class SimpleSearchHB extends HttpServlet implements Info {
   private static final long serialVersionUID = 1L;

   public SimpleSearchHB() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String keyword = request.getParameter("keyword").trim();

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

      List<Pet> listPets = null;
      if (keyword != null && !keyword.isEmpty()) {
    	  listPets = UtilDB.listPets(keyword);
      } else {
    	  listPets = UtilDB.listPets();
      }
      display(listPets, out);
      out.println("</ul>");
      out.println("<a href=/" + projectName + "/" + searchWebName + ">Search Pets</a> <br>");
      out.println("</body></html>");
   }

   void display(List<Pet> listPets, PrintWriter out) {
	  out.println("<table class='pet-table'>");
      out.println("<tr><th>ID</th><th>Name</th><th>Age</th><th>Temperament</th><th>Species</th><th>Breed</th><th>Weight</th></tr>");
      
      for (Pet pet : listPets) {
    	  System.out.println("[DBG] " + pet.getId() + ", " //
    			+ pet.getName() + ", " //
    			+ pet.getAge() + ", " //
    			+ pet.getSpecies() + ", "
    			+ pet.getBreed() + ", "
    			+ pet.getTemperament() + ", "
    			+ pet.getWeight());

    	  out.println("<li>" + pet.getId() + ", " //
    		   + pet.getName() + ", " //
	           + pet.getAge() + ", " //
	           + pet.getSpecies() + ", "
	           + pet.getBreed() + ", "
	           + pet.getTemperament() + ", "
	           + pet.getWeight() + "</li>");
    }
      out.println("</table>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
