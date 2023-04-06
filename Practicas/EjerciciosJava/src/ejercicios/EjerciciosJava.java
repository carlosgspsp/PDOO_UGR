package ejercicios;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author carlo
 */
public class EjerciciosJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /* 
        Carlos carlos = new Carlos("Segura");
        carlos.Mostrar();
        Parcela caminoRonda = new Parcela("Camino Ronda", 100.0f, 50.0f, 50.0f);
        //Parcela caminoRonda = new Parcela();
        caminoRonda.construirCasa();
        caminoRonda.construirHotel();
        caminoRonda.construirHotel();
        
        System.out.println("Alquiler de "+caminoRonda.getNombre()+" es: "+caminoRonda.getAlquilerCompleto());
        
        
        Parcela parcelaIdentidad1 = new Parcela("Camino Ronda", 100.0f, 50.0f, 50.0f);
        Parcela parcelaIdentidad2 = parcelaIdentidad1;
        
        System.out.println("Igualdad de parcelaIdentidad1 y parcelaIdentidad2 en identidad : " + parcelaIdentidad1.igualdadIdentidad(parcelaIdentidad2));
       
        Parcela parcelaEstado1 = new Parcela("Camino Ronda", 100.0f, 50.0f, 50.0f);
        Parcela parcelaEstado2 = new Parcela("Camino Ronda", 100.0f, 50.0f, 50.0f);
        
        System.out.println("Igualdad de parcelaEstado1 y parcelaEstado2 en estado : " + parcelaEstado1.igualdadEstado(parcelaEstado2));
        
        Parcela parcelaNada1 = new Parcela("Camino Ronda", 100.0f, 50.0f, 50.0f);
        Parcela parcelaNada2 = new Parcela("Calle Doctor Marañon", 100.0f, 50.0f, 50.0f);
        
        System.out.println("Igualdad de parcelaNada1 y parcelaNada2 en identidad : " + parcelaNada1.igualdadIdentidad(parcelaNada2));
        System.out.println("Igualdad de parcelaNada1 y parcelaNada2 en estado : " + parcelaNada1.igualdadEstado(parcelaNada2));
        
         */
        //PRACTICA 2 SESION 1
        Hotel hotel1 = new Hotel("Zoraida Garden", "Almeria", 4);
        Director director = new Director("Juan", 782222123);
        hotel1.setDirector(director);

        Hotel hotel2 = new Hotel("Hotel Mediterraneo", "Almeria", 4);
        Cliente cliente = new Cliente("45901676R", "Carlos Garcia Segura");
        hotel2.addReserva(cliente, "01-01-2022", "05-01-2022");

        System.out.println("Hay " + Hotel.getNUM_HOTELES() + " hoteles construidos");
        System.out.println("El director del hotel1 es " + hotel1.getDirector().getNombre());

        System.out.println("\nRESERVAS DEL HOTEL");

        for (int i = 0; i < hotel2.getReservas().size(); i++) {
            Cliente clienteAux = hotel2.getReservas().get(i).getCliente();
            System.out.println("Nombre del cliente: " + clienteAux.getNombre());
            System.out.println("Fecha de entrada del cliente: " + hotel2.getReservas().get(i).getFechaEntrada());
            System.out.println("Otras reservas del cliente:");
            for (int j = 0; j < clienteAux.getReservas().size(); j++) {
                System.out.println("\t" + clienteAux.getReservas().get(j).getFechaEntrada());
            }

        }

        //PRACTICA 2 SESION 2
        Empleado empleado = new Empleado("Jorge");
        hotel1.addEmpleado(empleado);
        
        System.out.println("El hotel tiene "+hotel1.getEmpleados().size()+" empleado(s).");
        
        hotel1.addHabitacion(1, 2);
        hotel1.addHabitacion(2, 10);
        
        System.out.println("Habitacion para 5 personas: " + hotel1.buscarHabitacionCapacidad(5));
        System.out.println("Habitacion para 2 personas: " + hotel1.buscarHabitacionCapacidad(2));
        System.out.println("Habitacion para 15 personas: " + hotel1.buscarHabitacionCapacidad(15));
    }

}
