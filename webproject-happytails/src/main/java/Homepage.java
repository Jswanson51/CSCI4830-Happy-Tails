import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Pet;
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
		
		//Prints the homepage title and motto.
		response.getWriter().append("<h1 style=\"font-family:verdana\"><center>Happy Tails</center></h1>");
		response.getWriter().append("<h4 style=\"font-family:verdana\"><center>Where all animals find happy homes!</center></h4>");
		
	    //Displays all pets in database
		response.setContentType("text/html");

	      // #1
		UtilDB.createPets("Spot", "11", "Energetic", "Dog", "Dalmatian", "25lbs");
	    UtilDB.createPets("Fluffy", "3", "Calm", "Cat", "Persian", "12lbs");
	      
	      // #2
	     display(response.getWriter());
	 }

	 void display(PrintWriter out) {
		 String title = "Pets Looking for Homes:";
	     String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
	            "transitional//en\">\n"; //
	      out.println(docType + //
	            "<html>\n" + //
	            "<h4 style=\\\"font-family:verdana\\\"><center>" + title + "</center></h4>\n" + //
	            "<body bgcolor=\"#f0f0f0\">\n" //
	            );
	      out.println("<ul>");
	      List<Pet> listPets = UtilDB.listPets();
	      for (Pet pet : listPets) {
	    	  System.out.println("[DBG] " + pet.getId() + ", " //
	    			+ pet.getName() + ", " //
	    			+ pet.getAge() + ", " //
	    			+ pet.getTemperament() + ","
	    			+ pet.getSpecies() + ","
	    			+ pet.getBreed() + ","
	    			+ pet.getWeight());
	
	    	  out.println("<li>" + pet.getId() + ", " //
	    		   + pet.getName() + ", " //
		           + pet.getAge() + ", " //
		           + pet.getTemperament() + ","
		           + pet.getSpecies() + ","
		           + pet.getBreed() + ","
		           + pet.getWeight() + "</li>");
	    }
	 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}