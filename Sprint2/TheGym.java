package Sprint2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TheGym {

    public static void main(String[] args) {
        boolean customerFound = false;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter social security number or name: ");
        String input = scanner.nextLine().trim();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/Sprint2/GymData.txt"))) {
            String line;
            String socialSecurityNumber = "";
            String name = "";
            String paymentDateStr = "";
            boolean readingName = false;

            while ((line = reader.readLine()) != null) {
                if (!readingName) {
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        socialSecurityNumber = parts[0].trim();
                        name = parts[1].trim();
                        readingName = true;
                    }
                } else {
                    readingName = false;
                    paymentDateStr = line.trim();
                    LocalDate paymentDate = LocalDate.parse(paymentDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    LocalDate today = LocalDate.now();

                    if (socialSecurityNumber.equals(input) || name.equals(input)) {
                        System.out.println("Customer found:");
                        System.out.println("Social Security Number: " + socialSecurityNumber);
                        System.out.println("Name: " + name);
                        if (today.minusYears(1).isBefore(paymentDate)) {
                            System.out.println(name + " is a paying customer.");
                            customerFound = true;

                            try (BufferedWriter trainingWriter = new BufferedWriter(new FileWriter("src/Sprint2/PersonalTraining.txt", true))) {
                                LocalDate trainingDate = LocalDate.now();
                                trainingWriter.write(socialSecurityNumber + "," + name + "," + trainingDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                                trainingWriter.newLine();
                                System.out.println("Training information saved.");
                            } catch (IOException e) {
                                System.err.println("An error occurred while writing personal training information: " + e.getMessage());

                            }
                        } else {
                            System.out.println(name + " is a former customer.");
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());

        }

        if (!customerFound) {
            System.out.println("The person is unauthorized.");
        }
    }
}
