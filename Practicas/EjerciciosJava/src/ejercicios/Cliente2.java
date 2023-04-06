/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class Cliente2 {
    String dni;
    String nombre;
    ArrayList<Alquiler> alquileres;
    
    Cliente2(String dni, String nombre){
        this.dni = dni;
        this.nombre = nombre;
        alquileres = new ArrayList<>();
        
    }
    
    void addAlquiler(Alquiler alquiler){
        alquileres.add(alquiler);
    }
}
