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
	
	public void verificarSessionSecre() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();

			HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();  
			//STRING ROL
			Persona persona = (Persona)context.getExternalContext().getSessionMap().get("rol");
			System.out.println("Se imprime el valor a verificar  > "+persona);
			
            System.out.println("Personaa---:"+persona);
			
            
            ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
            
            
            FacesContext contextf = FacesContext.getCurrentInstance();
    		HttpServletRequest requestf = (HttpServletRequest) context.getExternalContext().getRequest();

            if(requestf.getAttribute("user").equals("secretaria")|| persona.getRol().equalsIgnoreCase("secretaria")) {
            	System.out.println("El Usuario doctor esta logeado");
            }else {
				context.getExternalContext().redirect("/HospitalUPS/index.html");

            	
            } 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void verificarSessionDoc() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();

			HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();  
			//STRING ROL
			Persona persona = (Persona)context.getExternalContext().getSessionMap().get("rol");
			System.out.println("Se imprime el valor a verificar  > "+persona);
			
            System.out.println("Personaa---:"+persona);
			
            
            ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();
            
            
            FacesContext contextf = FacesContext.getCurrentInstance();
    		HttpServletRequest requestf = (HttpServletRequest) context.getExternalContext().getRequest();

            if(requestf.getAttribute("user").equals("doctor")|| persona.getRol().equalsIgnoreCase("doctor")) {
            	System.out.println("El Usuario doctor esta logeado");
            }else {
				context.getExternalContext().redirect("/HospitalUPS/index.html");

            	
            } 
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	 

}
