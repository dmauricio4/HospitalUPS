package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.PersonaFacade;
import ec.edu.ups.ejb.DoctorFacade;
import ec.edu.ups.entidad.Doctor; 

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
    public PersonaBean() {

    }    
    
    @PostConstruct
    public void init() {
	//ejbCategoryFacade.create(new Category("Hola"));
	//ejbCategoryFacade.create(new Category("1211"));
	list = ejbCategoryFacade.findAll();
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

	public String add() {
	ejbCategoryFacade.create(new Persona(this.cedula,this.nombres,this.apellidos,this.direccion,this.telefono,this.correo,this.rol,this.password));
	list = ejbCategoryFacade.findAll();
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