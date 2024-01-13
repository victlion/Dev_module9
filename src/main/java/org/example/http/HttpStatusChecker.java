package org.example.http;

import org.example.exception.ImageNotFoundException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class HttpStatusChecker {

    public String getStatusImage(int code) {
        String response = "";
        try {
            URL url = new URL("https://http.cat/" + code + ".jpg");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int statusCode = connection.getResponseCode();
            if (statusCode == 404) {
                throw new ImageNotFoundException("Image not found (404)");
            }
            response = url.toString();

            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ImageNotFoundException e) {
            throw new RuntimeException(e);
        }
        return response;
    }
}
