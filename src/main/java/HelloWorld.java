import java.time.LocalDateTime;
import java.util.ResourceBundle;

/**
 * Created by Виталий on 12.09.2016.
 */
public class HelloWorld {

    ResourceBundle res;

    HelloWorld(){
        res = ResourceBundle.getBundle("helloworld");
    }

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        HelloWorld helloWorld = new HelloWorld();
        System.out.println(helloWorld.getMessage(now));
    }

    public String getMessage(LocalDateTime time) {
        int hour = time.getHour();
        if (hour >= 6 && hour < 9) {
            return res.getString("morning.message");
        }
        else if (hour >= 9 && hour < 19) {
            return res.getString("day.message");
        }
        else if (hour >= 19 && hour < 23) {
            return res.getString("evening.message");
        }
        else  {
            return res.getString("night.message");
        }
    }

}
