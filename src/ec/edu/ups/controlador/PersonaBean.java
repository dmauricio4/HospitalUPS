package ec.edu.ups.controlador;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.http.HttpServletRequest;
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

	private Persona doctorEspecialidad;

	private Persona pacientePersona;

	public PersonaBean() {

	}

	@PostConstruct
	public void init() {
		list = ejbCategoryFacade.findAll(); 
		citas= ejbCitaFacade.findAll();
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
		FacesContext context = FacesContext.getCurrentInstance();			
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();		
		
		HttpSession session = request.getSession(true); 	
		
		Persona per = new Persona();
		per=(Persona)session.getAttribute("persona"); 
		
		this.id_persona= per.getIdPersona();

		citas = ejbCitaFacade.getCitaEsperaID(per.getIdPersona());
		return citas;
	}
	

	
	public String buscarCitasCedulas() {
		citas= ejbCitaFacade.getCitasCedula(this.cedula);
		
		return null;
	}
	public String add() {

		Persona per = new Persona();
		per.setApellidos(apellidos);
		per.setCedula(cedula);
		per.setNombres(nombres);
		per.setDireccion(direccion);
		per.setTelefono(telefono);
		per.setCorreo(correo);
		per.setRol(rol);
		per.setPassword(password);
		ejbCategoryFacade.create(per);
		list = ejbCategoryFacade.findAll();

		this.cedula = "";
		this.nombres = "";
		this.apellidos = "";
		this.direccion = "";
		this.telefono = "";
		this.correo = "";
		this.rol = "Selecionar";
		this.password = "";
		per = new Persona();
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