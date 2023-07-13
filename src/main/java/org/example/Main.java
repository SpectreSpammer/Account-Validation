package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final String CREDENTIALS_FILE = "C:\\Users\\MUGIWARA\\Desktop\\Intellij Projects\\credentials.txt";
    public static void main(String[] args) {
             Scanner scanner = new Scanner(System.in);


            System.out.print("Enter your username: ");
            String username = scanner.nextLine();

            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            if (validateUsername(username) && validatePassword(password)) {
                storeCredentials(username, password);
                System.out.println("Credentials saved successfully!");
            } else {
                System.out.println("Invalid username or password.");
                System.out.println("******************");
            }


    }


    public static boolean validateUsername(String username) {

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);

        return pattern.matcher(username).matches();
    }

    public static boolean validatePassword(String password) {

        Pattern pattern;
        if(password.length() >= 12){
            String passwordRegex = "[A-Za-z0-9+_.&#@!%^*()-]+";
             pattern = Pattern.compile(passwordRegex);
        }else{
            System.out.println("Your password should be contains a special character and atleast 6 characters or above");
            return false;
        }

        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    private static void storeCredentials(String username, String password) {
        try (FileWriter writer = new FileWriter(CREDENTIALS_FILE,true)) {
            writer.write("Username: " + username + "\n");
            writer.write("Password: " + password + "\n");
            writer.write("\n");
        } catch (IOException e) {
            System.out.println("Error occurred while storing credentials: " + e.getMessage());
        }
    }
}
