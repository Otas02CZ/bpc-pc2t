import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class CatImpl implements Animal {

    public void sound() {
        System.out.println("manu mnau");
    }

    @Override
    public String toString() {
        return "mnau mnau";
    }

    public void writeMeToFile() throws IOException {
        PrintWriter writer = new PrintWriter("cat.txt", "UTF-8");
        writer.println(this.toString());
        writer.close();
    }
}
