package com.pokebro.Model;

/**
 * Created by Bryant on 8/17/2014.
 */
public class Monster {
    private String name;
    private int imageResource;

    public Monster(String name, int image) {
        this.name = name;
        this.imageResource = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int image) {
        this.imageResource = image;
    }
}
