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
	
	
	
	public List<Cita> getCitasCedula(String cedula){
		String query = "SELECT c FROM public.\"Cita\" c,public.\"Persona\" p WHERE  c.estado_cita ='En espera' and c.id_paciente= p.id_persona and p.cedula= :cedula";
		List<Cita> citas = new ArrayList<Cita>();
		
		try {
			citas = (List<Cita>) entityManager.createQuery(query)
											 .setParameter("cedula", cedula)
											 .getResultList();
			
			System.out.println("CItas: " + citas);
			
			
		} catch (Exception e) {
			System.out.println("--> ERROR Cita.getCitasbyEstado" + e.getMessage());
		}
		return citas;
	}
	
	
	
	
	

}
