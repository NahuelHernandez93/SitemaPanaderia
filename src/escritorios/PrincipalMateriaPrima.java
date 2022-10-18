package escritorios;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import clasesUtilidadGeneral.OperacionesUtiles;
import formularios.FormularioEditarMateriaPrima;
import formularios.FormularioRegistrarIngresoMateriaPrima;
import formularios.FormularioRegistrarMateriaPrima;
import operacionesIngresoMateriaPrima.ABMIngresoMateriaPrima;
import operacionesIngresoMateriaPrima.InterfazGraficaFormularioRegistrarIngresoMateriaPrima;
import operacionesMateriaPrima.ABMMateriaPrima;
import operacionesMateriaPrima.InterfazGraficaFormularioEditarMateriaPrima;
import operacionesMateriaPrima.InterfazGraficaFormularioRegistrarMateriaPrima;
import operacionesMateriaPrima.TablaMateriaPrima;
import principal.MaterialButton;
import sun.applet.Main;

public class PrincipalMateriaPrima extends javax.swing.JInternalFrame {

    public PrincipalMateriaPrima() {
        formularioRegistrarMateriaPrima = null;
        formularioEditarMateriaPrima = null;
        formularioRegistrarIngresoMateriaPrima=null;
        initComponents();
    }

    private InterfazGraficaFormularioRegistrarMateriaPrima InterfazGraficaRegistrar;
    private InterfazGraficaFormularioEditarMateriaPrima InterfazGraficaEditar;
    private FormularioRegistrarMateriaPrima formularioRegistrarMateriaPrima;
    private FormularioEditarMateriaPrima formularioEditarMateriaPrima;
    private TablaMateriaPrima tablaMateriaPrima;
    private  ABMMateriaPrima abm;

    private InterfazGraficaFormularioRegistrarIngresoMateriaPrima InterfazGraficaRegistrarIngreso;
    private FormularioRegistrarIngresoMateriaPrima formularioRegistrarIngresoMateriaPrima;
    private  ABMIngresoMateriaPrima abmIngreso;

    
    public InterfazGraficaFormularioRegistrarMateriaPrima getInterfazGraficaRegistrar() {
        return InterfazGraficaRegistrar;
    }

    public void setInterfazGraficaRegistrar(InterfazGraficaFormularioRegistrarMateriaPrima InterfazGraficaRegistrar) {
        this.InterfazGraficaRegistrar = InterfazGraficaRegistrar;
    }

    public InterfazGraficaFormularioEditarMateriaPrima getInterfazGraficaEditar() {
        return InterfazGraficaEditar;
    }

    public void setInterfazGraficaEditar(InterfazGraficaFormularioEditarMateriaPrima InterfazGraficaEditar) {
        this.InterfazGraficaEditar = InterfazGraficaEditar;
    }

    public InterfazGraficaFormularioRegistrarIngresoMateriaPrima getInterfazGraficaRegistrarIngreso() {
        return InterfazGraficaRegistrarIngreso;
    }

    public void setInterfazGraficaRegistrarIngreso(InterfazGraficaFormularioRegistrarIngresoMateriaPrima InterfazGraficaRegistrarIngreso) {
        this.InterfazGraficaRegistrarIngreso = InterfazGraficaRegistrarIngreso;
    }

    public ABMMateriaPrima getAbm() {
        return abm;
    }

    public void setAbm(ABMMateriaPrima abm) {
        this.abm = abm;
    }

    public ABMIngresoMateriaPrima getAbmIngreso() {
        return abmIngreso;
    }

    public void setAbmIngreso(ABMIngresoMateriaPrima abmIngreso) {
        this.abmIngreso = abmIngreso;
    }

    public FormularioRegistrarMateriaPrima getFormularioRegistrarMateriaPrima() {
        return formularioRegistrarMateriaPrima;
    }

    public void setFormularioRegistrarMateriaPrima(FormularioRegistrarMateriaPrima formularioRegistrarMateriaPrima) {
        this.formularioRegistrarMateriaPrima = formularioRegistrarMateriaPrima;
    }

    public FormularioEditarMateriaPrima getFormularioEditarMateriaPrima() {
        return formularioEditarMateriaPrima;
    }

    public void setFormularioEditarMateriaPrima(FormularioEditarMateriaPrima formularioEditarMateriaPrima) {
        this.formularioEditarMateriaPrima = formularioEditarMateriaPrima;
    }

    public FormularioRegistrarIngresoMateriaPrima getFormularioRegistrarIngresoMateriaPrima() {
        return formularioRegistrarIngresoMateriaPrima;
    }

