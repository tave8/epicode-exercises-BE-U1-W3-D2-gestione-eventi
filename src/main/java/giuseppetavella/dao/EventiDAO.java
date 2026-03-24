package giuseppetavella.dao;

import giuseppetavella.entities.Evento;
import giuseppetavella.exceptions.evento.EventoIDNotFoundException;
import giuseppetavella.exceptions.evento.SaveEventoException;
import jakarta.persistence.EntityManager;

public class EventiDAO {
    
    private final EntityManager entityManager;
    
    public EventiDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public void save(Evento nuovoEvento) throws SaveEventoException {
          
    }
    
    // public Evento getById(long targetId) throws EventoIDNotFoundException {
    //
    // }
    //
    // public void delete(long targetId) throws EventoIDNotFoundException {
    //    
    // }
}
