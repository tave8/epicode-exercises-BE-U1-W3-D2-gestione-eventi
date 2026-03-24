package giuseppetavella;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestione-eventi");
    
    public static void main(String[] args) {
        
        System.out.println("Hello World!");
    }
}
