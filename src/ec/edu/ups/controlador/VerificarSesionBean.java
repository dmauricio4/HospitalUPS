package ec.edu.ups.controlador;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
 
import ec.edu.ups.entidad.Persona;

/**
 * @author ADMINX
 *
 */
@ManagedBean
@ViewScoped
public class VerificarSesionBean implements Serializable {
	
	public void verificarSession() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			//STRING ROL
			String persona = (String)context.getExternalContext().getSessionMap().get("rol");
			System.out.println("Se imprime el valor a verificar  > "+persona);
			
            System.out.println("Personaa---:"+persona);
			
            if (persona == null) {
				context.getExternalContext().redirect("/HospitalUPS/index.html");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	 

}
