package ec.edu.ups.controlador;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
//import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Named;
import javax.servlet.ServletException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.faces.application.ConfigurableNavigationHandler;

import javax.faces.event.ComponentSystemEvent;
import ec.edu.ups.ejb.PersonaFacade;
import ec.edu.ups.ejb.SessionFacade;
import ec.edu.ups.entidad.Persona;
import ec.edu.ups.entidad.Sesion;

import com.sun.istack.logging.Logger;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)

@Named
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = Logger.getLogger(LoginBean.class);

	@EJB
	private PersonaFacade ejbPersonaFacade;

	private List<Persona> listpersona;

	public String correo;
	public String rol;
	private String password;

	private HttpServletRequest request;
	private HttpServletResponse response;
	private Sesion sesion;
	@EJB
	private SessionFacade ejbSesionFacade;

	private int count;

	public LoginBean() {
		super();

		LOG.info("Cuenta de login Inicializando");
		// TODO Auto-generated constructor stub
		count = 0;
	}

	@PostConstruct
	public void init() {
		sesion = new Sesion();
	}

	public void addMessage(String summary, String detail) {
		System.out.println(summary + "<<>>" + detail);

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail));
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void countActionVoid() {
		LOG.info("CountBean#countActionVoid() - Increasing counter ...");
		count++;
	}

	public String countActionAndForward() {
		LOG.info("CountBean#countActionAndForward() - Increasing counter ...");
		count++;
		return "count";
	}

	public String countActionAndRedirect() {
		LOG.info("CountBean#countActionAndRedirect() - Increasing counter ...");
		count++;
		return "count?faces-redirect=true;";
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public PersonaFacade getEjbPersonaFacade() {
		return ejbPersonaFacade;
	}

	public void setEjbPersonaFacade(PersonaFacade ejbPersonaFacade) {
		this.ejbPersonaFacade = ejbPersonaFacade;
	}

	public List<Persona> getListpersona() {
		return listpersona;
	}

	public void setListpersona(List<Persona> listpersona) {
		this.listpersona = listpersona;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void loginUser() throws ServletException, IOException {

		listpersona = ejbPersonaFacade.findbylogin(this.correo, this.password);
		
		String url = null;
		for (Persona persona : listpersona) {
			this.correo = persona.getCorreo();
			this.rol = persona.getRol();
			System.out.println("-----------login user con rol de >"+persona.getRol());

			addMessage("ERROR", " valores de persona >"+persona.getRol());
			
			Sesion se = new Sesion();
			
			FacesContext context = FacesContext.getCurrentInstance();
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("rol", persona.getRol());
			FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			FacesContext.getCurrentInstance().getExternalContext().setSessionMaxInactiveInterval(5);

			
			se.setSesion(persona);
			se.setCodigoSesion(ejbSesionFacade.count());
			se.setFechaSesion(new Date());
			se.setSesionActiva(true);
			HttpSession httpSession = (HttpSession) context.getExternalContext().getSession(true);

			se.setHttpSession(httpSession);
			ejbSesionFacade.create(se);

			if (persona.getRol().equals("doctor")) {
				try {
					context.getExternalContext().redirect("/HospitalUPS/doctor/index.html");

					addMessage("AVISO", "Su cuenta doctor se a creado");
				} catch (Exception e) {
					addMessage("ERROR", " esta con errores");
				}

			}
			if (persona.getRol().equals("secretaria")) {
				try {
					context.getExternalContext().redirect("/HospitalUPS/template/templateIndexSecre.xhtml");
					addMessage("AVISO", "Su cuenta doctor se a creado");

				} catch (Exception e) {
					addMessage("ERROR", " esta con errores");
				}
			}
			if (persona.getRol().equals("administrador")) {
				System.out.println("Se aplica el redicionamiento");				try {
					context.getExternalContext().redirect("/HospitalUPS/administrador/index.html");

					addMessage("AVISO", "Su cuenta doctor se a creado");
				} catch (Exception e) {
					addMessage("ERROR", " esta con errores");
				}
			}
			if (persona.getRol().equals("paciente")) {
				url = "/HospitalUPS/paciente/index.html";
			}
			FacesContext.getCurrentInstance().getExternalContext().setSessionMaxInactiveInterval(5);
			break;
		}
	}

	public void cerrarSesion() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
						+ "/HospitalUPS/index.html");

	}

}
