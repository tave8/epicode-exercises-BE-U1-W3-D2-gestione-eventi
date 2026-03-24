package giuseppetavella.exceptions.evento;

public class FindEventoException extends RuntimeException {
    public FindEventoException(long targetId) {
        super("Error while finding event with target ID " + targetId);
    }
}
