package giuseppetavella.entities;


import jakarta.persistence.*;
import org.hibernate.annotations.DialectOverride;

import java.time.LocalDate;

// map this java class to a db table
@Entity
// can customize table metadata
@Table(name = "eventi")
public class Evento {
    @Id // mandatory. the primary key for this table
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evento_id")
    private long id;
    
    @Column(name = "titolo", nullable = false)
    private String titolo;
    
    @Column(name = "data_evento", nullable = false)
    private LocalDate dataEvento;
    
    @Column(name = "tipo_evento", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;
    
    @Column(name = "numero_massimo_partecipanti", nullable = false)
    // TODO: numero massimo partecipanti >= 0
    private int numeroMassimoPartecipanti;

    @Column(name = "descrizione")
    private String descrizione;
    
    // mandatory. why?
    public Evento() {}
    
}
