package br.com.alura.screenmatch.challenge2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double limit;
        int condition;

        System.out.println("Enter your credit card limit:");
        limit = scanner.nextDouble();
        CreditCard card = new CreditCard(limit);

        do {
            String name;
            double price;
            System.out.println("Product name: ");
            name = scanner.next();
            System.out.println("Product price: ");
            price = scanner.nextDouble();

            Product product = new Product(name, price);
            if (card.purchase(product)) {
                System.out.println("Purchase made");
            } else {
                System.out.println("Insufficient balance");
            }
            System.out.println("Enter 0 to exit 1 to continue shopping");
            condition = scanner.nextInt();
            System.out.println();
        }while (condition != 0);

        System.out.println("*********************\n");

        for (Product product : card.getListPurchasedProducts()){
            System.out.println(product);
        }
        System.out.printf("Balance: %.2f", card.getBalance());
        System.out.println("\n\n*********************");

    }
}
