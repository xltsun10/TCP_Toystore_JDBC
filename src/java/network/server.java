/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package network;

/**
 *
 * @author lequa
 */
import dao.SelectOptions;
import dao.ToyDAO;
import dao.TypeDAO;
import java.io.*;
import java.net.*;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Toy;

public class server {
    public static void main(String[] args) throws SQLException {
        int port = 1234;
        

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is running and listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                // Xử lý yêu cầu từ client trong một Thread riêng biệt
                ClientHandler clientHandler = new ClientHandler(socket);
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                
                InputStream inputStream = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                OutputStream outputStream = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(outputStream, true);
                
                // Tạo ObjectOutputStream từ OutputStream để gửi dữ liệu
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                // Nhận danh sách đối tượng
                ToyDAO toyDAO = new ToyDAO();
                List<Toy> sendList = toyDAO.getAllToys();
                TypeDAO typeDAO = new TypeDAO();
                List<model.Type> sendListType = typeDAO.getAllTypes();


                String clientMessage;

                while ((clientMessage = reader.readLine()) != null) {
                    
                    
                    String[] mes=clientMessage.split(";");
                    String txtSearch=mes[0];
                    String typeString=mes[1];
                    int idType=Integer.parseInt(typeString);
                    String age=mes[2];
                    if(age.equalsIgnoreCase("Tuổi"))
                        age="";
                    String priceIndexS=mes[3];
                    int priceIndex= Integer.parseInt(priceIndexS);
                    String priceS="0-5000000";
                    switch (priceIndex) {
                        case 0:
                            priceS="0-5000000";
                            break;
                        case 1:
                            priceS="0-50000";
                            break;
                        case 2:
                            priceS="50000-100000";
                            break;
                        case 3:
                            priceS="100000-500000";
                            break;
                        case 4:
                            priceS="500000-1000000";
                            break;
                        case 5:
                            priceS="1000000-5000000";
                            break;
                        default:
                            break;
                    }
                    String[] pricerange= priceS.split("-");
                    float minPrice= Float.parseFloat(pricerange[0]);
                    float maxPrice= Float.parseFloat(pricerange[1]);
                    String type= "Không";
                    if(Integer.parseInt(typeString)!=0)
                        type=typeDAO.getTypebyId(Integer.parseInt(typeString)).getName();
                    
                    if(idType==0)
                        sendList= toyDAO.getToyFilter2(txtSearch,  age, minPrice, maxPrice);
                    else
                        sendList= toyDAO.getToyFilter(txtSearch, idType, age, minPrice, maxPrice);

                    System.out.println("Received from client: Từ khóa: " + txtSearch+";Loại: "+type+";Tuổi: "+age+";KHoảng giá: "+priceS);
                    // Xử lý yêu cầu từ client
//                    String response = "Server response to '" + clientMessage + " tu sever";
//                    writer.println(response);
//                    System.out.println("Sent to client: " + response);
                    
                    
                    // Gửi danh sách
                    objectOutputStream.writeObject(sendList);
                    System.out.println("Sent object to client: " + "object");
                    objectOutputStream.flush();
                    
                    // Gửi danh sách
                    objectOutputStream.writeObject(sendListType);
                    System.out.println("Sent type to client: " + "object");
                    objectOutputStream.flush();
                    
                }
                objectOutputStream.close();
                outputStream.close();
                socket.close();
                
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException ex) {
                Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }
}