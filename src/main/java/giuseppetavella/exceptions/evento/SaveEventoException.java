package giuseppetavella.exceptions.evento;

import giuseppetavella.entities.Evento;

public class SaveEventoException extends RuntimeException {
    public SaveEventoException(Evento evento) {
        super("Error while saving " + evento + ".");
    }
}
