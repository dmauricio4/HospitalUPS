package ec.edu.ups.controlador;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.annotation.FacesConfig;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;

import com.sun.istack.internal.logging.Logger;

import ec.edu.ups.ejb.PersonaFacade;
import ec.edu.ups.entidad.Persona;
import ec.edu.ups.entidad.Sesion;

@ManagedBean(name="inicioMb")
@Named
@ViewScoped
public class InicioMb implements Serializable {
	private static final long serialVersionUID = 1L;

	private String titulo = "Gestión de sesiones con JSF";
	private String nomUsuario;
	private String claveUsuario;
	private static final Logger LOG = Logger.getLogger(LoginBean.class);


	@EJB
	private PersonaFacade ejbPersonaFacade;

	private List<Persona> listpersona;
	
	
	public InicioMb() {
		super();
		LOG.info("InicioLogin");

		// TODO Auto-generated constructor stub
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public void loginUser() throws ServletException, IOException {

		listpersona = ejbPersonaFacade.findbylogin(this.nomUsuario, this.claveUsuario);
		String url = null;
		for (Persona persona : listpersona) {
			this.nomUsuario = persona.getCorreo();
			this.claveUsuario = persona.getRol(); 
			FacesContext facesContext = FacesContext.getCurrentInstance();
			 
			InicioMb ini = new InicioMb();
			
			ini.iniciarSesion();
			
			ini.setNomUsuario(persona.getNombres()); 
			ini.setTitulo("Logeado");
			
			if (persona.getRol().equals("doctor")) {
				url = "/doctor/index.html";

			}
			if (persona.getRol().equals("secretaria")) {
				url = "/secretaria/index.html";
			}
			if (persona.getRol().equals("administrador")) {
				System.out.println("Se aplica el redicionamiento");
				url = "/administrador/index.html";
			}
			if (persona.getRol().equals("paciente")) {
				url = "/paciente/index.html";
			}

			FacesContext.getCurrentInstance().getExternalContext().setSessionMaxInactiveInterval(5);
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + url);

			break;
		}
	}

	
	public String iniciarSesion() {
		
		
		
		Sesion.iniciarSesion(FacesContext.getCurrentInstance());
		Sesion.setDatosSesion("nomUsuario", this.nomUsuario);
		System.out.println("valor nombres >"+this.nomUsuario);
		
		return "pagina_inicio?faces-redirect=true";
	}
	 
	public String cerrarSesion() {
		try {
			Sesion.iniciarSesion(FacesContext.getCurrentInstance());
			Sesion.cerrarSesion();
			
			return "index?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
			
			return null;
		}
	}
	
	public String getTitulo() {
		return titulo;
	}

	public String getNomUsuario() {
		return nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

	public String getClaveUsuario() {
		return claveUsuario;
	}

	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
	}
}