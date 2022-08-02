package com.example.gameon;

public class BookingScreenDataModel
{
    private String name;
    private String state;
    private String About;

    public BookingScreenDataModel() {
        // empty constructor required for firebase.
    }

    // constructor for our object class.
    public BookingScreenDataModel(String name,String state, String About) {
        this.name = name;
        this.state = state;
        this.About = About;
    }

    // getter and setter methods
    public String getName() {
        return name;
    }

    public String getAbout() {
        return About;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    public void setAbout(String About) {
        this.About = About;
    }
}
