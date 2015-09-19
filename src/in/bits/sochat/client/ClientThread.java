/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.bits.sochat.client;

import in.bits.sochat.bean.Message;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tarun
 */
class ClientThread extends Thread{
    private Client client;
    public ClientThread(Client client) {
        this.client = client;
        start();
    }
    
    public void run(){
        while(true){
            try {
                Message message = (Message) client.getIn().readObject();
            } catch (IOException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
