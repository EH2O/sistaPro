import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Controller {
    public static void main(String[] args) {
        Model model = new Model();
        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        // Reading data using readLine
        String name = null;
        while (!Objects.equals(name, "stop")){
            try {
                name = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if(name.equals("get money")){
                System.out.println(model.getMoney());
            }
        }

    }
}
