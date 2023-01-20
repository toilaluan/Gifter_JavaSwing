package controllers;

import models.NhanKhauModel;
import models.TableModel;
import services.NhanKhauService;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.EventObject;
import java.util.List;

public class NhanKhauManageController {
    private JPanel jpnView;
    private NhanKhauService nhanKhauService;
    private List<NhanKhauModel> nhanKhauModelList;
    private String[] fields;
    DefaultTableModel tableModel;
    private JTable table;
    public NhanKhauManageController(JPanel jpnView) throws SQLException, ClassNotFoundException {
        this.jpnView = jpnView;
        nhanKhauService = new NhanKhauService();
        nhanKhauModelList = nhanKhauService.getListNhanKhau();
        fields = new String[]{"ID", "Họ tên", "Ngày sinh", "Giới tính"};
        initAction();
//        table.addMouseListener();
    }

    private void initAction(){
        setDataTable();
    }
    private void setDataTable(){
        tableModel = TableModel.setTableNhanKhau(this.nhanKhauModelList, fields);
        table = new JTable(tableModel) {
            @Override
            public boolean editCellAt(int row, int column, EventObject e) {
                return false;
            }

        };

        // thiet ke bang

        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getColumnModel().getColumn(0).setMaxWidth(80);
        table.getColumnModel().getColumn(0).setMinWidth(80);
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }

    public JTable getTable() {
        return table;
    }
}
