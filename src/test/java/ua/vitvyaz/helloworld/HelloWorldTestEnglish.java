package ua.vitvyaz.helloworld;

import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalTime;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

/**
 * Tests class HelloWorld with English locale
 * Created by Vitalii Viazovoi on 18.09.2016.
 */
public class HelloWorldTestEnglish {

    private HelloWorld helloWorld = new HelloWorld();;

    @BeforeClass
    public static void init() {
        Locale.setDefault(new Locale("en"));
    }

    @Test
    public void testGetMessage08_59English() {
        LocalTime time = LocalTime.of(8, 59);
        assertEquals("Good morning, World!", helloWorld.getMessage(time));
    }

    @Test
    public void testGetMessage09_00English() {
        LocalTime time = LocalTime.of(9, 0);
        assertEquals("Good day, World!", helloWorld.getMessage(time));
    }

    @Test
    public void testGetMessage22_59English() {
        LocalTime time = LocalTime.of(22, 59);
        assertEquals("Good evening, World!", helloWorld.getMessage(time));
    }

    @Test
    public void testGetMessage23_00English() {
        LocalTime time = LocalTime.of(23, 0);
        assertEquals("Good night, World!", helloWorld.getMessage(time));
    }

    @Test
    public void testGetMessage00_00English() {
        LocalTime time = LocalTime.of(0, 0);
        assertEquals("Good night, World!", helloWorld.getMessage(time));
    }
}
