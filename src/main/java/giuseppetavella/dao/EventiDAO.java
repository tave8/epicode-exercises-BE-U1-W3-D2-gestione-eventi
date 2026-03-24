package giuseppetavella.dao;

import giuseppetavella.entities.Evento;
import giuseppetavella.exceptions.evento.EventoIDNotFoundException;
import giuseppetavella.exceptions.evento.SaveEventoException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventiDAO {
    
    private final EntityManager entityManager;
    
    public EventiDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public void save(Evento nuovoEvento) throws SaveEventoException {
        // 1. instantiate new transaction from instance's entity manager
        EntityTransaction transaction = entityManager.getTransaction();
        
        // 2. open new transaction
        transaction.begin();
        
        // 3. save new event in hibernate persistance context
        // TODO: how to know if there were errors?
        entityManager.persist(nuovoEvento);
        
        // 4. commit or rollback changes from persistance context, into db
        transaction.commit();
        
    }
    
    // public Evento getById(long targetId) throws EventoIDNotFoundException {
    //
    // }
    //
    // public void delete(long targetId) throws EventoIDNotFoundException {
    //    
    // }
}
