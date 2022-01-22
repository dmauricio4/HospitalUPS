package ec.edu.ups.entidad;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the "Doctor_Especialidad" database table.
 * 
 */
@Entity
@Table(name="\"Doctor_Especialidad\"")
@NamedQuery(name="Doctor_Especialidad.findAll", query="SELECT d FROM Doctor_Especialidad d")
public class Doctor_Especialidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_doctor_especialidad")
	private Integer idDoctorEspecialidad;

	//bi-directional many-to-one association to Especialidad
	@ManyToOne
	@JoinColumn(name="id_especialidad")
	private Especialidad especialidad;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="id_doctor")
	private Persona doctorPersona;

	public Doctor_Especialidad() {
	}
	
	public Doctor_Especialidad(Especialidad especialidad, Persona doctorPersona) {
		super();
		this.especialidad = especialidad;
		this.doctorPersona = doctorPersona;
	}

	public Integer getIdDoctorEspecialidad() {
		return this.idDoctorEspecialidad;
	}

	public void setIdDoctorEspecialidad(Integer idDoctorEspecialidad) {
		this.idDoctorEspecialidad = idDoctorEspecialidad;
	}
	
	public Especialidad getEspecialidad1() {
		return this.especialidad;
	}

	public void setEspecialidad1(Especialidad especialidad1) {
		this.especialidad = especialidad1;
	}

	@Override
	public String toString() {
		return "Doctor_Especialidad [idDoctorEspecialidad=" + idDoctorEspecialidad + ", especialidad=" + especialidad
				+ ", doctorPersona=" + doctorPersona + "]";
	}
	
	

}