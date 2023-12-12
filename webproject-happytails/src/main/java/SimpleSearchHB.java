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
      String keyword = request.getParameter("keyword");

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n"; //
      out.println(docType + //
    		  "<html>\n" +
                "<head>\n" +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<header>\n" +
                "<h1><center>Pets Database Result</center></h1>\n" +
                "</header>\n" +
                "<nav>\n" +
                "<a href=\"/" + Info.projectName + "/HomePage\">Happy Tails</a> <br>\n" +
                "<a href=\"/" + Info.projectName + "/simpleInsertHB.html\" >Insert Pets</a> <br>\n" +
                "<a href=\"/" + Info.projectName + "/simpleSearchHB.html\" class=\"color-change\">Search Pets</a> <br>\n" +
                "<a href=\"/" + Info.projectName + "/adoptionForm.html\" >Adoption Form</a> <br>\n" +
                "</nav>\n" +
                "<section>\n"
            );
      
      out.println("<ul>");
      
      System.out.println("[DBG] " + keyword);	

      List<Pet> listPets = null;
      if (keyword != null && !keyword.isEmpty()) {
    	  listPets = UtilDB.listPets(keyword);
      } else {
    	  listPets = UtilDB.listPets();
      }
      display(listPets, out);
      out.println("</ul>");
      out.println("<a href=/" + projectName + "/" + searchWebName + ">Back to Search</a> <br>");
      out.println("</body></html>");
   }

   void display(List<Pet> listPets, PrintWriter out) {
	   out.println("<table class='pet-table'>");
	    out.println("<tr><th>ID</th><th>Name</th><th>Age</th><th>Temperament</th><th>Species</th><th>Breed</th><th>Weight</th></tr>");

	    for (Pet pet : listPets) {
	    	System.out.println("[DBG] " + pet.getId() + ", " //
	    			+ pet.getName() + ", " //
	    			+ pet.getAge() + ", " //
	    			+ pet.getTemperament() + ", "
	    			+ pet.getSpecies() + ", "
	    			+ pet.getBreed() + ", "
	    			+ pet.getWeight());
	    	
	        out.println("<tr><td>" + pet.getId() + "</td><td>" //
	                + pet.getName() + "</td><td>" //
	                + pet.getAge() + "</td><td>"
	                + pet.getTemperament() + "</td><td>"
	                + pet.getSpecies() + "</td><td>"
	                + pet.getBreed() + "</td><td>"
	                + pet.getWeight() + "</td></tr>");
	    }

      out.println("</table>");
   }


   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
