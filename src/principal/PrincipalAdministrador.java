package principal;

import complementos.Cargar;
import complementos.OptionPaneMateriaPrima;
import escritorios.PrincipalCaja;
import escritorios.PrincipalCliente;
import escritorios.PrincipalConfiguracion;
import escritorios.PrincipalCuenta;
import escritorios.PrincipalGastos;
import escritorios.PrincipalIngresoMatPrima;
import escritorios.PrincipalMateriaPrima;
import escritorios.PrincipalProducto;
import escritorios.PrincipalProveedor;
import escritorios.PrincipalVenta;
import formularios.PaginasWeb;
import javax.swing.JLabel;
import javax.swing.JPanel;
import operacionesCaja.InterfazGraficaEscritorioCaja;
import operacionesCliente.InterfazGraficaEscritorioCliente;
import operacionesConfiguracion.InterfacesGraficasEscritorioConfiguracion;
import operacionesGasto.InterfazGraficaEscritorioGasto;
import operacionesProducto.InterfazGraficaEscritorioProducto;
import operacionesProveedor.InterfazGraficaEscritorioProveedor;
import operacionesVenta.InterfazGraficaEscritorioVenta;

/**
 *
 * @author TELCOM MPC
 */
public class PrincipalAdministrador extends javax.swing.JFrame {

    public PrincipalAdministrador() {
        initComponents();
        cliente = null;
        proveedor = null;
        producto = null;
        gasto = null;
        cargar = null;
        venta = null;
        caja = null;
        configuracion = null;
        materiaPrima = null;
        ingresoMateriaPrima = null;
        cuenta = null;
        webAFIP=null;
        setExtendedState(MAXIMIZED_BOTH);
    }

    //ventanas graficas -clases de interfaz.
    private PrincipalCliente cliente;
    private PrincipalProveedor proveedor;
    private PrincipalProducto producto;
    private PrincipalGastos gasto;
    private Cargar cargar;
    private PrincipalVenta venta;
    private PrincipalCaja caja;
    private PrincipalMateriaPrima materiaPrima;
    private PrincipalConfiguracion configuracion;
    private PrincipalIngresoMatPrima ingresoMateriaPrima;
    private PrincipalCuenta cuenta;
    public PaginasWeb webAFIP;

    //se utiliza en los metodos de apertura de ventana-clases de control.
    private final InterfazGraficaEscritorioCliente interfazGraficaCliente = new InterfazGraficaEscritorioCliente();
    private final InterfazGraficaEscritorioProveedor interfazGraficaProveedor = new InterfazGraficaEscritorioProveedor();
    private final InterfazGraficaEscritorioProducto interfazGraficaProducto = new InterfazGraficaEscritorioProducto();
    private final InterfazGraficaEscritorioGasto interfazGraficaGasto = new InterfazGraficaEscritorioGasto();
    private final InterfazGraficaEscritorioVenta interfazGraficaVenta = new InterfazGraficaEscritorioVenta();
    private final InterfazGraficaEscritorioCaja interfazGraficaCaja = new InterfazGraficaEscritorioCaja();
    private final InterfacesGraficasEscritorioConfiguracion interfazGraficaConfiguracion = new InterfacesGraficasEscritorioConfiguracion();
    



    //metodos de control de ventana.
    private boolean minimiza = false;
    public boolean cerra = false;

    public Escritorio getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(Escritorio escritorio) {
        this.escritorio = escritorio;
    }

    public PrincipalCliente getCliente() {
        return cliente;
    }

    public void setCliente(PrincipalCliente cliente) {
        this.cliente = cliente;
    }

    public PrincipalProveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(PrincipalProveedor proveedor) {
        this.proveedor = proveedor;
    }

    public PrincipalProducto getProducto() {
        return producto;
    }

    public void setProducto(PrincipalProducto producto) {
        this.producto = producto;
    }

    public PrincipalGastos getGasto() {
        return gasto;
    }

    public void setGasto(PrincipalGastos gasto) {
        this.gasto = gasto;
    }

    public Cargar getCargar() {
        return cargar;
    }

    public void setCargar(Cargar cargar) {
        this.cargar = cargar;
    }

    public PrincipalVenta getVenta() {
        return venta;
    }

    public void setVenta(PrincipalVenta venta) {
        this.venta = venta;
    }

    public PrincipalCaja getCaja() {
        return caja;
    }

