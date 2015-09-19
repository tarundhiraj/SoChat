/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.bits.sochat.client;

import in.bits.sochat.bean.Message;
import in.bits.sochat.ui.GroupChat;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tarun
 */
public class ClientThread implements Runnable{
    private Client client;
    private Message message;
    private GroupChat groupChat;
    private Thread thread;
    
    public ClientThread(Client client) {
        this.client = client;
        thread = new Thread(this);
        thread.start();
    }
    
    public void setGroupChat(GroupChat groupChat){
        this.groupChat = groupChat;
     }
    
    public Message getMessage(){
        return message;
    }
    
    public void run(){
        
        while(true){
            try {
                message = (Message) client.getIn().readObject();
                System.out.println("Message received ---> "+message.getMessage()+"\nFrom user ---->"+message.getUser()+"\nTimeStamp:"+message.getTime());
                groupChat.setMessage(message);
            } catch (IOException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
