package in.bits.sochat.net;

import in.bits.sochat.bean.Message;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tarun
 */
public class Client extends Thread{
    private Socket clientSocket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private static Message message;
    /**
     *
     * @param name
     * @param hostname
     * @param port
     * @throws java.io.IOException
     */
    public Client(String name,String hostname, int port) throws IOException{
        super.setName(name);
        initialize(hostname,port);
    }
    
    private void initialize(String hostname, int port) throws IOException{
        clientSocket = new Socket(hostname, port);
        in = new ObjectInputStream(clientSocket.getInputStream());
        out = new ObjectOutputStream(clientSocket.getOutputStream());
        this.start();
        System.out.println("Client Created!!");
        
    }
    
    @Override
    public void run() {
        super.run(); 
        while(true){
            try {
                message = (Message) in.readObject();
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public void sendMessage(Message msg) throws IOException{
        out.writeObject(msg);
        System.out.println("Message sent!!\n"+msg);
    }

    public static Message getMessage() {
        return message;
    }

    public static void setMessage(Message message) {
        Client.message = message;
    }
    
    
    
       
}
