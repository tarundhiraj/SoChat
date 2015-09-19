package in.bits.sochat.bean;

import java.sql.Time;

/**
 *
 * @author tarun
 */
public class Message {
    private Type type;
    private String user;
    private String message;
    private Time time;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    
    
    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    
    public Message(String user, String message) {
        this.user = user;
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return user + ": ("+ time + ") : " + message;
    }

    
    
    
    
    
 }
