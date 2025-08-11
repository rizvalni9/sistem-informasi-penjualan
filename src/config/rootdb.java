package config;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class rootdb {
    public Connection root;
    public Statement adapter;
    public DriverManager ctrldb;
    
    public void root(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            root=ctrldb.getConnection("jdbc:mysql://localhost/db02_23si11","root","");
            adapter=root.createStatement();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "DATABASE TIDAK TERKONEKSI !!!","ERROR",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}
