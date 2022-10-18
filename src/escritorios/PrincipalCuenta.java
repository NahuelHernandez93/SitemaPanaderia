package escritorios;

import clasesUtilidadGeneral.ColorFila;
import clasesUtilidadGeneral.OperacionesUtiles;
import ds.desktop.notify.DesktopNotify;
import formularios.FormularioEditarMovimientoCuenta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import operacionesCuenta.ABMCuenta;
import operacionesCuenta.ABMMovimientoCuenta;
import operacionesCuenta.InterfazGraficaEditarMovimiento;
import operacionesCuenta.InterfazGraficaEscritorioCuenta;
import operacionesCuenta.InterfazGraficaReporteMovimientos;
import operacionesCuenta.TablaCuenta;
import operacionesCuenta.TablaMovimientoCuenta;
import principal.MaterialButton;

/**
 *
 * @author TELCOM MPC
 */
public class PrincipalCuenta extends javax.swing.JInternalFrame {

    public PrincipalCuenta() {
        initComponents();
        formularioEditarMovimiento = null;
        formularioEditarMovimiento = null;
    }

    private TablaCuenta tablaCuenta;
    private TablaMovimientoCuenta tablaMovimientoCuenta;
    private Integer idCliente;
    private final ABMCuenta abm = new ABMCuenta();
    private final ABMMovimientoCuenta abmMovimiento = new ABMMovimientoCuenta();
    private FormularioEditarMovimientoCuenta formularioEditarMovimiento;
    private InterfazGraficaEditarMovimiento InterfazGraficaEditarMovimiento;
    private Integer cuantaFilaSeleccionada;





    
    public Integer getCuantaFilaSeleccionada() {
        return cuantaFilaSeleccionada;
    }

    public void setCuantaFilaSeleccionada(Integer cuantaFilaSeleccionada) {
        this.cuantaFilaSeleccionada = cuantaFilaSeleccionada;
    }

    public JLabel getLblNombre() {
        return lblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    public JTable getTablaGraficaCuenta() {
        return tablaGraficaCuenta;
    }

    public InterfazGraficaEditarMovimiento getInterfazGraficaEditarMovimiento() {
        return InterfazGraficaEditarMovimiento;
    }

    public void setInterfazGraficaEditarMovimiento(InterfazGraficaEditarMovimiento InterfazGraficaEditarMovimiento) {
        this.InterfazGraficaEditarMovimiento = InterfazGraficaEditarMovimiento;
    }


    public void setTablaGraficaCuenta(JTable tablaGraficaCuenta) {
        this.tablaGraficaCuenta = tablaGraficaCuenta;
    }

    public JTable getTablaGraficaMovimiento() {
        return tablaGraficaMovimiento;
    }

    public void setTablaGraficaMovimiento(JTable tablaGraficaMovimiento) {
        this.tablaGraficaMovimiento = tablaGraficaMovimiento;
    }

    public TablaCuenta getTablaCuenta() {
        return tablaCuenta;
    }

    public void setTablaCuenta(TablaCuenta tablaCuenta) {
        this.tablaCuenta = tablaCuenta;
    }

    public TablaMovimientoCuenta getTablaMovimientoCuenta() {
        return tablaMovimientoCuenta;
    }

    public void setTablaMovimientoCuenta(TablaMovimientoCuenta tablaMovimientoCuenta) {
        this.tablaMovimientoCuenta = tablaMovimientoCuenta;
    }

    public JPanel getPanelPrincipalTop() {
        return panelPrincipalTop;
    }

    public void setPanelPrincipalTop(JPanel panelPrincipalTop) {
        this.panelPrincipalTop = panelPrincipalTop;
    }

    public FormularioEditarMovimientoCuenta getFormularioEditarMovimiento() {
        return formularioEditarMovimiento;
    }

    public void setFormularioEditarMovimiento(FormularioEditarMovimientoCuenta formularioEditarMovimiento) {
        this.formularioEditarMovimiento = formularioEditarMovimiento;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public List getListaCamposCuenta() {
        List listCamposTexto = new ArrayList();
        listCamposTexto.add(this.getTxtMontoInicial());
        return listCamposTexto;
    }

    public List getListaCamposMovimientoCuenta() {
        List listCamposTexto = new ArrayList();
        listCamposTexto.add(this.getTxtMonto());
        return listCamposTexto;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipalTop = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaGraficaMovimiento = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        editPaneMotivo = new javax.swing.JEditorPane();
        btnGuardarMovimiento = new principal.MaterialButton();
        btnNuevaCuenta = new principal.MaterialButton();
        jSeparator3 = new javax.swing.JSeparator();
        txtMonto = new javax.swing.JTextField();
        btnGuardarCuenta = new principal.MaterialButton();
        btnNuevoMovimiento = new principal.MaterialButton();
        txtMontoInicial = new javax.swing.JTextField();
        btnnEditarMov = new principal.MaterialButton();
        btnEliminarMov = new principal.MaterialButton();
        btnReporteMovimientos = new principal.MaterialButton();
        btnNuevaCuenta3 = new principal.MaterialButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaGraficaCuenta = new javax.swing.JTable();
        lblNombreVentana = new javax.swing.JPanel();
        lblIcono = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblSalir = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblCliente = new javax.swing.JLabel();

        panelPrincipalTop.setBackground(new java.awt.Color(204, 0, 0));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tablaGraficaMovimiento.setBackground(new java.awt.Color(255, 255, 255));
        tablaGraficaMovimiento.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        tablaGraficaMovimiento.setForeground(new java.awt.Color(102, 0, 0));
        tablaGraficaMovimiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MOTIVO", "MONTO", "BALANCE", "FECHA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaGraficaMovimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaGraficaMovimiento.setDoubleBuffered(true);
        tablaGraficaMovimiento.setRowHeight(40);
        tablaGraficaMovimiento.setSelectionBackground(new java.awt.Color(102, 0, 0));
        tablaGraficaMovimiento.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tablaGraficaMovimiento.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaGraficaMovimiento.getTableHeader().setReorderingAllowed(false);
        tablaGraficaMovimiento.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                tablaGraficaMovimientoGraficaMovimientoComponentHidden(evt);
            }
        });
        jScrollPane1.setViewportView(tablaGraficaMovimiento);
        if (tablaGraficaMovimiento.getColumnModel().getColumnCount() > 0) {
            tablaGraficaMovimiento.getColumnModel().getColumn(2).setHeaderValue("BALANCE");
            tablaGraficaMovimiento.getColumnModel().getColumn(3).setHeaderValue("FECHA");
        }

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

