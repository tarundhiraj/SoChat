/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.bits.sochat.client;

import in.bits.sochat.bean.Message;

/**
 *
 * @author tarun
 */
public interface ClientInterface {
    public void sendMessage(Message message);
}
