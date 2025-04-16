package com.example.metsanouuds;

public class Article {
    private int imageResId;
    private String description;
    private int quantity;
    private int price;

    public Article(int imageResId, String description, int quantity, int price) {
        this.imageResId = imageResId;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public int getImageResId() { return imageResId; }
    public String getDescription() { return description; }
    public int getQuantity() { return quantity; }
    public int getPrice() { return price; }
}

