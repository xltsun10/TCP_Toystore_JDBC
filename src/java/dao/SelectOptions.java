/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import model.Type;
import java.nio.charset.StandardCharsets;
import model.Toy;

/**
 *
 * @author lequa
 */
public class SelectOptions {
    public void Seclect() throws SQLException{
    System.setProperty("file.encoding", StandardCharsets.UTF_8.name());
    int choiceNumber;
    Scanner scanner = new Scanner(System.in);
    // vòng lặp for vắng mặt cả 3 biểu thức
    for (;;) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("1. Thêm loại đồ chơi");
        System.out.println("2. Sửa loại đồ chơi");
        System.out.println("3. Xóa loại đồ chơi");
        System.out.println("4. Tìm kiếm loại đồ chơi theo tên");
        System.out.println("5. Thêm đồ chơi");
        System.out.println("6. Sửa đồ chơi");
        System.out.println("7. Xóa đồ chơi");
        System.out.println("8. Tìm kiếm đồ chơi theo tên");
        System.out.println("9. Thoát");

        do {
            System.out.print("Bấm số để chọn (1/2/3/...): ");
            choiceNumber = scanner.nextInt();
        } while ((choiceNumber < 1) || (choiceNumber > 9));

        ToyDAO toyDAO = new  ToyDAO();
        TypeDAO typeDAO = new  TypeDAO();
        
        switch (choiceNumber) {
            case 1:// thêm loại đồ chơi
                scanner = new Scanner(System.in);
                
                System.out.println("Nhập các thông tin sau để thêm loại đồ chơi:");
                System.out.println("Type name:");
                String name= scanner.nextLine();
                

                System.out.println("Description:");
                String description = scanner.nextLine();
      
                                             
                typeDAO.insertType(name, description);
        
                System.out.println("ADD TYPE COMPLETE !");
                break;
            case 2:// sửa đồ chơi
                scanner = new Scanner(System.in);
                
                System.out.println("Nhập các thông tin sau để sửa loại đồ chơi:");
                System.out.println("Type id:");
                int id= scanner.nextInt();
                scanner.nextLine();
                System.out.println("Type name:");
                name= scanner.nextLine();
                
                System.out.println("Description:");
                description = scanner.nextLine();
                               
                typeDAO.UpdateType(id, name, description);
                System.out.println("UPDATE TYPE COMPLETE!");
                break;
            case 3:// xóa loại đồ chơi
                scanner = new Scanner(System.in);
                System.out.println("Nhập id để xóa loại đồ chơi:");
                System.out.println("Type id:");
                id= scanner.nextInt();
                typeDAO.deleteType(id);
                System.out.println("DELETE TYPE COMPLETE!");
                break;
            case 4:// tìm kiếm loại đồ chơi
                scanner = new Scanner(System.in);
                System.out.print("Nhập từ khóa tìm kiếm: ");
                String txtString= scanner.nextLine();
                List<Type> listType= typeDAO.getTypebyName(txtString);
                System.out.println("Danh sách các loại đồ chơi với từ khóa: "+txtString);
                for(int i= 0; i< listType.size(); i++ ){
                    System.out.println("Tên: "+listType.get(i).getName());
                }
                break;
            case 5:// thêm đồ chơi
                scanner = new Scanner(System.in);
                listType= typeDAO.getAllTypes();
                
                String listTypeId="";
                for(int i=0; i<listType.size(); i++){
                    listTypeId=listTypeId + listType.get(i).getId()+". " +listType.get(i).getName()+";";
                }
                System.out.println("Nhập các thông tin sau để thêm đồ chơi:");
                System.out.println("Type(select number): "+listTypeId);
                int idType= scanner.nextInt();
                String nameToy= scanner.nextLine();
                System.out.print("Toy name: ");
                scanner.nextLine();
                
                System.out.print("Age: ");
                String age= scanner.nextLine();
                
                System.out.print("Image: ");
                String image= scanner.nextLine();
                

                System.out.print("Price:");
                Float price = scanner.nextFloat();
      
                                             
                toyDAO.insertToy(idType, nameToy, age, image, price);
        
                System.out.println("THÊM ĐỒ CHƠI THÀNH CÔNG!");
                break;
                
            case 6: //sửa đò chơi
                System.out.println("Nhập thông tin để sửa đồ chơi!");
                listType= typeDAO.getAllTypes();
                
                listTypeId="";
                for(int i=0; i<listType.size(); i++){
                    listTypeId=listTypeId + listType.get(i).getId()+". " +listType.get(i).getName()+";";
                }
                scanner = new Scanner(System.in);
                System.out.println("Toy id:");
                int idToy= scanner.nextInt();
                System.out.println("Type(select number): "+listTypeId);
                idType= scanner.nextInt();
                scanner.nextLine();
                nameToy= scanner.nextLine();
                System.out.print("Toy name: ");
                
                System.out.print("Age: ");
                age= scanner.nextLine();
                
                System.out.print("Image: ");
                image= scanner.nextLine();
                

                System.out.print("Price:");
                price = scanner.nextFloat();
      
                                             
                toyDAO.UpdateToy(idToy, idType, nameToy, age, image, price);
        
                System.out.println("SỬA ĐỒ CHƠI THÀNH CÔNG!");
                break;
            case 7:// xóa đồ chơi
                scanner = new Scanner(System.in);
                System.out.println("Nhập id để xóa đồ chơi:");
                System.out.print("Toy id:");
                id= scanner.nextInt(); 
                toyDAO.deleteToy(id);
                System.out.println("XÓA ĐỒ CHƠI THÀNH CÔNG!");

                break;
            case 8://tìm kiếm đồ chơi theo tên
                scanner = new Scanner(System.in);
                System.out.print("Nhập từ khóa để tìm kiếm đồ chơi: ");
                txtString= scanner.nextLine();
                List<Toy> listToy= toyDAO.getToybyName(txtString);
                System.out.println("Danh sách các loại đồ chơi với từ khóa: "+txtString);
                for(int i= 0; i< listToy.size(); i++ ){
                    System.out.println(Integer.toString(i+1)+". "+listToy.get(i).getName());
                }
                break;
            case 9:
                return;
//                System.out.println("Server đã đóng! Tạm biệt!");
//                System.exit(0); // thoát chương trình
                
        }
    }
    }
    
}
