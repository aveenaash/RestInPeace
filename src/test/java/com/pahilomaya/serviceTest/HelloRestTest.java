package com.pahilomaya.serviceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.pahilomaya.restService.HelloRest;

public class HelloRestTest extends BaseTest {

    /*
     * Avoid using this method because the app runs test before being built. So it will always fail.
     * 
     * HttpURLConnection conn;
     * 
     * @Before public void setup() { // helloRest = new HelloRest(); }
     * 
     * @Test public void testSayHello() throws Exception { conn = connect("/pahilo");
     * 
     * conn.setRequestProperty("Content-Type", "application/json"); conn.setDoOutput(true); //
     * conn.getOutputStream().write(data.getBytes("UTF-8")); conn.getOutputStream().close(); assertEquals(readResponse(conn),
     * "Want to say Hello"); }
     */

    HelloRest helloRest;

    @Before
    public void setups() {
        helloRest = new HelloRest();
    }

    @Test
    public void testHello() {
        assertEquals(helloRest.sayHello(), "");
    }
}
