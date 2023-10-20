/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cristian Rodriguez
 */
public class Informe1 {
    int codigo;
    String apellidosAlumno;
    String nombresAlumno;
    String carreraAlumno;
    String grupoAlumno;
    String telefonoAlumno;
    String precio_mensualidad;
    String meses_pagados;
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getApellidosAlumno() {
        return apellidosAlumno;
    }

    public void setApellidosAlumno(String apellidosAlumno) {
        this.apellidosAlumno = apellidosAlumno;
    }
    
    public String getNombresAlumno() {
        return nombresAlumno;
    }

    public void setNombresAlumno(String nombresAlumno) {
        this.nombresAlumno = nombresAlumno;
    }

  
    public String getCarreraAlumno() {
        return carreraAlumno;
    }

    public void setCarreraAlumno(String carreraAlumno) {
        this.carreraAlumno = carreraAlumno;
    }

    public String getGrupoAlumno() {
        return grupoAlumno;
    }

    public void setGrupoAlumno(String grupoAlumno) {
        this.grupoAlumno = grupoAlumno;
    }

    public String getTelefonoAlumno() {
        return telefonoAlumno;
    }

    public void setTelefonoAlumno(String telefonoAlumno) {
        this.telefonoAlumno = telefonoAlumno;
    }
    
     public String getprecio_mensualidad() {
        return precio_mensualidad;
    }

    public void setprecio_mensualidad(String precio_mensualidad) {
        this.precio_mensualidad = precio_mensualidad;
    }
    
     public String getmeses_pagados() {
        return meses_pagados;
    }

    public void setmeses_pagados (String meses_pagados) {
        this.meses_pagados = meses_pagados;
    }
 
    
    
   public void MostrarAlumno(JTable paramTabaTotalAlumnos){
        CConexion objetoConexion = new CConexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        String sql="";
        
        modelo.addColumn("Id");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Nombres");
        modelo.addColumn("Carrera");
        modelo.addColumn("Grupo");
        modelo.addColumn("Telefono");
        modelo.addColumn("Precios_Mensualidad");
        modelo.addColumn("Meses_Pagados");
    
        

       
        
        //select * from AlumnosGYM order by meses_pagados desc;
        paramTabaTotalAlumnos.setModel(modelo);

        sql="select * from AlumnosGYM order by meses_pagados desc;";

        String[] datos = new String [8];
       
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
                datos[5]=rs.getString(6);
                datos[6]=rs.getString(7);
                datos[7]=rs.getString(8);
               

                modelo.addRow(datos);
                
            }   
            paramTabaTotalAlumnos.setModel(modelo);
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null,"ERROR: "+e.toString());
        }
    }
}
