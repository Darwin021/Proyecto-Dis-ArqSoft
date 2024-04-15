/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

/**
 *
 * @author Warwin02
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Warwin02
 */
public class Conexion {
    String bd="curriculum";
    String url="jdbc:mysql://localhost:3306/";
    String user="root";
    String password="";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection cx;

    public Conexion(String bd) {
        this.bd=bd; 
    }
    public Connection Conectar(){
        try{
        Class.forName(driver);
        cx=DriverManager.getConnection(url+bd, user, password);
        System.out.print("Se conecto a la BD: "+bd);
        }catch(ClassNotFoundException |SQLException ex){
            System.out.print("No se conecto a la BD:" + bd );      
        }
        return cx;
    }
    public void desconectar(){
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    public static void main(String[] args){
        Conexion c = new Conexion("proyecto");
        c.Conectar();
    }
}