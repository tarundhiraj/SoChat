/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.bits.sochat.server;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tarun
 */
public class ServerUpdateThread implements Runnable{
    private Thread thread;
    private Server server;

    public ServerUpdateThread(Server server) {
        this.server = server;
        thread = new Thread(this);
    }
       
    @Override
    public void run() {
        
        while(true){
            server.sendClientList();
            try {
                Thread.sleep(60000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ServerUpdateThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
