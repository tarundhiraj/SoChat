/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.bits.sochat.ui;

import in.bits.sochat.bean.Message;
import in.bits.sochat.bean.UniList;
import in.bits.sochat.client.Client;
import in.bits.sochat.client.ClientThread;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**This class creates a new GroupChat window.
 *
 **/
public class GroupChat extends javax.swing.JFrame {

    /**
     * Creates new form GroupChat
     */
    String fetchName;
    UniList ul;
    
    private final Client client;
    
    public GroupChat(Client client) {
        this.client = client;
        ul = new UniList();
        initComponents();
        ClientThread ct;
        ct = (ClientThread)this.client.getClientThread();
        ct.setGroupChat(this);
        ct.setUnicastList(ul);
        groupOutput.setDisabledTextColor(Color.BLACK);
        
    }
    
    /**
     * Creates the dialog box that flashes in front the client to accept or 
     * reject the incoming chat request
     * @param message the message received from the server.
     * Server sends a message to connect to a specified client by the other user.
     */
    public void createDialogBox(Message message){
        
        String displayText = message.getUser() + " would like to chat with you. Do you want to accept the request?";
        
        int messageType = JOptionPane.INFORMATION_MESSAGE;
        int optionType = JOptionPane.YES_NO_OPTION;
        int code = JOptionPane.showConfirmDialog(this, displayText, "Chat Request", optionType, messageType);
        
        if (code == JOptionPane.YES_OPTION) {
            client.sendMessage(new Message(in.bits.sochat.bean.Type.ACCEPT, client.getUserName(), "has accepted your chat request.", null, message.getUser()));
            ChatWindow cw = new ChatWindow(client, message.getUser());
            ul.addToList(message.getUser(), cw);
            cw.setVisible(true);
        } else if (code == JOptionPane.NO_OPTION) {
            client.sendMessage(new Message(in.bits.sochat.bean.Type.REJECT, client.getUserName(), "has declined your chat request.", null, message.getUser()));
        } else if (code == JOptionPane.CLOSED_OPTION) {
            client.sendMessage(new Message(in.bits.sochat.bean.Type.REJECT, client.getUserName(), "has declined your chat request.", null, message.getUser()));
        }
    }
    
