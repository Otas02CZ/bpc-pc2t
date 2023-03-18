public class Test {
    public static void main(String[] args) {
        Ware[] listOfWares = new Ware[4];
        listOfWares[0] = new Food("Rohlík", (float) 1.5, (short) 1);
        listOfWares[1] = new Tool("Kleště",278f, (short) 24);
        listOfWares[2] = new Food("Chleba", 20.8f, (short) 6);
        listOfWares[3] = new Food("Jablko", 51f,(short) 20);
        for(int index=0;index<listOfWares.length;index++) {
            Ware ware = listOfWares[index];
            if (ware instanceof Food) {
                System.out.printf("%s, cena: %.2f, trvanlivost: %d %s\n", ware.getName(), ware.getPrice(), ((Food) ware).getBestBefore(), ware.getUnit());
            }
            else if (ware instanceof Tool) {
                System.out.printf("%s, cena: %.2f\n", ware.getName(), ware.getPrice());
            }

        }
    }
}
