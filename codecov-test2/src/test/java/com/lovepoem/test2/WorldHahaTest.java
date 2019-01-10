package com.lovepoem.test2;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldHahaTest {
    private WorldHaha subject;

    @BeforeAll
    public void setup() {
        subject = new WorldHaha();
    }

    @Test
    public void testGetMessage() {
        assertEquals("WorldHaha small!", subject.getMessage(false));
    }

    @Test
    public void testGetMessage2() {
        assertEquals("WorldHaha big!", subject.getMessage(true));
    }

    @Test
    public void testFail() {
        Assertions.assertEquals(true, true);
    }

}
