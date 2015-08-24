package in.bits.sochat.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author tarun
 */
public class Client extends Thread{
    private Socket clientSocket;
    private BufferedReader in;
    private BufferedWriter out;

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
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        this.start();
        
    }
    
    @Override
    public void run() {
        super.run(); 
        while(true){
            
        }
    }
       
}
