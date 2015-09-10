/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.bits.sochat.server;

import in.bits.sochat.bean.Message;
import java.net.Socket;

/**
 *
 * @author tarun
 */
public interface ServerInterface {
    public void listen(int port);
    public void broadcast(Message message);
    public void closeConnection(Socket socket);
}
