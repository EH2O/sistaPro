
import java.sql.*;
import java.util.Timer;
import java.util.TimerTask;

public class Model{
    Connection conn = null;
    Controller c;
    double mps = 0;
    double money = 0;
    double mpc = 1;
    extraHands extraHands = new extraHands();
    public Model(){

    }
    public void update(){
        this.money += this.mps;
        c.updateDisplay(this.money, this.mps, this.mpc);

    }
    public void start(){

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                update();
            }}, 0, 1000);

    }
    public double getMoney(){
        return this.money;
    }

    public void setController(Controller c) {
        this.c = c;
    }

    public void clicked() {
        money += mpc;
        c.updateDisplay(money, mps, mpc);
    }
    public void uppgrade(int id) {
        if (id == 1 && money >= extraHands.getPrice()){

            mpc += extraHands.getMpsUp();
            money -= extraHands.getPrice();
            extraHands.bought();
        }
        c.updateDisplay(money, mps, mpc);
    }

    public int getOwned(int i) {
        if (i == 1){
            return extraHands.getOwned();
    }
        return 404;
    }

    public int getPrice(int i) {
        if (i == 1){
            return extraHands.getPrice();
        }
        return 418;
    }
    public  String userEx(String UserName) {
        Statement stmt = null;
        String ans = "";
        MakeConnection();
        try {
            stmt = conn.createStatement();
            String userExsist = "SELECT player FROM eho02cg WHERE player = '" + UserName + "'";
            ResultSet result = stmt.executeQuery(userExsist);
            ans = result.getString("player");
            System.out.println("ans");
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ans;
    }
    public void MakeConnection(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://"+ DatabaseInfo.ip +":"+ DatabaseInfo.port +"/"+ DatabaseInfo.base +"? "+
                    "allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",DatabaseInfo.user,DatabaseInfo.password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addTo(String UserName, String password) {
        Statement stmt = null;
        String ans;
        String blank = "x";
        MakeConnection();
        try {
            PreparedStatement stmt2 = conn.prepareStatement("INSERT INTO eho02cg(player, password, cgs) VALUES (?, ?, ?)");

            stmt2.setString(1, UserName);
            stmt2.setString(2, password);
            stmt2.setString(3, "x");

            stmt2.executeUpdate();
            stmt2.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public boolean Login(String UserName, String password){
        Statement stmt = null;
        boolean ans = false;
        MakeConnection();
        try {
            stmt = conn.createStatement();
            String userExsist = "SELECT password FROM eho02cg WHERE player = '" + UserName + "'";
            ResultSet result = stmt.executeQuery(userExsist);
            if(password.equals(result.getString("password"))){
                ans = true;
            }else {
                ans = false;
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("smth went wrong");
        }
        return ans;

    }
}
