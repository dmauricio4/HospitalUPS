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
			Persona cliente = (Persona) context.getExternalContext().getSessionMap().get("user");
            System.out.println("Personaa---:"+cliente);
			if (cliente == null) {
				context.getExternalContext().redirect("index.html");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	 

}
