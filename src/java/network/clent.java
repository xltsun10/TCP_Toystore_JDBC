/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package network;

/**
 *
 * @author lequa
 */
import java.io.*;
import java.net.*;

public class clent {
    public static void main(String[] args) {
        String serverIP = "127.0.0.1";
        int port = 1111;

        try {
            Socket socket = new Socket(serverIP, port);
            System.out.println("Connected to server: " + socket.getInetAddress().getHostAddress());

            // Tạo luồng đọc từ Server
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // Tạo luồng ghi vào Server
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);

            // Gửi yêu cầu và nhận phản hồi từ Server
            BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
            String userInput;

            while ((userInput = userInputReader.readLine()) != null) {
                writer.println(userInput);

                String serverResponse = reader.readLine();
                System.out.println("Server response: " + serverResponse);
                
                
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}