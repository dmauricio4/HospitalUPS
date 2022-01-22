package ec.edu.ups.entidad;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "Especialidad" database table.
 * 
 */
@Entity
@Table(name="\"Especialidad\"")
@NamedQuery(name="Especialidad.findAll", query="SELECT e FROM Especialidad e")
public class Especialidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_especialidad")
	private Integer idEspecialidad;

	@Column(name="descripcion_especialidad")
	private String descripcionEspecialidad;

	@Column(name="nombre_especialidad")
	private String nombreEspecialidad;


	public Especialidad() {
	}

	public Integer getIdEspecialidad() {
		return this.idEspecialidad;
	}

	public void setIdEspecialidad(Integer idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public String getDescripcionEspecialidad() {
		return this.descripcionEspecialidad;
	}

	public void setDescripcionEspecialidad(String descripcionEspecialidad) {
		this.descripcionEspecialidad = descripcionEspecialidad;
	}

	public String getNombreEspecialidad() {
		return this.nombreEspecialidad;
	}

	public void setNombreEspecialidad(String nombreEspecialidad) {
		this.nombreEspecialidad = nombreEspecialidad;
	}

	@Override
	public String toString() {
		return "Especialidad [idEspecialidad=" + idEspecialidad + ", descripcionEspecialidad=" + descripcionEspecialidad
				+ ", nombreEspecialidad=" + nombreEspecialidad + "]";
	}
	

}