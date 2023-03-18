public class Tool extends Ware{
    private short warranty;

    public Tool(String name, float price, short warranty) {
        super(name, price);
        this.warranty = warranty;
    }
    public short getWarranty() {
        return this.warranty;
    }
    public void setWarranty(short warranty) {
        this.warranty = warranty;
    }
    public String getUnit() {
        return "měsíců";
    }
}
