/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.bits.sochat.server;

import in.bits.sochat.bean.Message;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tarun
 */
public class Server implements ServerInterface{
    private ServerSocket serverSocket;
    private HashMap<Socket,ObjectOutputStream> clients;
    public Server(int port) throws IOException{
        clients = new HashMap<>();
        listen(port);
     }
       
    @Override
    public void listen(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Listening on port :"+ port);
            Socket socket = serverSocket.accept();
            System.out.println("Connected to :"+socket);
            ObjectOutputStream buf = new ObjectOutputStream(socket.getOutputStream());
            clients.put(socket, buf);
            new ServerThread(this,socket);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @Override
    public void broadcast(Message message) {
        for(Map.Entry<Socket, ObjectOutputStream> entry : clients.entrySet()){
            try {
                entry.getValue().writeObject(message);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void closeConnection(Socket socket) {
        try {
            clients.get(socket).close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
