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
public class CAlumnos {
    
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
        

       
        
        
        paramTabaTotalAlumnos.setModel(modelo);
        
        sql="SELECT * FROM AlumnosGYM ORDER BY id";
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
   /*JTextField paramHorario*/
    public void InsertarAalumno(JTextField paramCodigo,JTextField paramApellidos,JTextField paramNombres, JTextField paramCarrera, JTextField paramGrupo,JTextField paramTelefono, JTextField paramprecio_mensualidad, JTextField parammeses_pagados){
        
        setApellidosAlumno(paramApellidos.getText());
        setNombresAlumno(paramNombres.getText());         
        setCarreraAlumno(paramCarrera.getText());  
        setGrupoAlumno(paramGrupo.getText());
        setTelefonoAlumno(paramTelefono.getText());
        setprecio_mensualidad(paramprecio_mensualidad.getText());
        setmeses_pagados(parammeses_pagados.getText());


        
        CConexion objetoConexion = new CConexion();
        
        
        String consulta = "INSERT INTO AlumnosGYM(apellidos, nombres,carrera,grupo,telefono,precio_mensualidad,meses_pagados) VALUES(?,?,?,?, ?,?,?);";
      
        try{
         CallableStatement cs=  objetoConexion.establecerConexion().prepareCall(consulta);
         cs.setString(1, getApellidosAlumno());
         cs.setString(2, getNombresAlumno());
         cs.setString(3, getCarreraAlumno());
         cs.setString(4, getGrupoAlumno());
         cs.setString(5, getTelefonoAlumno());
         cs.setString(6, getprecio_mensualidad());
         cs.setString(7, getmeses_pagados());
                 
         cs.execute();
         
         JOptionPane.showConfirmDialog(null, "Se inserto correctamente :)");

        }catch(Exception e){
             JOptionPane.showConfirmDialog(null, "ERROR de insertado)"+e.toString());
        }     
    }
    
    public void SeleccionarAlumno(JTable paramTablaAlumno,JTextField paramCodigo,JTextField paramApellidos,JTextField paramNombres,  JTextField paramCarrera, JTextField paramGrupo , JTextField paramTelefono,JTextField paramprecio_mensualidad, JTextField parammeses_pagados){
        
        try{
           int fila = paramTablaAlumno.getSelectedRow();
           if(fila>=0){
            
               
               paramCodigo.setText(paramTablaAlumno.getValueAt(fila,0).toString());
               paramApellidos.setText(paramTablaAlumno.getValueAt(fila,1).toString());
               paramNombres.setText(paramTablaAlumno.getValueAt(fila,2).toString());
               paramCarrera.setText(paramTablaAlumno.getValueAt(fila,3).toString());
               paramGrupo.setText(paramTablaAlumno.getValueAt(fila,4).toString());
               paramTelefono.setText(paramTablaAlumno.getValueAt(fila,5).toString());
               paramprecio_mensualidad.setText(paramTablaAlumno.getValueAt(fila,6).toString());
               parammeses_pagados.setText(paramTablaAlumno.getValueAt(fila,7).toString());

           }
           else{
               JOptionPane.showMessageDialog(null,"Fila no seleccionada.");
           }
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, "ERROR" +e.toString());
        }
        
    }
    
    public void ModificararAlumno(JTextField paramCodigo,JTextField paramApellidos, JTextField paramNombres, JTextField paramCarrera, JTextField paramGrupo , JTextField paramTelefono,JTextField paramprecio_mensualidad, JTextField parammeses_pagados){

        setCodigo(Integer.parseInt(paramCodigo.getText()));
        setApellidosAlumno(paramApellidos.getText());
        setNombresAlumno(paramNombres.getText());   
        setCarreraAlumno(paramCarrera.getText());  
        setGrupoAlumno(paramGrupo.getText());
        setTelefonoAlumno(paramTelefono.getText());
        setprecio_mensualidad(paramprecio_mensualidad.getText());
        setmeses_pagados(parammeses_pagados.getText());
        
        CConexion objetoConexion = new CConexion();
        
        
        String consulta = "UPDATE AlumnosGYM SET apellidos=?, nombres=?,carrera=?, grupo=?,telefono=?, precio_mensualidad=?, meses_pagados=? WHERE AlumnosGYM.id=?;";

        try{
         CallableStatement cs=  objetoConexion.establecerConexion().prepareCall(consulta);
         
         cs.setString(1, getApellidosAlumno());
         cs.setString(2, getNombresAlumno());
         cs.setString(3, getCarreraAlumno());
         cs.setString(4, getGrupoAlumno());
         cs.setString(5, getTelefonoAlumno());
         cs.setString(6, getprecio_mensualidad());
         cs.setString(7, getmeses_pagados());
         cs.setInt(8, getCodigo());
         
         cs.execute();
         
         JOptionPane.showConfirmDialog(null, "Se Modifico Correctamente :)");

        }catch(Exception e){
             JOptionPane.showConfirmDialog(null, "ERROR :( )"+e.toString());
        }    
    }
    public void EliminarAalumno(JTextField paramCodigo ){
        
        setCodigo(Integer.parseInt(paramCodigo.getText()));
       
    
        CConexion objetoConexion = new CConexion();
        
        
        String consulta = "DELETE FROM AlumnosGYM WHERE AlumnosGYM.id=?;";

      //WHERE AlumnosGYM.id=?;
        try{
         CallableStatement cs=  objetoConexion.establecerConexion().prepareCall(consulta);
       
         cs.setInt(1, getCodigo());
         
         cs.execute();
         
        // JOptionPane.showConfirmDialog(null, "Se Eliminó Correctamente :)");

        }catch(Exception e){
             JOptionPane.showConfirmDialog(null, "ERROR :( )"+e.toString());
        }   
    }    

    

   
    

    
}
