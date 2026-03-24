package giuseppetavella.exceptions.evento;

public class DeleteEventoException extends RuntimeException {
    public DeleteEventoException(long targetId) {
        super("Error while deleting event with ID " + targetId);
    }
}
