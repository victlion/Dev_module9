package org.example.http;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {
   public void askStatus(){
       HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
       HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();

       System.out.print("Enter HTTP status code : ");
       Scanner scanner = new Scanner(System.in);
       try {
           int code = scanner.nextInt();
           if(httpStatusChecker.getStatusImage(code).equals("200")){
               httpStatusImageDownloader.downloadStatusImage(code);
               System.out.println("200");
           }else {
               System.out.println("There is not image for HTTP status " + code);
           }
       }catch (InputMismatchException e){
           System.out.println("Please enter valid number");
       }
    }
}
