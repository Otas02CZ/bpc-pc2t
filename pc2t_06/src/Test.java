public class Test {
    public static void main(String[] args) {
        Ware[] listOfWares = new Ware[4];
        listOfWares[0] = new Food("Rohlík", (float) 1.5, (short) 1);
        listOfWares[1] = new Tool("Kleště",(float) 278, (short) 24);
        listOfWares[2] = new Food("Chleba", (float) 20.8, (short) 6);
        listOfWares[3] = new Food("Jablko", (float) 51,(short) 20);
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
