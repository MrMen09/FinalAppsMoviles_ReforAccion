package com.example.finalappsmoviles_reforaccion;

public class Post {
    // Atributos
    private String title;
    private String description;

    private int imagePostId;

    // Constructor
    public Post(String title, String description, int imagePostId) {
        this.title = title;
        this.description = description;
        this.imagePostId = imagePostId;
    }

    // Getters y Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImagePostId(){return imagePostId;}

    public void setImagePostId(int imagePostId){ this.imagePostId = imagePostId;}
}
