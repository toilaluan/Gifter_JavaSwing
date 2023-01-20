package services;

import com.mysql.cj.protocol.Resultset;
import models.NhanKhauModel;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NhanKhauService {
    Connection conn;
    public List<NhanKhauModel> getListNhanKhau() throws SQLException, ClassNotFoundException {
        conn = SQLConnection.getSQLConnection();
        List<NhanKhauModel> listNhanKhau = new ArrayList<>();
        String query = String.format("SELECT * FROM %s", SQLConfig.table_nhan_khau);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()){
            NhanKhauModel nhanKhauModel = new NhanKhauModel();
            nhanKhauModel.setId(rs.getInt("id"));
            nhanKhauModel.setHoten(rs.getString("hoten"));
            nhanKhauModel.setNgaysinh(String.valueOf(rs.getDate("ngaysinh")));
            nhanKhauModel.setGioitinh(rs.getString("gioitinh"));
            listNhanKhau.add(nhanKhauModel);
        }
        stmt.close();
        conn.close();
        return listNhanKhau;
    }
    public void themNhanKhau(String hoten, Date ngaysinh, String gioitinh) throws SQLException, ClassNotFoundException {
        conn = SQLConnection.getSQLConnection();
        PreparedStatement pst = conn.prepareStatement("INSERT INTO nhankhau(hoten, ngaysinh, gioitinh) VALUES (?,?,?)");
        pst.setString(1, hoten);
        pst.setDate(2, ngaysinh);
        pst.setString(3, gioitinh);
        pst.executeUpdate();
    }
}
