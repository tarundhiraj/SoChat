/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.bits.sochat.test;

import in.bits.sochat.bean.Message;
import in.bits.sochat.net.Client;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tarun
 */
public class Main {
    public static void main(String[] args) {
        try {
            Client client = new Client("Tarun","172.12.34.12", 2000);
            
        } catch (IOException ex) {
            
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
