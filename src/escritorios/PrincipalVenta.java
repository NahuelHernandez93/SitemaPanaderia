package escritorios;

import formularios.FormularioDetalleDeVenta;
import formularios.FormularioEditarVenta;
import formularios.FormularioEstadoVenta;
import formularios.FormularioRegistrarVenta;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import operacionesVenta.ABMVenta;
import operacionesVenta.InterfazGraficaDetalleVenta;
import operacionesVenta.InterfazGraficaFormularioEditarVenta;
import operacionesVenta.InterfazGraficaFormularioEstadoVenta;
import operacionesVenta.InterfazGraficaFormularioRegistrarVenta;
import operacionesVenta.InterfazGraficaFormularioWebAFIP;
import operacionesVenta.TablaVenta;
import principal.PrincipalAdministrador;

/**
 *
 * @author TELCOM MPC
 */
public class PrincipalVenta extends javax.swing.JInternalFrame {

    public PrincipalVenta() {
        initComponents();
        fromularioRegistrarVenta = null;
        formularioEditarVenta = null;
        formularioDetalleVenta = null;
        formularioEstadoVenta=null;
        radButtonPendientes.setEnabled(false);
    }

    private InterfazGraficaFormularioRegistrarVenta interfazGraficaRegistrar;
    private InterfazGraficaFormularioEditarVenta interfazGraficaEditar;
    private InterfazGraficaDetalleVenta interfazGraficaDetalleVenta;
    private InterfazGraficaFormularioEstadoVenta interfazGraficaEstadoVenta;
    
    private FormularioRegistrarVenta fromularioRegistrarVenta;
    private FormularioEditarVenta formularioEditarVenta;
    private FormularioDetalleDeVenta formularioDetalleVenta;
    private FormularioEstadoVenta formularioEstadoVenta;
    private TablaVenta tablaVenta;
    private PrincipalAdministrador principalAdministrador;
    
    private final InterfazGraficaFormularioWebAFIP interfazGraficaWeb = new InterfazGraficaFormularioWebAFIP();

    public PrincipalAdministrador getPrincipalAdministrador() {
        return principalAdministrador;
    }

    public void setPrincipalAdministrador(PrincipalAdministrador principalAdministrador) {
        this.principalAdministrador = principalAdministrador;
    }

    public InterfazGraficaFormularioRegistrarVenta getInterfazGraficaRegistrar() {
        return interfazGraficaRegistrar;
    }

    public void setInterfazGraficaRegistrar(InterfazGraficaFormularioRegistrarVenta interfazGraficaRegistrar) {
        this.interfazGraficaRegistrar = interfazGraficaRegistrar;
    }

    public InterfazGraficaFormularioEditarVenta getInterfazGraficaEditar() {
        return interfazGraficaEditar;
    }

    public void setInterfazGraficaEditar(InterfazGraficaFormularioEditarVenta interfazGraficaEditar) {
        this.interfazGraficaEditar = interfazGraficaEditar;
    }

    public InterfazGraficaDetalleVenta getInterfazGraficaDetalleVenta() {
        return interfazGraficaDetalleVenta;
    }

    public void setInterfazGraficaDetalleVenta(InterfazGraficaDetalleVenta interfazGraficaDetalleVenta) {
        this.interfazGraficaDetalleVenta = interfazGraficaDetalleVenta;
    }

   

   

    public FormularioEstadoVenta getFormularioEstadoVenta() {
        return formularioEstadoVenta;
    }

    public void setFormularioEstadoVenta(FormularioEstadoVenta formularioEstadoVenta) {
        this.formularioEstadoVenta = formularioEstadoVenta;
    }

    public InterfazGraficaFormularioEstadoVenta getInterfazGraficaEstadoVenta() {
        return interfazGraficaEstadoVenta;
    }

    public void setInterfazGraficaEstadoVenta(InterfazGraficaFormularioEstadoVenta interfazGraficaEstadoVenta) {
        this.interfazGraficaEstadoVenta = interfazGraficaEstadoVenta;
    }

    public FormularioRegistrarVenta getFromularioRegistrarVenta() {
        return fromularioRegistrarVenta;
    }

    public void setFromularioRegistrarVenta(FormularioRegistrarVenta fromularioRegistrarVenta) {
        this.fromularioRegistrarVenta = fromularioRegistrarVenta;
    }

    public FormularioEditarVenta getFormularioEditarVenta() {
        return formularioEditarVenta;
    }

    public void setFormularioEditarVenta(FormularioEditarVenta formularioEditarVenta) {
        this.formularioEditarVenta = formularioEditarVenta;
    }

    public FormularioDetalleDeVenta getFormularioDetalleVenta() {
        return formularioDetalleVenta;
    }

    public void setFormularioDetalleVenta(FormularioDetalleDeVenta formularioDetalleVenta) {
        this.formularioDetalleVenta = formularioDetalleVenta;
    }
    
    


