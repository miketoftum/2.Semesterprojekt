package com.manhpd;

import javafx.beans.property.SimpleStringProperty;

public class Credit {
    private SimpleStringProperty Title;
    private int ID;
    private int Year;


    public Credit(int ID, String Title, int Year) {
        this.ID = ID;
        this.Year = Year;
        this.Title = new SimpleStringProperty(Title);

    }

    public String getTitle() {
        return Title.get();
    }

    public String titleProperty() {
        return Title.get();
    }

    public void setTitle(String title) {
        this.Title.set(title);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

}
