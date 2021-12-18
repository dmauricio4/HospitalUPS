package ec.edu.ups.ejb;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Paciente;


@Stateless
public class PacienteFacade extends AbstractFacade<Paciente> {

    @PersistenceContext(unitName = "HospitalUPS")
    private EntityManager em;

    public PacienteFacade() {
        super(Paciente.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}

