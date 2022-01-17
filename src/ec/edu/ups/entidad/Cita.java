package ec.edu.ups.entidad;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Citas
 *
 */
@Entity
public class Cita implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int codigo;
	
	@ManyToOne
	private Paciente pacienteCita;
	
	@OneToOne
	private MedicoEspecialidad medicoEspecialidad;
	
	@ManyToOne
	private Historial historialCita;
	
	private Date fechaCita;
	
	private String sintomas;
	
	private String estadoCita;
	
	private String observacionCita;
	
	private Double costoCita;
	
	
		

	public Cita() {
		super();
	}




	public Cita(int codigo, Paciente pacienteCita, MedicoEspecialidad medicoEspecialidad, Historial historialCita,
			Date fechaCita, String sintomas, String estadoCita, String observacionCita, Double costoCita) {
		super();
		this.codigo = codigo;
		this.pacienteCita = pacienteCita;
		this.medicoEspecialidad = medicoEspecialidad;
		this.historialCita = historialCita;
		this.fechaCita = fechaCita;
		this.sintomas = sintomas;
		this.estadoCita = estadoCita;
		this.observacionCita = observacionCita;
		this.costoCita = costoCita;
	}




	public int getCodigo() {
		return codigo;
	}




	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}




	public Paciente getPacienteCita() {
		return pacienteCita;
	}




	public void setPacienteCita(Paciente pacienteCita) {
		this.pacienteCita = pacienteCita;
	}




	public MedicoEspecialidad getMedicoEspecialidad() {
		return medicoEspecialidad;
	}




	public void setMedicoEspecialidad(MedicoEspecialidad medicoEspecialidad) {
		this.medicoEspecialidad = medicoEspecialidad;
	}




	public Historial getHistorialCita() {
		return historialCita;
	}




	public void setHistorialCita(Historial historialCita) {
		this.historialCita = historialCita;
	}




	public Date getFechaCita() {
		return fechaCita;
	}




	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}




	public String getSintomas() {
		return sintomas;
	}




	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}




	public String getEstadoCita() {
		return estadoCita;
	}




	public void setEstadoCita(String estadoCita) {
		this.estadoCita = estadoCita;
	}




	public String getObservacionCita() {
		return observacionCita;
	}




	public void setObservacionCita(String observacionCita) {
		this.observacionCita = observacionCita;
	}




	public Double getCostoCita() {
		return costoCita;
	}




	public void setCostoCita(Double costoCita) {
		this.costoCita = costoCita;
	}




	@Override
	public String toString() {
		return "Cita [codigo=" + codigo + ", pacienteCita=" + pacienteCita + ", medicoEspecialidad="
				+ medicoEspecialidad + ", historialCita=" + historialCita + ", fechaCita=" + fechaCita + ", sintomas="
				+ sintomas + ", estadoCita=" + estadoCita + ", observacionCita=" + observacionCita + ", costoCita="
				+ costoCita + "]";
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + ((costoCita == null) ? 0 : costoCita.hashCode());
		result = prime * result + ((estadoCita == null) ? 0 : estadoCita.hashCode());
		result = prime * result + ((fechaCita == null) ? 0 : fechaCita.hashCode());
		result = prime * result + ((historialCita == null) ? 0 : historialCita.hashCode());
		result = prime * result + ((medicoEspecialidad == null) ? 0 : medicoEspecialidad.hashCode());
		result = prime * result + ((observacionCita == null) ? 0 : observacionCita.hashCode());
		result = prime * result + ((pacienteCita == null) ? 0 : pacienteCita.hashCode());
		result = prime * result + ((sintomas == null) ? 0 : sintomas.hashCode());
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
		Cita other = (Cita) obj;
		if (codigo != other.codigo)
			return false;
		if (costoCita == null) {
			if (other.costoCita != null)
				return false;
		} else if (!costoCita.equals(other.costoCita))
			return false;
		if (estadoCita == null) {
			if (other.estadoCita != null)
				return false;
		} else if (!estadoCita.equals(other.estadoCita))
			return false;
		if (fechaCita == null) {
			if (other.fechaCita != null)
				return false;
		} else if (!fechaCita.equals(other.fechaCita))
			return false;
		if (historialCita == null) {
			if (other.historialCita != null)
				return false;
		} else if (!historialCita.equals(other.historialCita))
			return false;
		if (medicoEspecialidad == null) {
			if (other.medicoEspecialidad != null)
				return false;
		} else if (!medicoEspecialidad.equals(other.medicoEspecialidad))
			return false;
		if (observacionCita == null) {
			if (other.observacionCita != null)
				return false;
		} else if (!observacionCita.equals(other.observacionCita))
			return false;
		if (pacienteCita == null) {
			if (other.pacienteCita != null)
				return false;
		} else if (!pacienteCita.equals(other.pacienteCita))
			return false;
		if (sintomas == null) {
			if (other.sintomas != null)
				return false;
		} else if (!sintomas.equals(other.sintomas))
			return false;
		return true;
	}
	
	
	
	
	
	
	
   
}
