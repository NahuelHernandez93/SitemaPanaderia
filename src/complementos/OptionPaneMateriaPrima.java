package complementos;

import javax.swing.JButton;
import javax.swing.JPanel;
import operacionesIngresoMateriaPrima.InterfazGraficaEscritorioIngresoMateriaPrima;

import operacionesMateriaPrima.InterfazGraficaEscritorioMateriaPrima;
import principal.MaterialButton;

import principal.PrincipalAdministrador;

/**
 *
 * @author Hasper Franco
 * @author Nahuel Hernandez
 */
public class OptionPaneMateriaPrima extends javax.swing.JDialog {

    /**
     * Creates new form OptionPaneMateriaPrima
     */
    public OptionPaneMateriaPrima(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private final InterfazGraficaEscritorioMateriaPrima interfazGraficaMateriaPrima = new InterfazGraficaEscritorioMateriaPrima();
    private final InterfazGraficaEscritorioIngresoMateriaPrima interfazGraficaIngresoMateriaPrima = new InterfazGraficaEscritorioIngresoMateriaPrima();
    private PrincipalAdministrador principalAdministrador;

    public PrincipalAdministrador getPrincipalAdministrador() {
        return principalAdministrador;
    }

    public void setPrincipalAdministrador(PrincipalAdministrador principalAdministrador) {
        this.principalAdministrador = principalAdministrador;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        panelPrincipalTop = new javax.swing.JPanel();
        lblSalir = new javax.swing.JLabel();
        btnIngresoMateriaPrima = new principal.MaterialButton();
        btnMateriaPrima = new principal.MaterialButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 102), java.awt.Color.gray, new java.awt.Color(102, 102, 102), java.awt.Color.gray));
        jPanel2.setMaximumSize(new java.awt.Dimension(415, 300));
        jPanel2.setMinimumSize(new java.awt.Dimension(415, 300));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        lblSalir.setForeground(new java.awt.Color(0, 0, 0));
        lblSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel_60px.png"))); // NOI18N
        lblSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSalirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalTopLayout = new javax.swing.GroupLayout(panelPrincipalTop);
        panelPrincipalTop.setLayout(panelPrincipalTopLayout);
        panelPrincipalTopLayout.setHorizontalGroup(
            panelPrincipalTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalTopLayout.createSequentialGroup()
                .addGap(0, 358, Short.MAX_VALUE)
                .addComponent(lblSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelPrincipalTopLayout.setVerticalGroup(
            panelPrincipalTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalTopLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnIngresoMateriaPrima.setBackground(new java.awt.Color(0, 0, 0,60));
        btnIngresoMateriaPrima.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresoMateriaPrima.setText("INGRESO MATERIA PRIMA");
        btnIngresoMateriaPrima.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresoMateriaPrima.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnIngresoMateriaPrima.setMaximumSize(new java.awt.Dimension(170, 35));
        btnIngresoMateriaPrima.setMinimumSize(new java.awt.Dimension(170, 35));
        btnIngresoMateriaPrima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresoMateriaPrimaActionPerformed(evt);
            }
        });

        btnMateriaPrima.setBackground(new java.awt.Color(0, 0, 0,60));
        btnMateriaPrima.setForeground(new java.awt.Color(255, 255, 255));
        btnMateriaPrima.setText("MATERIA PRIMA");
        btnMateriaPrima.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMateriaPrima.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnMateriaPrima.setMaximumSize(new java.awt.Dimension(170, 35));
        btnMateriaPrima.setMinimumSize(new java.awt.Dimension(170, 35));
        btnMateriaPrima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMateriaPrimaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipalTop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnIngresoMateriaPrima, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                    .addComponent(btnMateriaPrima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelPrincipalTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnMateriaPrima, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnIngresoMateriaPrima, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalirMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblSalirMouseClicked

    private void btnIngresoMateriaPrimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresoMateriaPrimaActionPerformed
        interfazGraficaIngresoMateriaPrima.setPrincipalAdministrador(principalAdministrador);
        interfazGraficaIngresoMateriaPrima.ejecutarNuevaVentana();
        this.dispose();
    }//GEN-LAST:event_btnIngresoMateriaPrimaActionPerformed

    private void btnMateriaPrimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMateriaPrimaActionPerformed
        interfazGraficaMateriaPrima.setPrincipalAdministrador(principalAdministrador);
        interfazGraficaMateriaPrima.ejecutarNuevaVentana();
        this.dispose();
    }//GEN-LAST:event_btnMateriaPrimaActionPerformed

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
            java.util.logging.Logger.getLogger(OptionPaneMateriaPrima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OptionPaneMateriaPrima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OptionPaneMateriaPrima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OptionPaneMateriaPrima.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                OptionPaneMateriaPrima dialog = new OptionPaneMateriaPrima(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public JPanel getPanelTop() {
        return panelPrincipalTop;
    }

    public void setPanelTop(JPanel panelTop) {
        this.panelPrincipalTop = panelTop;
    }

    public MaterialButton getBtnIngresoMateriaPrima() {
        return btnIngresoMateriaPrima;
    }

    public void setBtnIngresoMateriaPrima(MaterialButton btnIngresoMateriaPrima) {
        this.btnIngresoMateriaPrima = btnIngresoMateriaPrima;
    }

    public MaterialButton getBtnMateriaPrima() {
        return btnMateriaPrima;
    }

    public void setBtnMateriaPrima(MaterialButton btnMateriaPrima) {
        this.btnMateriaPrima = btnMateriaPrima;
    }




    // Variables declaration - do not modify//GEN-BEGIN:variables
    public principal.MaterialButton btnIngresoMateriaPrima;
    public principal.MaterialButton btnMateriaPrima;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblSalir;
    private javax.swing.JPanel panelPrincipalTop;
    // End of variables declaration//GEN-END:variables
}
