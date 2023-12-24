package com.example.finalappsmoviles_reforaccion;

import java.util.ArrayList;
import java.util.List;

public class Activity extends Post {
    // Atributos
    private String date;
    private String ubication;

    private static List<Activity> activitiesList = new ArrayList<>();

    // Constructor
    public Activity(String title, String description, String date, String ubication, int imagePostId) {
        super(title, description, imagePostId);
        this.date = date;
        this.ubication = ubication;
    }

    // Getters y Setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUbication() {
        return ubication;
    }

    public void setUbication(String ubication) {
        this.ubication = ubication;
    }

    public static List<Activity> getActivitiesList(){
        return activitiesList;
    }

    public static void addActivity(String title, String description, String date, String ubication) {
        if (date != null) {
            activitiesList.add(new Activity(title, description, date, ubication, R.drawable.default_post_image));
        }
    }

}