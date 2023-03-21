import java.io.Serializable;

public class Student implements Serializable {
	public Student() {

	}
	public Student(String name, int year)
	{
		this.name = name;
		this.year = year;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public float getAverage() throws AverageException {
		if (average ==0) {
			throw new AverageException("Jeste nebyl zadan prumer.");
		}
		return average;
	}

	public void setAverage(float average) throws AverageException {
		if (average < 1 || average > 5) {
			throw new AverageException("Chybna hodnota zadavaneho prumeru.");
		}
		this.average = average;
	}

	public void copyToReferenced(Student studentRef) {
		studentRef.name = name;
		studentRef.year = year;
		studentRef.average = average;
	}

	private String name;
	private int year;
	private float average;
}