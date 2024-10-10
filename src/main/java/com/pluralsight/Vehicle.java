package com.pluralsight;

public class Vehicle {
    //Attributes
    private long vehicleId;
    private String makeModel;
    private String color;
    private int odometerReading;
    private float price;

    //constructor
    public Vehicle(long _vehicleId, String _makeModel, String _color, int _odometerReading, float _price){
        this.vehicleId = _vehicleId;
        this.makeModel = _makeModel;
        this.color = _color;
        this.odometerReading = _odometerReading;
        this.price = _price;
    }
    //Empty constructor
    public Vehicle(){

    }//Getter + Setter Methods
    public long getVehicleId(){
        return vehicleId;
    }
    public void setVehicleId(long vehicleId){
        this.vehicleId = vehicleId;
    }
    public String getMakeModel(){
        return makeModel;
    }
    public void setMakeModel(String makeModel){
        this.makeModel = makeModel;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }
    public int getOdometerReading(){
        return odometerReading;
    }
    public void setOdometerReading(int odometerReading){
        this.odometerReading = odometerReading;
    }
    public float getPrice(){
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
