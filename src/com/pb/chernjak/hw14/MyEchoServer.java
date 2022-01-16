package com.pb.chernjak.hw14;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyEchoServer {
    private JPanel JavaEchoServer;
    private JButton buttonSend;
    private JTextArea textServer;
    private JTextField textClient;
    private Socket server;
    private BufferedReader in;
    private PrintWriter out;

    public MyEchoServer() throws IOException {
        int serverPort = 1234;
        server = new Socket("127.0.0.1", serverPort);
        in = new BufferedReader(new InputStreamReader(server.getInputStream()));
        out = new PrintWriter(server.getOutputStream(), true);

        buttonSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = textClient.getText();
                textClient.setText(null);
                textServer.append("R: " + message + "\n");
                out.println(message);
                try {
                    String serverMessage = in.readLine();
                    textServer.append("A: " + serverMessage + "\n");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public void close() throws IOException {
        in.close();
        out.close();
        server.close();
    }

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("MyEchoServer");
        MyEchoServer myEchoServer = new MyEchoServer();
        frame.setContentPane(myEchoServer.JavaEchoServer);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