    public TablaVenta getTablaVenta() {
        return tablaVenta;
    }

    public void setTablaVenta(TablaVenta tablaVenta) {
        this.tablaVenta = tablaVenta;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipalTop = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaGrafica = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        lblIcono = new javax.swing.JLabel();
        lblNombreVentana = new javax.swing.JLabel();
        lblSalir = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnEditarVenta = new principal.MaterialButton();
        btnWeb = new principal.MaterialButton();
        btnNuevo = new principal.MaterialButton();
        radButonSoloPedidos = new javax.swing.JRadioButton();
        radButtonPendientes = new javax.swing.JRadioButton();
        bntEstado = new principal.MaterialButton();
        btnDetallesVenta = new principal.MaterialButton();

        panelPrincipalTop.setBackground(new java.awt.Color(204, 0, 0));
        panelPrincipalTop.setForeground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tablaGrafica.setBackground(new java.awt.Color(255, 255, 255));
        tablaGrafica.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        tablaGrafica.setForeground(new java.awt.Color(102, 0, 0));
        tablaGrafica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CLIENTE", "FECHA", "PRECIO TOTAL", "TIPO DE VENTA", "ESTADO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaGrafica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaGrafica.setDoubleBuffered(true);
        tablaGrafica.setRowHeight(40);
        tablaGrafica.setSelectionBackground(new java.awt.Color(153, 0, 0));
        tablaGrafica.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tablaGrafica.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaGrafica.setShowHorizontalLines(false);
        tablaGrafica.setShowVerticalLines(false);
        tablaGrafica.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaGrafica);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(0, 0, 0, 60));
        jPanel4.setForeground(new java.awt.Color(0, 0, 0));

        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/low_price_80px.png"))); // NOI18N

        lblNombreVentana.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNombreVentana.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreVentana.setText("VENTAS Y PEDIDOS");

        lblSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel_60px.png"))); // NOI18N
        lblSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSalirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIcono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombreVentana, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblNombreVentana, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblIcono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

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
        });

        btnEditarVenta.setBackground(new java.awt.Color(0,0,0,60));
        btnEditarVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarVenta.setText("EDITAR VENTA");
        btnEditarVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarVenta.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnEditarVenta.setMinimumSize(new java.awt.Dimension(0, 0));
        btnEditarVenta.setPreferredSize(new java.awt.Dimension(230, 35));
        btnEditarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarVentaActionPerformed(evt);
            }
        });

        btnWeb.setBackground(new java.awt.Color(0,0,0,60));
        btnWeb.setForeground(new java.awt.Color(255, 255, 255));
        btnWeb.setText("WEB AFIP");
        btnWeb.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnWeb.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnWeb.setMinimumSize(new java.awt.Dimension(0, 0));
        btnWeb.setPreferredSize(new java.awt.Dimension(230, 35));
        btnWeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWebActionPerformed(evt);
            }
        });

        btnNuevo.setBackground(new java.awt.Color(0,0,0,60));
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setText("NUEVO VENTA");
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnNuevo.setMinimumSize(new java.awt.Dimension(0, 0));
        btnNuevo.setPreferredSize(new java.awt.Dimension(230, 35));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        radButonSoloPedidos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        radButonSoloPedidos.setForeground(new java.awt.Color(255, 255, 255));
        radButonSoloPedidos.setText("SOLO PEDIDOS");
        radButonSoloPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radButonSoloPedidosActionPerformed(evt);
            }
        });

        radButtonPendientes.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        radButtonPendientes.setForeground(new java.awt.Color(255, 255, 255));
        radButtonPendientes.setText("PENDIENTES");
        radButtonPendientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radButtonPendientesActionPerformed(evt);
            }
        });

        bntEstado.setBackground(new java.awt.Color(0,0,0,60));
        bntEstado.setForeground(new java.awt.Color(255, 255, 255));
        bntEstado.setText("ELIMINAR/CAMBIAR ESTADO");
        bntEstado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bntEstado.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        bntEstado.setMinimumSize(new java.awt.Dimension(0, 0));
        bntEstado.setPreferredSize(new java.awt.Dimension(230, 35));
        bntEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntEstadoActionPerformed(evt);
            }
        });

        btnDetallesVenta.setBackground(new java.awt.Color(0,0,0,60));
        btnDetallesVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnDetallesVenta.setText("VER DEtALLES");
        btnDetallesVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDetallesVenta.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnDetallesVenta.setMinimumSize(new java.awt.Dimension(0, 0));
        btnDetallesVenta.setPreferredSize(new java.awt.Dimension(230, 35));
        btnDetallesVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetallesVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalTopLayout = new javax.swing.GroupLayout(panelPrincipalTop);
        panelPrincipalTop.setLayout(panelPrincipalTopLayout);
        panelPrincipalTopLayout.setHorizontalGroup(
            panelPrincipalTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelPrincipalTopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(btnWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(btnEditarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bntEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDetallesVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipalTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(radButonSoloPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(radButtonPendientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelPrincipalTopLayout.setVerticalGroup(
            panelPrincipalTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalTopLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelPrincipalTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalTopLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPrincipalTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bntEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDetallesVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelPrincipalTopLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(radButonSoloPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalTopLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radButtonPendientes, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipalTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipalTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        interfazGraficaRegistrar.setPrincipalVenta(this);
        interfazGraficaRegistrar.setPrincipalAdministrador(principalAdministrador);
        interfazGraficaRegistrar.nuevoFormularioRegistrar();

    }//GEN-LAST:event_btnNuevoActionPerformed


    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        tablaVenta.setPrincipalVenta(this);
        tablaVenta.ejecutarRellenarTabla();
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnEditarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarVentaActionPerformed
        tablaVenta.setPrincipalVenta(this);
        if (tablaVenta.verificarFilaSeleccionada()) {
            interfazGraficaEditar.setPrincipalVenta(this);
            interfazGraficaEditar.setPrincipalAdministrador(principalAdministrador);
            interfazGraficaEditar.setIdVenta(tablaVenta.obtenerIdFilaSeleccionada());
            interfazGraficaEditar.nuevoFormularioEditar();
        }
    }//GEN-LAST:event_btnEditarVentaActionPerformed

    private void btnWebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWebActionPerformed
        interfazGraficaWeb.setPrincipalAdministrador(principalAdministrador);
        interfazGraficaWeb.nuevaVentana();
    }//GEN-LAST:event_btnWebActionPerformed

    private void radButonSoloPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radButonSoloPedidosActionPerformed
        if (radButonSoloPedidos.isSelected()) {
            radButtonPendientes.setEnabled(true);
            radButtonPendientes.setForeground(new Color(255, 255, 255));
        } else {
            radButtonPendientes.setEnabled(false);
            radButtonPendientes.setSelected(false);
            radButtonPendientes.setForeground(new Color(102, 102, 102));
        }
        tablaVenta.ejecutarRellenarTabla();
    }//GEN-LAST:event_radButonSoloPedidosActionPerformed

    private void radButtonPendientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radButtonPendientesActionPerformed
        tablaVenta.ejecutarRellenarTabla();
    }//GEN-LAST:event_radButtonPendientesActionPerformed

    private void bntEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEstadoActionPerformed
 if (tablaVenta.verificarFilaSeleccionada()) {
     interfazGraficaEstadoVenta.setPrincipalVenta(this);
    interfazGraficaEstadoVenta.nuevoFormularioEstadoVenta();
 }

    }//GEN-LAST:event_bntEstadoActionPerformed

    private void btnDetallesVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetallesVentaActionPerformed
        tablaVenta.setPrincipalVenta(this);
        if (tablaVenta.verificarFilaSeleccionada()) {
            interfazGraficaDetalleVenta.setPrincipalVenta(this);
            interfazGraficaDetalleVenta.nuevoFormularioDetalleDeVenta();
        }
    }//GEN-LAST:event_btnDetallesVentaActionPerformed

    private void lblSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalirMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblSalirMouseClicked

    public JPanel getPanelPrincipalTop() {
        return panelPrincipalTop;
    }

    public void setPanelPrincipalTop(JPanel panelPrincipalTop) {
        this.panelPrincipalTop = panelPrincipalTop;
    }

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public void setTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
    }

    public JRadioButton getRadButonSoloPedidos() {
        return radButonSoloPedidos;
    }

    public void setRadButonSoloPedidos(JRadioButton radButonSoloPedidos) {
        this.radButonSoloPedidos = radButonSoloPedidos;
    }

    public JRadioButton getRadButtonPendientes() {
        return radButtonPendientes;
    }

    public void setRadButtonPendientes(JRadioButton radButtonPendientes) {
        this.radButtonPendientes = radButtonPendientes;
    }

    public JTable getTablaGrafica() {
        return tablaGrafica;
    }

    public void setTablaGrafica(JTable tablaGrafica) {
        this.tablaGrafica = tablaGrafica;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private principal.MaterialButton bntEstado;
    private principal.MaterialButton btnDetallesVenta;
    private principal.MaterialButton btnEditarVenta;
    private principal.MaterialButton btnNuevo;
    private principal.MaterialButton btnWeb;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblIcono;
    private javax.swing.JLabel lblNombreVentana;
    private javax.swing.JLabel lblSalir;
    private javax.swing.JPanel panelPrincipalTop;
    private javax.swing.JRadioButton radButonSoloPedidos;
    private javax.swing.JRadioButton radButtonPendientes;
    private javax.swing.JTable tablaGrafica;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
