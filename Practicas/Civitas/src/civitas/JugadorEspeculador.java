/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

/**
 *
 * @author carlo
 */
public class JugadorEspeculador extends Jugador {

    protected static int FACTORESPECULADOR = 2;

    protected JugadorEspeculador(Jugador jugador) {
        super(jugador);
        actualizaPropiedadesPorConversion();
    }

    void actualizaPropiedadesPorConversion() {
        for (int i = 0; i < getPropiedades().size(); i++) {
            this.getPropiedades().get(i).actualizaPropietarioPorConversion(this);
        }
    }

    JugadorEspeculador convertir() {
        return this;

    }

    @Override
    float paga(float cantidad) {
        return super.paga(cantidad / FACTORESPECULADOR); //To change body of generated methods, choose Tools | Templates.
    }

    private static int getCasasMax() {
        return CasasMax * FACTORESPECULADOR;
    }

    private static int getHotelesMax() {
        return HotelesMax * FACTORESPECULADOR;
    }

    public String toString() {

        return "SOY UN JUGADOR ESPECULADOR.\n " + super.toString();
    }

}
