
import java.util.Timer;
import java.util.TimerTask;

public class Model{

    int mps = 3;
    public int money = 0;
    public Model(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                update();
            }
        }, 0, 1000);
    }
    public void update(){
        this.money += this.mps;

    }
    public int getMoney(){
        return this.money;
    }
}