    /**
     * It displays a dialog when the username specified is not unique.
     * @param message the message from the Server
     * Server sends a message that a username with the specified username 
     * already exists.
     * @see Message
     */
    public void showRejectionDialog(Message message){
        int messageType = JOptionPane.INFORMATION_MESSAGE;
        int optionType = JOptionPane.OK_CANCEL_OPTION;
        int code = JOptionPane.showConfirmDialog(this,message.getMessage(), "Problem with Username", optionType, messageType);
        
        if (code == JOptionPane.OK_OPTION || code == JOptionPane.CANCEL_OPTION || code == JOptionPane.CLOSED_OPTION) {
            new ChatStartup().setVisible(true);
            
            this.dispose();
        }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        onlineListPane = new javax.swing.JScrollPane();
        onlineList = new javax.swing.JList();
        onlineLabel = new javax.swing.JLabel();
        groupOutputPane = new javax.swing.JScrollPane();
        groupOutput = new javax.swing.JEditorPane();
        sendButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        profileIcon = new javax.swing.JLabel();
        welcomeLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        groupInputPane = new javax.swing.JScrollPane();
        groupInput = new javax.swing.JTextArea();
        connectButton = new javax.swing.JButton();
        groupMenuBar = new javax.swing.JMenuBar();
        Connection = new javax.swing.JMenu();
        groupDisconnect = new javax.swing.JMenuItem();
        groupExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        onlineList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {};
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        onlineList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        onlineList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                onlineListValueChanged(evt);
            }
        });
        onlineListPane.setViewportView(onlineList);

        onlineLabel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        onlineLabel.setText("Currently Online:");

        groupOutput.setEditable(false);
        groupOutput.setBackground(new java.awt.Color(204, 241, 248));
        groupOutput.setEnabled(false);
        groupOutputPane.setViewportView(groupOutput);

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });
        sendButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sendButtonKeyPressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        profileIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profileIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/chaticon.png"))); // NOI18N

        welcomeLabel.setFont(new java.awt.Font("Letter Gothic Std", 0, 16)); // NOI18N
        welcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeLabel.setText("  SoChat");

        nameLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 11)); // NOI18N
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        nameLabel.setText(client.getUserName());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(profileIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(welcomeLabel)
                .addGap(133, 133, 133)
                .addComponent(nameLabel)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(welcomeLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(profileIcon)
                .addContainerGap())
        );

        groupInput.setColumns(20);
        groupInput.setLineWrap(true);
        groupInput.setRows(5);
        groupInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                groupInputKeyPressed(evt);
            }
        });
        groupInputPane.setViewportView(groupInput);

        connectButton.setText("Connect");
        connectButton.setEnabled(false);
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        Connection.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Connection.setText("Connection");

        groupDisconnect.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.SHIFT_MASK));
        groupDisconnect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/disconnect.png"))); // NOI18N
        groupDisconnect.setText("Disconnect");
        groupDisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupDisconnectActionPerformed(evt);
            }
        });
        Connection.add(groupDisconnect);

        groupExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK));
        groupExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.png"))); // NOI18N
        groupExit.setText("Exit");
        groupExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupExitActionPerformed(evt);
            }
        });
        Connection.add(groupExit);

        groupMenuBar.add(Connection);

        setJMenuBar(groupMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(groupOutputPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(groupInputPane, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sendButton, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(onlineListPane, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(onlineLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(74, 74, 74)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(connectButton)
                        .addGap(80, 80, 80))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(onlineLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(onlineListPane, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(connectButton)
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(groupOutputPane, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sendButton, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                    .addComponent(groupInputPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 * This function is called when the user clicks on the <strong>exit</strong> 
 * menuitem under the connection menu
 * @param evt Action
 * @see ActionEvent
 */
    private void groupExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupExitActionPerformed
       client.sendMessage(new Message(in.bits.sochat.bean.Type.LOGOUT, null, null, null,null));
       ChatStartup chat = new ChatStartup();
       chat.setVisible(true);
       this.dispose();
       System.exit(0);
    }//GEN-LAST:event_groupExitActionPerformed

    /**
     * this method is invoked each time a user inputs some text in the input 
     * textfield and clicks on the send Button
     * @param evt ActionEvent
     * @see ActionEvent
     */
    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        client.sendMessage(new Message(in.bits.sochat.bean.Type.CHAT,client.getUserName(),groupInput.getText() , null, null));
        groupInput.setText("");

    }//GEN-LAST:event_sendButtonActionPerformed

    /**This method populates the <strong>Currently Online</strong> list.
     *
     */
    private void groupInputKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_groupInputKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            client.sendMessage(new Message(in.bits.sochat.bean.Type.CHAT,client.getUserName(),groupInput.getText().trim() , null, null));
            groupInput.requestFocus();
            groupInput.setText("");
        }
    
    }//GEN-LAST:event_groupInputKeyPressed
/**
 * requests for a connection to the client with the selected client under the 
 * <strong>Currently Online</strong> list
 * @param evt 
 */
    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        String initMessage = "<<" + client.getUserName() + " has initiated a one-on-one chat.>>";
        ChatWindow cw = new ChatWindow(client, fetchName);
        System.out.println(fetchName);
        ul.addToList(fetchName, cw);
        cw.setVisible(true);
        cw.setTextOutput(initMessage);
        client.sendMessage(new Message(in.bits.sochat.bean.Type.REQUEST,client.getUserName(),initMessage, null, fetchName));
    }//GEN-LAST:event_connectButtonActionPerformed

    /**
     * disconnects a user by sending a message of type LOGOUT.
     * After successful LOGOUT, the user is no longer visible as online to other
     * users.
     */
    private void groupDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupDisconnectActionPerformed
        client.sendMessage(new Message(in.bits.sochat.bean.Type.LOGOUT, null, null, null, null));
        groupOutput.setText(groupOutput.getText() + "\n<<<Chat Disconnected!!!>>>");
    }//GEN-LAST:event_groupDisconnectActionPerformed

    /**
     * Enables the connect button whenver a user is selected. from the user list. 
     */
    private void onlineListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_onlineListValueChanged
        fetchName = (String) onlineList.getSelectedValue();
        connectButton.setEnabled(true);
    }//GEN-LAST:event_onlineListValueChanged
    
    /**
     * sends message to the server whenever user enters his/her chat and hits Enter.
     */
    private void sendButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sendButtonKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            client.sendMessage(new Message(in.bits.sochat.bean.Type.CHAT,client.getUserName(),groupInput.getText() , null, null));
             groupInput.setText("");
        }
    }//GEN-LAST:event_sendButtonKeyPressed

    /**
     * sets the message received from the server on the output text field
     * @param message 
     */
    public void setMessage(Message message){
        groupOutput.setText(groupOutput.getText()+"\n"+message.getUser()+" ["+message.getTime()+"] : "+message.getMessage());
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Connection;
    private javax.swing.JButton connectButton;
    private javax.swing.JMenuItem groupDisconnect;
    private javax.swing.JMenuItem groupExit;
    private javax.swing.JTextArea groupInput;
    private javax.swing.JScrollPane groupInputPane;
    private javax.swing.JMenuBar groupMenuBar;
    private javax.swing.JEditorPane groupOutput;
    private javax.swing.JScrollPane groupOutputPane;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel onlineLabel;
    private javax.swing.JList onlineList;
    private javax.swing.JScrollPane onlineListPane;
    private javax.swing.JLabel profileIcon;
    private javax.swing.JButton sendButton;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables

    /**
     * populates the online users list after it has been received from the server.
     * @param list 
     */
    public void setOnlineList(String list) {
        String[] clientList;
        clientList = list.split(",");
        DefaultListModel lm = new DefaultListModel();
        for(String s: clientList){
            lm.addElement(s);
        }
        onlineList.setModel(lm);
    }
}
