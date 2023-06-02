import javax.swing.*;
import java.awt.event.ActionListener;

public class View {
    private JTextArea money;
    private JPanel Base;
    private JButton clickButton;
    private JButton qwertyu;
    private JButton extraHands;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;

    public JPanel getPanel() {
        return Base;
    }
    public void displayMoney(double m, double mps, double mpc){
        money.setText("Total happiness: " + m + "\nHappiness per second : "+ mps +  "\nHappiness per pat: " + mpc);
    }
    public void setButtonPresser(ActionListener bp, int id){
        if(id == 0){
            clickButton.addActionListener(bp);
        }
        if(id == 1){
            extraHands.addActionListener(bp);
        }

    }
    public void event (int id, int owned, int price){
        if(id == 1){
            extraHands.setText("Extra hands!!    " +  "owned: " + owned+ "    " + "price: " + price);
        }


    }

}
