/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.segundoparcial;
import Vista.VistaColegio;
import Controlador.ControladorColegio;
/**
 *
 * @author Daniel Alejandro
 */
public class SegundoParcial {

   public static void main(String[] args) {
        // 1. Instanciar la Vista
        VistaColegio vista = new VistaColegio();

        // 2. Instanciar el Controlador pasándole la Vista
        ControladorColegio controlador = new ControladorColegio(vista);

        // 3. Iniciar la aplicación
        controlador.iniciar();
    }
}
