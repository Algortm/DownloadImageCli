package org.example;
import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus(){
        Scanner scanner = new Scanner(System.in);
        int code;
        while(true){
            System.out.println("Input code in console:\n");
            try{
                code = scanner.nextInt();
                HttpStatusImageDownloader img = new HttpStatusImageDownloader();
                try {
                    img.downloadStatusImage(code);
                    System.out.println("Image download for HTTP status - " + code);
                } catch (ResourceNotFoundException e) {
                    System.out.println("There is not image for HTTP status " + code);
                }
            } catch (Exception e){
                System.out.println("Please enter valid number");
                scanner = new Scanner(System.in);
            }
        }
    }
}
