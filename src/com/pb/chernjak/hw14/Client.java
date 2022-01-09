package com.pb.chernjak.hw14;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {

        int serverPort = 1234;
        Socket server = new Socket("127.0.0.1", serverPort);

        BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
        PrintWriter out = new PrintWriter(server.getOutputStream(), true);
        BufferedReader inConsole = new BufferedReader(new InputStreamReader(System.in));

        String message, serverMessage;
        System.out.println("Введите сообщение: ");
        while ((message = inConsole.readLine()) != null) {
            out.println(message);
            serverMessage = in.readLine();
            System.out.println(serverMessage);
            if ("exit".equalsIgnoreCase(message)) {
                break;
            }
        }
        in.close();
        out.close();
        inConsole.close();
        server.close();
    }
}
