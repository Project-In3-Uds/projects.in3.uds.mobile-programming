package com.example.metsanouuds;

public class Article {
    private int imageResId;
    private String description;
    private int quantity;
    private int price;
    private String name;

    public Article(int imageResId, String name, String description, int quantity, int price) {
        this.imageResId = imageResId;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public int getImageResId() { return imageResId; }
    public String getDescription() { return description; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public int getPrice() { return price; }
    public String getName() { return name; }
}

