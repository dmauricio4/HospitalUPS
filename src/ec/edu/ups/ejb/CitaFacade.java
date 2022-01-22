package ec.edu.ups.ejb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Cita;
import ec.edu.ups.entidad.Persona;

@Stateless
public class CitaFacade extends AbstractFacade<Cita> {
	
	@PersistenceContext(unitName = "HospitalUPS")
	private EntityManager entityManager;

	public CitaFacade() {
		super(Cita.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	public List<Cita> getCitasbyEstado(String estado) {
		String query = "SELECT c FROM Cita c WHERE c.estadoCita = :estado";
		List<Cita> citas = new ArrayList<Cita>();
		
		try {
			citas = (List<Cita>) entityManager.createQuery(query)
											 .setParameter("estado", estado)
											 .getResultList();
			
			
		} catch (Exception e) {
			System.out.println("--> ERROR Cita.getCitasbyEstado" + e.getMessage());
		}
		return citas;
	}
	
	public List<Cita> getCitasbyDate(Date fecha) {
		String query = "SELECT c FROM Cita c WHERE c.fechaCita = :fecha";
		List<Cita> citas = new ArrayList<Cita>();
		
		try {
			citas = (List<Cita>) entityManager.createQuery(query)
											 .setParameter("fecha", fecha)
											 .getResultList();
			
			System.out.println("CItas: " + citas);
			
			
		} catch (Exception e) {
			System.out.println("--> ERROR Cita.getCitasbyEstado" + e.getMessage());
		}
		return citas;
	}
	
	
	
	

}
