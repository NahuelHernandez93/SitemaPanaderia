package escritorios;

import java.awt.Color;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import operacionesConfiguracion.ConfiguracionTxt;
import clasesUtilidadGeneral.OperacionesUtiles;
import javax.swing.JTextField;
import operacionesConfiguracion.InterfacesGraficasEscritorioConfiguracion;
import principal.MaterialButton;

/**
 *
 * @author TELCOM MPC
 */
public class PrincipalConfiguracion extends javax.swing.JInternalFrame {

    /**
     * Creates new form PrincipalConfiguracion
     */
    public PrincipalConfiguracion() {
        initComponents();
        //btnGuardar.setEnabled(false);
    }
    private ConfiguracionTxt configuracionTxt;
    private InterfacesGraficasEscritorioConfiguracion interfacesGraficasEscritorioConfiguracion;
   
    
    

    public InterfacesGraficasEscritorioConfiguracion getInterfacesGraficasEscritorioConfiguracion() {
        return interfacesGraficasEscritorioConfiguracion;
    }

    public void setInterfacesGraficasEscritorioConfiguracion(InterfacesGraficasEscritorioConfiguracion interfacesGraficasEscritorioConfiguracion) {
        this.interfacesGraficasEscritorioConfiguracion = interfacesGraficasEscritorioConfiguracion;
    }

    public ConfiguracionTxt getConfiguracionTxt() {
        return configuracionTxt;
    }

