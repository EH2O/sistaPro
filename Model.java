import com.sun.security.ntlm.Client;

import javax.jws.WebParam;
import java.util.Timer;
import java.util.TimerTask;

public class Model{
    Controller c;
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
