import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.sql.*;
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

        m.setController(this);
        m.start();
        v.setButtonPresser(new bp(), 0);
        v.setButtonPresser(new up1(), 1);
    }
    private class bp implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.clicked();
        }
    }
    private class up1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            model.uppgrade(1);
            view.event(1, model.getOwned(1), model.getPrice(1));
        }
    }
    public void updateDisplay(double m, double mps, double mpc){
        view.displayMoney(m, mps, mpc);
    }
    public static void main(String[] args) {

        boolean Reg = true;
        boolean Login = true;
        Model model = new Model();

        String[] options = {"Login", "Register"};

        int x = JOptionPane.showOptionDialog(null, "Do you want to login or register?", "Login/Register", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if (x == 0){
            while (Login){
                String UserName = JOptionPane.showInputDialog(null, "Enter the username");
                String Password = JOptionPane.showInputDialog(null, "Enter the password");
                if(model.Login(UserName, Password)){
                    System.out.println("logged in");
                    Login = false;
                }
            }
        }
        else{

            while(Reg) {
                String UserName = JOptionPane.showInputDialog(null, "Username");
                String Password = JOptionPane.showInputDialog(null, "Password must be atleast 5 charaters long. (password sparas som det är för jag vet inte hur man krypterar det)");
                String CPassword = JOptionPane.showInputDialog(null, "Confirme password");

                if(Password.length() > 4 && Password.equals(CPassword)){
                    String test = model.userEx(UserName);
                    if (test.equals("")){
                        model.addTo(UserName, Password);
                        Reg = false;
                    }

                else{
                    JOptionPane.showMessageDialog(null, "Username already taken");

                }
            }else{
                JOptionPane.showMessageDialog(null, "Password to short or not matching");

            }


        }}
        View view = new View();

        Controller program = new Controller(model, view);

        program.setVisible(true);

    }

}
