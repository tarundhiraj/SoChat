/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.bits.sochat.client;

import in.bits.sochat.bean.Message;
import in.bits.sochat.bean.Type;
import in.bits.sochat.bean.UniList;
import in.bits.sochat.ui.GroupChat;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**<strong>ClientThread</strong> handles the connection of one client connection.
 * Client Thread is responsible for all the communication between Server and the 
 * Client that it is handling.
 *
 */
public class ClientThread implements Runnable{
    private Client client;
    private Message message;
    private GroupChat groupChat;
    private Thread thread;
    private UniList unicastList;
    
    /**
     * Creates a client thread for a particular client
     * @param client : Client that has established successful connection
     */
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
    
    
    /**
     * Handles the messages as they are received from the server. ClientThread 
     * receives and processes the messages depending upon the type of the message.
     * @see Message
     * @see Type
     */
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
                    String list = "";
                    String listFromServer = message.getMessage();
                    String lists[] = listFromServer.split(",");
                    for(String name : lists){
                        if(name.equalsIgnoreCase(client.getUserName())){
                            continue;
                        }else{
                            list+=name+",";
                        }
                    }
                    groupChat.setOnlineList(list);
                    
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
                    
                }else if(message.getType().getTypeOfMessage().equalsIgnoreCase("DISCONNECT")){
                    unicastList.getCWRef(message.getUser()).setTextOutput(message.getMessage());
                    unicastList.getCWRef(message.getUser()).disableInput();
                    unicastList.removeFromList(message.getUser());
                }else if(message.getType().getTypeOfMessage().equalsIgnoreCase("CONFLICT")){
                    groupChat.showRejectionDialog(message);
                }
                
            } catch (IOException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
