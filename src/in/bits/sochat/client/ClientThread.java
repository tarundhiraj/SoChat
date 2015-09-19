/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.bits.sochat.client;

import in.bits.sochat.bean.Message;
import java.io.IOException;
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
        Message message;
        while(true){
            try {
                message = (Message) client.getIn().readObject();
                System.out.println("Message received ---> "+message.getMessage()+"\nFrom user ---->"+message.getUser()+"\nTimeStamp:"+message.getTime());
            } catch (IOException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
