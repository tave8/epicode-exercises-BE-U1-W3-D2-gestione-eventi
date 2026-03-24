package giuseppetavella.dao;

import giuseppetavella.entities.Evento;
import giuseppetavella.exceptions.evento.EventoIDNotFoundException;
import giuseppetavella.exceptions.evento.SaveEventoException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.Optional;

public class EventiDAO {
    
    private final EntityManager entityManager;
    
    // the class that this DAO class refers to 
    // example: 
    //      Events (DAO class) -- refers to --> Event (entity class)
    private static final Class<Evento> entityClass = Evento.class; 
    
    
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
    
    public Evento getById(long targetId) throws EventoIDNotFoundException {
        Evento evento = entityManager.find(entityClass, targetId);
        if(evento == null) {
            throw new EventoIDNotFoundException(targetId);
        }
        return evento;
    }
    
    public void delete(long targetId) throws EventoIDNotFoundException {
        // first I find this entity instance from the db
        // so i reuse the get by id method in this DAO class
        Evento evento = this.getById(targetId);
        
        // instantiate transaction
        EntityTransaction transaction = this.entityManager.getTransaction();
        
        // begin transaction
        transaction.begin();
        
        // TODO: from when i find the object in DB, till when i edit it again,
        // give the command "remove" this entity instance from the 
        // hibernate persistence context
        // TODO: what error does it throw?
        this.entityManager.remove(evento);
        
        transaction.commit();
    }
}
