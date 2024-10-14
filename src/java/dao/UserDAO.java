/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;

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
    
    public static void main(String[] args) {
        UserDAO userDAO= new UserDAO();
        List<User> list = userDAO.getAllUsers();
        for(User u: list){
            System.out.println(u.getUsername());
        }
        User user= userDAO.getUserbyUsername("admin");
        System.out.println(user.getUsername());
    }
}
