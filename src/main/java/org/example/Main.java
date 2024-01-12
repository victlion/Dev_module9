package org.example;

import org.example.http.HttpImageStatusCli;
import org.example.http.HttpStatusChecker;
import org.example.http.HttpStatusImageDownloader;

public class Main {
    public static void main(String[] args) {
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
        HttpImageStatusCli httpImageStatusCli = new HttpImageStatusCli();

//        System.out.println(httpStatusChecker.getStatusImage(202));
//        httpStatusImageDownloader.downloadStatusImage(400);
        httpImageStatusCli.askStatus();
    }
}