    public void setFormularioRegistrarIngresoMateriaPrima(FormularioRegistrarIngresoMateriaPrima formularioRegistrarIngresoMateriaPrima) {
        this.formularioRegistrarIngresoMateriaPrima = formularioRegistrarIngresoMateriaPrima;
    }




    public TablaMateriaPrima getTablaMateriaPrima() {
        return tablaMateriaPrima;
    }

    public void setTablaMateriaPrima(TablaMateriaPrima tablaMateriaPrima) {
        this.tablaMateriaPrima = tablaMateriaPrima;
    }

    public JTable getTabla() {
        return tablaGrafica;
    }

    public void setTabla(JTable tabla) {
        this.tablaGrafica = tabla;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popMenu = new javax.swing.JPopupMenu();
        panelPrincipalTop = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaGrafica = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        lblIcono = new javax.swing.JLabel();
        lblNombreVentana = new javax.swing.JLabel();
        lblSalir = new javax.swing.JLabel();
        btnNuevo = new principal.MaterialButton();
        txtBuscar = new javax.swing.JTextField();
        btnEliminar = new principal.MaterialButton();
        btnEditar = new principal.MaterialButton();
        btnNuevoIngreso = new principal.MaterialButton();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        lbltrigo1 = new javax.swing.JLabel();
        buttonSalir1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        nuevo1 = new principal.MaterialButton();
        txtBuscar1 = new javax.swing.JTextField();
        boxEntidad1 = new javax.swing.JComboBox<>();

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
                "MATERIA PRIMA", "PROVEEDOR", "MARCA", "UNIDAD DE MEDIDA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaGrafica.setComponentPopupMenu(popMenu);
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(0, 0, 0, 60));
        jPanel4.setForeground(new java.awt.Color(0, 0, 0));

        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/trigo.png"))); // NOI18N

