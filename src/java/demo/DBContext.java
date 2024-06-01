/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

import java.sql.*;

/**
 *
 * @author lequa
 */
public class DBContext {
    public Connection connection;

    public DBContext() {
        try {
            String user= "root";
            String password="141010";
            String url="jdbc:mysql://localhost:3306/quanlydochoi";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    
}
