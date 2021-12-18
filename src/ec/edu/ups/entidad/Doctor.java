package ec.edu.ups.entidad;

import java.io.Serializable;

import javax.inject.Named;
import javax.persistence.*;


/**
 * Entity implementation class for Entity: Doctor
 *
 */
@Entity
@Named("doctor")
public class Doctor implements Serializable {
	
	 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int codigo;
	private String enfermedad;
	
	@ManyToOne
	private Persona doctor;
	
	
	public Doctor() {
	}


	public Doctor(int codigo, String enfermedad) {
		super();
		this.codigo = codigo;
		this.enfermedad = enfermedad;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getEnfermedad() {
		return enfermedad;
	}


	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}


	public Persona getDoctor() {
		return doctor;
	}


	public void setDoctor(Persona doctor) {
		this.doctor = doctor;
	}


	@Override
	public String toString() {
		return "Doctor [codigo=" + codigo + ", enfermedad=" + enfermedad + ", doctor=" + doctor + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + ((doctor == null) ? 0 : doctor.hashCode());
		result = prime * result + ((enfermedad == null) ? 0 : enfermedad.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		if (codigo != other.codigo)
			return false;
		if (doctor == null) {
			if (other.doctor != null)
				return false;
		} else if (!doctor.equals(other.doctor))
			return false;
		if (enfermedad == null) {
			if (other.enfermedad != null)
				return false;
		} else if (!enfermedad.equals(other.enfermedad))
			return false;
		return true;
	}

 
 

 
	
	
   
}
