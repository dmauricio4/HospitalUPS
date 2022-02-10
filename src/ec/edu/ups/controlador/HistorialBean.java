package ec.edu.ups.controlador;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.edu.ups.ejb.CitaFacade;
import ec.edu.ups.ejb.HistorialFacade;
import ec.edu.ups.ejb.PersonaFacade; 
import ec.edu.ups.entidad.Cita;
import ec.edu.ups.entidad.Historial;
import ec.edu.ups.entidad.Persona;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class HistorialBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private HistorialFacade ejbHistorialFacade;
	
	private List<Historial>  historiales;
 
	private Historial historial;
	  
	private Integer idHistorial;

	private String orden;

	private String receta;
  
	private Cita cita;
	
	private Integer id_cita;
	
	@EJB
	private CitaFacade ejbCitaFacade;
	

	
	
	public HistorialBean() {

	}

	@PostConstruct
	public void init() {
		historiales = ejbHistorialFacade.findAll();
		cita= new Cita();
		historial = new Historial();
		
	}
  	
	
	

	public Integer getId_cita() {
		return id_cita;
	}

	public void setId_cita(Integer id_cita) {
		this.id_cita = id_cita;
	}

	public HistorialFacade getEjbHistorialFacade() {
		return ejbHistorialFacade;
	}

	public void setEjbHistorialFacade(HistorialFacade ejbHistorialFacade) {
		this.ejbHistorialFacade = ejbHistorialFacade;
	}

	public List<Historial> getHistoriales() {
		return historiales;
	}

	public void setHistoriales(List<Historial> historiales) {
		this.historiales = historiales;
	}

	public Historial getHistorial() {
		return historial;
	}

	public void setHistorial(Historial historial) {
		this.historial = historial;
	}

	public Integer getIdHistorial() {
		return idHistorial;
	}

	public void setIdHistorial(Integer idHistorial) {
		this.idHistorial = idHistorial;
	}

	public String getOrden() {
		return orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}

	public String getReceta() {
		return receta;
	}

	public void setReceta(String receta) {
		this.receta = receta;
	}

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}
	
	

 
	
	 
 

	public CitaFacade getEjbCitaFacade() {
		return ejbCitaFacade;
	}

	public void setEjbCitaFacade(CitaFacade ejbCitaFacade) {
		this.ejbCitaFacade = ejbCitaFacade;
	}

	
	
	public String buscarHistorialCita() {
		
		System.out.println("Se ejecuta el aajaz para selecionar citas e historial---------");
		
		historiales= new ArrayList<Historial>();
		historiales= ejbHistorialFacade.findAll();
		for (Historial historial : historiales) {
			Cita cita1 = historial.getCita();
			System.out.println("------------ recore lista");
			if(cita1.getIdCita()==cita.getIdCita())
			{
				System.out.println("Valr de condicion---"+historial.toString());
				this.orden= historial.getOrden();
				this.receta= historial.getReceta();
				
			}
			
		}
		
		
		return null;
	}
	
	public String guardar() {
		
		Historial historial1= new Historial();		 
		cita=ejbCitaFacade.find(this.id_cita);	
		
		historial1.setCita(cita);
		historial1.setOrden(orden);
		historial1.setReceta(receta);
		 
		ejbHistorialFacade.create(historial1);	
		
		historiales = ejbHistorialFacade.findAll();
		 
		 
		 this.id_cita =0;
		 this.orden = "";
		 this.receta="";
		 
		
		return null;
	}
 
	public String actualizar() {
		
		historiales = ejbHistorialFacade.findAll();		
		Cita cita2 = new Cita();
		Historial historial1= new Historial();		
		cita=ejbCitaFacade.find(this.id_cita);
		for (Historial historial : historiales) {			
			cita2 =historial.getCita();
			if(cita2.getIdCita().equals(cita.getIdCita())) {
				historial.setCita(cita2);
				historial.setOrden(this.orden);
				historial.setReceta(this.receta);	

				ejbHistorialFacade.edit(historial);
 
				break;
			}
			
			
		}
		
		
		historiales = ejbHistorialFacade.findAll();

		 this.id_cita =0;
		this.orden="";
		this.receta="";
		return null;
	}
 
	

}