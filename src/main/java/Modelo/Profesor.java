/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Daniel Alejandro
 */
public class Profesor extends Persona{
    private String cedula;
    private String area;
    private double valorHora;
    private int horasDictadas;
    
    public Profesor(String nombre, String direccion, String telefono, String fechaNacimiento, 
                    String cedula, String area, double valorHora, int horasDictadas) {
        super(nombre, direccion, telefono, fechaNacimiento);
        
        this.cedula = cedula;
        this.area=area;
        this.valorHora = valorHora;
        this.horasDictadas=horasDictadas;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public int getHorasDictadas() {
        return horasDictadas;
    }

    public void setHorasDictadas(int horasDictadas) {
        this.horasDictadas = horasDictadas;
    }
    
    public double calcularPagoMensual (){
        double basico = this.horasDictadas *this.valorHora;
        double preparacion = basico*0.30;
        return basico + preparacion;
    }
    
    public double calcularPrestaciones (){
        return calcularPagoMensual () * 0.19;
    }
    
    @Override 
    public String toString (){
        return super.toString() + "| CC:" + cedula + " Area: " + area + " Pago total: " + calcularPagoMensual () + " Prestaciones: $" + calcularPrestaciones();
                
    }
    
}