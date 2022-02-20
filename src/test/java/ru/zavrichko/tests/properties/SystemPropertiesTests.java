package ru.zavrichko.tests.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class SystemPropertiesTests {


    @Test
    void someTest1() {
        String someValue = System.getProperty("someKey");
        System.out.println(someValue); // null
    }

    @Test
    void someTest2() {
        System.setProperty("someKey", "red value");
        String someValue = System.getProperty("someKey");
        System.out.println(someValue); // red value
    }

    @Test
    void someTest3() {
        String someValue = System.getProperty("someKey", "blue value");
        System.out.println(someValue);
    }

    @Test
    @Tag("properties")
    void someTest5() {
        String browser = System.getProperty("browser");
        System.out.println(browser);
    }

    @Test
    @Tag("properties")
    void someTest6() {
        String browser = System.getProperty("browser", "chrome");
        String version = System.getProperty("version", "91");
        String browserSize = System.getProperty("browserSize", "300x300");

        System.out.println(browser);
        System.out.println(version);
        System.out.println(browserSize);
    }


    @Test
    @Tag("properties")
    void someTest7() {
        System.out.println("I want to say: " + System.getProperty("someText"));
    }
}