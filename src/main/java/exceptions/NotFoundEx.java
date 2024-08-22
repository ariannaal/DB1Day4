package exceptions;

public class NotFoundEx extends RuntimeException {

    public NotFoundEx(int id) {
        super("L'evento con id " + id + " non è stato trovato. Si prega di riprovare.");
    }

}
