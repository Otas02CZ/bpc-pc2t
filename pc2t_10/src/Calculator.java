import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Calculator extends JFrame {
    private ArrayList<JButton> buttons = new ArrayList<>();
    private JLabel display;
    private Font font;
    private JPanel displayPanel;
    private JPanel midButtonPanel;
    private JPanel botButtonPanel;
    Calculator() {
        this.setSize(600, 400);
        this.setVisible(true);
        this.setTitle("Ultra powerful calculator");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.font = new Font(Font.SANS_SERIF, Font.BOLD, 16);
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        this.addComponents();
    }

    private void addComponents() {
        this.setLayout(new GridLayout(3, 1));
        this.displayPanel = new JPanel(new GridLayout(1, 1));
        this.midButtonPanel = new JPanel(new GridLayout(3, 4));
        this.botButtonPanel = new JPanel(new GridLayout(1, 1));
        this.displayPanel.setVisible(true);
        this.midButtonPanel.setVisible(true);
        this.botButtonPanel.setVisible(true);
        this.getContentPane().add(this.displayPanel);
        this.getContentPane().add(this.midButtonPanel);
        this.getContentPane().add(this.botButtonPanel);
        this.display = new JLabel();
        this.display.setFont(this.font);
        this.display.setVisible(true);
        this.display.setText("0");
        this.display.setHorizontalAlignment(SwingConstants.RIGHT);
        this.displayPanel.add(this.display);
        String buttonText = "0123456789+-";
        for (int i=0;i<buttonText.length();i++) {
            JButton button = new JButton(String.valueOf(buttonText.charAt(i)));
            this.midButtonPanel.add(button);
            button.setFont(this.font);
            button.setVisible(true);
            this.buttons.add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                     buttonPressed(button.getText());
                }
            });
        }
        JButton button = new JButton("=");
        this.botButtonPanel.add(button);
        button.setFont(this.font);
        button.setVisible(true);
        this.buttons.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                buttonPressed("=");
            }
        });
    }
    public void buttonPressed(String text) {
        switch (text) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "0":
            case "+":
            case "-":
                this.display.setText(this.display.getText() + text);
                break;
            case "=":
                String displayText = this.display.getText();
                int numberA=0, numberB=0;
                String operation;
                int index = getIndex(displayText);
                if (index!=0) {
                    numberA = Integer.parseInt(displayText.substring(0, index));
                    displayText = displayText.substring(index);
                    operation = String.valueOf(displayText.charAt(0));
                    System.out.println(displayText);
                    System.out.println(displayText.length());
                    displayText = displayText.substring(0);
                    System.out.println(displayText.length());
                    System.out.println(numberA);
                    System.out.println(operation);
                    if (index != 0) {
                        numberB = Integer.parseInt(displayText);
                        System.out.println(numberB);
                        switch (operation) {
                            case "+":
                                numberA = numberA + numberB;
                                break;
                            case "-":
                                numberA = numberA + numberB;
                                break;
                        }
                    } else {
                        this.display.setText(String.valueOf(numberA));
                    }
                }
                    else {
                        this.display.setText("");
                        break;
                    }
                this.display.setText(String.valueOf(numberA));
                break;
            default:
                break;
        }
    }

    private int getIndex(String displayText) {
        int index = displayText.indexOf("+");
        if (index==-1) {
            index = displayText.indexOf("-");
            if (index==-1) {
                index = displayText.length()-1;
            }
        }
        return index;
    }
}
