package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Historial
 *
 */
@Entity

public class Historial implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	private int codigo;
	
	@OneToMany(mappedBy="historialCita")
	private List<Cita> citas;
	

	public Historial() {
		super();
	}


	public Historial(int codigo, List<Cita> citas) {
		super();
		this.codigo = codigo;
		this.citas = citas;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public List<Cita> getCitas() {
		return citas;
	}


	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}


	@Override
	public String toString() {
		return "Historial [codigo=" + codigo + ", citas=" + citas + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((citas == null) ? 0 : citas.hashCode());
		result = prime * result + codigo;
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
		Historial other = (Historial) obj;
		if (citas == null) {
			if (other.citas != null)
				return false;
		} else if (!citas.equals(other.citas))
			return false;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	
	
   
	
}
