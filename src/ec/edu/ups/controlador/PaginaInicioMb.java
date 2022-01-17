/**
 * 
 */
package ec.edu.ups.controlador;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.annotation.FacesConfig;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;

import ec.edu.ups.entidad.Persona;
import ec.edu.ups.entidad.Sesion;
 

@ManagedBean
@ViewScoped
public class PaginaInicioMb implements Serializable {
	public String nomUsuario;
	
	
	 

	public void verificarSession() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			Persona cliente = (Persona) context.getExternalContext().getSessionMap().get("cliente");

			if (cliente == null) {
				context.getExternalContext().redirect("index.html");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	
	
	public void checkLogin(ComponentSystemEvent event) {
		Sesion se = new Sesion();
		System.out.println("Se aplica la condicion si esta login true"+se.getSesionActiva());
		if (!se.getSesionActiva()) {
			FacesContext context = FacesContext.getCurrentInstance();
			ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler) context.getApplication()
					.getNavigationHandler();
			handler.performNavigation("login");
		}
	}

	
	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}
	public String getNomUsuario() { return this.nomUsuario; }
}
