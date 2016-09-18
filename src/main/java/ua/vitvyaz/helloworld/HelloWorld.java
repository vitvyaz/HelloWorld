package ua.vitvyaz.helloworld;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by vitvyaz on 12.09.2016.
 */
public class HelloWorld {

    public static final Logger LOG = LogManager.getLogger(HelloWorld.class);
    ResourceBundle res;

    HelloWorld(){
        LOG.trace("Constructor ua.vitvyaz.helloworld.HelloWorld()");
        LOG.trace("read data from file helloworld.properties");
        res = ResourceBundle.getBundle("helloworld");
    }

    public static void main(String[] args) {
        Locale defaultLocale = Locale.getDefault();
        System.out.println(defaultLocale);
        Locale.setDefault(new Locale("en"));
        System.out.println(Locale.getDefault());


        LOG.traceEntry("method main()");

        LocalDateTime now = LocalDateTime.now();
        LOG.info("now = " + now.toLocalDate() + " " + now.toLocalTime());

        HelloWorld helloWorld = new HelloWorld();
        System.out.println(helloWorld.getMessage(now));
        LOG.trace("exit from main()");

        Locale.setDefault(defaultLocale);
        System.out.println(Locale.getDefault());
    }

    public String getMessage(LocalDateTime time) {
        LOG.traceEntry("getMessage()");
        int hour = time.getHour();
        LOG.info("hour = " + hour);
        if (hour >= 6 && hour < 9) {
            LOG.info("return morning.message");
            return res.getString("morning.message");
        }
        else if (hour >= 9 && hour < 19) {
            LOG.info("return day.message");
            return res.getString("day.message");
        }
        else if (hour >= 19 && hour < 23) {
            LOG.info("return evening.message");
            return res.getString("evening.message");
        }
        else  {
            LOG.info("return night.message");
            return res.getString("night.message");
        }
    }

}
