package com.lovepoem.test2;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloWorld2Test {

    private HelloWorld2 subject;

    @BeforeEach
    public void setup() {
        subject = new HelloWorld2();
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
