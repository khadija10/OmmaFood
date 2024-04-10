package com.example.ommafood;

public class Meal {
    String meal, detail, prix;
    int imageId;

    public Meal(int imageId
                ,String meal, String detail, String prix) {
        this.meal = meal;
        this.detail = detail;
        this.prix = prix;
        this.imageId = imageId;
    }


}
