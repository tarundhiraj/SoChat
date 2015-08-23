/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.bits.sochat.ui;

/**
 *
 * @author tarun
 */
public class ChatWindow extends javax.swing.JFrame {

    /**
     * Creates new form WelcomeWindow
     */
    public ChatWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        namePanel = new javax.swing.JPanel();
        profileIcon = new javax.swing.JLabel();
        welcomeLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        output = new javax.swing.JEditorPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        input = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        disconnect = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(305, 510));
        setResizable(false);

        namePanel.setBackground(new java.awt.Color(255, 255, 255));

        profileIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profileIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\tarun\\Documents\\NetBeansProjects\\SoChat\\img\\chaticon.png")); // NOI18N

        welcomeLabel.setFont(new java.awt.Font("Letter Gothic Std", 0, 16)); // NOI18N
        welcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeLabel.setText("  SoChat");

        nameLabel.setFont(new java.awt.Font("Segoe UI Semibold", 1, 11)); // NOI18N
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        nameLabel.setText("Tarun Dhiraj");

        javax.swing.GroupLayout namePanelLayout = new javax.swing.GroupLayout(namePanel);
        namePanel.setLayout(namePanelLayout);
        namePanelLayout.setHorizontalGroup(
            namePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namePanelLayout.createSequentialGroup()
                .addComponent(profileIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        namePanelLayout.setVerticalGroup(
            namePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(profileIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(welcomeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        output.setEditable(false);
        output.setBackground(new java.awt.Color(204, 255, 204));
        jScrollPane1.setViewportView(output);

        input.setColumns(20);
        input.setLineWrap(true);
        input.setRows(4);
        input.setToolTipText("Enter your message here");
        input.setDragEnabled(true);
        jScrollPane2.setViewportView(input);

        jButton1.setText("Send");

        menuBar.setBackground(new java.awt.Color(0, 204, 204));

        file.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        file.setText("File");

        disconnect.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.SHIFT_MASK));
        disconnect.setText("Disconnect");
        disconnect.setToolTipText("Disconnect Chat");
        file.add(disconnect);

        Exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK));
        Exit.setText("Exit");
        Exit.setToolTipText("Exit Chat");
        file.add(Exit);

        menuBar.add(file);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(namePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(namePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChatWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenuItem disconnect;
    private javax.swing.JMenu file;
    private javax.swing.JTextArea input;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPanel namePanel;
    private javax.swing.JEditorPane output;
    private javax.swing.JLabel profileIcon;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}
