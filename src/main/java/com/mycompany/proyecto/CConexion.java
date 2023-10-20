/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristian Rodriguez
 */
public class CConexion {
    
    Connection conectar;
    String usuario = "postgres";
    String contrasenia = "cris";
    String bd = "trabajadores";
    String ip = "localhost";
    String puerto = "5432";
    
    String cadena = "jdbc:postgresql://"+ ip+":"+puerto+"/"+bd;

   
    public Connection establecerConexion(){
        
        try{
            Class.forName("org.postgresql.Driver");
            conectar=DriverManager.getConnection(cadena,usuario,contrasenia);
           // JOptionPane.showConfirmDialog(null,"Presione SI para continuar: ");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR"+e.toString());
        }
        
        return conectar;
        
    }
    
    
    
    
  
}