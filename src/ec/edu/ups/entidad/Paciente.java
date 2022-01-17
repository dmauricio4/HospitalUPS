package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Paciente
 *
 */
@Entity

public class Paciente implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int codigo;
	private int cantidad;
	
	@ManyToOne
	private Persona paciente;
	
	@OneToMany(mappedBy="pacienteCita")
	private List<Cita> citas;
	
	public Paciente() {
		super();
	}




	

	public Paciente(int codigo, int cantidad, Persona paciente, List<Cita> citas) {
		super();
		this.codigo = codigo;
		this.cantidad = cantidad;
		this.paciente = paciente;
		this.citas = citas;
	}






	public List<Cita> getCitas() {
		return citas;
	}



	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}



	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	
	public int getCantidad() {
		return cantidad;
	}






	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}






	public Persona getPaciente() {
		return paciente;
	}
	public void setPaciente(Persona paciente) {
		this.paciente = paciente;
	}





	@Override
	public String toString() {
		return "Paciente [codigo=" + codigo + ", cantidad=" + cantidad + ", paciente=" + paciente + ", citas=" + citas
				+ "]";
	}






	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad;
		result = prime * result + ((citas == null) ? 0 : citas.hashCode());
		result = prime * result + codigo;
		result = prime * result + ((paciente == null) ? 0 : paciente.hashCode());
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
		Paciente other = (Paciente) obj;
		if (cantidad != other.cantidad)
			return false;
		if (citas == null) {
			if (other.citas != null)
				return false;
		} else if (!citas.equals(other.citas))
			return false;
		if (codigo != other.codigo)
			return false;
		if (paciente == null) {
			if (other.paciente != null)
				return false;
		} else if (!paciente.equals(other.paciente))
			return false;
		return true;
	}






	
	
	
}
	