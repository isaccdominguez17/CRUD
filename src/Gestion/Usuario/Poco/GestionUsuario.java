/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Gestion.Usuario.Poco;

import Clases.Poco.usuario;
import Datos.conexion;
import java.sql.SQLDataException;
import java.sql.SQLException;
import javafx.scene.control.DateCell;

/**
 *
 * @author WINDOWS 7
 */
public class GestionUsuario implements IUsuario
{

    public GestionUsuario() 
    {
        objUsuario = new usuario(0, "", "", "");
        conexion.setUsuario("root");
        conexion.setClave("");
        conexion.setCadenaConexion("jdbc:mysql://localhost/usuariodb");
    }
    
    private usuario objUsuario;
    public usuario getObjUsuario() 
    {
        return objUsuario;
    }
    public void setObjUsuario(usuario objUsuario) 
    {
        this.objUsuario = objUsuario;
    }

    

    @Override
    public void insertar() throws SQLDataException 
    {
        try
        {
            conexion.GetInstancia().conectar();
            conexion.GetInstancia().ejecutar(
            "INSERT INTO `usuario`(`id`, `nombre`, `apellido`, `cedula`)"
                    + " VALUES ("+objUsuario.getId()+",'"+objUsuario.getNombre()+
                    "','"+objUsuario.getApellido()+"','"+objUsuario.getCedula()+"')");
        }
        catch(SQLException ex)
        {
            //throw ex;
        }
        finally{conexion.GetInstancia().desconectar();}
        
    }

    @Override
    public void eliminar() throws SQLDataException 
    {
        try
        {
            conexion.GetInstancia().conectar();
            conexion.GetInstancia().ejecutar("DELETE FROM `usuario` WHERE id="+objUsuario.getId());
        }
        catch(SQLException ex)
        {
            //throw ex;
        }
        finally{conexion.GetInstancia().desconectar();}
    }

    @Override
    public void actualizar() throws SQLDataException 
    {
        try
        {
            conexion.GetInstancia().conectar();
            conexion.GetInstancia().ejecutar("UPDATE `usuario` SET "
                    + "`nombre`='"+objUsuario.getNombre()+"',`apellido`='"+objUsuario.getApellido()+"',"
                    + "`cedula`='"+objUsuario.getCedula()+"' WHERE id="+objUsuario.getId());
        }
        catch(SQLException ex)
        {
            //throw ex;
        }
        finally{conexion.GetInstancia().desconectar();}
    }

    @Override
    public void consultar() throws SQLDataException 
    {
        
        try
        {
            conexion.GetInstancia().conectar();
            conexion.GetInstancia().ejecutar("SELECT `id`, `nombre`, `apellido`, `cedula` FROM `usuario` WHERE id="+objUsuario.getId());
        }
        catch(SQLException ex)
        {
            
        }
        finally{conexion.GetInstancia().desconectar();}
    }
    
}
