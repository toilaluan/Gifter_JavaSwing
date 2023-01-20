/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;
import java.sql.*;
/**
 *
 * @author Luan Tran
 */
public class SQLConnection {
    public static Connection getSQLConnection() throws SQLException, ClassNotFoundException{
        System.out.println(SQLConfig.dbURL);
        Connection conn = DriverManager.getConnection(SQLConfig.dbURL, SQLConfig.username, SQLConfig.password);
        if (conn == null){
            System.out.println("Conn is null");
        }
        return conn;
    }
}
