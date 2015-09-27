package in.bits.sochat.client;

import in.bits.sochat.bean.Message;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**<h1>Client</h1>
 * <p>The implementation of the Client Interface which establishes connection with
 * the Server on listening port. On successful establishment of connection, it 
 * creates individual<strong> Client Thread </strong>
 * </p>
 */
public class Client implements ClientInterface{
    private String userName;
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private ClientThread clientThread;

    public ClientThread getClientThread() {
        return clientThread;
    }

    public void setClientThread(ClientThread clientThread) {
        this.clientThread = clientThread;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public ObjectOutputStream getOut() {
        return out;
    }

    public void setOut(ObjectOutputStream out) {
        this.out = out;
    }

    public ObjectInputStream getIn() {
        return in;
    }

    public void setIn(ObjectInputStream in) {
        this.in = in;
    }
    
    /**Constructor to create a client with specified name
     * @param userName : Username or Nickname
     * @param hostname: IP Address of the Server
     * @param port: Port of the server
     * @throws IOException 
     */
    
    
    public Client(String userName,String hostname, int port) throws IOException{
        this.userName = userName;
        socket = new Socket(hostname, port);
        System.out.println("Connected to "+hostname+":"+port);
        clientHandler();
    }
    
    /**This method creates a new ClientThread to handle individual client 
     * connections
     * @throws IOException
     * @see ClientThread
     */
    
    
    private void clientHandler() throws IOException{
        in = new ObjectInputStream(socket.getInputStream());
        out = new ObjectOutputStream(socket.getOutputStream());
        clientThread = new ClientThread(this);
    }
    
    /**
     * This function is used to send message to the server using the OutputStream
     * @param message: Message from the GUI
     * @see ObjectOutputStream
     */
    
    @Override
    public void sendMessage(Message message) {
        try {
            out.writeObject(message);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
