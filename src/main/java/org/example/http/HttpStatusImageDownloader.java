package org.example.http;

import java.util.Objects;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusImageDownloader {
    HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
    public void downloadStatusImage(int code){
        String imageUrl = "https://http.cat/" + code + ".jpg";
        String destinationFile = getPath() + "img" + code + ".jpg";

        if(getImage(code)){
            try {
                URL url = new URL(imageUrl);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                InputStream inputStream = httpURLConnection.getInputStream();

                FileOutputStream fileOutputStream = new FileOutputStream(destinationFile);

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                }

                inputStream.close();
                fileOutputStream.close();

                httpURLConnection.disconnect();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Boolean getImage(int code){
        return !Objects.equals(httpStatusChecker.getStatusImage(code), "404");
    }
    private String getPath(){
        return HttpStatusImageDownloader.class.getProtectionDomain().
                getCodeSource().
                getLocation().
                getPath();
    }
}
