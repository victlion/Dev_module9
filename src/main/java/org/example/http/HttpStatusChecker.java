package org.example.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class HttpStatusChecker {

    public String getStatusImage(int code){
        String response = "";
        try {
            URL url = new URL("https://http.cat/" + code + ".jpg");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            response = String.valueOf(connection.getResponseCode());

            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}