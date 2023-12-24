package com.example.finalappsmoviles_reforaccion;

public class Tip extends Post {
    // Atributo adicional
    private String category;

    // Constructor
    public Tip(String title, String description, String category, int imagePostId) {
        super(title, description, imagePostId);
        this.category = category;
    }

    // Getter y Setter específico para Tip
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}