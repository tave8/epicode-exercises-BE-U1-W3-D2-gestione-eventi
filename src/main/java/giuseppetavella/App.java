package giuseppetavella;

import giuseppetavella.dao.EventiDAO;
import giuseppetavella.entities.Evento;
import giuseppetavella.entities.TipoEvento;
import giuseppetavella.exceptions.evento.EventoIDNotFoundException;
import giuseppetavella.exceptions.evento.SaveEventoException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class App {

    // entity manager factory = 1 connection database
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestione-eventi");
    
    public static void main(String[] args) {
        
        System.out.println("*** ENTITY MANAGER FACTORY INITIALIZATION: SUCCESS ***");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EventiDAO eventiDAO = new EventiDAO(entityManager);
        
        Evento evento1 = new Evento(
                "evento1", 
                LocalDate.now().plusYears(1),
                TipoEvento.PUBBLICO,
                3
        );
        
        
        // Evento evento2 = new Evento();
        
        // SAVE
        // try {
        //     eventiDAO.save(evento1);
        //         System.out.println("Evento "+evento1+" added successfully.");
        // }
        // catch(SaveEventoException ex) {
        //     System.out.println(ex.getMessage());
        // }

        // GET BY ID
        // try {
        //     System.out.println(
        //             eventiDAO.getById(9)
        //     );
        // }
        // catch(EventoIDNotFoundException ex) {
        //     System.out.println(ex.getMessage());
        // }

        // DELETE
        try {
            long targetIdToRemove = 11;
            eventiDAO.delete(targetIdToRemove);
            System.out.println("Evento with ID " + targetIdToRemove + " deleted successfully.");
        }
        catch(EventoIDNotFoundException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }

        
        entityManager.close();
        entityManagerFactory.close();
        
    }
}
