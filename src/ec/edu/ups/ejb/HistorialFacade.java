package ec.edu.ups.ejb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Cita;
import ec.edu.ups.entidad.Historial;
import ec.edu.ups.entidad.Persona;

@Stateless
public class HistorialFacade extends AbstractFacade<Historial> {
	
	@PersistenceContext(unitName = "HospitalUPS")
	private EntityManager entityManager;

	public HistorialFacade() {
		super(Historial.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}
	
	
	
	public List<Historial> getCitasCedula(Integer citaid){
		String query = "SELECT h FROM Historial h WHERE h.id_cita= :idCita";
		List<Historial> historiales = new ArrayList<Historial>();
		
		try {
			historiales = (List<Historial>) entityManager.createQuery(query)
											 .setParameter("idCita", citaid)
											 .getResultList();
			System.out.println("Historiales: " + historiales);
			
			
		} catch (Exception e) {
			System.out.println("--> ERROR Cita.getCitasbyEstado" + e.getMessage());
		}
		return historiales;
	}
	
	
	
	
	

}
