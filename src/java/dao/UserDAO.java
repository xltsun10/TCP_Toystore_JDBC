/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.User;
import model.UserDetail;

/**
 *
 * @author lequa
 */
public class UserDAO extends DBContext{
    public List<User> getAllUsers(){
        List<User> list = new ArrayList<>();
        String sql="Select * from Users";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                User user= new User(rs.getLong(1), 
                                    rs.getString(2), 
                                    rs.getString(3), 
                                    rs.getString(4), 
                                    rs.getString(5), 
                                    rs.getString(6), 
                                    rs.getString(7), 
                                    rs.getString(8));
                list.add(user);
            }
            
        } catch (SQLException e) {
        }
        return list;
    }
    
    public boolean userLogin(String username, String password){
        String query = "select * from Users where username = ? and password = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username );
            ps.setString(2, password );
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return true;
            }
        } catch (SQLException e) {}
        return false;
    }
    public void userRegister(String username, String password, String email){
        String query1="INSERT INTO Users (username, password, email, role, account_status, created_at)\n"
                + "     VALUES\n"
                + "     (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query1);
            ps.setString(1, username);
            ps.setString(2, password);            
            ps.setString(3, email);
            ps.setString(4, "customer");
            LocalDateTime currentDateTime = LocalDateTime.now();
            ps.setString(5, "active");
            ps.setString(6, currentDateTime.toString());

//            int affectedRows = ps.executeUpdate();
//            int userId=0;
//            if (affectedRows > 0) {
//                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
//                    if (generatedKeys.next()) {
//                        userId = generatedKeys.getInt(1); // Lấy user_id vừa tạo
//                    }
//                }
//            }
//            String query2="INSERT INTO USER_DETAILS(USER_ID) values(?)";
//            ps = connection.prepareStatement(query2);
//            ps.setInt(1, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }
    public void userUpdate(int id, String username, String password, String email ){
        String query="UPDATE Users  SET username =?, password=?,  email=?, updated_at= ? WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setString(3,email);
            LocalDateTime currentDateTime = LocalDateTime.now();
            ps.setString(4, currentDateTime.toString());
            ps.setInt(5, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public User getUserbyId(int id){
        String query = "select * from Users where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                //khoi tao doi tuong
                User user =  new User(rs.getLong(1), 
                                    rs.getString(2), 
                                    rs.getString(3), 
                                    rs.getString(4), 
                                    rs.getString(5), 
                                    rs.getString(6), 
                                    rs.getString(7), 
                                    rs.getString(8));
                return user;
            }
        } catch (SQLException e) {}
        return null;
        
    }
    
    public User getUserbyUsername(String username){
        String query = "select * from Users where username = ?";
        try {            
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                //khoi tao doi tuong
                User user =  new User(rs.getLong(1), 
                                    rs.getString(2), 
                                    rs.getString(3), 
                                    rs.getString(4), 
                                    rs.getString(5), 
                                    rs.getString(6), 
                                    rs.getString(7), 
                                    rs.getString(8));
                return user;
        } } catch (SQLException e) {}
        return null;
    }
    
    public User getUserbyEmail(String email){
        String query = "select * from Users where email = ?";
        try {            
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                //khoi tao doi tuong
                User user =  new User(rs.getLong(1), 
                                    rs.getString(2), 
                                    rs.getString(3), 
                                    rs.getString(4), 
                                    rs.getString(5), 
                                    rs.getString(6), 
                                    rs.getString(7), 
                                    rs.getString(8));
                return user;
        } } catch (SQLException e) {}
        return null;
    }
    public UserDetail getUserDetailbyUserId(int userId){
        
        String query = "select * from User_details where user_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                //khoi tao doi tuong
                UserDAO userDAO= new UserDAO();
                User user = userDAO.getUserbyId(userId);
                UserDetail userDetail =  new UserDetail(rs.getLong(1), 
                                    user, 
                                    rs.getString(3), 
                                    rs.getString(4), 
                                    rs.getString(5), 
                                    rs.getString(6), 
                                    rs.getString(7), 
                                    rs.getString(8));
                return userDetail;
            }
        } catch (SQLException e) {}
        return null;
    }
    
    public void updateUserDetail(int id, String firstName, String lastName, String phoneNumber, String address, String birthDate, String gender ){
        String query="UPDATE user_details  SET first_Name =?, last_Name=?,  phone_Number=?, address= ?, birth_Date=?, gender=?  WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,firstName);
            ps.setString(2,lastName);
            ps.setString(3,phoneNumber);
            ps.setString(4,address);
            ps.setString(5,birthDate);
            ps.setString(6,gender);
            ps.setInt(7, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        UserDAO userDAO= new UserDAO();
        List<User> list = userDAO.getAllUsers();
        for(User u: list){
            System.out.println(u.getUsername());
        }
        UserDetail userDetail= userDAO.getUserDetailbyUserId(1);
        System.out.println(userDetail.getAddress());
        if(userDAO.userLogin("admin2", "123456")){
            System.out.println("sdfhj");
        }
//        userDAO.userUpdate(3,"user2", "123456", "user2@gmail.com");
//        userDAO.updateUserDetail(2, "John", "Smith", "012373554", "Ho Chi Minh, Quan 1, Tan Thanh", "2000-2-3", "male");
//        
          userDAO.userRegister("user3", "123456", "user3@gmail.com");
    }
}
