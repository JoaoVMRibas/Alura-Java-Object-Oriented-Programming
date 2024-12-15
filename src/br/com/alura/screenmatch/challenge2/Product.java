package br.com.alura.screenmatch.challenge2;

public class Product implements Comparable<Product> {
    private final String name;
    private final double price;

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

    @Override
    public int compareTo(Product otherProduct) {
        if(this.price < otherProduct.price){
            return -1;
        } else if (this.price > otherProduct.price) {
            return 1;
        }
        return 0;
    }
}
