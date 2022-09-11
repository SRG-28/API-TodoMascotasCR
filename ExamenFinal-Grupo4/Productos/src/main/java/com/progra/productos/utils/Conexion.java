/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.progra.productos.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Dario
 */
public class Conexion {
    public static Connection getConnection(){
          try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/todomascotascr", "root", "root");
           return con;
        }catch(Exception ex){
            System.out.println(ex);
            return null;
        }
    }
}
