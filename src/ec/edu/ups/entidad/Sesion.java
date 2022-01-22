package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.Enumeration;

import com.sun.istack.logging.Logger;
import javax.faces.context.FacesContext;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.http.HttpSession;


@Entity
public class Sesion implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int codigoSesion;
	private static HttpSession httpSession;
	private static Boolean sesionActiva;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaSesion; 

	@JoinColumn
	@ManyToOne
	private Persona sesion;
 

	
	public Sesion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCodigoSesion() {
		return codigoSesion;
	}

	public void setCodigoSesion(int codigoSesion) {
		this.codigoSesion = codigoSesion;
	}

	public Date getFechaSesion() {
		return fechaSesion;
	}

	public void setFechaSesion(Date fechaSesion) {
		this.fechaSesion = fechaSesion;
	}

 

	public Persona getSesion() {
		return sesion;
	}

	public void setSesion(Persona sesion) {
		this.sesion = sesion;
	}

	public static HttpSession getHttpSession() {
		return httpSession;
	}

	public   void setHttpSession(HttpSession httpSession) {
		Sesion.httpSession = httpSession;
	}

	public static  void iniciarSesion(FacesContext fc) {
		httpSession = (HttpSession) fc.getExternalContext().getSession(false);
		System.out.println("Se inicia la sesion-----> " + httpSession);
	}

	public static   void setDatosSesion(String nomObjeto, Object objeto) {
		try {
			if (httpSession.getId() != null && !httpSession.getId().isEmpty()) {
				sesionActiva = true;
				httpSession.setAttribute(nomObjeto, objeto);
				httpSession.setAttribute("sesionActiva", sesionActiva);
				System.out.println("Se aplica la creacion de Sesion : " + httpSession.getAttribute("sesionActiva"));
			} else {
				sesionActiva = false;
				httpSession.setAttribute("sesionActiva", sesionActiva);
				System.out.println(
						"Se aplica el error en la creacion de Sesion : " + httpSession.getAttribute("sesionActiva"));

				throw new Exception("Error en el inicio de sesión");
			}
		} catch (Exception e) {
			httpSession.invalidate();
			e.printStackTrace();
		}
	}
	public static   void cerrarSesion() {
		Enumeration<String> atributos = null;

		try {
			if (httpSession != null && httpSession.getId() != null && !httpSession.getId().isEmpty()) {
				sesionActiva = false;

				atributos = httpSession.getAttributeNames();

				while (atributos.hasMoreElements()) {
					String atributo = atributos.nextElement();

					httpSession.removeAttribute(atributo);
				}

				httpSession.invalidate();
			} else {
				throw new Exception("Error en el cierre de sesión");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public   Object getDatosSesion(String dato) {
		if (httpSession != null && httpSession.getId() != null && !httpSession.getId().isEmpty()) {
			httpSession.setAttribute("sesionActiva", sesionActiva);

			return httpSession.getAttribute(dato);
		} else {
			return null;
		}
	}

	public static   Boolean getEstadoSesion() {
		if (httpSession != null && httpSession.getId() != null && !httpSession.getId().isEmpty()
				&& httpSession.getAttribute("sesionActiva") != null) {
			return Boolean.parseBoolean(httpSession.getAttribute("sesionActiva").toString());
		} else {
			return false;
		}
	}

	public   Boolean getSesionActiva() {
		return sesionActiva;
	}

	public   void setSesionActiva(Boolean sesionActiva) {
		Sesion.sesionActiva = sesionActiva;
	}

 
}