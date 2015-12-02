package com.pahilomaya.serviceTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseTest {

    String API_PATH = "http://localhost:8080/PahiloMaya/api/";
    protected ObjectMapper mapper = new ObjectMapper();
    protected HttpURLConnection conn;

    public HttpURLConnection connect(String path, String reqData) throws MalformedURLException, IOException {
        HttpURLConnection con = (HttpURLConnection) new URL(API_PATH + path).openConnection();
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);
        con.getOutputStream().write(reqData.getBytes("UTF-8"));
        con.getOutputStream().close();
        return con;
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

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public <E> E readResponse(HttpURLConnection conn, Class className) throws IOException {

        InputStream is = conn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder builder = new StringBuilder();
        String line = null;
        while ((line = br.readLine()) != null) {
            builder.append(line);
        }
        return (E) mapper.readValue(builder.toString(), className);
    }

}
