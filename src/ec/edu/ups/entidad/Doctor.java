package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.List;

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
	private String experienciaL;
	
	@ManyToOne
	private Persona doctor;
	
	
	@OneToMany(mappedBy="doctorespecialidad")
	private List<MedicoEspecialidad> MedicoEspecialidad;
	
	public Doctor() {
	}

 

	public Doctor(int codigo, String experienciaL, Persona doctor,
			List<ec.edu.ups.entidad.MedicoEspecialidad> medicoEspecialidad) {
		super();
		this.codigo = codigo;
		this.experienciaL = experienciaL;
		this.doctor = doctor;
		MedicoEspecialidad = medicoEspecialidad;
	}



	public String getExperienciaL() {
		return experienciaL;
	}



	public void setExperienciaL(String experienciaL) {
		this.experienciaL = experienciaL;
	}



	public List<MedicoEspecialidad> getMedicoEspecialidad() {
		return MedicoEspecialidad;
	}



	public void setMedicoEspecialidad(List<MedicoEspecialidad> medicoEspecialidad) {
		MedicoEspecialidad = medicoEspecialidad;
	}



	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

 

	public Persona getDoctor() {
		return doctor;
	}


	public void setDoctor(Persona doctor) {
		this.doctor = doctor;
	}



	@Override
	public String toString() {
		return "Doctor [codigo=" + codigo + ", experienciaL=" + experienciaL + ", doctor=" + doctor
				+ ", MedicoEspecialidad=" + MedicoEspecialidad + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((MedicoEspecialidad == null) ? 0 : MedicoEspecialidad.hashCode());
		result = prime * result + codigo;
		result = prime * result + ((doctor == null) ? 0 : doctor.hashCode());
		result = prime * result + ((experienciaL == null) ? 0 : experienciaL.hashCode());
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
		if (MedicoEspecialidad == null) {
			if (other.MedicoEspecialidad != null)
				return false;
		} else if (!MedicoEspecialidad.equals(other.MedicoEspecialidad))
			return false;
		if (codigo != other.codigo)
			return false;
		if (doctor == null) {
			if (other.doctor != null)
				return false;
		} else if (!doctor.equals(other.doctor))
			return false;
		if (experienciaL == null) {
			if (other.experienciaL != null)
				return false;
		} else if (!experienciaL.equals(other.experienciaL))
			return false;
		return true;
	}

  

 
	
	
   
}
