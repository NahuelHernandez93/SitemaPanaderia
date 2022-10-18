package formularios;

import clasesUtilidadGeneral.OperacionesUtiles;
import com.itextpdf.text.DocumentException;
import escritorios.PrincipalCliente;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import escritorios.PrincipalVenta;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import operacionesCaja.OperacionesEditarCorte;
import operacionesCliente.InterfazGraficaEscritorioCliente;
import operacionesVenta.ABMVenta;
import operacionesVenta.ComprobanteVenta;
import operacionesVenta.OperacionesSecundariasVenta;
import operacionesVenta.TablaClienteLista;
import operacionesVenta.TablaCuenta;
import operacionesVenta.TablaProductosListados;
import operacionesVenta.TablaProductosDisponibles;
import principal.MaterialButton;
import principal.PrincipalAdministrador;
import rojeru_san.componentes.RSDateChooser;

public class FormularioRegistrarVenta extends javax.swing.JDialog {

    /**
     * Creates new form FormularioRegistrarVenta
     */
    public FormularioRegistrarVenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private final ABMVenta abm = new ABMVenta();
    private PrincipalVenta principalVenta;
    private TablaProductosDisponibles tablaProductosDisponibles;
    private TablaProductosListados tablaProductosListados;
    private OperacionesSecundariasVenta operacionesSecundariasVenta;
    private TablaClienteLista tablaClienteLista;
    private TablaCuenta tablaCuenta;
    private ComprobanteVenta comprobante;

    private PrincipalAdministrador principalAdministrador;
    private PrincipalCliente principalCliente;
    private Integer IdCliente;
    private Integer IdCuenta;

    public PrincipalCliente getPrincipalCliente() {
        return principalCliente;
    }

    public void setPrincipalCliente(PrincipalCliente principalCliente) {
        this.principalCliente = principalCliente;
    }

    public TablaCuenta getTablaCuenta() {
        return tablaCuenta;
    }

    public void setTablaCuenta(TablaCuenta tablaCuenta) {
        this.tablaCuenta = tablaCuenta;
    }

    public ComprobanteVenta getComprobante() {
        return comprobante;
    }

    public void setComprobante(ComprobanteVenta comprobante) {
        this.comprobante = comprobante;
    }

    public TablaClienteLista getTablaClienteLista() {
        return tablaClienteLista;
    }

    public void setTablaClienteLista(TablaClienteLista tablaClienteLista) {
        this.tablaClienteLista = tablaClienteLista;
    }

    public PrincipalAdministrador getPrincipalAdministrador() {
        return principalAdministrador;
    }

    public void setPrincipalAdministrador(PrincipalAdministrador principalAdministrador) {
        this.principalAdministrador = principalAdministrador;
    }

    public OperacionesSecundariasVenta getOperacionesSecundariasVenta() {
        return operacionesSecundariasVenta;
    }

    public void setOperacionesSecundariasVenta(OperacionesSecundariasVenta operacionesSecundariasVenta) {
        this.operacionesSecundariasVenta = operacionesSecundariasVenta;
    }

    public TablaProductosDisponibles getTablaProductosDisponibles() {
        return tablaProductosDisponibles;
    }

    public void setTablaProductosDisponibles(TablaProductosDisponibles tablaProductosDisponibles) {
        this.tablaProductosDisponibles = tablaProductosDisponibles;
    }

    public TablaProductosListados getTablaProductosListados() {
        return tablaProductosListados;
    }

    public void setTablaProductosListados(TablaProductosListados tablaProductosListados) {
        this.tablaProductosListados = tablaProductosListados;
    }

    public JComboBox<String> getBoxTipoVenta() {
        return boxTipoVenta;
    }

    public void setBoxTipoVenta(JComboBox<String> boxTipoVenta) {
        this.boxTipoVenta = boxTipoVenta;
    }

    public JTable getTablaGraficaProductosDisponibles() {
        return tablaGraficaProductosDisponibles;
    }

    public void setTablaGraficaProductosDisponibles(JTable tablaGraficaProductosDisponibles) {
        this.tablaGraficaProductosDisponibles = tablaGraficaProductosDisponibles;
    }

