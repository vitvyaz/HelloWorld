package ua.vitvyaz.helloworld;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalTime;
import java.util.ResourceBundle;

/**
 * Simple concole application.
 * Says Good day, World! or Good evening, World! etc.
 * Uses Log4j 2 for logging and properties for localisation
 *
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

        LOG.traceEntry("method main()");

        LocalTime now = LocalTime.now();
        LOG.info("now (current  time) = " + now);

        HelloWorld helloWorld = new HelloWorld();
        System.out.println(helloWorld.getMessage(now));
        LOG.trace("exit from main()\n--");
    }

    public String getMessage(LocalTime time) {
        LOG.traceEntry("getMessage()");
        int hour = time.getHour();
        LOG.info("hour = " + hour);
        if (hour >= 6 && hour < 9) {
            return getPropertyMessage("morning.message");
        }
        else if (hour >= 9 && hour < 19) {
            return getPropertyMessage("day.message");
        }
        else if (hour >= 19 && hour < 23) {
            return getPropertyMessage("evening.message");
        } else {
            return getPropertyMessage("night.message");
        }
    }

    private String getPropertyMessage(String property) {
        String message = res.getString(property);
        LOG.info("return " + property + ": " + message);
        return message;
    }

}
