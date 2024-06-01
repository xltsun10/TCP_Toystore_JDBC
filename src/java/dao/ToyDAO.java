/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

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
        String sql= "select * from Toy";
        try {
            PreparedStatement ps= connection.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Toy toy =new Toy(rs.getInt(1),
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
    public Toy getToybyId(int id){
        String query = "select * from Toy where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                //khoi tao doi tuong
                Toy toy =  new Toy(rs.getInt(1),
                                rs.getInt(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getFloat(6));
                return toy;
            }
        } catch (SQLException e) {}
        return null;
    }
    public List<Toy> getToybyName(String txtSearch){
        List<Toy> list = new ArrayList<>();
        String query = "select * from Toy where name LIKE ?";
        try {            
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "%"+txtSearch+"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                //khoi tao doi tuong
                Toy toy =  new Toy(rs.getInt(1),
                                rs.getInt(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getFloat(6));
                list.add(toy);
            }
        } catch (SQLException e) {}
        return list;
    }
    public List<Toy> getToyFilter(String txtSearch, int idType, String age, float priceMin, float priceMax){
        List<Toy> list = new ArrayList<>();
        String query = "select * from Toy where name LIKE ? and idType=? and age LIKE ? and price> ? and price <?";
        try {            
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "%"+txtSearch+"%");
            ps.setInt(2, idType);
            ps.setString(3, "%"+age+"%");
            ps.setFloat(4, priceMin);
            ps.setFloat(5, priceMax);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                //khoi tao doi tuong
                Toy toy =  new Toy(rs.getInt(1),
                                rs.getInt(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getFloat(6));
                list.add(toy);
            }
        } catch (SQLException e) {}
        return list;
    }
    public List<Toy> getToyFilter2(String txtSearch,  String age, float priceMin, float priceMax){
        List<Toy> list = new ArrayList<>();
        String query = "select * from Toy where name LIKE ? and age LIKE ? and price> ? and price <?";
        try {            
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "%"+txtSearch+"%");
            ps.setString(2, "%"+age+"%");
            ps.setFloat(3, priceMin);
            ps.setFloat(4, priceMax);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                //khoi tao doi tuong
                Toy toy =  new Toy(rs.getInt(1),
                                rs.getInt(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getFloat(6));
                list.add(toy);
            }
        } catch (SQLException e) {}
        return list;
    }
    public void insertToy(int idType, String name, String age, String image, Float price){
        String query="INSERT INTO Toy (idType, name, age, image, price)\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, idType);
            ps.setString(2, name);            
            ps.setString(3, age);
            ps.setString(4, image);
            ps.setFloat(5, price);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void UpdateToy(int id, int idType, String name, String age, String image, Float price){
        String query="UPDATE Book  SET idType =?, name=?,  age=?,  image=?,  price=? WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,idType);
            ps.setString(2,name);
            ps.setString(3,age);
            ps.setString(4, image);
            ps.setFloat(5,price);
            ps.setInt(6,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void deleteToy(int id){
        String query="delete from Toy where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
        }

    }
    public static void main(String[] args) {
        ToyDAO dao = new ToyDAO();
        List<Toy> list = dao.getAllToys();
        System.out.println(list.get(0).getName());
        System.out.println(dao.getToybyId(1).getName());
        List<Toy> list2 = dao.getToybyName("bé");
        System.out.println("rfhsdfh"+ list2.get(1).getName());
        dao.insertToy(1, "hsdg", "0-5", "sjkfh", (float) 3);
        System.out.println("//////////////");
        System.out.println(dao.getToyFilter("", 2, "5-18", 0, 5000000).get(0).getName());
    }
    
}
