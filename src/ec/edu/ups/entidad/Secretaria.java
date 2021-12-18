package ec.edu.ups.entidad;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Secretaria
 *
 */
@Entity

public class Secretaria implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int codigo;
	private int aniosExperiencia;
	
	@ManyToOne
	private Persona secretaria;
	public Secretaria() {
		super();
	}
	public Secretaria(int codigo, int aniosExperiencia) {
		super();
		this.codigo = codigo;
		this.aniosExperiencia = aniosExperiencia;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getAniosExperiencia() {
		return aniosExperiencia;
	}
	public void setAniosExperiencia(int aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}
	public Persona getSecretaria() {
		return secretaria;
	}
	public void setSecretaria(Persona secretaria) {
		this.secretaria = secretaria;
	}
	@Override
	public String toString() {
		return "Secretaria [codigo=" + codigo + ", aniosExperiencia=" + aniosExperiencia + ", secretaria=" + secretaria
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aniosExperiencia;
		result = prime * result + codigo;
		result = prime * result + ((secretaria == null) ? 0 : secretaria.hashCode());
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
		Secretaria other = (Secretaria) obj;
		if (aniosExperiencia != other.aniosExperiencia)
			return false;
		if (codigo != other.codigo)
			return false;
		if (secretaria == null) {
			if (other.secretaria != null)
				return false;
		} else if (!secretaria.equals(other.secretaria))
			return false;
		return true;
	}
	
	
   
}
