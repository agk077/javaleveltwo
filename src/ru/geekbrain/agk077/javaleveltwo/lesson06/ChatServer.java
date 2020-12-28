package ru.geekbrain.agk077.javaleveltwo.lesson06;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
    private static final int DEFAULT_PORT = 8189;

    public static void main(String[] args) throws IOException {
        new ChatServer().start(DEFAULT_PORT);
    }

    public void start(int port) throws IOException {
        ServerSocket socket = null;
        Socket clientSocket = null;
        Thread inputThread = null;
        try {
            socket = new ServerSocket(port);
            System.out.println("Сервер стартовал");
            clientSocket = socket.accept();
            System.out.println("Клиент подключился");
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            inputThread = runInputThread(in);
            runOutputLoop(out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputThread != null) inputThread.interrupt();
            if (clientSocket != null) clientSocket.close();
            if (socket != null) socket.close();
        }
    }

    private void runOutputLoop(DataOutputStream out) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String message = scanner.next();
            out.writeUTF(message);
            if (message.equals(ChatCmd.END.toString())) {
                break;
            }
        }
    }

    private Thread runInputThread(DataInputStream in) {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    String message = in.readUTF();
                    System.out.println("Со стороны клиента: " + message);
                    if (message.equals(ChatCmd.END.toString())) {
                        System.err.println("Со стороны клиента пришёл запрос на закрытие соединения...");
                        System.exit(0);
                    } else if (message.equals(ChatCmd.CLEAR.toString())) {
                        for (int i = 0; i < 100; i++) {
                            System.out.println();
                        }
                        System.out.println("Экран очищен");
                    }
                } catch (IOException e) {
                    System.out.println("Соединение было закрыто");
                    break;
                }
            }
        });
        thread.start();
        return thread;
    }

}
