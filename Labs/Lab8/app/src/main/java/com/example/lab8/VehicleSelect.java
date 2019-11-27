package com.example.lab8;

public class VehicleSelect {
    private String vehicle;
    private String vehicleURL;

    private void setVehicleInfo(Integer vehicleType){
        switch (vehicleType){
            case 0:
                vehicle = "Mustang";
                vehicleURL = "https://www.ford.com/cars/mustang/";
                break;
            case 1:
                vehicle = "Fusion";
                vehicleURL = "https://www.ford.com/cars/fusion/";
                break;
            case 2:
                vehicle = "Explorer";
                vehicleURL = "https://www.ford.com/suvs/explorer/";
                break;
            case 3:
                vehicle = "F-150";
                vehicleURL = "https://www.ford.com/trucks/f150/";
                break;
             default:
                 vehicle = "none";
                 vehicleURL = "https://www.cars.com/";
        }
    }

    public void setVehicle(Integer vehicleType)
    {
        setVehicleInfo(vehicleType);
    }
    public void setVehicleURL(Integer vehicleType)
    {
        setVehicleInfo(vehicleType);
    }
    public String getVehicle(){
        return vehicle;
    }
    public String getVehicleURL(){
        return vehicleURL;
    }
}
