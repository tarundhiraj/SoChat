/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.bits.sochat.bean;

/**
 *
 * @author tarun
 */
public enum Type{
    
    CHAT("CHAT"),
    ACCEPT("ACCEPT"),
    PROBE("PROBE"),
    LOGOUT("LOGOUT"),
    HELLO("HELLO"),
    LIST("LIST");
    Type(String typeOfMessage){
        this.typeOfMessage = typeOfMessage;
    }
    private String typeOfMessage;

public String getTypeOfMessage(){
       return typeOfMessage;
}
    
}
