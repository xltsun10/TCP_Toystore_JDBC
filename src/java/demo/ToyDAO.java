/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

import java.util.ArrayList;
import java.util.List;
import model.Toy;
import java.sql.*;

/**
 *
 * @author lequa
 */
public class ToyDAO extends DBContext{
    public List<Toy> getAllToys(){
        List<Toy> list = new ArrayList<>();
        String sql="Select * from Toys";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Toy toy= new Toy(rs.getInt(1), 
                        rs.getInt(2), 
                        rs.getString(3), 
                        rs.getString(4), 
                        rs.getString(5), 
                        rs.getFloat(6));
                list.add(toy);
            }
            
        } catch (SQLException e) {
        }
        return list;
    }
    public List<Toy> getAllToy(){
        List<Toy> list= new ArrayList<>();
        String sql="INSERT INTO `login`.`tbluser` (`username`, `password`, `address`, `birthday`, `sex`, `description`) VALUES ('nhat003', '123456', 'Hanio', '2001-10-01', 'dfs', 'sf');";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while (rs.next()) {                
                Toy toy= new Toy(rs.getInt(1), 
                        rs.getInt(2), 
                        rs.getString(3), 
                        rs.getString(4), 
                        rs.getString(5), 
                        rs.getFloat(6));
                list.add(toy);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    public static void main(String[] args) {
        ToyDAO toyDAO =  new ToyDAO();
        List<Toy> list = toyDAO.getAllToys();
        for(Toy toy : list){
            System.out.println(toy.getName()+"\n");
        }
                
        
    }
}
