package giuseppetavella;

import giuseppetavella.dao.EventiDAO;
import giuseppetavella.entities.Evento;
import giuseppetavella.entities.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class App {

    // entity manager factory = 1 connection database
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestione-eventi");
    
    public static void main(String[] args) {
        
        System.out.println("*** ENTITY MANAGER FACTORY INITIALIZATION: SUCCESS ***");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EventiDAO eventiDAO = new EventiDAO(entityManager);
        
        // TODO: in theory you could instantiate an entity with 0 arguments, because 
        //      the constructor must have 0 parameters for hibernate?
        Evento evento1 = new Evento(
                "evento1", 
                LocalDate.now().plusYears(1),
                TipoEvento.PRIVATO,
                3
        );       
        
        eventiDAO.save(evento1);
        
        
        
        entityManager.close();
        entityManagerFactory.close();
        
    }
}
