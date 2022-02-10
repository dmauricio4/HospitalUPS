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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import ec.edu.ups.ejb.CitaFacade;
import ec.edu.ups.ejb.PersonaFacade;
import ec.edu.ups.entidad.Cita;
import ec.edu.ups.entidad.Persona;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class PersonaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private PersonaFacade ejbCategoryFacade;
	private List<Persona> list;
	private String descripcion;
	private String cedula;
	private String nombres;
	private String apellidos;
	private String direccion;
	private String telefono;
	private String correo;
	private String rol;
	private String password;	
	private Integer id_persona;

	@EJB
	private CitaFacade ejbCitaFacade;
	private List<Cita> citas;
	private Integer idCita;
	private String comentarioCita;
	private BigDecimal costo;
	private String estadoCita;
	private Date fechaCita;
	private String sintomatologia;
	private Cita cita;

	private Persona doctorEspecialidad;

	private Persona pacientePersona;

	public PersonaBean() {

	}

	@PostConstruct
	public void init() {
		list = ejbCategoryFacade.findAll(); 
		
		citas= ejbCitaFacade.findAll();
		
	}
	

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

	public Persona[] getList() {
		return list.toArray(new Persona[0]);
	}

	public void setList(List<Persona> list) {
		this.list = list;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public PersonaFacade getEjbCategoryFacade() {
		return ejbCategoryFacade;
	}

	public void setEjbCategoryFacade(PersonaFacade ejbCategoryFacade) {
		this.ejbCategoryFacade = ejbCategoryFacade;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

	public CitaFacade getEjbCitaFacade() {
		return ejbCitaFacade;
	}

	public void setEjbCitaFacade(CitaFacade ejbCitaFacade) {
		this.ejbCitaFacade = ejbCitaFacade;
	}
 
	
	
	
	public Integer getId_persona() {
		return id_persona;
	}

	public void setId_persona(Integer id_persona) {
		this.id_persona = id_persona;
	}
 

	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public Integer getIdCita() {
		return idCita;
	}

	public void setIdCita(Integer idCita) {
		this.idCita = idCita;
	}

	public String getComentarioCita() {
		return comentarioCita;
	}

	public void setComentarioCita(String comentarioCita) {
		this.comentarioCita = comentarioCita;
	}

	public BigDecimal getCosto() {
		return costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	public String getEstadoCita() {
		return estadoCita;
	}

	public void setEstadoCita(String estadoCita) {
		this.estadoCita = estadoCita;
	}

	public Date getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}

	public String getSintomatologia() {
		return sintomatologia;
	}

	public void setSintomatologia(String sintomatologia) {
		this.sintomatologia = sintomatologia;
	}

	public Persona getDoctorEspecialidad() {
		return doctorEspecialidad;
	}

	public void setDoctorEspecialidad(Persona doctorEspecialidad) {
		this.doctorEspecialidad = doctorEspecialidad;
	}

	public Persona getPacientePersona() {
		return pacientePersona;
	}

	public void setPacientePersona(Persona pacientePersona) {
		this.pacientePersona = pacientePersona;
	} 
	
	
	public List<Cita> listarCitasID() {  
		citas= new ArrayList<Cita>();
		FacesContext context = FacesContext.getCurrentInstance(); 		
		Persona persona = (Persona)context.getExternalContext().getSessionMap().get("persona"); 
		this.id_persona= persona.getIdPersona(); 
		
		List<Cita> citasb=ejbCitaFacade.findAll();
		
		
		for (Cita cita : citasb) { 
		Persona codigo = cita.getDoctorEspecialidad();
				
			if (codigo.getIdPersona() ==this.id_persona &&  cita.getEstadoCita().equals("En espera")) {
				System.out.println("CIta condicionada---------------"+cita.toString());
				citas.add(cita);
				 		
			} 
			
			
		} 
		return citas;
	}
	
  
	public List<Cita> listarCitasAtendidas() {  
    citas= new ArrayList<Cita>();
		FacesContext context = FacesContext.getCurrentInstance(); 		
		Persona persona = (Persona)context.getExternalContext().getSessionMap().get("persona"); 
		this.id_persona= persona.getIdPersona(); 
		
		List<Cita> citasb=ejbCitaFacade.findAll();
		
		
		for (Cita cita : citasb) { 
		Persona codigo = cita.getDoctorEspecialidad();
      
			if (codigo.getIdPersona() ==this.id_persona &&  cita.getEstadoCita().equals("Atendido")) {
        System.out.println("CIta condicionada---------------"+cita.toString());
				citas.add(cita);
				 		
			} 
			
			
		} 
		return citas;
	}
        
        
      
    
	public List<Cita> listarCitasCanceladas() {   
		citas= new ArrayList<Cita>();
		FacesContext context = FacesContext.getCurrentInstance(); 		
		Persona persona = (Persona)context.getExternalContext().getSessionMap().get("persona"); 
		this.id_persona= persona.getIdPersona(); 
		
		List<Cita> citasb=ejbCitaFacade.findAll();
		
		
		for (Cita cita : citasb) { 
		Persona codigo = cita.getDoctorEspecialidad();
	 
			if (codigo.getIdPersona() ==this.id_persona &&  cita.getEstadoCita().equals("Cancelada")) {
        
				System.out.println("CIta condicionada---------------"+cita.toString());
				citas.add(cita);
				 		
			} 
			
			
		} 
		return citas;
	}
	 
	public List<Cita> listarCitasAgendadas() {  
		citas= new ArrayList<Cita>();
		FacesContext context = FacesContext.getCurrentInstance(); 		
		Persona persona = (Persona)context.getExternalContext().getSessionMap().get("persona"); 
		this.id_persona= persona.getIdPersona(); 
		
		List<Cita> citasb=ejbCitaFacade.findAll();
		
		
		for (Cita cita : citasb) { 
		Persona codigo = cita.getDoctorEspecialidad();
				
			if (codigo.getIdPersona() ==this.id_persona &&  cita.getEstadoCita().equals("Agendado")) {
				System.out.println("CIta condicionada---------------"+cita.toString());
				citas.add(cita);
				 		
			} 
			
			
		} 
		return citas;
	}
	
	
	
	 
	
	public String ValidarSesion()  {  
		
        FacesContext context = FacesContext.getCurrentInstance(); 		
		Persona persona = (Persona)context.getExternalContext().getSessionMap().get("persona"); 
		
		 if(persona.getRol().equals("Doctor")) {
 
         	System.out.println("El Usuario doctor esta logeado");
         }else {
        	 
 
        	  ExternalContext externalContext = context.getExternalContext();
        	  HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();     
        	  HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();   	  
 

        		try {
					request.getRequestDispatcher("index.html").forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}; 
 			
         } 
		
		return null;
	} 
	
	
 
	
	
	public List<Cita> buscarCitasCedulas() {  
		citas= new ArrayList<Cita>();   
		
		this.idCita=0;
		this.comentarioCita="";
		this.estadoCita="";
		this.fechaCita= null;
		this.sintomatologia="";
		this.doctorEspecialidad= new Persona();
		this.pacientePersona=new Persona();
		
		List<Cita> citasb=ejbCitaFacade.findAll(); 	
		
		for (Cita cital : citasb) { 
		 Persona persona = cital.getPacientePersona();	  
		 
			if (persona.getCedula().equals(this.cedula)&&  cital.getEstadoCita().equals("En espera")) {
				//this.cita =cital;				 			 
				citas.add(cital);		 		

				System.out.println("valor de cita buscada > "+citas.toString());
			} 
			
			
		}   
		this.cedula="";
		return citas;
	}
	
	
	
	 	
	public String cancelarCita(Cita c) {		
			c.setEstadoCita("Cancelado");
			ejbCitaFacade.edit(c);			

			citas=ejbCitaFacade.findAll();
				
		return null;
	}
	
	public String atenderCita(Cita c) {		
		c.setEstadoCita("Atendido");
		ejbCitaFacade.edit(c);	

		citas=ejbCitaFacade.findAll();
		return null;
	}
	

	public String delete(Persona c) {
		ejbCategoryFacade.remove(c);
		list = ejbCategoryFacade.findAll();
		return null;
	}

	public String edit(Persona c) {
		c.setEditable(true);
		return null;
	}

	public String save(Persona c) {
		ejbCategoryFacade.edit(c);
		c.setEditable(false);
		return null;
	}
	
	

}