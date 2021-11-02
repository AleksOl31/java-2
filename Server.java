package ru.alexanna.lesson_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private ServerSocket serverSocket;
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner scanner;

    public Server() {
        try {
            serverSocket = new ServerSocket(8081);
            start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void start() throws IOException {
        System.out.println("Server started...");
        Socket incoming = serverSocket.accept();
        System.out.println("Client connected...");
        System.out.println("Client address: " + incoming.getInetAddress());

        in = new DataInputStream(incoming.getInputStream());
        out = new DataOutputStream(incoming.getOutputStream());
        scanner = new Scanner(System.in);

        listenInboundMessage();
    }

    private void listenInboundMessage() {
        new Thread(() -> {
            while (true) {
                try {
                    String outboundMessage = scanner.nextLine();
                    out.writeUTF(outboundMessage);
                } catch (IOException e) {
                    System.out.println("Connection closed.");
                    break;
                }
            }
        }).start();

        while (true) {
            try {
                String msg = readInboundMessage();
                System.out.println("Client message: " + msg);
                if (msg.equals("exit")) {
                    System.out.println("Client disconnected.");
                    break;
                }
            } catch (MyServerException e) {
                System.out.println("The client is gone away.");
                System.out.println("Connection closed.");
                break;
            }
        }
    }

    private String readInboundMessage() {
        try {
            return in.readUTF();
        } catch (EOFException e) {
            throw new MyServerException("End of stream reached unexpectedly. Probably, client is shutdown.", e);
        } catch (IOException e) {
            throw new MyServerException("Something went wrong during read-operation.", e);
        }
    }

}
