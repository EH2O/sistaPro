import javax.swing.*;
import java.awt.event.ActionListener;

public class View {
    private JTextArea money;
    private JPanel Base;
    private JButton clickButton;

    public JPanel getPanel() {
        return Base;
    }
    public void displayMoney(double m, double mps, double mpc){
        money.setText(m + "\nMPS: "+ mps +  "\nMPC: " + mpc);
    }
    public void setButtonPresser(ActionListener bp){
        clickButton.addActionListener(bp);
    }
}
