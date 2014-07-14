/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Datos;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WINDOWS 7
 */
public class conexion 
{
    //antes de esto añaddir la libreria de mySql y abrir la conexion con la base de datos...
    private Connection conex = null;
    private PreparedStatement preStat = null;
    private ResultSet resul = null;
    
    private static conexion instancia;
    public static conexion GetInstancia()
    {
        if (instancia==null) 
        {
            instancia=new conexion();
        }
        return instancia;
    }
    
    
    private static String usuario;
    public static String getUsuario() 
    {
        return usuario;
    }
    public static void setUsuario(String usuario) 
    {
        conexion.usuario = usuario;
    }

    private static String clave;
    public static String getClave() 
    {
        return clave;
    }
    public static void setClave(String clave) 
    {
        conexion.clave = clave;
    }

    private static String cadenaConexion;
    public static String getCadenaConexion() 
    {
        return cadenaConexion;
    }
    public static void setCadenaConexion(String cadenaConexion) {
        conexion.cadenaConexion = cadenaConexion;
    }

    public conexion() 
    {
        
    }

    

    
    public void conectar()
    {
        try {
            conex = (Connection) DriverManager.getConnection(cadenaConexion, usuario,clave );
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void desconectar()
    {
        try {
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ejecutar(String instruccion) throws SQLException
    {
        try
        {
            preStat=(PreparedStatement) conex.prepareStatement(instruccion);
            preStat.executeUpdate();
        }
        catch(SQLException ex)
        {
            throw ex;
        }
       
    }
}
