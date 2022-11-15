/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ObliDDA.iu;


/**
 *
 * @author Martin
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form VentanaInicio
     */
    public Inicio() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bUsuario = new javax.swing.JButton();
        bMonitoreo = new javax.swing.JButton();
        bTrabajador = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bUsuario.setText("Usuario");
        bUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUsuarioActionPerformed(evt);
            }
        });

        bMonitoreo.setText("Monitoreo");
        bMonitoreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMonitoreoActionPerformed(evt);
            }
        });

        bTrabajador.setText("Trabajador");
        bTrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTrabajadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bTrabajador)
                    .addComponent(bMonitoreo)
                    .addComponent(bUsuario))
                .addContainerGap(176, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(bTrabajador)
                .addGap(45, 45, 45)
                .addComponent(bUsuario)
                .addGap(49, 49, 49)
                .addComponent(bMonitoreo)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bTrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTrabajadorActionPerformed
        new Login(this, false).setVisible(true);
    }//GEN-LAST:event_bTrabajadorActionPerformed

    private void bUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUsuarioActionPerformed
        RealizarLlamada dialogo = new RealizarLlamada(this, false);
        dialogo.setVisible(true);
    }//GEN-LAST:event_bUsuarioActionPerformed

    private void bMonitoreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMonitoreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bMonitoreoActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bMonitoreo;
    private javax.swing.JButton bTrabajador;
    private javax.swing.JButton bUsuario;
    // End of variables declaration//GEN-END:variables
}
