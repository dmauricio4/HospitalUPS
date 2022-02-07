package ec.edu.ups.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.ejb.PersonaFacade;
import ec.edu.ups.entidad.Persona;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PersonaFacade ejbPersonaFacade;
	
	private List<Persona> listpersona;
	private Integer id_persona;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() { 
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String url = null;
		String rol = "";  
		
		listpersona = ejbPersonaFacade.findbylogin(email,password);		
		for (Persona persona : listpersona) {
			this.id_persona= persona.getIdPersona();
			email = persona.getCorreo();
						if (persona.getRol().equalsIgnoreCase("doctor")) {	
				HttpSession session = request.getSession(true);
				session.setAttribute("persona", persona);				 	
					url="./doctor/templateDoctor.xhtml";	  					
			}else if (persona.getRol().equalsIgnoreCase("secretaria")) {
				 url="./template/error.html";
			}
			if (persona.getRol().equalsIgnoreCase("administrador")) {
				url="./administrador/error.html";	
			}
			if (persona.getRol().equalsIgnoreCase("paciente")) {
				url = "./paciente/error.html";
			}
			
			break;					
		}	 
		request.getRequestDispatcher(url).forward(request, response);
		 

	}

}
