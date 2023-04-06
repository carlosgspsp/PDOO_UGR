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
public class Empleado {

    String nombre;
    ArrayList<Hotel> hoteles;
    ArrayList<Actividad> actividades;

    public Empleado(String nombre) {
        this.nombre = nombre;
        hoteles = new ArrayList<>();
        actividades = new ArrayList<>();
    }
    
    public void addActividad(Actividad actividad){
        
    }
    public String getNombre() {
        return nombre;
    }
    
    public boolean addTrabajo(Hotel hotel){
        if (hoteles.size()<=2){
            hoteles.add(hotel);
            return true;
        }
        else return false;
    }

}
