package com.pahilomaya.serviceTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    String API_PATH = "http://localhost:8080/PahiloMaya/api";

    public HttpURLConnection connect(String path) throws MalformedURLException, IOException {
        return (HttpURLConnection) new URL(API_PATH + path).openConnection();
    }

    public String readResponse(HttpURLConnection conn) throws IOException {

        InputStream is = conn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder builder = new StringBuilder();
        String line = null;
        while ((line = br.readLine()) != null) {
            builder.append(line);
        }

        return builder.toString();
    }
}
