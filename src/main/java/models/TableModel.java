package models;

import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Objects;

public class TableModel {
    public static DefaultTableModel setTableNhanKhau(List<NhanKhauModel> listItem, String[] fields){
        final int num_col = fields.length;
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnIdentifiers(fields);
        Object[] obj = new Object[num_col];
        listItem.forEach(item -> {
            obj[0] = item.getId();
            obj[1] = item.getHoten();
            obj[2] = item.getNgaysinh();
            obj[3] = item.getGioitinh();
            dtm.addRow(obj);
        });
        return dtm;
    }
}
