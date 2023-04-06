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
public class Pelicula {
    String titulo;
    ArrayList<Alquiler> alquileres;
    
    Pelicula(String titulo){
        this.titulo=titulo;
        alquileres = new ArrayList<>(); 
                
    }
    
    void addAlquiler(Cliente2 cliente, String fecha){
        alquileres.add(new Alquiler(fecha,this, cliente));
    }
    
}
