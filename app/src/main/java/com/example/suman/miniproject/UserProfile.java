package com.example.suman.miniproject;

/**
 * Created by suman on 15-10-2017.
 */

public class UserProfile {

   public String fav;

    public UserProfile(String fav) {
        this.fav = fav;
    }

    public UserProfile()
    {

    }
    public String getUserName()
    {
        return this.fav;
    }
}