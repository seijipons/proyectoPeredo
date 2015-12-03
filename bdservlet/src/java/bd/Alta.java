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

/**
 *
 * @author PCCoco
 */
public class Alta extends HttpServlet {

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
        
        String nombre = request.getParameter("nombre");
        String paterno = request.getParameter("ape_p");
        String materno = request.getParameter("ape_m");
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("contra");
        String direccion = request.getParameter("direccion");
        String fecnac = request.getParameter("fecha");
        
        try
        {
         
            String strSQL = "INSERT INTO usuario ( nombre_usuario, ape_paterno, ape_materno, user, password, fecha_nac, direccion, id_tusuario) " +
                    " VALUES( "
                    + "'" + nombre + "', '" 
                    + paterno + "', '" 
                    + materno + "', '" 
                    + usuario + "', '"
                    + password + "', '" 
                    + fecnac+ "', '" 
                    + direccion + "', 2)";
               System.out.println(strSQL);

            consulta.executeUpdate(strSQL); 
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Alta de usuario en Mysql</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Alta de usuario en la Base de Datos</h1>");
            out.println("</body>");
            out.println("</html>");

            
        }
        catch(Exception e)
        {
            System.out.println("Error en la consulta: " + e.getMessage());
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
