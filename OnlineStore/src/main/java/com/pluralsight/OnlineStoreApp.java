package com.pluralsight;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class OnlineStoreApp {
    public static void main(String[] args) {
        ArrayList<Product> products = getProduct();

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
                    for (Product p : products) {
                        System.out.println(p.getSku() + "|" + p.getName() + "|" + p.getPrice() + "|" + p.getDepartment());
                    }
                    System.out.println();
                    break;
                default:
                    System.out.println("Option not implemented yet.\n");
                    break;
            }
        }
    }
    
    }
   public static ArrayList<Product> getProduct() {
        ArrayList<Product> product = new ArrayList<Product>();

        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/products.csv"))) {
            br.readLine();
            String file;
            while ((file = br.readLine()) != null) {
                String[] parts = file.split("\\|");

                String sku = parts[0];
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                String department = parts[3];

                product.add(new Product(sku, name, price, department));
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return product;
    }


