/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;
import java.sql.*;
import models.UserModel;
import services.SQLConfig;
import services.SQLConnection;
/**
 *
 * @author Luan Tran
 */
public class LoginController {
    Connection conn;
    public static UserModel user = new UserModel();
    public boolean login(String username, String password) throws SQLException, ClassNotFoundException{

        conn = SQLConnection.getSQLConnection();
        String query = String.format("SELECT * FROM %s WHERE username = '%s'", SQLConfig.admin_users_table_name, username);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        if (rs == null){
            return false;
        }
        while (rs.next()){
            if (rs.getString("password") == null ? password == null : rs.getString("password").equals(password)){
                user.setUsername(username);
                user.setID(rs.getInt("id"));
                return true;
            }
        }
        return false;
    }
}
