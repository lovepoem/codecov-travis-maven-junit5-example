package com.lovepoem.test1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloWorldTest {

    private HelloWorld subject;

    @BeforeAll
    public void setup() {
        subject = new HelloWorld();
    }

    @Test
    public void testGetMessage() {
        assertEquals("Hello World!", subject.getMessage(false));
    }

    @Test
    public void testGetMessage2() {
        assertEquals("Hello Universe!", subject.getMessage(true));
    }

}
