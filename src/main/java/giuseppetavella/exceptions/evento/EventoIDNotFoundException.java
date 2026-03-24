package giuseppetavella.exceptions.evento;

public class EventoIDNotFoundException extends RuntimeException {
    public EventoIDNotFoundException(long targetId) {
        super("Evento with ID " + targetId + " was not found.");
    }
}
