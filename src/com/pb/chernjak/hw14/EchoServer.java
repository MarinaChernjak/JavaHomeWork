package com.pb.chernjak.hw14;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {

    static class Handler implements Runnable {
        private final Socket socket;

        public Handler(Socket socket) { this.socket = socket; }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + ". Подключился новый клиент");

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String clientMessage;
                while ((clientMessage = in.readLine()) != null) {
                    System.out.println("Запрос клиента: \n" + clientMessage);
                    //отправляем ответ
                    out.println(LocalDateTime.now().toString() + " -> " + clientMessage);
                    if (clientMessage.equalsIgnoreCase("exit"))
                        break;
                }

                out.close();
                in.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (Exception ex) {
                    //ignore
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 1234;
        ServerSocket echoServer = new ServerSocket(port);
        System.out.println("Сервер запущен на порту : " + port);
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        while (true) {
            System.out.println("Ожидаем новое подключение...");
            Socket clientSocket = echoServer.accept();
            threadPool.submit(new Handler(clientSocket));
        }
    }
}
