package ec.edu.ups.entidad;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the "Factura_Detalle" database table.
 * 
 */
@Entity
@Table(name="\"Factura_Detalle\"")
@NamedQuery(name="Factura_Detalle.findAll", query="SELECT f FROM Factura_Detalle f")
public class Factura_Detalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_factura_detalle")
	private Integer idFacturaDetalle;

	private BigDecimal subtotal;

	//bi-directional many-to-one association to Factura_Cabecera
	@OneToMany(mappedBy="facturaDetalle")
	private List<Factura_Cabecera> facturaCabeceras;

	//bi-directional many-to-one association to Cita
	@ManyToOne
	@JoinColumn(name="id_cita")
	private Cita cita;

	public Factura_Detalle() {
	}

	public Integer getIdFacturaDetalle() {
		return this.idFacturaDetalle;
	}

	public void setIdFacturaDetalle(Integer idFacturaDetalle) {
		this.idFacturaDetalle = idFacturaDetalle;
	}

	public BigDecimal getSubtotal() {
		return this.subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public List<Factura_Cabecera> getFacturaCabeceras() {
		return this.facturaCabeceras;
	}

	public void setFacturaCabeceras(List<Factura_Cabecera> facturaCabeceras) {
		this.facturaCabeceras = facturaCabeceras;
	}

	public Factura_Cabecera addFacturaCabecera(Factura_Cabecera facturaCabecera) {
		getFacturaCabeceras().add(facturaCabecera);
		facturaCabecera.setFacturaDetalle(this);

		return facturaCabecera;
	}

	public Factura_Cabecera removeFacturaCabecera(Factura_Cabecera facturaCabecera) {
		getFacturaCabeceras().remove(facturaCabecera);
		facturaCabecera.setFacturaDetalle(null);

		return facturaCabecera;
	}

	public Cita getCita() {
		return this.cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

}