    public void setCaja(PrincipalCaja caja) {
        this.caja = caja;
    }

    public PrincipalMateriaPrima getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(PrincipalMateriaPrima materiaPrima) {
        this.materiaPrima = materiaPrima;
    }

    public PrincipalIngresoMatPrima getIngresoMateriaPrima() {
        return ingresoMateriaPrima;
    }

    public void setIngresoMateriaPrima(PrincipalIngresoMatPrima ingresoMateriaPrima) {
        this.ingresoMateriaPrima = ingresoMateriaPrima;
    }

    public PrincipalConfiguracion getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(PrincipalConfiguracion configuracion) {
        this.configuracion = configuracion;
    }

    public PrincipalCuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(PrincipalCuenta cuenta) {
        this.cuenta = cuenta;
    }

    public PaginasWeb getWebAFIP() {
        return webAFIP;
    }

    public void setWebAFIP(PaginasWeb webAFIP) {
        this.webAFIP = webAFIP;
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSYearDate1 = new rojeru_san.componentes.RSYearDate();
        panelBase = new javax.swing.JPanel();
        panelPrincipalTop = new javax.swing.JPanel();
        lblVentaDolar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblCompraDolar = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblCompraDolar1 = new javax.swing.JLabel();
        panelPrincipalBody = new javax.swing.JPanel();
        btnGestionVentas = new principal.MaterialButtomRectangle();
        btnGestionMateriPrima = new principal.MaterialButtomRectangle();
        btnGestionProducto = new principal.MaterialButtomRectangle();
        btnGestionProveedor = new principal.MaterialButtomRectangle();
        btnGestionCliente = new principal.MaterialButtomRectangle();
        btnGestionCaja = new principal.MaterialButtomRectangle();
        btnGestionGastos = new principal.MaterialButtomRectangle();
        btnConfiguracion = new principal.MaterialButtomRectangle();
        escritorio = new principal.Escritorio();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelBase.setBackground(new java.awt.Color(255, 255, 255));

        panelPrincipalTop.setBackground(new java.awt.Color(142, 131, 54));

        lblVentaDolar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblVentaDolar.setForeground(new java.awt.Color(255, 255, 255));
        lblVentaDolar.setText("cargando...");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("VENTA:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DÓLAR OFICIAL");

        lblCompraDolar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblCompraDolar.setForeground(new java.awt.Color(255, 255, 255));
        lblCompraDolar.setText("cargando...");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("COMPRA:");

        lblCompraDolar1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCompraDolar1.setForeground(new java.awt.Color(255, 255, 255));
        lblCompraDolar1.setText("/");

        javax.swing.GroupLayout panelPrincipalTopLayout = new javax.swing.GroupLayout(panelPrincipalTop);
        panelPrincipalTop.setLayout(panelPrincipalTopLayout);
        panelPrincipalTopLayout.setHorizontalGroup(
            panelPrincipalTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalTopLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCompraDolar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCompraDolar1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblVentaDolar)
                .addGap(14, 14, 14))
        );
        panelPrincipalTopLayout.setVerticalGroup(
            panelPrincipalTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalTopLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelPrincipalTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCompraDolar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblVentaDolar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCompraDolar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        panelPrincipalBody.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipalBody.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.lightGray, java.awt.Color.gray, java.awt.Color.lightGray));

        btnGestionVentas.setBackground(new java.awt.Color(177, 159, 65));
        btnGestionVentas.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionVentas.setText("VENTAS y PEDIDOS");
        btnGestionCaja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionVentasActionPerformed(evt);
            }
        });

        btnGestionMateriPrima.setBackground(new java.awt.Color(177, 159, 65));
        btnGestionMateriPrima.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionMateriPrima.setText(" MATERIA PRIMA");
        btnGestionMateriPrima.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionMateriPrima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionMateriPrimaActionPerformed(evt);
            }
        });

        btnGestionProducto.setBackground(new java.awt.Color(177, 159, 65));
        btnGestionProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionProducto.setText(" PRODUCTOS");
        btnGestionProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionProductoActionPerformed(evt);
            }
        });

        btnGestionProveedor.setBackground(new java.awt.Color(177, 159, 65));
        btnGestionProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionProveedor.setText(" PROVEEDORES");
        btnGestionProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionProveedorActionPerformed(evt);
            }
        });

        btnGestionCliente.setBackground(new java.awt.Color(177, 159, 65));
        btnGestionCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionCliente.setText("  CLIENTES");
        btnGestionCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionClienteActionPerformed(evt);
            }
        });

        btnGestionCaja.setBackground(new java.awt.Color(177, 159, 65));
        btnGestionCaja.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionCaja.setText("CAJA");
        btnGestionCaja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionCajaActionPerformed(evt);
            }
        });

        btnGestionGastos.setBackground(new java.awt.Color(177, 159, 65));
        btnGestionGastos.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionGastos.setText("GASTOS");
        btnGestionGastos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGestionGastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionGastosActionPerformed(evt);
            }
        });

        btnConfiguracion.setBackground(new java.awt.Color(177, 159, 65));
        btnConfiguracion.setForeground(new java.awt.Color(255, 255, 255));
        btnConfiguracion.setText("CONFIGURACIÓN");
        btnConfiguracion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfiguracionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalBodyLayout = new javax.swing.GroupLayout(panelPrincipalBody);
        panelPrincipalBody.setLayout(panelPrincipalBodyLayout);
        panelPrincipalBodyLayout.setHorizontalGroup(
            panelPrincipalBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalBodyLayout.createSequentialGroup()
                .addGroup(panelPrincipalBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGestionVentas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(btnGestionCaja, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(btnConfiguracion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(btnGestionProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(btnGestionProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(btnGestionCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(btnGestionGastos, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(btnGestionMateriPrima, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelPrincipalBodyLayout.setVerticalGroup(
            panelPrincipalBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalBodyLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnGestionMateriPrima, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnGestionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnGestionProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnGestionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnGestionGastos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnGestionVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnGestionCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelBaseLayout = new javax.swing.GroupLayout(panelBase);
        panelBase.setLayout(panelBaseLayout);
        panelBaseLayout.setHorizontalGroup(
            panelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipalTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPrincipalBody, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBaseLayout.setVerticalGroup(
            panelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBaseLayout.createSequentialGroup()
                .addComponent(panelPrincipalTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelPrincipalBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBase, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGestionClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionClienteActionPerformed
        interfazGraficaCliente.setPrincipalAdministrador(this);
        interfazGraficaCliente.ejecutarNuevaVentana();
    }//GEN-LAST:event_btnGestionClienteActionPerformed

    private void btnGestionProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionProveedorActionPerformed
        interfazGraficaProveedor.setPrincipalAdministrador(this);
        interfazGraficaProveedor.ejecutarNuevaVentana();
    }//GEN-LAST:event_btnGestionProveedorActionPerformed

    private void btnGestionProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionProductoActionPerformed
        interfazGraficaProducto.setPrincipalAdministrador(this);
        interfazGraficaProducto.ejecutarNuevaVentana();
    }//GEN-LAST:event_btnGestionProductoActionPerformed

    private void btnGestionGastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionGastosActionPerformed
        interfazGraficaGasto.setPrincipalAdministrador(this);
        interfazGraficaGasto.ejecutarNuevaVentana();
    }//GEN-LAST:event_btnGestionGastosActionPerformed


    private void btnGestionCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionCajaActionPerformed
        interfazGraficaCaja.setPrincipalAdministrador(this);
        interfazGraficaCaja.ejecutarNuevaVentana();
    }//GEN-LAST:event_btnGestionCajaActionPerformed

    private void btnConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfiguracionActionPerformed
        interfazGraficaConfiguracion.setPrincipalAdministrador(this);
        interfazGraficaConfiguracion.ejecutarNuevaVentana();

    }//GEN-LAST:event_btnConfiguracionActionPerformed

    private void btnGestionMateriPrimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionMateriPrimaActionPerformed

        OptionPaneMateriaPrima optionPaneMateriaPrima = new OptionPaneMateriaPrima(this, true);
        optionPaneMateriaPrima.getPanelTop().setBackground(this.getPanelPrincipalTop().getBackground());
        optionPaneMateriaPrima.getBtnIngresoMateriaPrima().setBackground(this.getPanelPrincipalTop().getBackground());
        optionPaneMateriaPrima.getBtnMateriaPrima().setBackground(this.getPanelPrincipalTop().getBackground());
        optionPaneMateriaPrima.setPrincipalAdministrador(this);
        optionPaneMateriaPrima.setVisible(true);
    }//GEN-LAST:event_btnGestionMateriPrimaActionPerformed

    private void btnGestionVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionVentasActionPerformed
        interfazGraficaVenta.setPrincipalAdministrador(this);
        interfazGraficaVenta.ejecutarNuevaVentana();
    }//GEN-LAST:event_btnGestionVentasActionPerformed

    public JPanel getPanelPrincipalBody() {
        return panelPrincipalBody;
    }

    public void setPanelPrincipalBody(JPanel panelPrincipalBody) {
        this.panelPrincipalBody = panelPrincipalBody;
    }

    public JPanel getPanelPrincipalTop() {
        return panelPrincipalTop;
    }

    public void setPanelPrincipalTop(JPanel panelPrincipalTop) {
        this.panelPrincipalTop = panelPrincipalTop;
    }

    public MaterialButtomRectangle getBtnConfiguracion() {
        return btnConfiguracion;
    }

    public void setBtnConfiguracion(MaterialButtomRectangle btnConfiguracion) {
        this.btnConfiguracion = btnConfiguracion;
    }

    public MaterialButtomRectangle getBtnGestionCliente() {
        return btnGestionCliente;
    }

    public void setBtnGestionCliente(MaterialButtomRectangle btnGestionCliente) {
        this.btnGestionCliente = btnGestionCliente;
    }
    
    public MaterialButtomRectangle getBtnGestionMateriPrima() {
        return btnGestionMateriPrima;
    }

    public void setBtnGestionMateriPrima(MaterialButtomRectangle btnGestionMateriPrima) {
        this.btnGestionMateriPrima = btnGestionMateriPrima;
    }


    public MaterialButtomRectangle getBtnGestionGastos() {
        return btnGestionGastos;
    }

    public void setBtnGestionGastos(MaterialButtomRectangle btnGestionGastos) {
        this.btnGestionGastos = btnGestionGastos;
    }

    public MaterialButtomRectangle getBtnGestionProducto() {
        return btnGestionProducto;
    }

    public void setBtnGestionProducto(MaterialButtomRectangle btnGestionProducto) {
        this.btnGestionProducto = btnGestionProducto;
    }

    public MaterialButtomRectangle getBtnGestionProveedor() {
        return btnGestionProveedor;
    }

    public MaterialButtomRectangle getBtnGestionCaja() {
        return btnGestionCaja;
    }

    public void setBtnGestionCaja(MaterialButtomRectangle btnGestionCaja) {
        this.btnGestionCaja = btnGestionCaja;
    }

    public MaterialButtomRectangle getBtnGestionVentas() {
        return btnGestionVentas;
    }

    public void setBtnGestionVentas(MaterialButtomRectangle btnGestionVentas) {
        this.btnGestionVentas = btnGestionVentas;
    }

    public void setBtnGestionProveedor(MaterialButtomRectangle btnGestionProveedor) {
        this.btnGestionProveedor = btnGestionProveedor;
    }

    public JLabel getLblCompraDolar() {
        return lblCompraDolar;
    }

    public void setLblCompraDolar(JLabel lblCompraDolar) {
        this.lblCompraDolar = lblCompraDolar;
    }

    public JLabel getLblVentaDolar() {
        return lblVentaDolar;
    }

    public void setLblVentaDolar(JLabel lblVentaDolar) {
        this.lblVentaDolar = lblVentaDolar;
    }

    



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private principal.MaterialButtomRectangle btnConfiguracion;
    private principal.MaterialButtomRectangle btnGestionCaja;
    private principal.MaterialButtomRectangle btnGestionCliente;
    private principal.MaterialButtomRectangle btnGestionGastos;
    private principal.MaterialButtomRectangle btnGestionMateriPrima;
    private principal.MaterialButtomRectangle btnGestionProducto;
    private principal.MaterialButtomRectangle btnGestionProveedor;
    private principal.MaterialButtomRectangle btnGestionVentas;
    private principal.Escritorio escritorio;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblCompraDolar;
    private javax.swing.JLabel lblCompraDolar1;
    private javax.swing.JLabel lblVentaDolar;
    private javax.swing.JPanel panelBase;
    private javax.swing.JPanel panelPrincipalBody;
    private javax.swing.JPanel panelPrincipalTop;
    private rojeru_san.componentes.RSYearDate rSYearDate1;
    // End of variables declaration//GEN-END:variables


}
