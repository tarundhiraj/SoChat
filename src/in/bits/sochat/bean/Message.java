package in.bits.sochat.bean;

import java.io.Serializable;
import java.sql.Time;

/**
     * 
     * Message bean created to have a template for messages being exchanged between the server and clients.
     * The properties of message have been implemented as variables.<br>
     * The variables are:<br>
     * 1. type: denotes the type of the message being exchanged.<br>
     * 2. user: username of the sender of the message.<br>
     * 3. message: contains the body of the message.<br>
     * 4. time: holds the timestamp of the message, depending on situation it can be time sent or time received.<br>
     * 5. receiver: (used mostly for unicasting) hold the username of the intended receiver of the message as specified by the sender.<br>
    */
public class Message implements Serializable{
    
    private Type type;
    private String user;
    private String message;
    private Time time;
    private String receiver;
    
    /**
     * Constructor of the bean which takes the parameters as explained above.
     * @param type
     * @param user
     * @param message
     * @param time
     * @param receiver 
     */

public Message(Type type, String user, String message, Time time, String receiver) {
        this.type = type;
        this.user = user;
        this.message = message;
        this.time = time;
        this.receiver = receiver;
    }
    
/**
     * Below are the getters and setters for the variables of the bean.
     */
    
    /**
     * @return the type
     */
       
    public Type getType() {
        return type;
    }
    
    
    /**
     * @param type the type to set
     */


    public void setType(Type type) {
        this.type = type;
    }
    
     /**
     * @return the time
     */
       
    
    public Time getTime() {
        return time;
    }
    /**
     * @param time the time to set
     */


    public void setTime(Time time) {
        this.time = time;
    }
    
    /**
     * @return the user
     */
    

    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }
    /**
     * @return the message
     */

    public String getMessage() {
        return message;
    }
    /**
     * @param message the message to set
     */

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return user + ": ("+ time + ") : " + message;
    }

    /**
     * @return the receiver
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * @param receiver the receiver to set
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

 }
