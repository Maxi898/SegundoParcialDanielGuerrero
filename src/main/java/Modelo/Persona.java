/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Daniel Alejandro
 */
public class Persona {
    private String nombre;
    private String direccion;
    private String telefono;
    private String fechaNacimiento;
    
    public Persona (String nombre, String direccion, String telefono, String fechaNacimiento){
        this.direccion=direccion;
        this.nombre=nombre;
        this.fechaNacimiento=fechaNacimiento;
        this.telefono=telefono;
                
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    @Override
    public String toString(){
        return  "Nombre: " + nombre + " | Tel: " + telefono + " | Dir: " + direccion + " | F.Nac: "+ fechaNacimiento; 
    }
}
