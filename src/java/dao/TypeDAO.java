/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Type;
import java.sql.*;


/**
 *
 * @author lequa
 */
public class TypeDAO extends DBContext{
    public List<Type> getAllTypes() {
        List<Type> list = new ArrayList<>();
        String sql = "select * from Types";
        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                Type type = new Type(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
                list.add(type);
            }

        } catch (SQLException e) {
            System.out.println(e);

        }
        return list;
    }
    public Type getTypebyId(int id) throws SQLException{
        
        String sql= "select * from Types where id = ?";
        
        try {
            PreparedStatement pt = connection.prepareStatement(sql);
            pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();
            while(rs.next()){
                Type type = new Type(id, rs.getString(2), rs.getString(3));
                return type;                
            }
        } catch (SQLException e) {
            throw e;
        }
        return null;
    }
    public List<Type> getTypebyName(String txtSearch)throws SQLException{
        List<Type> list = new ArrayList<>();
        String query = "select * from Types where name LIKE ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, "%"+txtSearch+"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                //khoi tao doi tuong
                Type type =  new Type(rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("description"));
                list.add(type);
            }
        } catch (SQLException e) {}
        return list;
    }
    public void insertType(String name, String description){
        String query="INSERT INTO Types (name, description)\n"
                + "     VALUES\n"
                + "           (?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setString(1, name);
            ps.setString(2, description);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void UpdateType(int id, String name, String description){
        String query="UPDATE Types  SET name =?, description=? WHERE id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,name);
            ps.setString(2,description);
            ps.setInt(3,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void deleteType(int id){
        String query="delete from Types where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
        }

    }
    public static void main(String[] args) throws SQLException {
        
        TypeDAO dao = new TypeDAO();
        List<Type> list= dao.getAllTypes();
        System.out.println(list.size());
        System.out.println(list.get(0).getName());
        Type type = dao.getTypebyId(2);
        System.out.println(type.getName());
        dao.insertType("nguoi lon", "cho ngươi 18+");
        dao.UpdateType(1, "Sơ sinh", "Đồ dùng cho trẻ nhỏ và sơ sinh");
        List<Type> listType= dao.getTypebyName("hình");
        System.out.println("Danh sách các loại đồ chơi với từ khóa:");
        for(int i= 0; i< listType.size(); i++ ){
            System.out.println(i);
            System.out.println("Tên: "+listType.get(i).getName());
        }
    }
}
