package com.theironyard.clt;


import java.util.ArrayList;

public class User {
    public String name;
    public String password = "42";
    public ArrayList<String> posts = new ArrayList<>();

    public User(String name) {

        posts.add("hi");
        posts.add("Twitter sucks!");
        posts.add("Time for fun");


        this.name = name;
    }
}
