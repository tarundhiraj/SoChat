/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.bits.sochat.bean;
/**
 * 
 * enum to hold the various types of messages that are being exchanged between clients and server.
 * The types of messages being sent are:
 * 1. CHAT: Regular messages sent for the purpose of chatting in the group.
 * 2. UNICAST: Messages used for chatting one on one with another user.
 * 3. REQUEST: Message sent to request another user to initiate one on one chat.
 * 4. ACCEPT: Message sent when the other user accepts request for one on one chat.
 * 5. REJECT: Message sent when the other user rejects the request for one on one chat.
 * 6. DISCONNECT: Message sent when the user wants to disconnect from the chat.
 * 7. LOGOUT: Message sent when the user wants to leave the group chat.
 * 8. LIST: Used by server for the purpose of updating list of online users.
 * 9. CONFLICT: Used by server to inform user of a username conflict.
 */

public enum Type{
    
    CHAT("CHAT"),
    UNICAST("UNICAST"),
    REQUEST("REQUEST"),
    ACCEPT("ACCEPT"),
    REJECT("REJECT"),
    DISCONNECT("DISCONNECT"),
    LOGOUT("LOGOUT"),
    HELLO("HELLO"),
    LIST("LIST"),
    CONFLICT("CONFLICT");
    Type(String typeOfMessage){
        this.typeOfMessage = typeOfMessage;
    }
    private String typeOfMessage;

     /**
     * 
     * @return the type of message
     */
 
public String getTypeOfMessage(){
       return typeOfMessage;
}
    
}
