package com.example.producttest;

public class Product {
    public String name;
    private int quantity;
    private double cost;

    Product(String n, int quant, double cost){
        name = n;
        quantity = quant;
        this.cost = cost;

    }

    //getter setter


    public void addQuantity(double amt) {
        quantity += amt;
    }

    public void purchase(){
        quantity--;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getCost() {
        return cost;
    }

    public String toString(){
        //return "Product Name: "+name+" Quantity: "+quantity+" Cost: "+cost;
        return name;
    }
}
