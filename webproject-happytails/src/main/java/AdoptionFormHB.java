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

@WebServlet("/AdoptionFormHB")
public class AdoptionFormHB extends HttpServlet implements Info {
   private static final long serialVersionUID = 1L;

   public AdoptionFormHB() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String petId = request.getParameter("petId");
      String petName = request.getParameter("petName");

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
                "<h1><center>Adoption Form</center></h1>\n" +
                "</header>\n" +
                "<nav>\n" +
                "<a href=\"/" + Info.projectName + "/HomePage\">Happy Tails</a> <br>\n" +
                "<a href=\"/" + Info.projectName + "/simpleInsertHB.html\" >Insert Pets</a> <br>\n" +
                "<a href=\"/" + Info.projectName + "/simpleSearchHB.html\" >Search Pets</a> <br>\n" +
                "<a href=\"/" + Info.projectName + "/adoptionForm.html\" class=\"color-change\">Adoption Form</a> <br>\n" +
                "</nav>\n" +
                "<section>\n"
            );
      
      out.println("<ul>");
      
      if (petId != null && !petId.isEmpty()) {
    	    try {
    	        int id = Integer.parseInt(petId);
    	        boolean success = UtilDB.deletePet(id);

                if (success) {
                    out.println("<h3>Pet with ID " + id + " deleted successfully.</h3>");
                } else {
                    out.println("<h3>Error deleting Pet with ID " + id + ". Pet not found.</h3>");
                }
            } catch (NumberFormatException e) {
                out.println("<h3>Error: Invalid Pet ID format.</h3>");
            }
        } else {
            out.println("<h3>Error: Please provide a valid Pet ID.</h3>");
        }
      
      out.println("</ul>");
      out.println("<a href=/" + projectName + "/" + adoptionWebName + ">Back to Adoption Form</a> <br>");
      out.println("</body></html>");
   }


   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
