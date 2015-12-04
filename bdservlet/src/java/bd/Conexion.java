/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.PrintWriter;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SeijiPons
 */
public class Conexion {


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author LabCompu1
 */

    Connection conexion=null;
    ResultSet cantidadNombres;
    String lista_nombres;
    public Conexion(){
        System.out.println("Creando conexion por: Esmeralda Leticia Luz Pons");
        cargarControlador();
        realizarConexion();
        
    }
    public void cargarControlador(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver cargado");
            
        }catch(ClassNotFoundException ex){
            System.out.println("No se encuentra el controlador");
            
        }
    }
    public void realizarConexion(){
        try{
           
            String servidor="jdbc:mysql://localhost:3306/consultorio";
            String usuarioDB="root";
            String passwordDB="";
           
            conexion=DriverManager.getConnection(servidor,usuarioDB,passwordDB);
            System.out.println("Conexion Exitosa");
            
        }catch(SQLException ex){
            System.out.println("No se realizó la conexión");
        }
    }
    public String xXx(String cadena){
        return cadena;
    }
    public void olakease(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
    
        try
        {
         
          //  String strSQL = "SELECT * FROM `enfermedades` WHERE 1";
            //   System.out.println(strSQL);

            //consulta.executeUpdate(strSQL); 
            
           /* out.println("<html>");
            out.println("<head>");
            out.println("<title>Alta de usuario en Mysql</title>");  
            out.println("</head>");
            out.println("<body>");
            */
            out.println("<h1>Prueba de impresion 2</h1>");
            /*out.println("</body>");
            out.println("</html>");
            */

            
        }
        catch(Exception e)
        {
            System.out.println("Error en la consulta: " + e.getMessage());
        }
    }
    
     public ResultSet listaEnfermedades(){
        try{
            Conexion c=new Conexion();
            ResultSet resultadoEnfermedades;
            ResultSetMetaData datosConsulta;
            String consulta=""
                    + "SELECT `id_enfermedad`,`descripcion_enfermedad` FROM `enfermedades` WHERE 1";
            Statement sentencia=c.conexion.createStatement();
            resultadoEnfermedades=sentencia.executeQuery(consulta);
            
            datosConsulta=resultadoEnfermedades.getMetaData();
            String[] filasConsulta=new String[datosConsulta.getColumnCount()];
          
            int a,num;
                       
           /* 
            while(resultadoProductos.next()){
              
                filasConsulta[0]=resultadoProductos.getString(1);
                filasConsulta[1]=resultadoProductos.getString(2);
                
                 
            }//end while
            */
            
            return resultadoEnfermedades;
            
        }catch(Exception ex){
            System.out.println("No consulta usuarios: "+ ex.getMessage());
            ex.printStackTrace();
            
            return null;
        }
    } 
     public ResultSet query(String query){
        try{
            Conexion c=new Conexion();
            ResultSet resultadoEnfermedades;
            ResultSetMetaData datosConsulta;
            String consulta=query;
            Statement sentencia=c.conexion.createStatement();
            resultadoEnfermedades=sentencia.executeQuery(consulta);
            
            datosConsulta=resultadoEnfermedades.getMetaData();
            //String[] filasConsulta=new String[datosConsulta.getColumnCount()];
          
           //int a,num;
                       
           /* 
            while(resultadoProductos.next()){
              
                filasConsulta[0]=resultadoProductos.getString(1);
                filasConsulta[1]=resultadoProductos.getString(2);
                
                 
            }//end while
            */
            
            return resultadoEnfermedades;
            
        }catch(Exception ex){
            System.out.println("No consulta usuarios: "+ ex.getMessage());
            ex.printStackTrace();
            
            return null;
        }
    }
}

    