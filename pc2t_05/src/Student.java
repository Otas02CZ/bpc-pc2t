import java.io.Serializable;

public class Student implements Serializable {
	public Student(String jmeno, int rocnik)
	{
		this.jmeno=jmeno;
		this.rocnik=rocnik;
	}
	
	public String getJmeno()
	{
		return jmeno;
	}
	
	public int getRocnik()
	{
		return rocnik;
	}
	
	public float getStudijniPrumer() throws prumerVyjimka{
		if (studijniPrumer==0) {
			throw new prumerVyjimka("Jeste nebyl zadan prumer.");
		}
		return studijniPrumer;
	}

	public void setStudijniPrumer(float studijniPrumer) throws prumerVyjimka{
		if (studijniPrumer < 1 || studijniPrumer > 5) {
			throw new prumerVyjimka("Chybna hodnota zadavaneho prumeru.");
		}
		this.studijniPrumer = studijniPrumer;
	}

	private String jmeno;
	private int rocnik;
	private float studijniPrumer;
}