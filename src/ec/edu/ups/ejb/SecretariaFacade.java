package ec.edu.ups.ejb;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Secretaria;


@Stateless
public class SecretariaFacade extends AbstractFacade<Secretaria> {

    @PersistenceContext(unitName = "HospitalUPS")
    private EntityManager em;

    public SecretariaFacade() {
        super(Secretaria.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}

