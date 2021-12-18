package ec.edu.ups.ejb;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Doctor;


@Stateless
public class DoctorFacade extends AbstractFacade<Doctor> {

    @PersistenceContext(unitName = "HospitalUPS")
    private EntityManager em;

    public DoctorFacade() {
        super(Doctor.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}

