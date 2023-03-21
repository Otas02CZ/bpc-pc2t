public class AverageException extends Exception {
    public AverageException() {
        super("Spatny prumer.");
    }
    public AverageException(String text) {
        super(text);
    }
}
