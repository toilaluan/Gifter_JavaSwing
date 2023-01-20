/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

/**
 *
 * @author Luan Tran
 */
public class SQLConfig {
    public static String hostname = "localhost";
    public static String username = "root";
    public static String password = "";
    public static String port = "";
    public static String dbName = "gifter";
    public static String dbURL = String.format("jdbc:mysql://%s:3306/%s", hostname, dbName);
    public static String admin_users_table_name = "admin_users";
    
    public static String table_nhan_khau = "nhankhau";
}
