import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controller extends JFrame{

    Model model;
    View view;
    public Controller(Model m, View v){
        this.model = m;
        this.view = v;
        this.setContentPane(view.getPanel());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        view.setButtonPresser(new bp());
        m.setController(this);
        m.start();

    }
    private class bp implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            model.clicked();



        }
    }
    public void ShowMoney(double m, double mps, double mpc){
        view.displayMoney(m, mps, mpc);
    }
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();

        Controller program = new Controller(model, view);

        program.setVisible(true);

    }
}
