package com.example.finalexam;

public class Burrito {

    private String burrito;
    private String burritoURL;
    private void setBurritoInfo(Integer burritoNum){
        switch (burritoNum){
            case 0:
                burrito = "Illegal Petes";
                burritoURL = "https://www.illegalpetes.com/";
                break;
            case 1:
                burrito = "Chipotle";
                burritoURL = "https://www.chipotle.com/";
                break;
            case 2:
                burrito = "Bartaco";
                burritoURL = "https://bartaco.com/";
                break;
            default:
                burrito = "none";

        }
    }
    public void setBurrito(Integer burritoNum){
        setBurritoInfo(burritoNum);
    }
    public String getBurrito(){
        return burrito;
    }
    public void setBurritoURL(Integer burritoNum){
        setBurritoInfo(burritoNum);
    }
    public String getBurritoURL(){
        return burritoURL;
    }
}
