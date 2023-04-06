/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import civitas.Casilla;
import civitas.CasillaCalle;
import civitas.CasillaSorpresa;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author carlo
 */
public class CasillaPanel extends javax.swing.JPanel {

    /**
     * Creates new form CasillaPanel
     */
    Casilla casilla;

         public CasillaPanel() {
        initComponents();
        init();
        
    }
    /*
    public CasillaPanel(Casilla casilla) {
        initComponents();
        init();
        this.casilla = casilla;
        this.nombreTextField.setText(casilla.getNombre());
        this.nombrePanel.setVisible(true);
        
        repaint();
        revalidate();
    }
    
    
       public CasillaPanel(CasillaSorpresa casilla) {
        this((Casilla)casilla);
        
    }
       
   
    
     public CasillaPanel(CasillaCalle casilla) {
        this((Casilla)casilla);
        
        
        this.precioAlquilerTextField.setText(String.valueOf(casilla.getPrecioAlquilerCompleto()));
        this.precioCompraTextField.setText(String.valueOf(casilla.getPrecioCompra()));
        this.precioEdificarTextField.setText(String.valueOf(casilla.getPrecioEdificar()));
        this.numCasasTextField.setText(String.valueOf(casilla.getNumCasas()));
        this.numHotelesTextField.setText(String.valueOf(casilla.getNumHoteles()));

        if (casilla.tienePropietario()) {
            this.propietarioTextField.setText(casilla.getPropietario().getNombre());
            
        } else {
            this.propietarioTextField.setText("No tiene propietario");  
        }
        this.precioCompraPanel.setVisible(true);
        this.precioEdificarPanel.setVisible(true);
        this.precioAlquilerPanel.setVisible(true);
        this.numCasasPanel.setVisible(true);
        this.numHotelesPanel.setVisible(true);
        this.propietarioPanel.setVisible(true);
        
        repaint();
        revalidate();
        
    }
     */
   

    public void setCasilla(Casilla casilla) {
        this.casilla = casilla;
        this.nombreTextField.setText(casilla.getNombre());
        this.nombrePanel.setVisible(true);
        //this.setLayout(new BorderLayout());
        //this.nombrePanel.setLocation(this.getX()+((int)(this.getSize().getWidth())/2),this.getY()+((int)(this.getSize().getHeight())/2));
        
        repaint();
        revalidate();

    }

    public JPanel getNombrePanel() {
        return nombrePanel;
    }
    
    
    
    private void init(){
        casilla = null;
        this.nombrePanel.setVisible(false);
        this.precioCompraPanel.setVisible(false);
        this.precioEdificarPanel.setVisible(false);
        this.precioAlquilerPanel.setVisible(false);
        this.numCasasPanel.setVisible(false);
        this.numHotelesPanel.setVisible(false);
        this.propietarioPanel.setVisible(false);
    }

    public void setCasilla(CasillaCalle casilla) {
        this.casilla = casilla;
        this.nombreTextField.setText(casilla.getNombre());
        this.precioAlquilerTextField.setText(String.valueOf(casilla.getPrecioAlquilerCompleto()));
        this.precioCompraTextField.setText(String.valueOf(casilla.getPrecioCompra()));
        this.precioEdificarTextField.setText(String.valueOf(casilla.getPrecioEdificar()));
        this.numCasasTextField.setText(String.valueOf(casilla.getNumCasas()));
        this.numHotelesTextField.setText(String.valueOf(casilla.getNumHoteles()));
        

        if (casilla.tienePropietario()) {
            this.propietarioTextField.setText(casilla.getPropietario().getNombre());
            
            this.propietarioPanel.setBackground(casilla.getPropietario().getColorJugador());
            /*
            switch (casilla.getPropietario().getIndiceJugador()){
                case 0:
                    this.propietarioPanel.setBackground(new Color (0,255,0));
                    break;
                case 1:
                    this.propietarioPanel.setBackground(new Color (255,0,0));
                    break;
                case 2:
                    this.propietarioPanel.setBackground(new Color (148,206,255));
                    break;
                case 3:
                    this.propietarioPanel.setBackground(new Color (255,240,0));
                    break;
            }
            */
            repaint();
            revalidate();
        } else {
            this.propietarioTextField.setText("No tiene propietario");  
        }
        this.nombrePanel.setVisible(true);
        this.precioCompraPanel.setVisible(true);
        this.precioEdificarPanel.setVisible(true);
        this.precioAlquilerPanel.setVisible(true);
        this.numCasasPanel.setVisible(true);
        this.numHotelesPanel.setVisible(true);
        this.propietarioPanel.setVisible(true);
        
        

    }

