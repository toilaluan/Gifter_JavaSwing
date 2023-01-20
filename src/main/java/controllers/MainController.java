package controllers;

import views.NhanKhauPanel;
import views.TrangChuPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;

public class MainController {
    private List<JButton> menuBtn;
    private JPanel contentPanel;
    private JFrame mainFrame;
    public MainController(JFrame mainFrame, JPanel contentPanel){
        this.mainFrame = mainFrame;
        this.contentPanel = contentPanel;
    }
    public void setEvent(List<JButton> menuBtn){
        this.menuBtn = menuBtn;
        this.menuBtn.forEach(jButton -> {
            jButton.addMouseListener(new ButtonListener(jButton));
        });
    }
    class ButtonListener implements MouseListener{
        JButton button;
        JPanel view;
        public ButtonListener(JButton button){
            this.button = button;
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println(button.getText());
            switch (button.getText()){
                case "Nhan khau":
                    try {
                        view = new NhanKhauPanel(mainFrame);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    } catch (ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case "Trang chu":
                    view = new TrangChuPanel();
                    break;
                default:
                    break;
            }
            contentPanel.removeAll();
            contentPanel.setLayout(new BorderLayout());
            contentPanel.add(view);
            contentPanel.validate();
            contentPanel.repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
