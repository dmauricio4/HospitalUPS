package ec.edu.ups.controlador;
import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.glassfish.api.event.EventListener;

import ec.edu.ups.entidad.Sesion;


public class AutorizacionListener implements EventListener,Serializable, PhaseListener{
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {
		try {
			String paginaActual = event.getFacesContext().getViewRoot().getViewId();
			Sesion.iniciarSesion(event.getFacesContext());
			
			if (!paginaActual.contains("index.html") && Sesion.getEstadoSesion() == false) {				
				FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml?faces-redirect=true");
	
				NavigationHandler nh = event.getFacesContext().getApplication().getNavigationHandler();
				nh.handleNavigation(event.getFacesContext(), null, "index");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void beforePhase(PhaseEvent event) {}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

	@Override
	public void event(Event arg0) {
		// TODO Auto-generated method stub
		
	}

}
