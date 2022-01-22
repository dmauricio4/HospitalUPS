package ec.edu.ups.entidad;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the "Factura_Cabecera" database table.
 * 
 */
@Entity
@Table(name="\"Factura_Cabecera\"")
@NamedQuery(name="Factura_Cabecera.findAll", query="SELECT f FROM Factura_Cabecera f")
public class Factura_Cabecera implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_factura_cabecera")
	private Integer idFacturaCabecera;

	private BigDecimal descuento;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_factura")
	private Date fechaFactura;

	@Column(name="\"IVA\"")
	private BigDecimal iva;

	private BigDecimal subtotal;

	private BigDecimal total;

	//bi-directional many-to-one association to Factura_Detalle
	@ManyToOne
	@JoinColumn(name="id_factura_detalle")
	private Factura_Detalle facturaDetalle;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="id_persona")
	private Persona persona;

	public Factura_Cabecera() {
	}

	public Integer getIdFacturaCabecera() {
		return this.idFacturaCabecera;
	}

	public void setIdFacturaCabecera(Integer idFacturaCabecera) {
		this.idFacturaCabecera = idFacturaCabecera;
	}

	public BigDecimal getDescuento() {
		return this.descuento;
	}

	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	public Date getFechaFactura() {
		return this.fechaFactura;
	}

	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	public BigDecimal getIva() {
		return this.iva;
	}

	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}

	public BigDecimal getSubtotal() {
		return this.subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Factura_Detalle getFacturaDetalle() {
		return this.facturaDetalle;
	}

	public void setFacturaDetalle(Factura_Detalle facturaDetalle) {
		this.facturaDetalle = facturaDetalle;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}