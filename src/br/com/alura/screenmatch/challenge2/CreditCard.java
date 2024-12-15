package br.com.alura.screenmatch.challenge2;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {
    private final double limit;
    private double balance;
    private List<Product> listPurchasedProducts;

    public CreditCard(double limit){
        this.limit = limit;
        this.balance = limit;
        this.listPurchasedProducts = new ArrayList<>();
    }

    public double getLimit() {
        return limit;
    }

    public double getBalance() {
        return balance;
    }

    public List<Product> getListPurchasedProducts() {
        return listPurchasedProducts;
    }

    public boolean purchase(Product product){
        if(product.getPrice() > this.balance) {
            return false;
        }else {
            this.balance -= product.getPrice();
            listPurchasedProducts.add(product);
            return true;
        }
    }
}
