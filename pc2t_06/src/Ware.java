public abstract class Ware {
    private String name;
    private float price;
    private static short dph = 21;

    public Ware(String name, float price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getPrice() {
        return this.price*((dph/100)+1);
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public abstract String getUnit();


}
