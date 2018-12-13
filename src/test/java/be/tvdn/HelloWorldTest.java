package be.tvdn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloWorldTest {

    @Test
    void sayHello() {
        HelloWorld helloWorld = new HelloWorld();
        assertEquals("Hello World", helloWorld.sayHello());
    }
}