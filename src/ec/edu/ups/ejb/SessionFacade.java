package ec.edu.ups.ejb;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
 
import ec.edu.ups.entidad.Sesion;


@Stateless
public class SessionFacade extends AbstractFacade<Sesion> {

    @PersistenceContext(unitName = "HospitalUPS")
    private EntityManager em;

    public SessionFacade() {
        super(Sesion.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}

