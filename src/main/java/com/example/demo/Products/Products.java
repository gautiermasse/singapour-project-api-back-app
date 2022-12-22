package com.example.demo.Products;

public class Products {

    private final long id;
    private final String content;

    public Products(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
