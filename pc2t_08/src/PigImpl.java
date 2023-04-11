public class PigImpl implements Animal {

    public void sound() {
        System.out.println("oink oink");
    }

    @Override
    public String toString() {
        return "oink oink";
    }
}
