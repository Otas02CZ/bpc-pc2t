import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Database {
	public Database()
	{
		DB = new HashMap<>();
		sc=new Scanner(System.in);
	}

	public boolean studentExists(String name) {
		return DB.containsKey(name);
	}

	public void setStudent(String name, int rok)
	{
		DB.put(name, new Student(name, rok));
	}
	
	public boolean getStudent(String name, Student studentRef)
	{
		Student student = DB.get(name);
		if (student == null) return false;
		else {
			student.copyToReferenced(studentRef);
			return true;
		}
	}
	
	public boolean setAverage(String name, float prumer) throws AverageException
	{
		Student student = DB.get(name);
		if (student == null) return false;
		else  {
			student.setAverage(prumer);
			return true;
		}
	}

	public void printAllStudentNames() {
		Set<String> mapKeys = DB.keySet();
		for (String key:mapKeys) {
			System.out.printf("%s\n", DB.get(key).getName());
		}
		if (DB.isEmpty())
			System.out.println("Databaze je prazdna.");
	}

	public void printAllStudents() {
		Set<String> mapKeys = DB.keySet();
		for (String key:mapKeys) {
			Student student = DB.get(key);
			if (student.getName().equals("Peter")) {
				try {
					System.out.printf("Meno: %s, rok narodenia: %d, študijný prumer: %.2f\n", student.getName(), student.getYear(), student.getAverage());
				} catch (AverageException e) {
					System.out.printf("Meno: %s, rok narodenia: %d\n", student.getName(), student.getYear());
				}
			}
			else {
				try {
					System.out.printf("Jméno: %s, rok narození: %d, studijní průměr: %.2f\n", student.getName(), student.getYear(), student.getAverage());
				} catch (AverageException e) {
					System.out.printf("Jméno: %s, rok narození: %d\n", student.getName(), student.getYear());
				}
			}
		}
		if (DB.isEmpty())
			System.out.println("Databaze je prazdna.");
		else
			System.out.printf("V databazi je %d studentu.\n", DB.size());
	}

	public boolean removeStudent(String name) {
		Student student = DB.get(name);
		if (student == null)
			return false;
		else {
			DB.remove(name);
			return true;
		}

	}

	public void writeDBToFile(String fileName) throws IOException {
		FileOutputStream fos = new FileOutputStream(fileName+".hmsd");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(DB);
		fos.close();
	}

	public void loadDBFromFile(String fileName) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(fileName+".hmsd");
		ObjectInputStream ois = new ObjectInputStream(fis);
		DB = (HashMap)ois.readObject();
		fis.close();
	}
	
	private Scanner sc;
	private HashMap<String, Student> DB;
}