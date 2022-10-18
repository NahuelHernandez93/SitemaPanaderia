package escritorios;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import operacionesCliente.ABMCliente;
import operacionesCliente.TablaCliente;
import clasesUtilidadGeneral.OperacionesUtiles;
import formularios.FormularioEditarCliente;
import formularios.FormularioEditarVenta;
import formularios.FormularioRegistrarCliente;
import formularios.FormularioRegistrarVenta;
import operacionesCliente.InterfazGraficaFormularioEditarCliente;
import operacionesCliente.InterfazGraficaFormularioRegistrarCliente;
import operacionesVenta.OperacionesSecundariasVenta;
import operacionesCuenta.InterfazGraficaEscritorioCuenta;
import principal.MaterialButton;
import principal.PrincipalAdministrador;

/**
 *
 * @author TELCOM MPC
 */
public class PrincipalCliente extends javax.swing.JInternalFrame {

    public PrincipalCliente() {
        initComponents();
        formularioRegistrarCliente = null;
        formularioEditarCliente = null;
    }

    private InterfazGraficaFormularioRegistrarCliente interfazGraficaRegistrar;
    private InterfazGraficaFormularioEditarCliente interfazGraficaEditar;
    private FormularioRegistrarCliente formularioRegistrarCliente;
    private FormularioEditarCliente formularioEditarCliente;
    private TablaCliente tablaCliente;
    private final ABMCliente abm = new ABMCliente();
    private final InterfazGraficaEscritorioCuenta interfazGraficaCuenta = new InterfazGraficaEscritorioCuenta();
    private PrincipalAdministrador principalAdministrador;

    
    
    public InterfazGraficaFormularioRegistrarCliente getInterfazGraficaRegistrar() {
        return interfazGraficaRegistrar;
    }

    public void setInterfazGraficaRegistrar(InterfazGraficaFormularioRegistrarCliente interfazGraficaRegistrar) {
        this.interfazGraficaRegistrar = interfazGraficaRegistrar;
    }

    public InterfazGraficaFormularioEditarCliente getInterfazGraficaEditar() {
        return interfazGraficaEditar;
    }

    public void setInterfazGraficaEditar(InterfazGraficaFormularioEditarCliente interfazGraficaEditar) {
        this.interfazGraficaEditar = interfazGraficaEditar;
    }


    public TablaCliente getTablaCliente() {
        return tablaCliente;
    }

    public void setTablaCliente(TablaCliente tablaCliente) {
        this.tablaCliente = tablaCliente;
    }

    public JTable getTablaGrafica() {
        return tablaGrafica;
    }

    public void setTablaGrafica(JTable tablaGrafica) {
        this.tablaGrafica = tablaGrafica;
    }

    public FormularioRegistrarCliente getFormularioRegistrarCliente() {
        return formularioRegistrarCliente;
    }

    public void setFormularioRegistrarCliente(FormularioRegistrarCliente formularioRegistrarCliente) {
        this.formularioRegistrarCliente = formularioRegistrarCliente;
    }

    public FormularioEditarCliente getFormularioEditarCliente() {
        return formularioEditarCliente;
    }

    public void setFormularioEditarCliente(FormularioEditarCliente formularioEditarCliente) {
        this.formularioEditarCliente = formularioEditarCliente;
    }

    public PrincipalAdministrador getPrincipalAdministrador() {
        return principalAdministrador;
    }

