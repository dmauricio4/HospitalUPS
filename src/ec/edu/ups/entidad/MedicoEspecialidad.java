package ec.edu.ups.entidad;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: MedicoEspecialidad
 *
 */
@Entity

public class MedicoEspecialidad implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int codigo;
	
	@OneToOne
	private Cita cita;
	
	@ManyToOne
	private Especialidad medicoespecialidad;
	
	
	@ManyToOne
	private Doctor doctorespecialidad;
	

	public MedicoEspecialidad() {
		super();
	}

 


	public MedicoEspecialidad(int codigo, Cita cita, Especialidad medicoespecialidad, Doctor doctorespecialidad) {
		super();
		this.codigo = codigo;
		this.cita = cita;
		this.medicoespecialidad = medicoespecialidad;
		this.doctorespecialidad = doctorespecialidad;
	}




	public Cita getCita() {
		return cita;
	}




	public void setCita(Cita cita) {
		this.cita = cita;
	}




	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public Especialidad getMedicoespecialidad() {
		return medicoespecialidad;
	}


	public void setMedicoespecialidad(Especialidad medicoespecialidad) {
		this.medicoespecialidad = medicoespecialidad;
	}


	public Doctor getDoctorespecialidad() {
		return doctorespecialidad;
	}


	public void setDoctorespecialidad(Doctor doctorespecialidad) {
		this.doctorespecialidad = doctorespecialidad;
	}


	@Override
	public String toString() {
		return "MedicoEspecialidad [codigo=" + codigo + ", medicoespecialidad=" + medicoespecialidad
				+ ", doctorespecialidad=" + doctorespecialidad + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + ((doctorespecialidad == null) ? 0 : doctorespecialidad.hashCode());
		result = prime * result + ((medicoespecialidad == null) ? 0 : medicoespecialidad.hashCode());
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
		MedicoEspecialidad other = (MedicoEspecialidad) obj;
		if (codigo != other.codigo)
			return false;
		if (doctorespecialidad == null) {
			if (other.doctorespecialidad != null)
				return false;
		} else if (!doctorespecialidad.equals(other.doctorespecialidad))
			return false;
		if (medicoespecialidad == null) {
			if (other.medicoespecialidad != null)
				return false;
		} else if (!medicoespecialidad.equals(other.medicoespecialidad))
			return false;
		return true;
	}
	
	
	
	
	
	
   
}
