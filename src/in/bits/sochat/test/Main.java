/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.bits.sochat.test;

import in.bits.sochat.bean.Message;
import in.bits.sochat.bean.Type;
import in.bits.sochat.client.Client;
import java.io.IOException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tarun
 */
public class Main {
    public static void main(String[] args) {
        Client client;
        try {
            client = new Client("Tarun","172.17.13.75", 5000);
            Message msg = new Message(Type.CHAT, "Tarun", "Hello There",null);
            client.sendMessage(msg);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
}