        lblNombreVentana.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNombreVentana.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreVentana.setText("GESTIÓN DE MATERIA PRIMA");

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
                .addComponent(lblNombreVentana, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(lblIcono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addComponent(lblNombreVentana, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap()))))
        );

        btnNuevo.setBackground(new java.awt.Color(0,0,0,60));
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setText("Nuevo Materia Prima");
        btnNuevo.setAlignmentY(0.0F);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.setFont(btnNuevo.getFont().deriveFont(btnNuevo.getFont().getStyle() | java.awt.Font.BOLD));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

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

        btnEliminar.setBackground(new java.awt.Color(0,0,0,60));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setFont(btnEliminar.getFont().deriveFont(btnEliminar.getFont().getStyle() | java.awt.Font.BOLD));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(0,0,0,60));
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("EDITAR");
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.setFont(btnEditar.getFont().deriveFont(btnEditar.getFont().getStyle() | java.awt.Font.BOLD));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnNuevoIngreso.setBackground(new java.awt.Color(0,0,0,60));
        btnNuevoIngreso.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoIngreso.setText("NUEVO INGRESO");
        btnNuevoIngreso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoIngreso.setFont(btnNuevoIngreso.getFont().deriveFont(btnNuevoIngreso.getFont().getStyle() | java.awt.Font.BOLD));
        btnNuevoIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoIngresoActionPerformed(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNuevoIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelPrincipalTopLayout.setVerticalGroup(
            panelPrincipalTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalTopLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipalTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevoIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtBuscar.getAccessibleContext().setAccessibleName("");
        txtBuscar.getAccessibleContext().setAccessibleDescription("");

        jPanel2.setBackground(new java.awt.Color(204, 0, 0));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(204, 0, 0));

        tabla1.setBackground(new java.awt.Color(255, 255, 255));
        tabla1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        tabla1.setForeground(new java.awt.Color(102, 0, 0));
        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MATERIA PRIMA", "PROVEEDOR", "MARCA", "UNIDAD DE MEDIDA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla1.setComponentPopupMenu(popMenu);
        tabla1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabla1.setDoubleBuffered(true);
        tabla1.setRowHeight(40);
        tabla1.setSelectionBackground(new java.awt.Color(153, 0, 0));
        tabla1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tabla1.setShowHorizontalLines(false);
        tabla1.setShowVerticalLines(false);
        tabla1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabla1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(0, 0, 0, 60));
        jPanel6.setForeground(new java.awt.Color(0, 0, 0));

        lbltrigo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/trigo.png"))); // NOI18N

        buttonSalir1.setBackground(new java.awt.Color(153, 0, 0));
        buttonSalir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancel_60px.png"))); // NOI18N
        buttonSalir1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102), 2));
        buttonSalir1.setBorderPainted(false);
        buttonSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalir1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("GESTIÓN DE MATERIA PRIMA");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbltrigo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonSalir1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(buttonSalir1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbltrigo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        nuevo1.setBackground(new java.awt.Color(0,0,0,60));
        nuevo1.setForeground(new java.awt.Color(255, 255, 255));
        nuevo1.setText("Nuevo Materia Prima");
        nuevo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nuevo1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        nuevo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevo1ActionPerformed(evt);
            }
        });

        txtBuscar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.lightGray));
        txtBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscar1ActionPerformed(evt);
            }
        });
        txtBuscar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscar1KeyReleased(evt);
            }
        });

        boxEntidad1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        boxEntidad1.setForeground(new java.awt.Color(255, 255, 255));
        boxEntidad1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MateriaPrima", "Proveedor" }));
        boxEntidad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxEntidad1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nuevo1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boxEntidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(boxEntidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nuevo1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipalTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 696, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 696, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipalTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public void setTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
    }


    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        InterfazGraficaRegistrar.setPrincipalMateriaPrima(this);
        InterfazGraficaRegistrar.nuevoFormularioRegistrar();
    }//GEN-LAST:event_btnNuevoActionPerformed


    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed

    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        tablaMateriaPrima.setPrincipalMateriaPrima(this);
        tablaMateriaPrima.ejecutarRellenarTabla();
        
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void buttonSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalir1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonSalir1ActionPerformed

    private void nuevo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nuevo1ActionPerformed

    private void txtBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscar1ActionPerformed

    private void txtBuscar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscar1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscar1KeyReleased

    private void boxEntidad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxEntidad1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxEntidad1ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        abm.setPrincipalMateriaPrima(this);
        tablaMateriaPrima.setPrincipalMateriaPrima(this);
        if (tablaMateriaPrima.verificarFilaSeleccionada()) {
            if (OperacionesUtiles.mensajeEliminarRegistro()) {
                if (abm.ejecutarEliminar()) {
                    tablaMateriaPrima.setEstadoConsulta(0);
                    tablaMateriaPrima.ejecutarRellenarTabla();
                }
            }

        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        tablaMateriaPrima.setPrincipalMateriaPrima(this);
        if (tablaMateriaPrima.verificarFilaSeleccionada()) {
            InterfazGraficaEditar.setPrincipalMateriaPrima(this);
            InterfazGraficaEditar.nuevoFormularioEditar();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnNuevoIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoIngresoActionPerformed
        if (tablaMateriaPrima.verificarFilaSeleccionada()) {
            InterfazGraficaRegistrarIngreso.setPrincipalMateriaPrima(this);
            InterfazGraficaRegistrarIngreso.nuevoFormularioRegistrar();
        }

    }//GEN-LAST:event_btnNuevoIngresoActionPerformed

    private void lblSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalirMouseClicked
        this.dispose();
    }//GEN-LAST:event_lblSalirMouseClicked

    public MaterialButton getBtnEditar() {
        return btnEditar;
    }

    public JPanel getPanelPrincipalTop() {
        return panelPrincipalTop;
    }

    public void setPanelPrincipalTop(JPanel panelPrincipalTop) {
        this.panelPrincipalTop = panelPrincipalTop;
    }

    public JTable getTablaGrafica() {
        return tablaGrafica;
    }

    public void setTablaGrafica(JTable tablaGrafica) {
        this.tablaGrafica = tablaGrafica;
    }

    public void setBtnEditar(MaterialButton btnEditar) {
        this.btnEditar = btnEditar;
    }

    public MaterialButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(MaterialButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public MaterialButton getBtnNuevoIngreso() {
        return btnNuevoIngreso;
    }

    public void setBtnNuevoIngreso(MaterialButton btnNuevoIngreso) {
        this.btnNuevoIngreso = btnNuevoIngreso;
    }

    public MaterialButton getBtnNuevo() {
        return btnNuevo;
    }

    public void setBtnNuevo(MaterialButton btnNuevo) {
        this.btnNuevo = btnNuevo;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxEntidad1;
    private principal.MaterialButton btnEditar;
    private principal.MaterialButton btnEliminar;
    private principal.MaterialButton btnNuevo;
    private principal.MaterialButton btnNuevoIngreso;
    private javax.swing.JButton buttonSalir1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JLabel lblIcono;
    private javax.swing.JLabel lblNombreVentana;
    private javax.swing.JLabel lblSalir;
    public static javax.swing.JLabel lbltrigo1;
    private principal.MaterialButton nuevo1;
    private javax.swing.JPanel panelPrincipalTop;
    private javax.swing.JPopupMenu popMenu;
    public static javax.swing.JTable tabla1;
    private javax.swing.JTable tablaGrafica;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtBuscar1;
    // End of variables declaration//GEN-END:variables

}
