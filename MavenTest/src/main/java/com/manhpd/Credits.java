package com.manhpd;

import org.bson.codecs.pojo.annotations.BsonProperty;

public class Credits {

    @BsonProperty("_id")
    private int ProductionID;
    private String ProductionName;
    private int Year;
    private int PersonID;
    private String PersonName;
    private String Occupation;

    public Credits() {
        this.ProductionID = 0;
        this.ProductionName = "";
        this.Year = 0;
        this.PersonID = 0;
        this.PersonName = "";
        this.Occupation = "";
    }

    public Credits(int ProductionID, String ProductionName, int Year, int PersonID, String PersonName, String Occupation) {
        this.ProductionID = ProductionID;
        this.ProductionName = ProductionName;
        this.Year = Year;
        this.PersonID = PersonID;
        this.PersonName = PersonName;
        this.Occupation = Occupation;

    }

    public void setPersonID(int personID) {
        PersonID = personID;
    }

    public void setPersonName(String personName) {
        PersonName = personName;
    }

    public void setOccupation(String occupation) {
        Occupation = occupation;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public void setProductionID(int productionID) {
        ProductionID = productionID;
    }

    public void setProductionName(String productionName) {
        ProductionName = productionName;
    }


    public int getYear() {
        return Year;
    }

    public String getProductionName() {
        return ProductionName;
    }

    public int getProductionID() {
        return ProductionID;
    }

    public int getPersonID(){
        return PersonID;
    }
    public String getPersonName(){
        return PersonName;
    }
    public String getOccupation(){
        return Occupation;
    }
}
