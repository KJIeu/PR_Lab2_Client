package PR.lab2.client.UI;

import javax.swing.*;
import java.net.InetAddress;
import java.net.Socket;
import PR.lab2.client.common.*;


public class ClientUI extends javax.swing.JFrame implements ConnectionListener{
    private JTextArea textArea1;
    private JButton connectButton;
    private JTextField textFieldMessage;
    private JButton sendButton;
    private JTextField textFieldHost;

    public ClientUI(){
        frameInit();
        setState(false);

    }

    private void sendButtonActionPerformed(java.awt.event.ActionEvent event){

    }

    private void connectButtonActionPerformed(java.awt.event.ActionEvent event){
        try {
            String host = textFieldHost.getText().trim();
            Socket socket = new Socket(InetAddress.getByName(host), Connection.Port);
            Connection c = new ConnectionImpl(socket, this);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void connectionCreated(Connection c) {
        System.out.println("Client connected to the server");
    }

    @Override
    public void connectionClosed(Connection c) {
        System.out.println("Client connection was closed");
    }

    @Override
    public void connectionException(Connection c, Exception ex) {
        ex.printStackTrace();
    }

    @Override
    public void receivedContent(Message msg) {
             textArea1.append("\n" + msg.toString());
    }

    private void setState(boolean isConnected){

        textArea1.setEnabled(isConnected);
        textFieldMessage.setEnabled(isConnected);
        sendButton.setEnabled(isConnected);

    }
}
