package com.pahilomaya.serviceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.pahilomaya.restService.HelloRest;

public class HelloRestTest {

    HelloRest helloRest;

    @Before
    public void setup() {
        helloRest = new HelloRest();
    }

    @Test
    public void testSayHello() {
        assertEquals(helloRest.sayHello(), "Just syysss Want to say Hello");
    }
}
