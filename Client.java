package ru.alexanna.lesson_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner scanner;
    private boolean isConnected;

    public Client() {
        try {
            socket = new Socket("localhost", 8081);
            scanner = new Scanner(System.in);
            start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void start() throws IOException {
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        isConnected = true;
        System.out.println("Server connection established: " + socket.getInetAddress());
        System.out.println("Enter your message...");
        new Thread(() -> {
            while (isConnected) {
                readInboundMessage();
            }
        }).start();

        while (isConnected) {
            writeOutboundMessage();
        }
    }

    private void readInboundMessage() {
        try {
            String inboundMessage = in.readUTF();
            System.out.println("Server message: " + inboundMessage);
            if (inboundMessage.equals("exit")) {
                System.out.println("Server closed connection.");
                closeConnection();
            }
        } catch (IOException e) {
            System.out.println("Connection closed.");
            closeConnection();
        }
    }

    private void writeOutboundMessage() {
        try {
            String outboundMessage = scanner.nextLine();
            out.writeUTF(outboundMessage);
            if (outboundMessage.equals("exit")) {
                closeConnection();
            }
        } catch (IOException e) {
            System.out.println("Connection closed.");
            closeConnection();
        }
    }

    private void closeConnection() {
        isConnected = false;
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}
