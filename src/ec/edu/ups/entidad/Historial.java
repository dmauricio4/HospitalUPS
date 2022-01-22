package ec.edu.ups.entidad;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "Historial" database table.
 * 
 */
@Entity
@Table(name="\"Historial\"")
@NamedQuery(name="Historial.findAll", query="SELECT h FROM Historial h")
public class Historial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_historial")
	private Integer idHistorial;

	private String orden;

	private String receta;

	//bi-directional many-to-one association to Cita
	@ManyToOne
	@JoinColumn(name="id_cita")
	private Cita cita;

	public Historial() {
	}

	public Integer getIdHistorial() {
		return this.idHistorial;
	}

	public void setIdHistorial(Integer idHistorial) {
		this.idHistorial = idHistorial;
	}

	public String getOrden() {
		return this.orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}

	public String getReceta() {
		return this.receta;
	}

	public void setReceta(String receta) {
		this.receta = receta;
	}

	public Cita getCita() {
		return this.cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

}