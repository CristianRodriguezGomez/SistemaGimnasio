/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cristian Rodriguez
 */
public class Informe2 {
    int codigo;
    String apellidosInstructor;
    String nombreInstructor;
    String telefonoInstructor;
    String alumnosInstructor;
   

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getapellidosInstructor() {
        return apellidosInstructor;
    }

    public void setapellidosInstructor(String apellidosInstructor) {
        this.apellidosInstructor = apellidosInstructor;
    }
    
    public String getnombreInstructor() {
        return nombreInstructor;
    }

    public void setnombreInstructor(String nombreInstructor) {
        this.nombreInstructor = nombreInstructor;
    }

  
    public String gettelefonoInstructor() {
        return telefonoInstructor;
    }

    public void settelefonoInstructor(String telefonoInstructor) {
        this.telefonoInstructor = telefonoInstructor;
    }

    public String getalumnosInstructor(){
        return alumnosInstructor;
    }

    public void setalumnosInstructor(String alumnosInstructor) {
        this.alumnosInstructor = alumnosInstructor;
    }

 
    
    

   public void MostrarInstructor(JTable paramTabaTotalInstructor){
        CConexion objetoConexion = new CConexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        String sql="";
        
        modelo.addColumn("Id");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Nombre");
        modelo.addColumn("Telefono");
        modelo.addColumn("Alumnos");
       
        
        
        paramTabaTotalInstructor.setModel(modelo);
        
        sql="SELECT * FROM INSTRUCTORES ORDER BY alumnos_asignados DESC;";
        String[] datos = new String [5];
       
        Statement st;
        
        try{
            st=objetoConexion.establecerConexion().createStatement();
            ResultSet rs=st.executeQuery(sql);
            
                while(rs.next()){
                    
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                
         
                modelo.addRow(datos);
                
            }   
            paramTabaTotalInstructor.setModel(modelo);
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null,"ERROR: "+e.toString());
        }
    }
   
}
