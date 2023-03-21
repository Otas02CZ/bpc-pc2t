import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Test {

	public static int getOnlyWholeNumFromConsole(Scanner sc)
	{
		int inputNumber;
		try
		{
			inputNumber = sc.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("zadejte prosim cele cislo ");
			sc.nextLine();
			inputNumber = getOnlyWholeNumFromConsole(sc);
		}
		return inputNumber;
	}

	public static float getOnlyNumFromConsole(Scanner sc) {
		float inputNumber;
		try {
			inputNumber = sc.nextFloat();
		}
		catch (Exception e) {
			System.out.println("Nastala vyjimka typu "+e.toString());
			System.out.println("zadejte prosim cislo ");
			sc.nextLine();
			inputNumber = getOnlyNumFromConsole(sc);
		}
		return inputNumber;
	}
	


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Database StudentDB = new Database();
		float avg;
		int choice;
		boolean run = true;
		String name, fileName;
		while(run)
		{
			System.out.println("Vyberte pozadovanou cinnost:");
			System.out.println("1 .. Reset databaze");
			System.out.println("2 .. vlozeni noveho studenta");
			System.out.println("3 .. nastaveni prumeru studenta");
			System.out.println("4 .. vypis informace o studentovi");
			System.out.println("5 .. smazani studenta");
			System.out.println("6 .. vypis vsech jmen studentu v databazi");
			System.out.println("7 .. detailni vypis seznamu studentu");
			System.out.println("8 .. ulozeni databaze do souboru");
			System.out.println("9 .. nacteni databaze ze souboru");
			System.out.println("10 .. ukonceni aplikace");
			choice= getOnlyWholeNumFromConsole(sc);
			switch(choice)
			{
				case 1:
					StudentDB = new Database();
					break;
				case 2:
					try {
						StudentDB.setStudent();
					}
					catch (InputMismatchException e) {
						System.out.println("Zadali jste chybny vstup");
					}
					break;
				case 3:
					StudentDB.printAllStudentNames();
					System.out.println("Zadejte jmeno a prumer studenta");
					name = sc.next();
					avg = getOnlyNumFromConsole(sc);
					try {
						if (!StudentDB.setAverage(name, avg)) {
							System.out.println("Zadany student v databazi neni.");
						}
					}
					catch (AverageException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					StudentDB.printAllStudentNames();
					System.out.println("Zadejte jmeno studenta");
					name = sc.next();
					try {
						Student student = new Student();
						if (!StudentDB.getStudent(name, student)) {
							System.out.println("Student se zadanym jmenem v databazi neni.");
							break;
						}
						else
							System.out.println("Jmeno: " + student.getName() + " rok narozeni: " + student.getYear() + " avg: " + student.getAverage());
					}
					catch (AverageException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 5:
					StudentDB.printAllStudentNames();
					System.out.println("Zadejte jmeno studenta pro odstraneni.");
					name = sc.next();
					if (!StudentDB.removeStudent(name)) {
						System.out.printf("Student %s nebyl nalezen a tudiz nemuze byt odebran.\n", name);
					}
					else
						System.out.printf("Student %s byl uspesne odebran.\n", name);
					break;
				case 6:
					StudentDB.printAllStudentNames();
					break;
				case 7:
					StudentDB.printAllStudents();
					break;
				case 8:
					System.out.println("Zadejte nazev souboru pro ulozeni, bez pripony: ");
					try {
						fileName = sc.next();
						StudentDB.writeDBToFile(fileName);
						System.out.printf("Uspesne ulozeno do souboru \"%s.hmsd\".\n", fileName);
					}
					catch (IOException e) {
						System.out.println(e.getMessage());
						System.out.println(e.getCause());
						System.out.println("Nastala chyba pri ukladani.");
					}
					catch (InputMismatchException e) {
						System.out.println("Nastala chyba pri ziskavani jmena souboru.");
					}
					break;
				case 9:
					System.out.println("Zadejte nazev souboru pro nacteni, bez pripony: ");
					try {
						fileName = sc.next();
						StudentDB.loadDBFromFile(fileName);
						System.out.printf("Uspesne nacteno ze souboru \"%s.hmsd\".\n", fileName);
					}
					catch (IOException e) {
						System.out.println(e.getMessage());
						System.out.println("Nastala chyba pri nacitani.");
					}
					catch (ClassNotFoundException e) {
						System.out.println("Nastala chyba pri nacitani.");
					}
					catch (InputMismatchException e) {
						System.out.println("Nastala chyba pri ziskavani jmena souboru.");
					}
					break;
				case 10:
					run=false;
					break;
			}
			
		}
	}

}
