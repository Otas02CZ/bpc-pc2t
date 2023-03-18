import java.io.*;
import java.util.Scanner;

public class Databaze {
	public Databaze(int pocetPrvku)
	{
		prvkyDatabaze=new Student[pocetPrvku];
		sc=new Scanner(System.in);
	}
	
	public void setStudent()
	{
		System.out.println("Zadejte jmeno studenta, rok narozeni");
		String jmeno=sc.next();
		int rok=sc.nextInt();
		prvkyDatabaze[posledniStudent++]=new Student(jmeno,rok);
	}
	
	public Student getStudent(int idx)
	{
		return prvkyDatabaze[idx];
	}
	
	public void setPrumer(int idx, float prumer) throws prumerVyjimka
	{
		prvkyDatabaze[idx].setStudijniPrumer(prumer);
	}

	public void printStudents(){
		int lastIndex = -1;
		for (int index=0;index<prvkyDatabaze.length;index++) {
			if (prvkyDatabaze[index]!=null) {
				Student student = prvkyDatabaze[index];
				try {
					System.out.printf("ID: %d - Jméno: %s, rok narození: %d, studijní průměr: %.2f\n", index, student.getJmeno(), student.getRocnik(), student.getStudijniPrumer());
				}
				catch (prumerVyjimka e) {
					System.out.printf("ID: %d - Jméno: %s, rok narození: %d\n", index, student.getJmeno(), student.getRocnik());
				}
				lastIndex = index;
			}
			else {
				System.out.printf("ID: %d - Toto misto databaze je prazdne.\n", index);
			}
		}

		if(lastIndex==-1)
			System.out.println("Databaze je prazdna.");
		else
			System.out.printf("V databazi je %d/%d prvku\n", lastIndex+1, prvkyDatabaze.length);
	}

	public void writeDBToFile(String fileName) throws IOException {
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(prvkyDatabaze);
		fos.close();
	}

	public void loadDBFromFile(String fileName) throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		prvkyDatabaze = (Student[]) ois.readObject();
		fis.close();
	}
	
	private Scanner sc;
	private Student [] prvkyDatabaze;
	private int posledniStudent;
}