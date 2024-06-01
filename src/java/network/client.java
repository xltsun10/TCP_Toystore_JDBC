/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package network;

import java.io.*;
import java.net.*;
import java.util.List;
import model.Toy;

public class client {
    public static void main(String[] args) throws ClassNotFoundException {
        String serverIP = "127.0.0.1";
        int port = 1234;

        try {
            Socket socket = new Socket(serverIP, port);
            System.out.println("Connected to server: " + socket.getInetAddress().getHostAddress());

            // Tạo luồng đọc từ Server
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            // Tạo luồng ghi vào Server
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);
            
            // Tạo ObjectInputStream từ InputStream để nhận dữ liệu
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            

            // Gửi yêu cầu và nhận phản hồi từ Server
            BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
            
            String userInput;

            while ((userInput = userInputReader.readLine()) != null) {
                writer.println(userInput);
                // Nhận danh sách đối tượng
//                List<Toy> receivedList = (List<Toy>) objectInputStream.readObject();
//                // In danh sách đối tượng
//                for (Toy obj : receivedList) {
//                    System.out.println(obj.getName());
//                }

                
//
//                String serverResponse = reader.readLine();
//                System.out.println("Server response: " + serverResponse);
                
                

                // Nhận danh sách đối tượng
                List<Toy> receivedList = (List<Toy>) objectInputStream.readObject();

                // In danh sách đối tượng
                for (Toy obj : receivedList) {
                    System.out.println(obj.getName());
                }
                
            }
                inputStream.close();
                objectInputStream.close();
                socket.close();
                        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}