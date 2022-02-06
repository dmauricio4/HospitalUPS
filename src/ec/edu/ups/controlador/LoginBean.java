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
	private Integer id_persona;
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
	
	
	public Sesion getSesion() {
		return sesion;
	}

	public void setSesion(Sesion sesion) {
		this.sesion = sesion;
	}

	public Integer getId_persona() {
		return id_persona;
	}

	public void setId_persona(Integer id_persona) {
		this.id_persona = id_persona;
	}

	public SessionFacade getEjbSesionFacade() {
		return ejbSesionFacade;
	}

	public void setEjbSesionFacade(SessionFacade ejbSesionFacade) {
		this.ejbSesionFacade = ejbSesionFacade;
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

	public void loginUser()  {

		listpersona = ejbPersonaFacade.findbylogin(this.correo, this.password);

		
		
		
		
		String url = null;
		for (Persona persona : listpersona) {
			this.id_persona= persona.getIdPersona();
			this.correo = persona.getCorreo();
			this.rol = persona.getRol(); 
			addMessage("ERROR", " valores de persona >"+persona.getRol());
			FacesContext context = FacesContext.getCurrentInstance();			
			HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();		
			
			try {
				request.login(correo, password);
			} catch (ServletException e) {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login failed!", null));
				//return "signin";
			} 
			

			if (persona.getRol().equals("doctor")) {
				try {

					
					
					//request.getSessionMap().put("rol", persona.getRol());
					
					request.setAttribute("user", persona);		
					
					context.getExternalContext().getSessionMap().put("rol", persona);
					context.getExternalContext().getSession(true);
					context.getExternalContext().setSessionMaxInactiveInterval(5);
					
					//SE APLICA LA CREACION DE SESION
					Sesion se = new Sesion();
					se.setSesion(persona);
					se.setCodigoSesion(ejbSesionFacade.count());
					se.setFechaSesion(new Date());
					se.setSesionActiva(true);
					HttpSession httpSession = (HttpSession) context.getExternalContext().getSession(true);
					se.setHttpSession(httpSession);
					ejbSesionFacade.create(se);
					
					context.getExternalContext().redirect("/HospitalUPS/doctor/templateDoctor.xhtml");

					addMessage("AVISO", "Su cuenta doctor se a creado");
				} catch (Exception e) {
					addMessage("ERROR", " esta con errores");
				}

			}
			if (persona.getRol().equals("secretaria")) {
				try {
					context.getExternalContext().redirect("/HospitalUPS/template/error.html");
					addMessage("AVISO", "Su cuenta doctor se a creado");

				} catch (Exception e) {
					addMessage("ERROR", " esta con errores");
				}
			}
			if (persona.getRol().equals("administrador")) {
				System.out.println("Se aplica el redicionamiento");				try {
					context.getExternalContext().redirect("/HospitalUPS/administrador/error.html");

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

	

	public void cerrarSesion() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath()
						+ "/HospitalUPS/index.html");

	}

}
