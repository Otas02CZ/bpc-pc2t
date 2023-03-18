import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Test {

	public static int pouzeCelaCisla(Scanner sc) 
	{
		int cislo = 0;
		try
		{
			cislo = sc.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("zadejte prosim cele cislo ");
			sc.nextLine();
			cislo = pouzeCelaCisla(sc);
		}
		return cislo;
	}

	public static float pouzeCisla(Scanner sc) {
		float cislo = 0;
		try {
			cislo = sc.nextFloat();
		}
		catch (Exception e) {
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("zadejte prosim cislo ");
			sc.nextLine();
			cislo = pouzeCisla(sc);
		}
		return cislo;
	}
	


	public static void main(String[] args) {	
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Databaze mojeDatabaze=new Databaze(1);
		int idx;
		float prumer;
		int volba;
		boolean run=true;
		String fileName;
		while(run)
		{
			System.out.println("Vyberte pozadovanou cinnost:");
			System.out.println("1 .. vytvoreni nove databaze");
			System.out.println("2 .. vlozeni noveho studenta");
			System.out.println("3 .. nastaveni prumeru studenta");
			System.out.println("4 .. vypis informace o studentovi");
			System.out.println("5 .. vypis seznamu vsech studentu");
			System.out.println("6 .. ulozeni do souboru");
			System.out.println("7 .. nacteni ze souboru");
			System.out.println("8 .. ukonceni aplikace");
			volba=pouzeCelaCisla(sc);
			switch(volba)
			{
				case 1:
					System.out.println("Zadejte pocet studentu");
					mojeDatabaze = new Databaze(Math.abs(pouzeCelaCisla(sc)));
					break;
				case 2:
					try {
						mojeDatabaze.setStudent();
					}
					catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("V databazi jiz neni volne misto.");
					}
					catch (InputMismatchException e) {
						System.out.println("Zadali jste chybny vstup");
					}
					break;
				case 3:
					mojeDatabaze.printStudents();
					System.out.println("Zadejte index a prumer studenta");
					idx = pouzeCelaCisla(sc);
					prumer = pouzeCisla(sc);
					try {
						mojeDatabaze.setPrumer(idx, prumer);
					}
					catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("Zadali jste spatny index.");
					}
					catch (NullPointerException e) {
						System.out.println("Polozka neexistuje.");
					}
					catch (prumerVyjimka e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					System.out.println("Zadejte index studenta");
					idx=pouzeCelaCisla(sc);
					try {
						Student info=mojeDatabaze.getStudent(idx);
						System.out.println("Jmeno: " + info.getJmeno() + " rok narozeni: " + info.getRocnik() + " prumer: " + info.getStudijniPrumer());
					}
					catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("Zadali jste chybny index studenta.");
					}
					catch (NullPointerException e) {
						System.out.println("Polozka neexistuje.");
					}
					catch (prumerVyjimka e) {
						System.out.println(e.getMessage());
					}
					break;
				case 5:
					mojeDatabaze.printStudents();
					break;
				case 6:
					System.out.print("Zadejte nazev souboru pro ulozeni: ");
					try {
						fileName = sc.next();
						mojeDatabaze.writeDBToFile(fileName);
						System.out.printf("Uspesne ulozeno do souboru \"%s\".\n", fileName);
					}
					catch (IOException e) {
						System.out.println(e.getMessage());
						System.out.println("Nastala chyba pri ukladani.");
					}
					catch (InputMismatchException e) {
						System.out.println("Nastala chyba pri ziskavani jmena souboru.");
					}
					break;
				case 7:
					System.out.print("Zadejte nazev souboru pro nacteni: ");
					try {
						fileName = sc.next();
						mojeDatabaze.loadDBFromFile(fileName);
						System.out.printf("Uspesne nacteno ze souboru \"%s\".\n", fileName);
					}
					catch (IOException e) {
						System.out.println("Nastala chyba pri ukladani.");
					}
					catch (ClassNotFoundException e) {
						System.out.println("Nastala chyba pri nacteni.");
					}
					catch (InputMismatchException e) {
						System.out.println("Nastala chyba pri ziskavani jmena souboru.");
					}
					break;
				case 8:
					run=false;
					break;
			}
			
		}
	}

}
