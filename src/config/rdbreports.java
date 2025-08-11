/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class rdbreports {
    private Connection root;
    
    public Connection getRoot(){
        if(root == null){
            try{
                String url = "jdbc:mysql://localhost:3306/db02_23si11";
                String user  = "root";
                String password = "";
                root = DriverManager.getConnection(url,user,password);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "DATABASE TIDAK TERKONEKSI !!!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        return root;
    }
}
