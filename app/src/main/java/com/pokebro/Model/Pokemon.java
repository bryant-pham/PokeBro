package com.pokebro.Model;

/**
 * Created by Bryant on 8/17/2014.
 */
public class Pokemon implements Monster {
    private String name;
    private String imagePath;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
