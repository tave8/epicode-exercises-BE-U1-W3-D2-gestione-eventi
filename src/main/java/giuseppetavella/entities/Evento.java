package giuseppetavella.entities;


import jakarta.persistence.*;

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
    
    public Evento(String titolo, LocalDate dataEvento, TipoEvento tipoEvento, int numeroMassimoPartecipanti, String descrizione) {
        this.setTitolo(titolo);
        this.setDataEvento(dataEvento);
        this.setTipoEvento(tipoEvento);
        this.setNumeroMassimoPartecipanti(numeroMassimoPartecipanti);
        this.setDescrizione(descrizione);
    }
    
    public Evento(String titolo, LocalDate dataEvento, TipoEvento tipoEvento, int numeroMassimoPartecipanti) {
        this(titolo, dataEvento, tipoEvento, numeroMassimoPartecipanti, "");
    }

    public String getTitolo() {
        return titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public long getId() {
        return id;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    // TODO: validation logic in setters vs DB. how do they come together? 
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", tipoEvento=" + tipoEvento +
                '}';
    }
}