    public void setPrincipalAdministrador(PrincipalAdministrador principalAdministrador) {
        this.principalAdministrador = principalAdministrador;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipalTop = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        btnnuevo = new principal.MaterialButton();
        btnCuenta = new principal.MaterialButton();
        btnnEditar = new principal.MaterialButton();
        btnEliminar = new principal.MaterialButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaGrafica = new javax.swing.JTable();
        panel = new javax.swing.JPanel();
        lblNombreVentana = new javax.swing.JLabel();
        lblIcono = new javax.swing.JLabel();
        lblSalir = new javax.swing.JLabel();

        panelPrincipalTop.setBackground(new java.awt.Color(204, 0, 0));

        txtBuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.lightGray));
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        btnnuevo.setBackground(new java.awt.Color(0, 0, 0,60));
        btnnuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnnuevo.setText("NUEVO CLIENTE");
        btnnuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnnuevo.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnnuevo.setMaximumSize(new java.awt.Dimension(130, 35));
        btnnuevo.setMinimumSize(new java.awt.Dimension(130, 35));
        btnnuevo.setPreferredSize(new java.awt.Dimension(130, 35));
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnCuenta.setBackground(new java.awt.Color(0, 0, 0,60));
        btnCuenta.setForeground(new java.awt.Color(255, 255, 255));
        btnCuenta.setText("CUENTA");
        btnCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCuenta.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnCuenta.setMaximumSize(new java.awt.Dimension(130, 35));
        btnCuenta.setMinimumSize(new java.awt.Dimension(130, 35));
        btnCuenta.setPreferredSize(new java.awt.Dimension(130, 35));
        btnCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuentaActionPerformed(evt);
            }
        });

        btnnEditar.setBackground(new java.awt.Color(0, 0, 0,60));
        btnnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnnEditar.setText("EDITAR CLIENTE");
        btnnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnnEditar.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnnEditar.setMaximumSize(new java.awt.Dimension(130, 35));
        btnnEditar.setPreferredSize(new java.awt.Dimension(130, 35));
        btnnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(0, 0, 0,60));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("ELIMINAR CLIENTE");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnEliminar.setMaximumSize(new java.awt.Dimension(130, 35));
        btnEliminar.setMinimumSize(new java.awt.Dimension(130, 35));
        btnEliminar.setPreferredSize(new java.awt.Dimension(130, 35));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        tablaGrafica.setBackground(new java.awt.Color(255, 255, 255));
        tablaGrafica.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        tablaGrafica.setForeground(new java.awt.Color(102, 0, 0));
        tablaGrafica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "APELLIDO", "RAZON SOCIAL", "DIRECCION", "NUMERO/DIR", "LOCALIDAD", "PROVINCIA", "TELEFONO", "TIPO TEPLEFONO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaGrafica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaGrafica.setDoubleBuffered(true);
        tablaGrafica.setRowHeight(40);
        tablaGrafica.setSelectionBackground(new java.awt.Color(102, 0, 0));
        tablaGrafica.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tablaGrafica.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaGrafica.getTableHeader().setReorderingAllowed(false);
        tablaGrafica.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                tablaGraficaComponentHidden(evt);
            }
        });
        jScrollPane1.setViewportView(tablaGrafica);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
        );

        lblNombreVentana.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNombreVentana.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreVentana.setText("CLIENTES");

        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user_group_man_man_80px.png"))); // NOI18N

        lblSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel_60px.png"))); // NOI18N
        lblSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSalirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombreVentana, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNombreVentana, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(lblSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblIcono, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout panelPrincipalTopLayout = new javax.swing.GroupLayout(panelPrincipalTop);
        panelPrincipalTop.setLayout(panelPrincipalTopLayout);
        panelPrincipalTopLayout.setHorizontalGroup(
            panelPrincipalTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalTopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(593, 593, 593)
                .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelPrincipalTopLayout.setVerticalGroup(
            panelPrincipalTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalTopLayout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipalTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel.setBackground(new java.awt.Color(0, 0, 0, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipalTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipalTop, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        tablaCliente.setPrincipalCliente(this);
        tablaCliente.ejecutarRellenarTabla();
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void tablaGraficaComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tablaGraficaComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaGraficaComponentHidden

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        interfazGraficaRegistrar.setPrincipalCliente(this);
        interfazGraficaRegistrar.nuevoFormularioRegistrar();

    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuentaActionPerformed
        interfazGraficaCuenta.setPrincipalAdministrador(this.getPrincipalAdministrador());
        tablaCliente.setPrincipalCliente(this);
        if (tablaCliente.verificarFilaSeleccionada()) {
            if (tablaCliente.verficarClienteNoconsumidorFinal(2)) {
                interfazGraficaCuenta.setNombreCliente(tablaCliente.obtenerNombreApellidoFilaSeleccionada());
                interfazGraficaCuenta.setIdCliente(tablaCliente.obtenerIdFilaSeleccionada());
                interfazGraficaCuenta.ejecutarNuevaVentana();
            }

        }

    }//GEN-LAST:event_btnCuentaActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        abm.setPrincipalCliente(this);
        tablaCliente.setPrincipalCliente(this);
        if (tablaCliente.verificarFilaSeleccionada()) {
            if (tablaCliente.verficarClienteNoconsumidorFinal(1)) {
                if (OperacionesUtiles.mensajeEliminarRegistro()) {
                    if (abm.ejecutarEliminar()) {
                        tablaCliente.setEstadoConsulta(0);
                        tablaCliente.ejecutarRellenarTabla();
                    }
                }
            }
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnEditarActionPerformed
        // TODO add your handling code here:
        tablaCliente.setPrincipalCliente(this);
        if (tablaCliente.verificarFilaSeleccionada()) {
            if (tablaCliente.verficarClienteNoconsumidorFinal(1)) {
                InterfazGraficaFormularioEditarCliente formularioEditar = new InterfazGraficaFormularioEditarCliente();
                formularioEditar.setPrincipalCliente(this);
                formularioEditar.nuevoFormularioEditar();
            }
        }
    }//GEN-LAST:event_btnnEditarActionPerformed

    private void lblSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalirMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblSalirMouseClicked

    public JPanel getPanelPrincipalTop() {
        return panelPrincipalTop;
    }

    public void setPanelPrincipalTop(JPanel panelPrincipalTop) {
        this.panelPrincipalTop = panelPrincipalTop;
    }

    public MaterialButton getBtnnuevocliente() {
        return btnnuevo;
    }

    public void setBtnnuevocliente(MaterialButton btnnuevocliente) {
        this.btnnuevo = btnnuevocliente;
    }

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public void setTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
    }

    public MaterialButton getBtnEliminarCli() {
        return btnEliminar;
    }

    public void setBtnEliminarCli(MaterialButton btnEliminarCli) {
        this.btnEliminar = btnEliminarCli;
    }

    public MaterialButton getBtnnEditarCl() {
        return btnnEditar;
    }

    public void setBtnnEditarCl(MaterialButton btnnEditarCl) {
        this.btnnEditar = btnnEditarCl;
    }

    public MaterialButton getBtnCuenta() {
        return btnCuenta;
    }

    public void setBtnCuenta(MaterialButton btnCuenta) {
        this.btnCuenta = btnCuenta;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private principal.MaterialButton btnCuenta;
    private principal.MaterialButton btnEliminar;
    private principal.MaterialButton btnnEditar;
    private principal.MaterialButton btnnuevo;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIcono;
    private javax.swing.JLabel lblNombreVentana;
    private javax.swing.JLabel lblSalir;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panelPrincipalTop;
    private javax.swing.JTable tablaGrafica;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
