package controllers;

import services.NhanKhauService;
import views.ThemNhanKhauFrame;

import javax.swing.*;
import java.sql.Date;
import java.sql.SQLException;

public class ThemNhanKhauController {
    JFrame parentFrame;
    JFrame themNhanKhauFrame;
    NhanKhauService nhanKhauService;
    public ThemNhanKhauController(JFrame parentFrame, JFrame themNhanKhauFrame){
        this.parentFrame = parentFrame;
        this.themNhanKhauFrame = themNhanKhauFrame;
        this.nhanKhauService = new NhanKhauService();
    }
    public boolean themNhanKhau(String hoten, Date gioitinh, String ngaysinh){
        try{
            nhanKhauService.themNhanKhau(hoten,gioitinh,ngaysinh);
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showConfirmDialog(this.themNhanKhauFrame, "Sai thong tin");
            return false;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
