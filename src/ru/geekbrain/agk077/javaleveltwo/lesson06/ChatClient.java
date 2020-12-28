package ru.geekbrain.agk077.javaleveltwo.lesson06;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    private static final int DEFAULT_PORT = 8189;

    public static void main(String[] args) throws IOException {
        new ChatClient().start("localhost", DEFAULT_PORT);
    }

    private void start(String host, int port) throws IOException {
        Socket socket = null;
        Thread inputThread = null;
        try {
            socket = new Socket(host, port);
            System.out.println("Клиент стартовал");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            inputThread = runInputThread(in);
            runOutputLoop(out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputThread != null) inputThread.interrupt();
            if (socket != null) socket.close();
        }
    }

    private Thread runInputThread(DataInputStream in) {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    String message = in.readUTF();
                    System.out.println("Со стороны сервера: " + message);
                    if (message.equals(ChatCmd.END.toString())) {
                        System.err.println("Со стороны сервера пришёл запрос на закрытие соединения...");
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
}