        editPaneMotivo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)));
        editPaneMotivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                editPaneMotivoKeyReleased(evt);
            }
        });

        btnGuardarMovimiento.setBackground(new java.awt.Color(0, 0, 0,60));
        btnGuardarMovimiento.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarMovimiento.setText("GUARDAR MOVIMIENTO");
        btnGuardarMovimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarMovimiento.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnGuardarMovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarMovimientoActionPerformed(evt);
            }
        });

        btnNuevaCuenta.setBackground(new java.awt.Color(0, 0, 0,60));
        btnNuevaCuenta.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevaCuenta.setText("NUEVA CUENTA");
        btnNuevaCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevaCuenta.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnNuevaCuenta.setMaximumSize(new java.awt.Dimension(130, 35));
        btnNuevaCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaCuentaActionPerformed(evt);
            }
        });

        txtMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoActionPerformed(evt);
            }
        });

        btnGuardarCuenta.setBackground(new java.awt.Color(0, 0, 0,60));
        btnGuardarCuenta.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarCuenta.setText("GUARDAR CUENTA");
        btnGuardarCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarCuenta.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnGuardarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCuentaActionPerformed(evt);
            }
        });

        btnNuevoMovimiento.setBackground(new java.awt.Color(0, 0, 0,60));
        btnNuevoMovimiento.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoMovimiento.setText("NUEVO MOVIMIENTO");
        btnNuevoMovimiento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoMovimiento.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnNuevoMovimiento.setMaximumSize(new java.awt.Dimension(130, 35));
        btnNuevoMovimiento.setMinimumSize(new java.awt.Dimension(130, 35));
        btnNuevoMovimiento.setPreferredSize(new java.awt.Dimension(130, 35));
        btnNuevoMovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoMovimientoActionPerformed(evt);
            }
        });

        txtMontoInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoInicialActionPerformed(evt);
            }
        });
        txtMontoInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoInicialKeyTyped(evt);
            }
        });

        btnnEditarMov.setBackground(new java.awt.Color(0, 0, 0,60));
        btnnEditarMov.setForeground(new java.awt.Color(255, 255, 255));
        btnnEditarMov.setText("EDITAR MOVIMIENTO");
        btnnEditarMov.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnnEditarMov.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnnEditarMov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnEditarMovActionPerformed(evt);
            }
        });

        btnEliminarMov.setBackground(new java.awt.Color(0, 0, 0,60));
        btnEliminarMov.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarMov.setText("ELIMINAR MOVIMIENTO");
        btnEliminarMov.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarMov.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnEliminarMov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarMovActionPerformed(evt);
            }
        });

        btnReporteMovimientos.setBackground(new java.awt.Color(0, 0, 0,60));
        btnReporteMovimientos.setForeground(new java.awt.Color(255, 255, 255));
        btnReporteMovimientos.setText("GENERAR REPORTE");
        btnReporteMovimientos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReporteMovimientos.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnReporteMovimientos.setMaximumSize(new java.awt.Dimension(130, 35));
        btnReporteMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteMovimientosActionPerformed(evt);
            }
        });

        btnNuevaCuenta3.setBackground(new java.awt.Color(0, 0, 0,60));
        btnNuevaCuenta3.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevaCuenta3.setText("ELIMINAR CUENTA");
        btnNuevaCuenta3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevaCuenta3.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnNuevaCuenta3.setMaximumSize(new java.awt.Dimension(130, 35));
        btnNuevaCuenta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaCuenta3ActionPerformed(evt);
            }
        });

        tablaGraficaCuenta.setBackground(new java.awt.Color(255, 255, 255));
        tablaGraficaCuenta.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        tablaGraficaCuenta.setForeground(new java.awt.Color(102, 0, 0));
        tablaGraficaCuenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° CUENTA", "BALANCE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaGraficaCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaGraficaCuenta.setDoubleBuffered(true);
        tablaGraficaCuenta.setRowHeight(40);
        tablaGraficaCuenta.setSelectionBackground(new java.awt.Color(102, 0, 0));
        tablaGraficaCuenta.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tablaGraficaCuenta.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaGraficaCuenta.getTableHeader().setReorderingAllowed(false);
        tablaGraficaCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaGraficaCuentaMousePressed(evt);
            }
        });
        tablaGraficaCuenta.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                tablaGraficaCuentaGraficaMovimientoComponentHidden(evt);
            }
        });
        jScrollPane3.setViewportView(tablaGraficaCuenta);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNuevoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnGuardarMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(editPaneMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(btnNuevaCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtMontoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnGuardarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnNuevaCuenta3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 712, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnnEditarMov, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarMov, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnReporteMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNuevaCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMontoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuardarCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addComponent(btnNuevaCuenta3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btnNuevoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editPaneMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminarMov, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnnEditarMov, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReporteMovimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
        );

        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/accounting_80px.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CUENTA CLIENTE");

        lblSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel_60px.png"))); // NOI18N
        lblSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSalirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout lblNombreVentanaLayout = new javax.swing.GroupLayout(lblNombreVentana);
        lblNombreVentana.setLayout(lblNombreVentanaLayout);
        lblNombreVentanaLayout.setHorizontalGroup(
            lblNombreVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lblNombreVentanaLayout.createSequentialGroup()
                .addComponent(lblIcono, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        lblNombreVentanaLayout.setVerticalGroup(
            lblNombreVentanaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblNombreVentanaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIcono, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
            .addGroup(lblNombreVentanaLayout.createSequentialGroup()
                .addComponent(lblSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lblNombreVentanaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        lblNombre.setBackground(new java.awt.Color(255, 255, 255));
        lblNombre.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));

        lblCliente.setBackground(new java.awt.Color(255, 255, 255));
        lblCliente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCliente.setForeground(new java.awt.Color(255, 255, 255));
        lblCliente.setText("CLIENTE:");

        javax.swing.GroupLayout panelPrincipalTopLayout = new javax.swing.GroupLayout(panelPrincipalTop);
        panelPrincipalTop.setLayout(panelPrincipalTopLayout);
        panelPrincipalTopLayout.setHorizontalGroup(
            panelPrincipalTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNombreVentana, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalTopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPrincipalTopLayout.setVerticalGroup(
            panelPrincipalTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalTopLayout.createSequentialGroup()
                .addComponent(lblNombreVentana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPrincipalTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 734, Short.MAX_VALUE))
        );

        lblNombreVentana.setBackground(new java.awt.Color(0, 0, 0, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipalTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipalTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaGraficaMovimientoGraficaMovimientoComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tablaGraficaMovimientoGraficaMovimientoComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaGraficaMovimientoGraficaMovimientoComponentHidden

    private void btnNuevaCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaCuentaActionPerformed
        new InterfazGraficaEscritorioCuenta().habilitarNuevaCuenta(this);
    }//GEN-LAST:event_btnNuevaCuentaActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        tablaMovimientoCuenta.setPrincipalCuenta(this);
        tablaMovimientoCuenta.ejecutarRellenarTabla();
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        // TODO add your handling code here:


    }//GEN-LAST:event_txtBuscarKeyTyped

    private void btnGuardarMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarMovimientoActionPerformed
        if (tablaCuenta.verificarFilaSeleccionada()) {
            this.setCuantaFilaSeleccionada(tablaCuenta.filaSeleccionada());
            abmMovimiento.setPrincipalCuenta(this);
            if (abmMovimiento.ejecutarRegistrar()) {
                tablaCuenta.setEstadoConsulta(0);
                tablaCuenta.ejecutarRellenarTabla();
                tablaMovimientoCuenta.setEstadoConsulta(0);
                tablaMovimientoCuenta.ejecutarRellenarTabla();
                new InterfazGraficaEscritorioCuenta().desHabilitarNuevoMovimientoCuenta(this);
                Integer fila = this.getCuantaFilaSeleccionada();
                this.tablaGraficaCuenta.changeSelection(fila, 0, closable, isIcon);
            }
        }

    }//GEN-LAST:event_btnGuardarMovimientoActionPerformed

    private void btnGuardarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCuentaActionPerformed
        abm.setPrincipalCuenta(this);
        if (abm.ejecutarRegistrar()) {
            tablaCuenta.setEstadoConsulta(0);
            tablaCuenta.ejecutarRellenarTabla();
            new InterfazGraficaEscritorioCuenta().desHabilitarNuevaCuenta(this);
        }
    }//GEN-LAST:event_btnGuardarCuentaActionPerformed

    private void btnNuevoMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoMovimientoActionPerformed
        new InterfazGraficaEscritorioCuenta().habilitarNuevoMovimientoCuenta(this);
    }//GEN-LAST:event_btnNuevoMovimientoActionPerformed

    private void txtMontoInicialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoInicialKeyTyped

    }//GEN-LAST:event_txtMontoInicialKeyTyped

    private void btnnEditarMovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnEditarMovActionPerformed

        if (tablaCuenta.verificarFilaSeleccionada()) {
            this.setCuantaFilaSeleccionada(tablaCuenta.filaSeleccionada());
            tablaMovimientoCuenta.setPrincipalCuenta(this);
            if (tablaMovimientoCuenta.verificarFilaSeleccionada()) {
                InterfazGraficaEditarMovimiento.setPrincipalCuenta(this);
                InterfazGraficaEditarMovimiento.nuevoFormularioEditar();
            }
        }
    }//GEN-LAST:event_btnnEditarMovActionPerformed

    private void btnEliminarMovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMovActionPerformed

        if (tablaCuenta.verificarFilaSeleccionada()) {
            this.setCuantaFilaSeleccionada(tablaCuenta.filaSeleccionada());
            if (tablaMovimientoCuenta.verificarFilaSeleccionada()) {
                if (tablaMovimientoCuenta.verificarNoMontoInicial()) {
                    if (OperacionesUtiles.mensajeEliminarRegistro()) {
                        abmMovimiento.setPrincipalCuenta(this);
                        if (abmMovimiento.ejecutarEliminar()) {
                            abmMovimiento.ejecutarActualizarMovimientoCuenta();
                            tablaMovimientoCuenta.setEstadoConsulta(0);
                            tablaMovimientoCuenta.ejecutarRellenarTabla();
                            tablaCuenta.setEstadoConsulta(0);
                            tablaCuenta.ejecutarRellenarTabla();
                            Integer fila = this.getCuantaFilaSeleccionada();
                            this.tablaGraficaCuenta.changeSelection(fila, 0, closable, isIcon);
                        }
                    }
                }
            }

        }
    }//GEN-LAST:event_btnEliminarMovActionPerformed

    private void txtMontoInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoInicialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoInicialActionPerformed

    private void txtMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoActionPerformed

    private void lblSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalirMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblSalirMouseClicked

    private void btnReporteMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteMovimientosActionPerformed
        if (tablaCuenta.verificarFilaSeleccionada()) {
            InterfazGraficaReporteMovimientos i = new InterfazGraficaReporteMovimientos();
            i.setPrincipalCuenta(this);
            i.nuevoFormularioReporte();
            
        }

    }//GEN-LAST:event_btnReporteMovimientosActionPerformed

    private void btnNuevaCuenta3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaCuenta3ActionPerformed
        abm.setPrincipalCuenta(this);
        if (tablaCuenta.verificarFilaSeleccionada()) {
            if (OperacionesUtiles.mensajeEliminarRegistro()) {
                if (abm.ejecutarEliminar()) {
                    tablaCuenta.setEstadoConsulta(0);
                    tablaCuenta.ejecutarRellenarTabla();
                }
            }
        }

    }//GEN-LAST:event_btnNuevaCuenta3ActionPerformed

    
    
    
    private void editPaneMotivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editPaneMotivoKeyReleased

        if (this.getEditPaneMotivo().getText().toString().equals("Monto Inicial")) {
            this.getEditPaneMotivo().setText("");
            DesktopNotify.showDesktopMessage("Informacion", "'Monto Inicial' no es un motivo valido", DesktopNotify.INFORMATION, 7000);
        }
    }//GEN-LAST:event_editPaneMotivoKeyReleased

    private void tablaGraficaCuentaGraficaMovimientoComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tablaGraficaCuentaGraficaMovimientoComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaGraficaCuentaGraficaMovimientoComponentHidden

    private void tablaGraficaCuentaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaGraficaCuentaMousePressed
          tablaMovimientoCuenta.setIdCuenta(tablaCuenta.obtenerIdFilaSeleccionada());
        tablaMovimientoCuenta.ejecutarRellenarTabla();
        tablaMovimientoCuenta.setEstadoConsulta(0);
        //cambiar color a fila
        ColorFila colorFila = new ColorFila(this.getPanelPrincipalTop().getBackground());
        getTablaGraficaMovimiento().setDefaultRenderer(Object.class, colorFila);
    }//GEN-LAST:event_tablaGraficaCuentaMousePressed

    public JPanel getPanel_1_primario() {
        return panelPrincipalTop;
    }

    public void setPanel_1_primario(JPanel panel_1_primario) {
        this.panelPrincipalTop = panel_1_primario;
    }

    public MaterialButton getBtnGuardarCuenta() {
        return btnGuardarCuenta;
    }

    public void setBtnGuardarCuenta(MaterialButton btnGuardarCuenta) {
        this.btnGuardarCuenta = btnGuardarCuenta;
    }

    public JTextField getTxtMontoInicial() {
        return txtMontoInicial;
    }

    public void setTxtMontoInicial(JTextField txtMontoInicial) {
        this.txtMontoInicial = txtMontoInicial;
    }

    public JEditorPane getEditPaneMotivo() {
        return editPaneMotivo;
    }

    public void setEditPaneMotivo(JEditorPane editPaneMotivo) {
        this.editPaneMotivo = editPaneMotivo;
    }

    public JTextField getTxtMonto() {
        return txtMonto;
    }

    public void setTxtMonto(JTextField txtMonto) {
        this.txtMonto = txtMonto;
    }

    public MaterialButton getBtnGuardarMovimiento() {
        return btnGuardarMovimiento;
    }

    public void setBtnGuardarMovimiento(MaterialButton btnGuardarMovimiento) {
        this.btnGuardarMovimiento = btnGuardarMovimiento;
    }

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public void setTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
    }

    public MaterialButton getBtnEliminarMov() {
        return btnEliminarMov;
    }

    public void setBtnEliminarMov(MaterialButton btnEliminarMov) {
        this.btnEliminarMov = btnEliminarMov;
    }

    public MaterialButton getBtnNuevaCuenta() {
        return btnNuevaCuenta;
    }

    public void setBtnNuevaCuenta(MaterialButton btnNuevaCuenta) {
        this.btnNuevaCuenta = btnNuevaCuenta;
    }

    public MaterialButton getBtnNuevoMovimiento() {
        return btnNuevoMovimiento;
    }

    public void setBtnNuevoMovimiento(MaterialButton btnNuevoMovimiento) {
        this.btnNuevoMovimiento = btnNuevoMovimiento;
    }

    public MaterialButton getBtnnEditarMov() {
        return btnnEditarMov;
    }

    public void setBtnnEditarMov(MaterialButton btnnEditarMov) {
        this.btnnEditarMov = btnnEditarMov;
    }

//

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private principal.MaterialButton btnEliminarMov;
    private principal.MaterialButton btnGuardarCuenta;
    private principal.MaterialButton btnGuardarMovimiento;
    private principal.MaterialButton btnNuevaCuenta;
    private principal.MaterialButton btnNuevaCuenta3;
    private principal.MaterialButton btnNuevoMovimiento;
    private principal.MaterialButton btnReporteMovimientos;
    private principal.MaterialButton btnnEditarMov;
    private javax.swing.JEditorPane editPaneMotivo;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblIcono;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JPanel lblNombreVentana;
    private javax.swing.JLabel lblSalir;
    private javax.swing.JPanel panelPrincipalTop;
    private javax.swing.JTable tablaGraficaCuenta;
    private javax.swing.JTable tablaGraficaMovimiento;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtMontoInicial;
    // End of variables declaration//GEN-END:variables
}
