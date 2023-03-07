package pc2t_01;
import java.util.Scanner;

public class mymain {
	public static void main(String[] args) {
		int input = 0;
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			System.out.println("Test Prvociselnosti\nZadejte cislo nebo 0 pro ukonceni programu:");
			if (scan.hasNextInt())
			{
				input = scan.nextInt();
				System.out.println("Vami zadane cislo je " + input);
			}
			else {
				System.out.println("Nezadali jste cislo!");
				scan.nextLine();
				continue;
			}
			if (input == 0) {
				System.out.println("Ukoncuji");
				break;
			}
			isPrime(input);
		}
		scan.close();
	}
	
	public static void isPrime(int numberToCheck) {
		boolean primality = true;
		if (numberToCheck<2)
			primality = false;
		for (int i=2;i<numberToCheck;i++) {
			if (numberToCheck%i == 0) {
				if (primality)
					primality = false;
				System.out.println("Cislo je delitelne cislem " + i + ".");
			}
		}
		if (primality)
			System.out.println("Cislo " + numberToCheck + " je prvocislo.");
		else
			System.out.println("Cislo " + numberToCheck + " neni prvocislo.");
	}
}
