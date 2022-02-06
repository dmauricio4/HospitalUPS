package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import ec.edu.ups.entidad.Persona;

/**
 * @author ADMINX
 *
 */
@ManagedBean
@ViewScoped
public class VerificarSesionBean implements Serializable {
	
	 
	public void verificarSessionDoc() {
		FacesContext context = FacesContext.getCurrentInstance(); 
		
		Persona persona = (Persona)context.getExternalContext().getSessionMap().get("rol"); 
		
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();  		       
        Persona persona2 = (Persona) request.getAttribute("user");
        
		
        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();  

		Persona persona3 = (Persona)extContext.getSessionMap().get("rol"); 

		try {

			//context.getExternalContext().redirect("/HospitalUPS/index.html");
			
			//persona3.getRol().equalsIgnoreCase("doctor")||persona2.getRol().equalsIgnoreCase("doctor")||
            
            if(persona3.getRol().equalsIgnoreCase("doctor")&&persona2.getRol().equalsIgnoreCase("doctor") && persona.getRol()=="doctor") {

				context.getExternalContext().redirect("/HospitalUPS/doctor/templateDoctor.xhtml");
            	System.out.println("El Usuario doctor esta logeado");
            }else {
				context.getExternalContext().redirect("/HospitalUPS/index.html");

            	
            } 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	 

}
