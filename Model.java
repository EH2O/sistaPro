
import java.util.Timer;
import java.util.TimerTask;

public class Model{
    Controller c;
    double mps = 0;
    double money = 0;
    double mpc = 1;
    public Model(){

    }
    public void update(){
        this.money += this.mps;
        c.ShowMoney(this.money, this.mps, this.mpc);

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
        c.ShowMoney(money, mps, mpc);
    }
}