    public void setConfiguracionTxt(ConfiguracionTxt configuracionTxt) {
        this.configuracionTxt = configuracionTxt;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipalTop = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblIcono = new javax.swing.JLabel();
        lblNombreventana = new javax.swing.JLabel();
        lblSalir = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnColorMarron = new principal.MaterialButton();
        btnColorRojo = new principal.MaterialButton();
        btnPaleta = new principal.MaterialButton();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnColorAzul = new principal.MaterialButton();
        jLabel5 = new javax.swing.JLabel();
        txtSaldoCuenta = new javax.swing.JTextField();
        btnGuardar = new principal.MaterialButton();

        panelPrincipalTop.setBackground(new java.awt.Color(204, 0, 0));

        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/services_80px.png"))); // NOI18N

        lblNombreventana.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNombreventana.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreventana.setText("CONFIGURACION");

        lblSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel_60px.png"))); // NOI18N
        lblSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSalirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblNombreventana, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1042, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblIcono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNombreventana, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnColorMarron.setBackground(new java.awt.Color(142, 131, 54,90));
        btnColorMarron.setForeground(new java.awt.Color(255, 255, 255));
        btnColorMarron.setText("MARRON CLARO");
        btnColorMarron.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnColorMarron.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnColorMarron.setMaximumSize(new java.awt.Dimension(130, 35));
        btnColorMarron.setMinimumSize(new java.awt.Dimension(130, 35));
        btnColorMarron.setPreferredSize(new java.awt.Dimension(130, 35));
        btnColorMarron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColorMarronActionPerformed(evt);
            }
        });

        btnColorRojo.setBackground(new java.awt.Color(147, 32, 48,90));
        btnColorRojo.setForeground(new java.awt.Color(255, 255, 255));
        btnColorRojo.setText("ROJO");
        btnColorRojo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnColorRojo.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnColorRojo.setMaximumSize(new java.awt.Dimension(130, 35));
        btnColorRojo.setMinimumSize(new java.awt.Dimension(130, 35));
        btnColorRojo.setPreferredSize(new java.awt.Dimension(130, 35));
        btnColorRojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColorRojoActionPerformed(evt);
            }
        });

        btnPaleta.setBackground(new java.awt.Color(0, 0, 0,60));
        btnPaleta.setForeground(new java.awt.Color(255, 255, 255));
        btnPaleta.setText("PALETA");
        btnPaleta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPaleta.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnPaleta.setMaximumSize(new java.awt.Dimension(130, 35));
        btnPaleta.setMinimumSize(new java.awt.Dimension(130, 35));
        btnPaleta.setPreferredSize(new java.awt.Dimension(130, 35));
        btnPaleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaletaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("NOTIFICAR CUANDO SALDO SEA MENOR A:");

        btnColorAzul.setBackground(new java.awt.Color(0, 85, 142,90));
        btnColorAzul.setForeground(new java.awt.Color(255, 255, 255));
        btnColorAzul.setText("AZUL");
        btnColorAzul.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnColorAzul.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnColorAzul.setMaximumSize(new java.awt.Dimension(130, 35));
        btnColorAzul.setMinimumSize(new java.awt.Dimension(130, 35));
        btnColorAzul.setPreferredSize(new java.awt.Dimension(130, 35));
        btnColorAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColorAzulActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("COLOR TEMA");

        txtSaldoCuenta.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtSaldoCuenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSaldoCuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSaldoCuentaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnColorAzul, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnColorMarron, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(btnColorRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPaleta, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSaldoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(376, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnColorRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPaleta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnColorAzul, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnColorMarron, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSaldoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(209, Short.MAX_VALUE))
        );

        btnGuardar.setBackground(new java.awt.Color(0, 0, 0,60));
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("GUARDAR");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnGuardar.setMaximumSize(new java.awt.Dimension(130, 35));
        btnGuardar.setMinimumSize(new java.awt.Dimension(130, 35));
        btnGuardar.setPreferredSize(new java.awt.Dimension(130, 35));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalTopLayout = new javax.swing.GroupLayout(panelPrincipalTop);
        panelPrincipalTop.setLayout(panelPrincipalTopLayout);
        panelPrincipalTopLayout.setHorizontalGroup(
            panelPrincipalTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelPrincipalTopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPrincipalTopLayout.setVerticalGroup(
            panelPrincipalTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalTopLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 0, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipalTop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipalTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnColorMarronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorMarronActionPerformed
        configuracionTxt.setColor(142, 131, 54, 255, 255, 255);
        configuracionTxt.setTemaPrincipalAdministrador();
     
        interfacesGraficasEscritorioConfiguracion.colorInterfazEscritorio();
       // btnGuardar.setEnabled(true);
    }//GEN-LAST:event_btnColorMarronActionPerformed

    private void btnColorRojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorRojoActionPerformed
        configuracionTxt.setColor(147, 32, 48, 255, 255, 255);
        configuracionTxt.setTemaPrincipalAdministrador();
       
        interfacesGraficasEscritorioConfiguracion.colorInterfazEscritorio();
       // btnGuardar.setEnabled(true);
    }//GEN-LAST:event_btnColorRojoActionPerformed

    private void btnPaletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaletaActionPerformed
        Color color = JColorChooser.showDialog(rootPane, "seleccione un color", this.getBackground());
        try {
            configuracionTxt.setColor(color.getRed(), color.getGreen(), color.getBlue(), 255, 255, 255);
        } catch (NullPointerException e) {
        }
        configuracionTxt.setTemaPrincipalAdministrador();
      
        interfacesGraficasEscritorioConfiguracion.colorInterfazEscritorio();
       // btnGuardar.setEnabled(true);
    }//GEN-LAST:event_btnPaletaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (OperacionesUtiles.mensajeGuardarTema()) {
           configuracionTxt.setSaldoCuenta(txtSaldoCuenta.getText());
            configuracionTxt.guardarConfiguaracion();
      //      btnGuardar.setEnabled(false);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnColorAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColorAzulActionPerformed
        configuracionTxt.setColor(0, 85, 142, 255, 255, 255);
        configuracionTxt.setTemaPrincipalAdministrador();
      
        interfacesGraficasEscritorioConfiguracion.colorInterfazEscritorio();
     //   btnGuardar.setEnabled(true);
    }//GEN-LAST:event_btnColorAzulActionPerformed

    private void lblSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalirMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblSalirMouseClicked

    private void txtSaldoCuentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaldoCuentaKeyReleased
         if(new OperacionesUtiles().advertenciaNum(evt)){
             txtSaldoCuenta.setText("0");
         }else if(txtSaldoCuenta.getText().equals("")){
             txtSaldoCuenta.setText("0");
         }
    }//GEN-LAST:event_txtSaldoCuentaKeyReleased

    public JPanel getPanelPrincipalTop() {
        return panelPrincipalTop;
    }

    public void setPanelPrincipalTop(JPanel panelPrincipalTop) {
        this.panelPrincipalTop = panelPrincipalTop;
    }

    public MaterialButton getBtnColorAzul() {
        return btnColorAzul;
    }

    public void setBtnColorAzul(MaterialButton btnColorAzul) {
        this.btnColorAzul = btnColorAzul;
    }

    public MaterialButton getBtnColorMarron() {
        return btnColorMarron;
    }

    public void setBtnColorMarron(MaterialButton btnColorMarron) {
        this.btnColorMarron = btnColorMarron;
    }

    public MaterialButton getBtnColorRojo() {
        return btnColorRojo;
    }

    public void setBtnColorRojo(MaterialButton btnColorRojo) {
        this.btnColorRojo = btnColorRojo;
    }

    public MaterialButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(MaterialButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public MaterialButton getBtnPaleta() {
        return btnPaleta;
    }

    public void setBtnPaleta(MaterialButton btnPaleta) {
        this.btnPaleta = btnPaleta;
    }

    public JTextField getTxtSaldoCuenta() {
        return txtSaldoCuenta;
    }

    public void setTxtSaldoCuenta(JTextField txtSaldoCuenta) {
        this.txtSaldoCuenta = txtSaldoCuenta;
    }


    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private principal.MaterialButton btnColorAzul;
    private principal.MaterialButton btnColorMarron;
    private principal.MaterialButton btnColorRojo;
    private principal.MaterialButton btnGuardar;
    private principal.MaterialButton btnPaleta;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblIcono;
    private javax.swing.JLabel lblNombreventana;
    private javax.swing.JLabel lblSalir;
    private javax.swing.JPanel panelPrincipalTop;
    private javax.swing.JTextField txtSaldoCuenta;
    // End of variables declaration//GEN-END:variables
}
