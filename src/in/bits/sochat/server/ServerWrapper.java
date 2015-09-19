/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.bits.sochat.server;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author tarun
 */
public class ServerWrapper {
    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);

        try {
            Server server = new Server(port);
        } catch (IOException ex) {
            Logger.getLogger(ServerWrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
