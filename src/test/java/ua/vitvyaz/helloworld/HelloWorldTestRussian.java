package ua.vitvyaz.helloworld;

import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalTime;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

/**
 * Created by Vitalii Viazovoi on 18.09.2016.
 */
public class HelloWorldTestRussian {

    private HelloWorld helloWorld = new HelloWorld();;

    @BeforeClass
    public static void init() {
        Locale.setDefault(new Locale("ru"));
    }

    @Test
    public void testGetMessage08_59Russian() {
        LocalTime time = LocalTime.of(8, 59);
        assertEquals("Доброе утро, Мир!", helloWorld.getMessage(time));
    }

    @Test
    public void testGetMessage09_00Russian() {
        LocalTime time = LocalTime.of(9, 0);
        assertEquals("Добрый день, Мир!", helloWorld.getMessage(time));
    }

    @Test
    public void testGetMessage22_59Russian() {
        LocalTime time = LocalTime.of(22, 59);
        assertEquals("Добрый вечер, Мир!", helloWorld.getMessage(time));
    }

    @Test
    public void testGetMessage23_00Russian() {
        LocalTime time = LocalTime.of(23, 0);
        assertEquals("Доброй ночи, Мир!", helloWorld.getMessage(time));
    }

    @Test
    public void testGetMessage00_00Russian() {
        LocalTime time = LocalTime.of(0, 0);
        assertEquals("Доброй ночи, Мир!", helloWorld.getMessage(time));
    }

}
