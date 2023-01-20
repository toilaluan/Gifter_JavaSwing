/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Luan Tran
 */
public class UserModel {
    private String username;
    private int id;
    public void setUsername(String username){
        this.username = username;
    }
    public void setID(int id){
        this.id = id;
    }
    public String getUsername(){
        return this.username;
    }
    public int getId(){
        return this.id;
    }
}
