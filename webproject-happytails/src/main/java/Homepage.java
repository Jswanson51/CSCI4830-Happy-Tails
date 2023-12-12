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
/**
 * Servlet implementation class Homepage
 */
@WebServlet("/HomePage")
public class Homepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Homepage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	    //Displays all pets in database
		response.setContentType("text/html");

	     display(response.getWriter());
	     
	 }

	 void display(PrintWriter out) {
	     String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
	            "transitional//en\">\n"; //
	      out.println(docType + //
	    		  "<html>\n" +
	                "<head>\n" +
	                "<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n" +
	                "</head>\n" +
	                "<body>\n" +
	                "<header>\n" +
	                "<h1><center>Homepage</center></h1>\n" +
	                "<h3><center>Where all animals find happy homes!</center></h3>\n" +
	                "</header>\n" +
	                "<nav>\n" +
	                "<a href=\"/" + Info.projectName + "/HomePage\" class=\"color-change\">Happy Tails</a> <br>\n" +
	                "<a href=\"/" + Info.projectName + "/simpleInsertHB.html\" >Insert Pets</a> <br>\n" +
	                "<a href=\"/" + Info.projectName + "/simpleSearchHB.html\" >Search Pets</a> <br>\n" +
	                "<a href=\"/" + Info.projectName + "/adoptionForm.html\" >Adoption Form</a> <br>\n" +
	                "</nav>\n" +
	                "<section>\n"
	            );
	      
	      out.println("<div class=\"pet-tile-container\">"); // Add a container for the pet tiles
	      List<Pet> listPets = UtilDB.listPets();
	      for (Pet pet : listPets) {
	          out.println("<div class=\"pet-tile\">"); // Add a class for styling the pet tile
	          out.println("<h4><i>" + pet.getId() + "</i>  |   " + pet.getName() + "</h4>");
	          out.println("<ul>");
	          out.println("<li>Age: " + pet.getAge() + "</li>");
	          out.println("<li>Temperament: " + pet.getTemperament() + "</li>");
	          out.println("<li>Species: " + pet.getSpecies() + "</li>");
	          out.println("<li>Breed: " + pet.getBreed() + "</li>");
	          out.println("<li>Weight: " + pet.getWeight() + "</li>");
	          out.println("</ul>");
	          out.println("</div>");
	      }
	      out.println("</div>"); // Close the container
	 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}