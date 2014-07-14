/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases.Poco; // es pojo no poco

/**
 *
 * @author WINDOWS 7
 */
public class usuario 
{
    
    private int id;
    public int getId() 
    {
        return id;
    }
    public void setId(int id) 
    {
        this.id = id;
    }

    private String nombre;
    public String getNombre() 
    {
        return nombre;
    }
    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    private String apellido;
    public String getApellido() 
    {
        return apellido;
    }
    public void setApellido(String apellido) 
    {
        this.apellido = apellido;
    }

    private String cedula;
    public String getCedula() 
    {
        return cedula;
    }
    public void setCedula(String cedula) 
    {
        this.cedula = cedula;
    }

    public usuario(int id, String nombre, String apellido, String cedula) 
    {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
    }

}
