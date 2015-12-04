/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;

/**
 *
 * @author PCCoco
 */
public class Login extends HttpServlet
{
    Connection conexion = null;
    Statement consulta = null;
    ResultSet resultado = null;

    public void init()
    {
        String controlador = getInitParameter("Controlador");
        String bd = getInitParameter("Bd");
        String usuario = getInitParameter("Usuario");
        String password = getInitParameter("Password");
                
        try
        {
            Class.forName(controlador);
            conexion = DriverManager.getConnection(bd,usuario,password);
            consulta = conexion.createStatement();    
        }
        catch(Exception e)
        {
            System.out.println("Error en la conexion: " + e.getMessage());
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String usuario = request.getParameter("usu");
        String password = request.getParameter("pas");
        
        
   

        try
        {
            String strSql = "SELECT * FROM usuario WHERE password = '"+password+"' and user = '"+usuario+"'";            
            resultado = consulta.executeQuery(strSql);
            
            if(resultado.next())
            {
                int status = resultado.getInt("id_tusuario");
                
                if(status ==1)
                {
                 
                    
                    response.sendRedirect("/bdservlet/consultorio.jsp?id="+resultado.getString("id_usuario"));
                    
                }
                else if(status == 2)
                {
                    response.sendRedirect("/bdservlet/Profesor.html");
                }
                else if(status == 3)
                {
                    response.sendRedirect("/bdservlet/Alumno.html");
                }
                else
                {
                    response.sendRedirect("/bdservlet/Error.html");
                }               
            }
            else
            {
                response.sendRedirect("/bdservlet/Error.html");
            }
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }
        finally
        {
            //out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
