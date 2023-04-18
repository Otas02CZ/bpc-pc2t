import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Okno extends JFrame {
    List<JDialog>  okna = new ArrayList<>();
    public Okno() {
        super();
        this.setSize(400, 300);
        this.setVisible(true);
        this.setTitle("Moje okno");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (int i=0;i<1000;i++) {
            JDialog moje_okno = new JDialog();
            moje_okno.setTitle("Muj dialog");
            moje_okno.setSize(200, 100);
            moje_okno.setVisible(true);
            okna.add(moje_okno);
        }
    }
}
