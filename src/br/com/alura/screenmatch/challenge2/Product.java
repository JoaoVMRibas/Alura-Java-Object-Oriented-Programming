package br.com.alura.screenmatch.challenge2;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return """
               Product: %s - %.2f
               """.formatted(this.name, this.price);
    }
}
