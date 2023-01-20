/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gifter;

import javax.swing.UIManager;
import views.LoginUI;

/**
 *
 * @author Luan Tran
 */
public class Gifter {

    public static void main(String[] args) {
//        System.out.println("Hello World!");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        LoginUI loginUI = new LoginUI();
        loginUI.setVisible(true); 
    }
}
