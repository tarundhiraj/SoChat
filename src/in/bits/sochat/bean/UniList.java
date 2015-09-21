/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.bits.sochat.bean;

import in.bits.sochat.ui.ChatWindow;
import java.util.HashMap;

/**
 *
 * @author Deepak
 */
public class UniList {
    private HashMap<String, Object> unicastList;
    
    public UniList() {
        unicastList = new HashMap<>();
    }
    
    public void addToList(String sender, ChatWindow cwRef) {
        unicastList.put(sender, cwRef);
    }
    
    public void removeFromList(String sender) {
        unicastList.remove(sender);
    }
    
    public ChatWindow getCWRef (String sender) {
        ChatWindow toReturn = (ChatWindow) unicastList.get(sender);
        return toReturn;
    }
}
