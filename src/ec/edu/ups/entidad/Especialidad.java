package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Especialidad
 *
 */
@Entity

public class Especialidad implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int codigo;
	
	private String nombreEspecialidad;
	
	 private String descripcionEspecialidad;
	 
	 @OneToMany(mappedBy="medicoespecialidad")
	 private List<MedicoEspecialidad> medicoEspecialidades;

	public Especialidad() {
		super();
	}

	public Especialidad(int codigo, String nombreEspecialidad, String descripcionEspecialidad,
			List<MedicoEspecialidad> medicoEspecialidades) {
		super();
		this.codigo = codigo;
		this.nombreEspecialidad = nombreEspecialidad;
		this.descripcionEspecialidad = descripcionEspecialidad;
		this.medicoEspecialidades = medicoEspecialidades;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombreEspecialidad() {
		return nombreEspecialidad;
	}

	public void setNombreEspecialidad(String nombreEspecialidad) {
		this.nombreEspecialidad = nombreEspecialidad;
	}

	public String getDescripcionEspecialidad() {
		return descripcionEspecialidad;
	}

	public void setDescripcionEspecialidad(String descripcionEspecialidad) {
		this.descripcionEspecialidad = descripcionEspecialidad;
	}

	public List<MedicoEspecialidad> getMedicoEspecialidades() {
		return medicoEspecialidades;
	}

	public void setMedicoEspecialidades(List<MedicoEspecialidad> medicoEspecialidades) {
		this.medicoEspecialidades = medicoEspecialidades;
	}

	@Override
	public String toString() {
		return "Especialidad [codigo=" + codigo + ", nombreEspecialidad=" + nombreEspecialidad
				+ ", descripcionEspecialidad=" + descripcionEspecialidad + ", medicoEspecialidades="
				+ medicoEspecialidades + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + ((descripcionEspecialidad == null) ? 0 : descripcionEspecialidad.hashCode());
		result = prime * result + ((medicoEspecialidades == null) ? 0 : medicoEspecialidades.hashCode());
		result = prime * result + ((nombreEspecialidad == null) ? 0 : nombreEspecialidad.hashCode());
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
		Especialidad other = (Especialidad) obj;
		if (codigo != other.codigo)
			return false;
		if (descripcionEspecialidad == null) {
			if (other.descripcionEspecialidad != null)
				return false;
		} else if (!descripcionEspecialidad.equals(other.descripcionEspecialidad))
			return false;
		if (medicoEspecialidades == null) {
			if (other.medicoEspecialidades != null)
				return false;
		} else if (!medicoEspecialidades.equals(other.medicoEspecialidades))
			return false;
		if (nombreEspecialidad == null) {
			if (other.nombreEspecialidad != null)
				return false;
		} else if (!nombreEspecialidad.equals(other.nombreEspecialidad))
			return false;
		return true;
	}
	
   
	
}