    public void setCasilla(CasillaSorpresa casilla) {
        setCasilla((Casilla) casilla);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombrePanel = new javax.swing.JPanel();
        nombreLabel = new javax.swing.JLabel();
        nombreTextField = new javax.swing.JTextField();
        precioCompraPanel = new javax.swing.JPanel();
        precioCompraLabel = new javax.swing.JLabel();
        precioCompraTextField = new javax.swing.JTextField();
        precioEdificarPanel = new javax.swing.JPanel();
        precioEdificarLabel = new javax.swing.JLabel();
        precioEdificarTextField = new javax.swing.JTextField();
        precioAlquilerPanel = new javax.swing.JPanel();
        precioAlquilerLabel = new javax.swing.JLabel();
        precioAlquilerTextField = new javax.swing.JTextField();
        numCasasPanel = new javax.swing.JPanel();
        numCasasLabel = new javax.swing.JLabel();
        numCasasTextField = new javax.swing.JTextField();
        numHotelesPanel = new javax.swing.JPanel();
        numHotelesLabel = new javax.swing.JLabel();
        numHotelesTextField = new javax.swing.JTextField();
        propietarioPanel = new javax.swing.JPanel();
        propietarioLabel = new javax.swing.JLabel();
        propietarioTextField = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        setPreferredSize(new java.awt.Dimension(216, 216));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        nombreLabel.setText("Nombre:");
        nombrePanel.add(nombreLabel);

        nombreTextField.setEditable(false);
        nombrePanel.add(nombreTextField);

        add(nombrePanel);

        precioCompraLabel.setText("Precio Compra:");
        precioCompraPanel.add(precioCompraLabel);

        precioCompraTextField.setEditable(false);
        precioCompraPanel.add(precioCompraTextField);

        add(precioCompraPanel);

        precioEdificarLabel.setText("Precio Edificar:");
        precioEdificarPanel.add(precioEdificarLabel);

        precioEdificarTextField.setEditable(false);
        precioEdificarPanel.add(precioEdificarTextField);

        add(precioEdificarPanel);

        precioAlquilerLabel.setText("Precio Alquiler:");
        precioAlquilerPanel.add(precioAlquilerLabel);

        precioAlquilerTextField.setEditable(false);
        precioAlquilerPanel.add(precioAlquilerTextField);

        add(precioAlquilerPanel);

        numCasasLabel.setText("Numero Casas:");
        numCasasPanel.add(numCasasLabel);

        numCasasTextField.setEditable(false);
        numCasasPanel.add(numCasasTextField);

        add(numCasasPanel);

        numHotelesLabel.setText("Numero Hoteles:");
        numHotelesPanel.add(numHotelesLabel);

        numHotelesTextField.setEditable(false);
        numHotelesPanel.add(numHotelesTextField);

        add(numHotelesPanel);

        propietarioLabel.setText("Propietario:");
        propietarioPanel.add(propietarioLabel);

        propietarioTextField.setEditable(false);
        propietarioPanel.add(propietarioTextField);

        add(propietarioPanel);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JPanel nombrePanel;
    private javax.swing.JTextField nombreTextField;
    private javax.swing.JLabel numCasasLabel;
    private javax.swing.JPanel numCasasPanel;
    private javax.swing.JTextField numCasasTextField;
    private javax.swing.JLabel numHotelesLabel;
    private javax.swing.JPanel numHotelesPanel;
    private javax.swing.JTextField numHotelesTextField;
    private javax.swing.JLabel precioAlquilerLabel;
    private javax.swing.JPanel precioAlquilerPanel;
    private javax.swing.JTextField precioAlquilerTextField;
    private javax.swing.JLabel precioCompraLabel;
    private javax.swing.JPanel precioCompraPanel;
    private javax.swing.JTextField precioCompraTextField;
    private javax.swing.JLabel precioEdificarLabel;
    private javax.swing.JPanel precioEdificarPanel;
    private javax.swing.JTextField precioEdificarTextField;
    private javax.swing.JLabel propietarioLabel;
    private javax.swing.JPanel propietarioPanel;
    private javax.swing.JTextField propietarioTextField;
    // End of variables declaration//GEN-END:variables
}
