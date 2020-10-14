package com.ieseljust.ad.BDJugadors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;


public class mySqlConnect{

    public static void main(String[] args) throws ClassNotFoundException, SQLException{
     
        Class.forName("com.mysql.cj.jdbc.Driver");

        String connectionUrl = "jdbc:mysql://localhost:3308/BDJocs? userUnicode=true&characterEncoding=UTF-8&user=root&password=root";
        Connection conn = DriverManager.getConnection(connectionUrl);

      
        ResultSet rs = conn.prepareStatement("show tables");
            executeQuery();
        System.out.println("\nTaules de la base de dades:\n");

        while (rs.next()) {
            String s = rs.getString(1);
            System.out.println(s);
        }
    
        System.out.println("\nRegistres de la tauala Genere:\n");

        rs = conn.prepareStatement("select * from Genere").executeQuery();
    
        while (rs.next()) {
            String id = rs.getInt(1);
            String nom = rs.getString(2);
            String desc = rs.getString(3);
            System.out.println(id+ " "+ nom+ " "+desc);
            
        }
    }
}
