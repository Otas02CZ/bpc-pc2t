public class Food extends Ware {
    private short bestBefore;

    public Food(String name, float price, short bestBefore) {
        super(name, price);
        this.bestBefore = bestBefore;
    }
    public short getBestBefore() {
        return this.bestBefore;
    }
    public void setBestBefore(short bestBefore) {
        this.bestBefore = bestBefore;
    }
    public String getUnit() {
        return "dnů";
    }
}
