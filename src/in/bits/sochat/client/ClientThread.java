/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.bits.sochat.client;

import in.bits.sochat.bean.Message;
import in.bits.sochat.bean.Type;
import in.bits.sochat.bean.UniList;
import in.bits.sochat.ui.ChatWindow;
import in.bits.sochat.ui.GroupChat;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
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
    private UniList unicastList;
    
    public ClientThread(Client client) {
        this.client = client;
        client.sendMessage(new Message(Type.HELLO, client.getUserName(), null, null, null));
        thread = new Thread(this);
        thread.start();
    }
    
    public void setGroupChat(GroupChat groupChat){
        this.groupChat = groupChat;
    }
    
    public void setUnicastList (UniList unicastList) {
        this.unicastList = unicastList;
    }
    
    public Message getMessage(){
        return message;
    }
    
    public void run(){
        Message message = null;
        while(true){
            try {
                message = (Message)client.getIn().readObject();
                
                if(message.getType().getTypeOfMessage().equalsIgnoreCase("CHAT")){
                    
                    System.out.println("Message received ---> "+message.getMessage()+"\nFrom user ---->"+message.getUser()+"\nTimeStamp:"+message.getTime());
                    groupChat.setMessage(message); 
                    
                }else if(message.getType().getTypeOfMessage().equalsIgnoreCase("LIST")){
                    
                    System.out.println("Client List Received!!"+message.getMessage());
                    groupChat.setOnlineList(message.getMessage());
                    
                }else if(message.getType().getTypeOfMessage().equalsIgnoreCase("REQUEST")){
                    
                    groupChat.createDialogBox(message);
                    
                }else if(message.getType().getTypeOfMessage().equalsIgnoreCase("ACCEPT")){
                    
                    unicastList.getCWRef(message.getUser()).setTextOutput("<<"+message.getUser()+" has accepted chat request.>>");
                    
                }else if(message.getType().getTypeOfMessage().equalsIgnoreCase("REJECT")){
                    
                    unicastList.getCWRef(message.getUser()).setTextOutput("<<"+message.getUser()+" has rejected chat request.>>");
                    unicastList.getCWRef(message.getUser()).setVisible(false);
                    unicastList.getCWRef(message.getUser()).dispose();
                    unicastList.removeFromList(message.getUser());
                    
                }else if(message.getType().getTypeOfMessage().equalsIgnoreCase("UNICAST")){
                    
                    unicastList.getCWRef(message.getUser()).setTextOutput(message.getUser()+": ["+message.getTime()+"]: "+message.getMessage());
                    
                }
                
            } catch (IOException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
