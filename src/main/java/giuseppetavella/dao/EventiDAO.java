package giuseppetavella.dao;

import giuseppetavella.entities.Evento;
import giuseppetavella.exceptions.evento.DeleteEventoException;
import giuseppetavella.exceptions.evento.EventoIDNotFoundException;
import giuseppetavella.exceptions.evento.FindEventoException;
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
        
        try {
            // 3. save new event in hibernate persistance context
            // TODO: how to know if there were errors?
            entityManager.persist(nuovoEvento);
            
            // 4. commit or rollback changes from persistance context, into db
            transaction.commit();
            
        } catch (RuntimeException ex) {
            transaction.rollback();
            throw new SaveEventoException(nuovoEvento);
        }
        
    }
    
    public Evento getById(long targetId) throws EventoIDNotFoundException, FindEventoException {
        Evento evento;
        
        try {
            evento = entityManager.find(entityClass, targetId);
        } catch (RuntimeException ex) {
            throw new FindEventoException(targetId);
        }
        
        if(evento == null) {
            throw new EventoIDNotFoundException(targetId);
        }
        
        return evento;
    }
    
    public void delete(long targetId) throws EventoIDNotFoundException, FindEventoException, DeleteEventoException {
        Evento evento;

        // first I find this entity instance from the db
        // so i reuse the get by id method in this DAO class
        evento = getById(targetId);
        
        // instantiate transaction
        EntityTransaction transaction = entityManager.getTransaction();
        
        // begin transaction
        transaction.begin();
        
        try {
            // TODO: from when i find the object in DB, till when i edit it again,
            // give the command "remove" this entity instance from the 
            // hibernate persistence context
            // TODO: what error does it throw?
            entityManager.remove(evento);
            
            transaction.commit();
            
        } catch(RuntimeException ex) {
            transaction.rollback();
            throw new DeleteEventoException(targetId);
        }
        
    }
}
