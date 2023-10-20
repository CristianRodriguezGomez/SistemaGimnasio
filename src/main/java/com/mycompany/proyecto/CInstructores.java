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
public class CInstructores {
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
        
        sql="SELECT * FROM INSTRUCTORES ORDER BY id;";
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
   /*JTextField paramHorario*/
    public void InsertarInstructor(JTextField paramCodigo,JTextField paramApellidos,JTextField paramNombre,JTextField paramTelefono, JTextField paramAlumnos){
        
        setapellidosInstructor(paramApellidos.getText());
        setnombreInstructor(paramNombre.getText());         
        settelefonoInstructor(paramTelefono.getText());
        setalumnosInstructor(paramAlumnos.getText());

        CConexion objetoConexion = new CConexion();
        
        
        String consulta = "INSERT INTO INSTRUCTORES (apellidos,nombre,telefono,alumnos_asignados) VALUES(?, ?, ?, ?);";
      
        try{
         CallableStatement cs=  objetoConexion.establecerConexion().prepareCall(consulta);
         cs.setString(1, getapellidosInstructor());
         cs.setString(2, getnombreInstructor());
         cs.setString(3, gettelefonoInstructor());
         cs.setString(4, getalumnosInstructor());

         
         cs.execute();
         
         JOptionPane.showConfirmDialog(null, "Se inserto correctamente :)");

        }catch(Exception e){
             JOptionPane.showConfirmDialog(null, "ERROR de insertado)"+e.toString());
        }     
    }
    
    public void SeleccionarInstructor(JTable paramTablaInstructor,JTextField paramCodigo,JTextField paramApellidos,JTextField paramNombre,JTextField paramTelefono, JTextField paramAlumnos){
        
        try{
           int fila = paramTablaInstructor.getSelectedRow();
           if(fila>=0){
            
               
               paramCodigo.setText(paramTablaInstructor.getValueAt(fila,0).toString());
               paramApellidos.setText(paramTablaInstructor.getValueAt(fila,1).toString());
               paramNombre.setText(paramTablaInstructor.getValueAt(fila,2).toString());
               paramTelefono.setText(paramTablaInstructor.getValueAt(fila,3).toString());
               paramAlumnos.setText(paramTablaInstructor.getValueAt(fila,4).toString());

           }
           else{
               JOptionPane.showMessageDialog(null,"Fila no seleccionada.");
           }
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, "ERROR" +e.toString());
        }
        
    }
    
    public void ModificararInstructor(JTextField paramCodigo,JTextField paramApellidos,JTextField paramNombre,JTextField paramTelefono, JTextField paramAlumnos){

        setCodigo(Integer.parseInt(paramCodigo.getText()));
        setapellidosInstructor(paramApellidos.getText());
        setnombreInstructor(paramNombre.getText());   
        settelefonoInstructor(paramTelefono.getText());
        setalumnosInstructor(paramAlumnos.getText());


    
        CConexion objetoConexion = new CConexion();
        
        
        String consulta = "UPDATE INSTRUCTORES SET apellidos=?, nombre=?,telefono=?, alumnos_asignados = ? WHERE INSTRUCTORES.id=?;";

        try{
         CallableStatement cs=  objetoConexion.establecerConexion().prepareCall(consulta);
         
         cs.setString(1, getapellidosInstructor());
         cs.setString(2, getnombreInstructor());
         cs.setString(3, gettelefonoInstructor());
         cs.setString(4, getalumnosInstructor());
         cs.setInt(5, getCodigo());
         
         cs.execute();
         
         JOptionPane.showConfirmDialog(null, "Se Modifico Correctamente :)");

        }catch(Exception e){
             JOptionPane.showConfirmDialog(null, "ERROR :( )"+e.toString());
        }    
    }
    public void EliminarInstructor(JTextField paramCodigo ){
        
        setCodigo(Integer.parseInt(paramCodigo.getText()));
       
    
        CConexion objetoConexion = new CConexion();
        
        
        String consulta = "DELETE FROM INSTRUCTORES WHERE INSTRUCTORES.id=?;";

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
