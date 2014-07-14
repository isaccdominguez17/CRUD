/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Gestion.Usuario.Poco;

import java.sql.SQLDataException;

/**
 *
 * @author WINDOWS 7
 */
public interface IUsuario 
{
    public  void insertar() throws SQLDataException;
    public  void eliminar() throws SQLDataException; 
    public  void actualizar()   throws SQLDataException;
    public  void consultar() throws SQLDataException;
}
