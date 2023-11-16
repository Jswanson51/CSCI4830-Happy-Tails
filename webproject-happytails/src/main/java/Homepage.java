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
		
		//Prints the homepage title and motto.
		response.getWriter().append("<h1><center>Happy Tails</center></h1>");
		response.getWriter().append("<h3><center>Where all animals find happy homes!</center></h3>");
		
	    //Displays all pets in database
		response.setContentType("text/html");

	     display(response.getWriter());
	}

	 void display(PrintWriter out) {
		 String title = "Pets Looking for Homes:";
	     String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
	            "transitional//en\">\n"; //
	      out.println(docType + //
	            "<html>\n" + //
	            "<style>\n" + //
	            "h1 { font-family:Arial, sans-serif; color: #AC3B61; font-size: 45px; }" +
	            "h3 { font-family:Arial, sans-serif; color: #123C69; }" +
	            "h4 { font-family:Arial, sans-serif; color: #FF9999; }" +
	            "li { border: 1px solid #000; margin: 5px; padding: 5px; width: 300px }" +
	            "</style>\n" +
	            "<h4><left>" + title + "</left></h4>\n" + //
	            "<body bgcolor=\"#eee2dc\">\n" //
	            );
	      out.println("<ul>");
	      List<Pet> listPets = UtilDB.listPets();
	      for (Pet pet : listPets) {
	    	  System.out.println("[DBG] " + pet.getId() + ", " //
	    			+ pet.getName() + ", " //
	    			+ pet.getAge() + ", " //
	    			+ pet.getTemperament() + ", "
	    			+ pet.getSpecies() + ", "
	    			+ pet.getBreed() + ", "
	    			+ pet.getWeight());
	
	    	  out.println("<li>" + pet.getId() + ", " //
	    		   + pet.getName() + ", " //
		           + pet.getAge() + ", " //
		           + pet.getTemperament() + ", "
		           + pet.getSpecies() + ", "
		           + pet.getBreed() + ", "
		           + pet.getWeight() + "</li>");
	    }
	    out.println("<a href=/" + Info.projectName + "/" + Info.insertWebName + ">Insert Pets</a> <br>");
	 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}