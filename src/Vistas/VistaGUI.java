/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controladores.IControlador;
import DTO.DTOAmortizacion;
import DTO.DTOCliente;
import Data.Lector;
import Modelo.Factorys.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdom2.JDOMException;

/**
 *
 * @author Mellvin
 */
public class VistaGUI extends javax.swing.JFrame {

    /**
     * Creates new form VistaGUI
     */
    public VistaGUI() throws IOException, JDOMException {
        initComponents();
        SetMonedas();
        SetAmortizacion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cNombre = new javax.swing.JTextField();
        cPA = new javax.swing.JTextField();
        cPlazo = new javax.swing.JTextField();
        cSA = new javax.swing.JTextField();
        cIA = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cMonto = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaResultados = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Sistema de Amortizacion");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Primer Apellido:");

        jLabel4.setText("Segundo Apellido:");

        jLabel5.setText("Plazo del Prestamo:");

        jLabel6.setText("Interes Anual:");

        jLabel7.setText("Moneda:");

        jLabel8.setText("Tipo de Amortizacion:");

        cNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cNombreActionPerformed(evt);
            }
        });
        cNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cNombreKeyTyped(evt);
            }
        });

        cPA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cPAKeyTyped(evt);
            }
        });

        cPlazo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cPlazoKeyTyped(evt);
            }
        });

        cSA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cSAKeyTyped(evt);
            }
        });

        cIA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cIAKeyTyped(evt);
            }
        });

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Monto del Prestamo:");

        cMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cMontoActionPerformed(evt);
            }
        });

        tablaResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Periodo K", "Deuda Inicial", "Intereses", "Amortización", "Cuota"
            }
        ));
        jScrollPane2.setViewportView(tablaResultados);

        jLabel10.setText("Nombre del cliente:");

        jLabel11.setText("Monto del prestamo:");

        jLabel13.setText("Plazo del prestamo");

        jLabel14.setText("Interes anual:");

        jLabel15.setText("Sistema de amortizacion:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(406, 406, 406)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(145, 145, 145)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cNombre)
                    .addComponent(cPA)
                    .addComponent(cSA)
                    .addComponent(cPlazo)
                    .addComponent(cIA)
                    .addComponent(jComboBox1, 0, 144, Short.MAX_VALUE)
                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cMonto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                    .addComponent(jLabel15))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cPA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cSA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14))
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cPlazo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jButton1)
                .addGap(187, 187, 187))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cNombreKeyTyped
        // TODO add your handling code here:
        
         int k = (int) evt.getKeyChar();//k = al valor de la tecla presionada   
		        if (k > 47 && k < 58) {//Si el caracter ingresado es una letra
		             evt.setKeyChar((char) KeyEvent.VK_CLEAR);//Limpiar el caracter ingresado
		             JOptionPane.showMessageDialog(null, "Por favor ingrese su nombre correctamentente", "Alerta",
	                     JOptionPane.ERROR_MESSAGE);
		        }
        
        
    }//GEN-LAST:event_cNombreKeyTyped

    private void cPAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cPAKeyTyped
        // TODO add your handling code here:
         int k = (int) evt.getKeyChar();//k = al valor de la tecla presionada  
          if (k > 47 && k < 58) {//Si el caracter ingresado es una letra
		             evt.setKeyChar((char) KeyEvent.VK_CLEAR);//Limpiar el caracter ingresado
		             JOptionPane.showMessageDialog(null, "Por favor ingrese su primer apellido correctamentente", "Alerta",
	                     JOptionPane.ERROR_MESSAGE);
		        }
    }//GEN-LAST:event_cPAKeyTyped

    private void cSAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cSAKeyTyped
        // TODO add your handling code here:
         int k = (int) evt.getKeyChar();//k = al valor de la tecla presionada  
          if (k > 47 && k < 58) {//Si el caracter ingresado es una letra
		             evt.setKeyChar((char) KeyEvent.VK_CLEAR);//Limpiar el caracter ingresado
		             JOptionPane.showMessageDialog(null, "Por favor ingrese su segundo apellido correctamentente", "Alerta",
	                     JOptionPane.ERROR_MESSAGE);
		        }
    }//GEN-LAST:event_cSAKeyTyped

    private void cPlazoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cPlazoKeyTyped
        // TODO add your handling code here:
         int k = (int) evt.getKeyChar();//k = al valor de la tecla presionada    
		         if (k >= 97 && k <= 122 || k >= 65 && k <= 90) {//Si el caracter ingresado es una letra
		             evt.setKeyChar((char) KeyEvent.VK_CLEAR);//Limpiar el caracter ingresado
		             JOptionPane.showMessageDialog(null, "Por favor digite números", " Alerta",
		                     JOptionPane.ERROR_MESSAGE);
		        }
        
        
        
        
    }//GEN-LAST:event_cPlazoKeyTyped

    private void cIAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cIAKeyTyped
        // TODO add your handling code here:
        
         int k = (int) evt.getKeyChar();//k = al valor de la tecla presionada    
		         if (k >= 97 && k <= 122 || k >= 65 && k <= 90) {//Si el caracter ingresado es una letra
		             evt.setKeyChar((char) KeyEvent.VK_CLEAR);//Limpiar el caracter ingresado
		             JOptionPane.showMessageDialog(null, "Por favor digite números", " Alerta",
		                     JOptionPane.ERROR_MESSAGE);
		        }
    }//GEN-LAST:event_cIAKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  
        
        enviarDatos();
        IControlador control = factorycontrol.crearControlador();
        control.consultarAmortizacion(dtoAmortizacion, dtoCliente);
        limpiarDatos();
        llenarTabla();
        
   

        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void cNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cNombreActionPerformed

    private void cMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cMontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cMontoActionPerformed

    
    private void SetMonedas() throws IOException, JDOMException{
    ArrayList monedas = Lector.obtenerMonedas();
    String[] array = new String[monedas.size()];
    for(int i = 0; i < array.length; i++) {
       jComboBox1.addItem(monedas.get(i).toString());
    }
    }
   
     private void SetAmortizacion() throws IOException, JDOMException{
    ArrayList amortizacion = Lector.obtenerTiposAmortizaciones();
    String[] array = new String[amortizacion.size()];
    for(int i = 0; i < array.length; i++) {
       jComboBox2.addItem(amortizacion.get(i).toString());
    }
    }
   
    private void enviarDatos(){
        if (validarVista()) {
            
        try{
        dtoCliente.setNombre(cNombre.getText());
        dtoCliente.setPrimerApellido(cPA.getText());
        dtoCliente.setSegundoApellido(cSA.getText());
        
        dtoAmortizacion.SetInteres_anual(Integer.parseInt(cIA.getText()));
        dtoAmortizacion.SetMonto_prestamo( Integer.parseInt(cMonto.getText()));
        dtoAmortizacion.SetPlazo(Integer.parseInt(cPlazo.getText()));
        dtoAmortizacion.SetTipoAmortizacion(jComboBox2.getSelectedItem().toString());
        dtoAmortizacion.SetMoneda(jComboBox1.getSelectedItem().toString());        
    }catch (Exception e){}
        
     }}
    
    
    
    private void limpiarDatos(){
     cNombre.setText("");
     cPA.setText("");
     cSA.setText("");
     cMonto.setText("");
     cPlazo.setText("");
     cIA.setText("");
    }
    
    
  
     private void llenarTabla(){
         String [] columnas = {"Periodo K", "Deuda", "Interes", "Cuota", "Amortizacion"};
        DefaultTableModel tabla = new DefaultTableModel(null, columnas);
       
            int temporalPlazo = dtoAmortizacion.GetPlazo();
            for (int i = 0; i <= dtoAmortizacion.GetPlazo()+1; i++){
                
                Object[] fila = new Object[5];
                fila[0] = i+1;
                fila[1] = dtoAmortizacion.getResultadoDeuda().get(i);
                fila[2] = dtoAmortizacion.getResultadoInteres().get(i);
                fila[3] = dtoAmortizacion.getResultadoCuota().get(i);
                fila[4] = dtoAmortizacion.getResultadoAmortizaciones().get(i);
                tabla.addRow(fila);
                tablaResultados.setModel(tabla);
                tablaResultados.setVisible(true);
            }
   
     }
     
      private boolean validarVista(){
          if (Integer.parseInt(cIA.getText()) <= 0){
              JOptionPane.showMessageDialog(null, "El interes anual debe ser mayor a cero", " Alerta",
		                     JOptionPane.ERROR_MESSAGE);
              return false;
        } 
          if(Integer.parseInt(cMonto.getText()) <= 0){
                JOptionPane.showMessageDialog(null, "El monto debe ser mayor a cero", " Alerta",
		                     JOptionPane.ERROR_MESSAGE);
                 return false;
          }
          
           if(Integer.parseInt(cPlazo.getText()) <= 0){
                JOptionPane.showMessageDialog(null, "El plazo debe ser mayor a cero", " Alerta",
		                     JOptionPane.ERROR_MESSAGE);
                 return false;
           }
          return true;
    }
 
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VistaGUI().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(VistaGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JDOMException ex) {
                    Logger.getLogger(VistaGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    


   
  
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cIA;
    private javax.swing.JTextField cMonto;
    private javax.swing.JTextField cNombre;
    private javax.swing.JTextField cPA;
    private javax.swing.JTextField cPlazo;
    private javax.swing.JTextField cSA;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTable tablaResultados;
    // End of variables declaration//GEN-END:variables

    private DTOCliente dtoCliente = new DTOCliente();
    private DTOAmortizacion dtoAmortizacion = new DTOAmortizacion();
    private  FactoryControlador factorycontrol = new FactoryConcretoControlador();





}
