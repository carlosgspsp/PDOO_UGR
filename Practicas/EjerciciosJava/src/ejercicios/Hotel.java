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
public class Hotel {

    private static int NUM_HOTELES = 0;

    String nombre;
    String ciudad;
    int estrellas;
    Director director;
    ArrayList<Reserva> reservas;
    ArrayList<Empleado> empleados;
    ArrayList<Habitacion> habitaciones;
    ArrayList<Actividad> actividades;

    public Hotel(String nombre, String ciudad, int estrellas) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.estrellas = estrellas;
        director = null;
        reservas = new ArrayList<>();
        empleados = new ArrayList<>();
        habitaciones = new ArrayList<>();
        actividades = new ArrayList<>();
        NUM_HOTELES += 1;
    }
    
    public static int getNUM_HOTELES() {
        return NUM_HOTELES;
    }

    public ArrayList<Actividad> getActividades() {
        return actividades;
    }
    
    public void addActividad(Actividad actividad)
    {
        
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public void addReserva(Cliente cliente, String fchaEntrada, String fchaSalida) {
        Reserva reserva = new Reserva(fchaEntrada, fchaSalida, cliente, this);
        reservas.add(reserva);
        cliente.addReserva(reserva);
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public boolean addEmpleado(Empleado empleado) {
        boolean contratar = empleado.addTrabajo(this);
        if (contratar) {
            empleados.add(empleado);
            return true;
        } else {
            return false;
        }
    }

    public void addHabitacion(int numero, int capacidad) {
        habitaciones.add(new Habitacion(numero, capacidad));
    }

    public int buscarHabitacionCapacidad(int capacidad) {
        for (int i = 0; i < habitaciones.size(); i++) {
            if (habitaciones.get(i).getCapacidad() >= capacidad) {
                return habitaciones.get(i).getNumero();
            }
        }
        return -1;
    }

}