    public JTextField getTxtBuscar() {
        return txtBuscar;
    }

    public void setTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
    }

    public Integer getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(Integer IdCliente) {
        this.IdCliente = IdCliente;
    }

    public Integer getIdCuenta() {
        return IdCuenta;
    }

    public void setIdCuenta(Integer IdCuenta) {
        this.IdCuenta = IdCuenta;
    }

    public JTable getTablaCliente() {
        return tablaGraficaCliente;
    }

    public void setTablaCliente(JTable tablaCliente) {
        this.tablaGraficaCliente = tablaCliente;
    }

    public JTable getTablaListarProductos() {
        return tablaListarProductos;
    }

    public void setTablaListarProductos(JTable tablaListarProductos) {
        this.tablaListarProductos = tablaListarProductos;
    }

    public JRadioButton getRadButonConsumidorFinal() {
        return radButonConsumidorFinal;
    }

    public void setRadButonConsumidorFinal(JRadioButton radButonConsumidorFinal) {
        this.radButonConsumidorFinal = radButonConsumidorFinal;
    }

    public MaterialButton getBtnBuscarCliente() {
        return btnBuscarCliente;
    }

    public void setBtnBuscarCliente(MaterialButton btnBuscarCliente) {
        this.btnBuscarCliente = btnBuscarCliente;
    }

    public JLabel getLblPrecioTotal() {
        return lblPrecioTotal;
    }

    public void setLblPrecioTotal(JLabel lblPrecioTotal) {
        this.lblPrecioTotal = lblPrecioTotal;
    }

    public JTextField getTxtCantidad() {
        return txtCantidad;
    }

    public void setTxtCantidad(JTextField txtCantidad) {
        this.txtCantidad = txtCantidad;
    }

    public PrincipalVenta getPrincipalVenta() {
        return principalVenta;
    }

    public void setPrincipalVenta(PrincipalVenta principalVenta) {
        this.principalVenta = principalVenta;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaListarProductos = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaGraficaProductosDisponibles = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btnQuitar = new principal.MaterialButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaGraficaCliente = new javax.swing.JTable();
        btnBuscarCliente = new principal.MaterialButton();
        radButonConsumidorFinal = new javax.swing.JRadioButton();
        lblPrecioTotal = new javax.swing.JLabel();
        lblInfoSuma = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        btnRegistrar = new principal.MaterialButton();
        btnCancelar = new principal.MaterialButton();
        btnAgregar = new principal.MaterialButton();
        txtCantidad = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        radBtnDescontar = new javax.swing.JRadioButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaGraficaDescontarCuenta = new javax.swing.JTable();
        txtBuscarClientes = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaGraficaListaCliente = new javax.swing.JTable();
        lblInfoSuma1 = new javax.swing.JLabel();
        lblNuevoBalance = new javax.swing.JLabel();
        btnVaciarTabla = new principal.MaterialButton();
        txtDescuento = new javax.swing.JTextField();
        txtPago = new javax.swing.JTextField();
        lblInfoSuma2 = new javax.swing.JLabel();
        lblVuelto = new javax.swing.JLabel();
        panelPrincipalTop = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        boxTipoVenta = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        rSDateChooser = new rojeru_san.componentes.RSDateChooser();
        radButonReporte = new javax.swing.JRadioButton();
        radButonImprimir = new javax.swing.JRadioButton();
        radButonAbrirAlFinalizar = new javax.swing.JRadioButton();

        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 102), java.awt.Color.gray, new java.awt.Color(102, 102, 102), java.awt.Color.gray));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        tablaListarProductos.setBackground(new java.awt.Color(255, 255, 255));
        tablaListarProductos.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        tablaListarProductos.setForeground(new java.awt.Color(102, 0, 0));
        tablaListarProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "CANTIDAD", "TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaListarProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaListarProductos.setDoubleBuffered(true);
        tablaListarProductos.setRowHeight(40);
        tablaListarProductos.setSelectionBackground(new java.awt.Color(153, 0, 0));
        tablaListarProductos.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tablaListarProductos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaListarProductos.setShowHorizontalLines(false);
        tablaListarProductos.setShowVerticalLines(false);
        tablaListarProductos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaListarProductos);

        tablaGraficaProductosDisponibles.setBackground(new java.awt.Color(255, 255, 255));
        tablaGraficaProductosDisponibles.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        tablaGraficaProductosDisponibles.setForeground(new java.awt.Color(102, 0, 0));
        tablaGraficaProductosDisponibles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "DESCRIPCION", "PRECIO UNITARIO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaGraficaProductosDisponibles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaGraficaProductosDisponibles.setDoubleBuffered(true);
        tablaGraficaProductosDisponibles.setRowHeight(40);
        tablaGraficaProductosDisponibles.setSelectionBackground(new java.awt.Color(153, 0, 0));
        tablaGraficaProductosDisponibles.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tablaGraficaProductosDisponibles.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaGraficaProductosDisponibles.setShowHorizontalLines(false);
        tablaGraficaProductosDisponibles.setShowVerticalLines(false);
        tablaGraficaProductosDisponibles.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tablaGraficaProductosDisponibles);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("PRODUCTOS LISTADOS");

        btnQuitar.setBackground(new java.awt.Color(0,0,0,60));
        btnQuitar.setForeground(new java.awt.Color(255, 255, 255));
        btnQuitar.setText("QUITAR");
        btnQuitar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuitar.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        tablaGraficaCliente.setBackground(new java.awt.Color(255, 255, 255));
        tablaGraficaCliente.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        tablaGraficaCliente.setForeground(new java.awt.Color(102, 0, 0));
        tablaGraficaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "TELÉFONO", "DIRECCION"
            }
        ));
        tablaGraficaCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaGraficaCliente.setDoubleBuffered(true);
        tablaGraficaCliente.setEnabled(false);
        tablaGraficaCliente.setRowHeight(40);
        tablaGraficaCliente.setSelectionBackground(new java.awt.Color(153, 0, 0));
        tablaGraficaCliente.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tablaGraficaCliente.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaGraficaCliente.setShowHorizontalLines(false);
        tablaGraficaCliente.setShowVerticalLines(false);
        tablaGraficaCliente.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tablaGraficaCliente);

        btnBuscarCliente.setBackground(new java.awt.Color(0,0,0,60));
        btnBuscarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarCliente.setText("SELECCIONAR");
        btnBuscarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarCliente.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        radButonConsumidorFinal.setText("CONSUMIDOR FINAL");
        radButonConsumidorFinal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radButonConsumidorFinalItemStateChanged(evt);
            }
        });
        radButonConsumidorFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radButonConsumidorFinalActionPerformed(evt);
            }
        });

        lblPrecioTotal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblPrecioTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        lblInfoSuma.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblInfoSuma.setForeground(new java.awt.Color(0, 0, 0));
        lblInfoSuma.setText("SUMA TOTAL:");

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        btnRegistrar.setBackground(new java.awt.Color(0, 0, 0,60));
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnRegistrar.setMaximumSize(new java.awt.Dimension(170, 35));
        btnRegistrar.setMinimumSize(new java.awt.Dimension(170, 35));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(0, 0, 0,60));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("SALIR");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnCancelar.setPreferredSize(new java.awt.Dimension(70, 50));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(0,0,0,60));
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("AGREGAR");
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txtCantidad.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.lightGray));
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("PRODUCTOS DISPONIBLES");

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

        radBtnDescontar.setText("DESCONTAR DE CUENTA");
        radBtnDescontar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radBtnDescontarItemStateChanged(evt);
            }
        });
        radBtnDescontar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radBtnDescontarActionPerformed(evt);
            }
        });

        tablaGraficaDescontarCuenta.setBackground(new java.awt.Color(255, 255, 255));
        tablaGraficaDescontarCuenta.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        tablaGraficaDescontarCuenta.setForeground(new java.awt.Color(102, 0, 0));
        tablaGraficaDescontarCuenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° CUENTA", "BALANCE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaGraficaDescontarCuenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaGraficaDescontarCuenta.setDoubleBuffered(true);
        tablaGraficaDescontarCuenta.setRowHeight(40);
        tablaGraficaDescontarCuenta.setSelectionBackground(new java.awt.Color(153, 0, 0));
        tablaGraficaDescontarCuenta.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tablaGraficaDescontarCuenta.setShowHorizontalLines(false);
        tablaGraficaDescontarCuenta.setShowVerticalLines(false);
        tablaGraficaDescontarCuenta.getTableHeader().setReorderingAllowed(false);
        tablaGraficaDescontarCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaGraficaDescontarCuentaMousePressed(evt);
            }
        });
        jScrollPane5.setViewportView(tablaGraficaDescontarCuenta);

        txtBuscarClientes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.lightGray));
        txtBuscarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarClientesActionPerformed(evt);
            }
        });
        txtBuscarClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarClientesKeyReleased(evt);
            }
        });

        tablaGraficaListaCliente.setBackground(new java.awt.Color(255, 255, 255));
        tablaGraficaListaCliente.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        tablaGraficaListaCliente.setForeground(new java.awt.Color(102, 0, 0));
        tablaGraficaListaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Teléfono", "Direccion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaGraficaListaCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaGraficaListaCliente.setDoubleBuffered(true);
        tablaGraficaListaCliente.setRowHeight(40);
        tablaGraficaListaCliente.setSelectionBackground(new java.awt.Color(153, 0, 0));
        tablaGraficaListaCliente.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tablaGraficaListaCliente.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaGraficaListaCliente.setShowHorizontalLines(false);
        tablaGraficaListaCliente.setShowVerticalLines(false);
        tablaGraficaListaCliente.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(tablaGraficaListaCliente);

        lblInfoSuma1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblInfoSuma1.setForeground(new java.awt.Color(0, 0, 0));
        lblInfoSuma1.setText("NUEVO BALANCE:");

        lblNuevoBalance.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblNuevoBalance.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        btnVaciarTabla.setBackground(new java.awt.Color(0,0,0,60));
        btnVaciarTabla.setForeground(new java.awt.Color(255, 255, 255));
        btnVaciarTabla.setText("VACIAR TABLA");
        btnVaciarTabla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVaciarTabla.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btnVaciarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaciarTablaActionPerformed(evt);
            }
        });

        txtDescuento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.lightGray));
        txtDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescuentoActionPerformed(evt);
            }
        });
        txtDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyTyped(evt);
            }
        });

        txtPago.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.lightGray));
        txtPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPagoActionPerformed(evt);
            }
        });
        txtPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPagoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPagoKeyTyped(evt);
            }
        });

        lblInfoSuma2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblInfoSuma2.setForeground(new java.awt.Color(0, 0, 0));
        lblInfoSuma2.setText("VUELTO:");

        lblVuelto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblVuelto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radButonConsumidorFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(94, 94, 94)
                                    .addComponent(txtBuscarClientes))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtBuscar))
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnQuitar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtCantidad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(lblInfoSuma1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNuevoBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(radBtnDescontar, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(218, 218, 218)
                                    .addComponent(btnVaciarTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblInfoSuma2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblInfoSuma, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblPrecioTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                    .addComponent(lblVuelto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnVaciarTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(radButonConsumidorFinal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBuscarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPrecioTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(lblInfoSuma, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblVuelto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblInfoSuma2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                                .addGap(27, 27, 27))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPago, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radBtnDescontar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblInfoSuma1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(lblNuevoBalance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelPrincipalTop.setBackground(new java.awt.Color(0, 0, 0, 60));
        panelPrincipalTop.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("REGISTRAR VENTA");

        boxTipoVenta.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        boxTipoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxTipoVentaActionPerformed(evt);
            }
        });
        boxTipoVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                boxTipoVentaKeyReleased(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/new_copy_70px.png"))); // NOI18N

        rSDateChooser.setForeground(new java.awt.Color(255, 255, 255));
        rSDateChooser.setColorBackground(new java.awt.Color(0, 0, 0));
        rSDateChooser.setColorButtonHover(new java.awt.Color(0, 0, 0));
        rSDateChooser.setColorDiaActual(new java.awt.Color(0, 0, 0));
        rSDateChooser.setColorForeground(new java.awt.Color(0, 0, 0));
        rSDateChooser.setPlaceholder("Seleccionar fecha pedido");

        radButonReporte.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        radButonReporte.setForeground(new java.awt.Color(255, 255, 255));
        radButonReporte.setText("GENERAR COMPROBANTE");
        radButonReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radButonReporteActionPerformed(evt);
            }
        });

        radButonImprimir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        radButonImprimir.setForeground(new java.awt.Color(255, 255, 255));
        radButonImprimir.setText("IMPRIMIR");
        radButonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radButonImprimirActionPerformed(evt);
            }
        });

        radButonAbrirAlFinalizar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        radButonAbrirAlFinalizar.setForeground(new java.awt.Color(255, 255, 255));
        radButonAbrirAlFinalizar.setText("ARIR AL FINALIZAR");
        radButonAbrirAlFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radButonAbrirAlFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalTopLayout = new javax.swing.GroupLayout(panelPrincipalTop);
        panelPrincipalTop.setLayout(panelPrincipalTopLayout);
        panelPrincipalTopLayout.setHorizontalGroup(
            panelPrincipalTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalTopLayout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(529, 529, 529)
                .addComponent(boxTipoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rSDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipalTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalTopLayout.createSequentialGroup()
                        .addComponent(radButonImprimir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(88, 88, 88))
                    .addGroup(panelPrincipalTopLayout.createSequentialGroup()
                        .addComponent(radButonReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(66, 66, 66))
                    .addGroup(panelPrincipalTopLayout.createSequentialGroup()
                        .addComponent(radButonAbrirAlFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        panelPrincipalTopLayout.setVerticalGroup(
            panelPrincipalTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalTopLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelPrincipalTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalTopLayout.createSequentialGroup()
                        .addGroup(panelPrincipalTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelPrincipalTopLayout.createSequentialGroup()
                                .addComponent(radButonReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radButonAbrirAlFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radButonImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalTopLayout.createSequentialGroup()
                        .addGroup(panelPrincipalTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(boxTipoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rSDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipalTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(panelPrincipalTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boxTipoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxTipoVentaActionPerformed
        operacionesSecundariasVenta.tipoVentaSeleccionada(boxTipoVenta.getSelectedItem().toString());
    }//GEN-LAST:event_boxTipoVentaActionPerformed

    private void boxTipoVentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boxTipoVentaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_boxTipoVentaKeyReleased
    int x, y;
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x, point.y - y);
    }//GEN-LAST:event_formMouseDragged

    private void radBtnDescontarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radBtnDescontarActionPerformed
        if (this.radBtnDescontar.isSelected()) {
            tablaCuenta.setIdCliente(IdCliente);
            tablaCuenta.ejecutarRellenarTabla();
            tablaCuenta.setEstadoConsulta(0);
        } else {
            operacionesSecundariasVenta.cuentaDisable();
        }

    }//GEN-LAST:event_radBtnDescontarActionPerformed

    private void radBtnDescontarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radBtnDescontarItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_radBtnDescontarItemStateChanged

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        tablaProductosDisponibles.setPrincipalVenta(principalVenta);
        tablaProductosDisponibles.ejecutarRellenarTabla();
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed

    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        if (new OperacionesUtiles().advertenciaNum(evt)) {
            OperacionesUtiles.borrarCampo(txtCantidad);
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyReleased

    }//GEN-LAST:event_txtCantidadKeyReleased

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed

    }//GEN-LAST:event_txtCantidadActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (tablaProductosDisponibles.verificarFilaSeleccionada()) {
            tablaProductosListados.setPrincipalVenta(principalVenta);
            tablaProductosListados.setTablaProductosDisponibles(tablaProductosDisponibles);
            if (tablaProductosListados.verificarValor()) {
                tablaProductosListados.ejecutarAgregarProducto();
                operacionesSecundariasVenta.obtenerPrecioTotal();
                operacionesSecundariasVenta.calcularVuelto();
                if (radBtnDescontar.isSelected()) {
                    this.IdCuenta = tablaCuenta.obtenerIdFilaSeleccionada();
                    tablaCuenta.cacularNuevoBalance();

                }
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        JOptionPane jop = new JOptionPane();
        if (jop.showConfirmDialog(jop, "¿SEGURO QUE DESEA SALIR DE REGISTRAR VENTAS?", "",
                jop.OK_CANCEL_OPTION) == jop.OK_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (operacionesSecundariasVenta.validarListaProductos()) {
            if (operacionesSecundariasVenta.validarTablaCliente()) {
                if (operacionesSecundariasVenta.validarFecha()) {
                    abm.setFormularioRegistrarVenta(this);
                    abm.setListaProductosListados(tablaProductosListados.getListaProductosListados());
                    abm.setPrincipalCliente(principalCliente);
                    if (abm.ejecutarRegistrar()) {
                        //Seccion comprobante
                        if (radButonReporte.isSelected()) {
                            comprobante.setRadBtnAbrirDocumento(radButonAbrirAlFinalizar);
                            comprobante.setRadBtnImprimir(radButonImprimir);
                            comprobante.setIdVenta(abm.getIdVenta());

                            try {
                                comprobante.ejecutarGenerarReporte();
                            } catch (FileNotFoundException | DocumentException ex) {
                                Logger.getLogger(FormularioRegistrarVenta.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }

                        principalVenta.getTablaVenta().setPrincipalVenta(principalVenta);
                        principalVenta.getTablaVenta().setEstadoConsulta(0);
                        principalVenta.getTablaVenta().ejecutarRellenarTabla();
                        if (radBtnDescontar.isSelected()) {
                            tablaCuenta.setIdCliente(IdCliente);
                            tablaCuenta.ejecutarRellenarTabla();
                            tablaCuenta.setEstadoConsulta(0);
                        }

                    }
                }
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void radButonConsumidorFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radButonConsumidorFinalActionPerformed
        operacionesSecundariasVenta.tipoConsumidorFinalEnabled();
        operacionesSecundariasVenta.cuentaDisable();
        this.radBtnDescontar.setEnabled(false);


    }//GEN-LAST:event_radButonConsumidorFinalActionPerformed

    private void radButonConsumidorFinalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radButonConsumidorFinalItemStateChanged

    }//GEN-LAST:event_radButonConsumidorFinalItemStateChanged

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        if (tablaClienteLista.verificarFilaSeleccionada()) {
            if (tablaClienteLista.verficarClienteNoconsumidorFinal()) {
                operacionesSecundariasVenta.transferirDatos(this.tablaGraficaListaCliente, this.tablaGraficaCliente);
                this.IdCliente = tablaClienteLista.obtenerIdFilaSeleccionada();
                operacionesSecundariasVenta.cuentaDisable();
                radBtnDescontar.setEnabled(true);
            }
        }
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    /*
    new InterfazGraficaEscritorioCliente().deshabilitarBotones(principalAdministrador, this, 1);
        this.setVisible(false);
     */

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        if (tablaProductosListados.verificarFilaSeleccionada()) {
            tablaProductosListados.quitarProducto();
            operacionesSecundariasVenta.obtenerPrecioTotal();
            operacionesSecundariasVenta.calcularVuelto();
            if (radBtnDescontar.isSelected()) {
                this.IdCuenta = tablaCuenta.obtenerIdFilaSeleccionada();
                tablaCuenta.cacularNuevoBalance();

            }
        }
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void txtBuscarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarClientesActionPerformed

    private void txtBuscarClientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarClientesKeyReleased
        //tablaClienteLista.setFormularioRegistrarVenta(this);
        tablaClienteLista.ejecutarRellenarTabla();
    }//GEN-LAST:event_txtBuscarClientesKeyReleased

    private void btnVaciarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaciarTablaActionPerformed
        JOptionPane jop = new JOptionPane();
        if (jop.showConfirmDialog(jop, "¿SEGURO QUE ELIMINAR TODOS LOS PRODUCTOS DE LA TABLA?", "",
                jop.OK_CANCEL_OPTION) == jop.OK_OPTION) {
            tablaProductosListados.setTablaProductosListados(tablaListarProductos);
            tablaProductosListados.vaciarTabla();
            operacionesSecundariasVenta.obtenerPrecioTotal();
            operacionesSecundariasVenta.calcularVuelto();
            if (radBtnDescontar.isSelected()) {
                this.IdCuenta = tablaCuenta.obtenerIdFilaSeleccionada();
                tablaCuenta.cacularNuevoBalance();

            }
        }


    }//GEN-LAST:event_btnVaciarTablaActionPerformed

    private void radButonReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radButonReporteActionPerformed
        if (radButonReporte.isSelected()) {
            radButonAbrirAlFinalizar.setEnabled(true);
            radButonImprimir.setEnabled(true);
             radButonAbrirAlFinalizar.setForeground(new Color(255, 255, 255));
            radButonImprimir.setForeground(new Color(255, 255, 255));
        } else {
            radButonAbrirAlFinalizar.setEnabled(false);
            radButonImprimir.setEnabled(false);
            radButonAbrirAlFinalizar.setSelected(false);
            radButonImprimir.setSelected(false);
             radButonAbrirAlFinalizar.setForeground(new Color(102, 102, 102));
            radButonImprimir.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_radButonReporteActionPerformed

    private void radButonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radButonImprimirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radButonImprimirActionPerformed

    private void tablaGraficaDescontarCuentaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaGraficaDescontarCuentaMousePressed
        this.IdCuenta = tablaCuenta.obtenerIdFilaSeleccionada();
        tablaCuenta.cacularNuevoBalance();
         operacionesSecundariasVenta.calcularVuelto();
         operacionesSecundariasVenta.mensajeTipoMovimiento(Double.valueOf(lblVuelto.getText()));
    }//GEN-LAST:event_tablaGraficaDescontarCuentaMousePressed

    private void txtDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescuentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescuentoActionPerformed

    private void txtDescuentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyReleased
        if (new OperacionesUtiles().advertenciaNum(evt)) {
            this.txtDescuento.setText("");
            operacionesSecundariasVenta.calcularVuelto();
        } else {
            if (radBtnDescontar.isSelected()) {
                tablaCuenta.cacularNuevoBalance();
                operacionesSecundariasVenta.calcularVuelto();
            } else {
                operacionesSecundariasVenta.calcularVuelto();
            }

        }

    }//GEN-LAST:event_txtDescuentoKeyReleased

    private void txtDescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyTyped
       new OperacionesUtiles().limitarCaracteres(evt, txtDescuento,12);
    }//GEN-LAST:event_txtDescuentoKeyTyped

    private void txtPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPagoActionPerformed

    private void txtPagoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagoKeyReleased
        if (new OperacionesUtiles().advertenciaNum(evt)) {
            this.txtPago.setText("");
            operacionesSecundariasVenta.calcularVuelto();
        } else {
            if (radBtnDescontar.isSelected()) {
                tablaCuenta.cacularNuevoBalance();
                operacionesSecundariasVenta.calcularVuelto();
            } else {
                operacionesSecundariasVenta.calcularVuelto();
            }
        }


    }//GEN-LAST:event_txtPagoKeyReleased

    private void txtPagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagoKeyTyped
      new OperacionesUtiles().limitarCaracteres(evt,txtPago,12);
    }//GEN-LAST:event_txtPagoKeyTyped

    private void radButonAbrirAlFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radButonAbrirAlFinalizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radButonAbrirAlFinalizarActionPerformed

    public JPanel getPanelPrincipalTop() {
        return panelPrincipalTop;
    }

    public void setPanelPrincipalTop(JPanel panelPrincipalTop) {
        this.panelPrincipalTop = panelPrincipalTop;
    }

    public RSDateChooser getrSDateChooser() {
        return rSDateChooser;
    }

    public void setrSDateChooser(RSDateChooser rSDateChooser) {
        this.rSDateChooser = rSDateChooser;
    }

    public MaterialButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(MaterialButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public MaterialButton getBtnQuitar() {
        return btnQuitar;
    }

    public void setBtnQuitar(MaterialButton btnQuitar) {
        this.btnQuitar = btnQuitar;
    }

    public JTable getTablaGraficaListaCliente() {
        return tablaGraficaListaCliente;
    }

    public void setTablaGraficaListaCliente(JTable tablaGraficaListaCliente) {
        this.tablaGraficaListaCliente = tablaGraficaListaCliente;
    }

    public JTable getTablaGraficaDescontarCuenta() {
        return tablaGraficaDescontarCuenta;
    }

    public void setTablaGraficaDescontarCuenta(JTable tablaGraficaDescontarCuenta) {
        this.tablaGraficaDescontarCuenta = tablaGraficaDescontarCuenta;
    }

    public JTextField getTxtBuscarClientes() {
        return txtBuscarClientes;
    }

    public void setTxtBuscarClientes(JTextField txtBuscarClientes) {
        this.txtBuscarClientes = txtBuscarClientes;
    }

    public JLabel getLblNuevoBalance() {
        return lblNuevoBalance;
    }

    public void setLblNuevoBalance(JLabel lblNuevoBalance) {
        this.lblNuevoBalance = lblNuevoBalance;
    }

    public JRadioButton getRadBtnDescontar() {
        return radBtnDescontar;
    }

    public void setRadBtnDescontar(JRadioButton radBtnDescontar) {
        this.radBtnDescontar = radBtnDescontar;
    }

    public JTextField getTxtDescuento() {
        return txtDescuento;
    }

    public void setTxtDescuento(JTextField txtDescuento) {
        this.txtDescuento = txtDescuento;
    }

    public JTextField getTxtPago() {
        return txtPago;
    }

    public void setTxtPago(JTextField txtPago) {
        this.txtPago = txtPago;
    }

    public JLabel getLblVuelto() {
        return lblVuelto;
    }

    public void setLblVuelto(JLabel lblVuelto) {
        this.lblVuelto = lblVuelto;
    }

    public JRadioButton getRadButonAbrirAlFinalizar() {
        return radButonAbrirAlFinalizar;
    }

    public void setRadButonAbrirAlFinalizar(JRadioButton radButonAbrirAlFinalizar) {
        this.radButonAbrirAlFinalizar = radButonAbrirAlFinalizar;
    }

    public JRadioButton getRadButonImprimir() {
        return radButonImprimir;
    }

    public void setRadButonImprimir(JRadioButton radButonImprimir) {
        this.radButonImprimir = radButonImprimir;
    }

    public JRadioButton getRadButonReporte() {
        return radButonReporte;
    }

    public void setRadButonReporte(JRadioButton radButonReporte) {
        this.radButonReporte = radButonReporte;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxTipoVenta;
    private principal.MaterialButton btnAgregar;
    private principal.MaterialButton btnBuscarCliente;
    public static principal.MaterialButton btnCancelar;
    private principal.MaterialButton btnQuitar;
    public static principal.MaterialButton btnRegistrar;
    private principal.MaterialButton btnVaciarTabla;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblInfoSuma;
    private javax.swing.JLabel lblInfoSuma1;
    private javax.swing.JLabel lblInfoSuma2;
    private javax.swing.JLabel lblNuevoBalance;
    private javax.swing.JLabel lblPrecioTotal;
    private javax.swing.JLabel lblVuelto;
    private javax.swing.JPanel panelPrincipalTop;
    private rojeru_san.componentes.RSDateChooser rSDateChooser;
    private javax.swing.JRadioButton radBtnDescontar;
    private javax.swing.JRadioButton radButonAbrirAlFinalizar;
    private javax.swing.JRadioButton radButonConsumidorFinal;
    private javax.swing.JRadioButton radButonImprimir;
    private javax.swing.JRadioButton radButonReporte;
    private javax.swing.JTable tablaGraficaCliente;
    private javax.swing.JTable tablaGraficaDescontarCuenta;
    private javax.swing.JTable tablaGraficaListaCliente;
    private javax.swing.JTable tablaGraficaProductosDisponibles;
    private javax.swing.JTable tablaListarProductos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtBuscarClientes;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtPago;
    // End of variables declaration//GEN-END:variables
}
