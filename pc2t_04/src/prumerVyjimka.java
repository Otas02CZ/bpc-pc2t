public class prumerVyjimka extends Exception {
    public prumerVyjimka() {
        super("Spatny prumer.");
    }
    public prumerVyjimka(String text) {
        super(text);
    }
}
