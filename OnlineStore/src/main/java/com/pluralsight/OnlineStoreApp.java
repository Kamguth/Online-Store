package com.pluralsight;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class OnlineStoreApp {
    public static void main(String[] args) {
        HashMap<Integer, Product> products = getProduct();

        Scanner keyboard = new Scanner(System.in);
        System.out.println("---Welcome to the Inventory Management System---\n");

        while (true) {
            System.out.println("Please choose from the following options\n");
            System.out.println("1- List all products\n" +
                    "2- Lookup a product\n" +
                    "3- Add a product\n" +
                    "4- Remove a product");
            System.out.print("Enter Selection: ");

            int selection = keyboard.nextInt();
            keyboard.nextLine(); 

            switch (selection) {
                case 1:
                    System.out.println("\n--- Product List ---");
                    for (Product p : products.values()) {
                        System.out.println(p);
                    }
                    System.out.println();
                    break;
                default:
                    System.out.println("Option not implemented yet.\n");
                    break;
            }
        }
    }

    public static HashMap<Integer, Product> getProduct() {
        ArrayList<Product> product = new ArrayList<Product>();


        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/products.csv"))) {
            String file;
            while ((file = br.readLine()) != null) {
                String[] parts = file.split("\\|");

                double price = Double.parseDouble(parts[2]);

            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return product;
    }
}

