import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Databaze {
	public Databaze()
	{
		DB = new HashMap<>();
		sc=new Scanner(System.in);
	}
	
	public void setStudent()
	{
		System.out.println("Zadejte jmeno studenta, rok narozeni");
		String jmeno=sc.next();
		int rok=sc.nextInt();
		DB.put(jmeno, new Student(jmeno, rok));
	}
	
	public Student getStudent(String name)
	{
		return DB.get(name);
	}
	
	public void setPrumer(String name, float prumer) throws prumerVyjimka, NullPointerException
	{
		DB.get(name).setStudijniPrumer(prumer);
	}
	
	private Scanner sc;
	private Student [] prvkyDatabaze;
	private Map<String, Student> DB;
}