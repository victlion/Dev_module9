package org.example.http;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus() {
        HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
        int code = 0;
        System.out.print("Enter HTTP status code : ");
        Scanner scanner = new Scanner(System.in);
        try {
            code = scanner.nextInt();
            httpStatusImageDownloader.downloadStatusImage(code);
            System.out.println("200");
        } catch (InputMismatchException e) {
            System.out.println("Please enter valid number");
        } catch (RuntimeException i) {
            System.out.println("There is not image for HTTP status " + code);
        }
    }
}
