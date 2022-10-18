package operacionesVenta;

import calsesPadre.InterfazGraficaFormularioEditar;
import clasesUtilidadGeneral.TextPrompt;
import complementos.Cargar;
import escritorios.PrincipalVenta;
import formularios.FormularioEditarVenta;
import java.awt.Color;
import javax.swing.SwingConstants;
import principal.PrincipalAdministrador;

/**
 * @author Hasper Franco
 */
public class InterfazGraficaFormularioEditarVenta extends InterfazGraficaFormularioEditar {

    protected PrincipalVenta principalVenta;
    protected TablaVenta tablaVenta;
    private PrincipalAdministrador principalAdministrador;
    private Integer idVenta;

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public PrincipalVenta getPrincipalVenta() {
        return principalVenta;
    }

    public void setPrincipalVenta(PrincipalVenta principalVenta) {
        this.principalVenta = principalVenta;
    }

    public TablaVenta getTablaVenta() {
        return tablaVenta;
    }

    public void setTablaVenta(TablaVenta tablaVenta) {
        this.tablaVenta = tablaVenta;
    }

    public PrincipalAdministrador getPrincipalAdministrador() {
        return principalAdministrador;
    }

    public void setPrincipalAdministrador(PrincipalAdministrador principalAdministrador) {
        this.principalAdministrador = principalAdministrador;
    }

    @Override
    public void nuevoFormularioEditar() {
        Cargar cargando = new Cargar();
        cargando.setVisible(true);
        if (principalVenta.getFormularioEditarVenta() == null) {
            //seccion formulario
            FormularioEditarVenta formularioEditar = new FormularioEditarVenta(frame, true);
            formularioEditar.setPrincipalVenta(principalVenta);
            formularioEditar.setPrincipalAdministrador(principalAdministrador);
            principalVenta.setFormularioEditarVenta(formularioEditar);
            colorTema();

            infoTextPrompt();

            //Seccion Tabla Productos Disponibles
            TablaProductosDisponibles tablaProductosDisponibles = new TablaProductosDisponibles();
            tablaProductosDisponibles.setTipoFormulario(2);
            tablaProductosDisponibles.setPrincipalVenta(principalVenta);
            tablaProductosDisponibles.ejecutarRellenarTabla();
            principalVenta.getFormularioEditarVenta().setTablaProductosDisponibles(tablaProductosDisponibles);

            //Seccion Tabla Productos Listados
            TablaProductosListados tablaProductosListados = new TablaProductosListados();
            tablaProductosListados.setTipoFormulario(2);
            tablaProductosListados.setFormularioEditarVenta(formularioEditar);
            tablaProductosListados.setIdVenta(idVenta);
            tablaProductosListados.ejecutarRellenarTabla();
            //datos secundarios no tienen nada que ver con la tabla
            tablaProductosListados.autoRellenarDatosSecundarios();
            principalVenta.getFormularioEditarVenta().setListaProductosEliminar(tablaProductosListados.getListaProductosEliminar());
            principalVenta.getFormularioEditarVenta().setTablaProductosListados(tablaProductosListados);

            configuracionTxtCantidadTxtTotal();

            //seccion tablaCliente
            TablaClienteWhenEdit tablaCliente = new TablaClienteWhenEdit();
            tablaCliente.setIdVenta(idVenta);
            tablaCliente.setFormularioEditarVenta(formularioEditar);
            tablaCliente.ejecutarRellenenarTabla();
            Integer idCliente = tablaCliente.getIdCliente();
            principalVenta.getFormularioEditarVenta().setIdCliente(idCliente);

            estadoInicialRadBtnDescontar(idCliente);

            TablaClienteLista tablaClienteLista = new TablaClienteLista();
            tablaClienteLista.setFormularioEditarVenta(principalVenta.getFormularioEditarVenta());
            tablaClienteLista.setIdClientePrevio(idCliente);
            tablaClienteLista.ejecutarRellenarTabla();
            formularioEditar.setTablaClienteLista(tablaClienteLista);

            TablaCuenta tablaCuenta = new TablaCuenta();
            tablaCuenta.setFormularioEditarVenta(formularioEditar);
            tablaCuenta.setIdVenta(idVenta);
            tablaCuenta.setIdCliente(idCliente);
            tablaCuenta.evaluarDescuentoPrevio();
            formularioEditar.setIdCuenta(tablaCuenta.obtenerIdCuenta());
            formularioEditar.setTablaCuenta(tablaCuenta);

            //Seccion Operaciones Secundarias
            //creo el objeto operaciones secundarias
            OperacionesSecundariasVenta operacionesSecundariasVenta = new OperacionesSecundariasVenta();
            //le pego el formulario con el que va a trabajar
            operacionesSecundariasVenta.setFormularioEditarVenta(formularioEditar);
            //le asigno el valor del tipo de formulario para los switchs(si es registrar 1 va a trabajar de una forma si es editar 2 va a trabajar de otra)
            operacionesSecundariasVenta.setTipoFormulario(2);
            //guardo el la instancia en el formulario grafico
            principalVenta.getFormularioEditarVenta().setOperacionesSecundariasVenta(operacionesSecundariasVenta);
            //Solo cuando es una venta con movimiento precio realizado
            operacionesSecundariasVenta.ejecutarCalcularBalanceCuentaPrevio();

            operacionesSecundariasVenta.colorLblVuelto(formularioEditar.getLblVuelto(), Double.valueOf(formularioEditar.getLblVuelto().getText()));

            rellenarBoxes();
            transferirDatos();
            radButons();

            ComprobanteVenta comprobante = new ComprobanteVenta();
            formularioEditar.setComprobante(comprobante);

        }
        cargando.dispose();
        principalVenta.getFormularioEditarVenta().setVisible(true);
        principalVenta.setFormularioEditarVenta(null);

    }

    public void infoTextPrompt() {
        new TextPrompt("CANTIDAD", principalVenta.getFormularioEditarVenta().getTxtCantidad());
        new TextPrompt("BUSCAR POR NOMBRE", principalVenta.getFormularioEditarVenta().getTxtBuscar());
        new TextPrompt("BUSCAR POR NOMBRE", principalVenta.getFormularioEditarVenta().getTxtBuscarClientes());
        new TextPrompt("MONTO PAGADO", principalVenta.getFormularioEditarVenta().getTxtPago());
        new TextPrompt("DESCUENTO", principalVenta.getFormularioEditarVenta().getTxtDescuento());
        principalVenta.getFormularioEditarVenta().getTxtBuscar().grabFocus();
    }

    @Override
    public void colorTema() {
        principalVenta.getFormularioEditarVenta().getPanelPrincipalTop().setBackground(principalVenta.getPanelPrincipalTop().getBackground());
        principalVenta.getFormularioEditarVenta().getrSDateChooser().setColorBackground(principalVenta.getPanelPrincipalTop().getBackground());

        principalVenta.getFormularioEditarVenta().getTablaGraficaListaCliente().setSelectionBackground(principalVenta.getPanelPrincipalTop().getBackground());
        principalVenta.getFormularioEditarVenta().getTablaGraficaListaCliente().setForeground(principalVenta.getPanelPrincipalTop().getBackground());

        principalVenta.getFormularioEditarVenta().getTablaGraficaProductosDisponibles().setSelectionBackground(principalVenta.getPanelPrincipalTop().getBackground());
        principalVenta.getFormularioEditarVenta().getTablaGraficaProductosDisponibles().setForeground(principalVenta.getPanelPrincipalTop().getBackground());

        principalVenta.getFormularioEditarVenta().getTablaListarProductos().setSelectionBackground(principalVenta.getPanelPrincipalTop().getBackground());
        principalVenta.getFormularioEditarVenta().getTablaListarProductos().setForeground(principalVenta.getPanelPrincipalTop().getBackground());

        principalVenta.getFormularioEditarVenta().getTablaGraficaDescontarCuenta().setSelectionBackground(principalVenta.getPanelPrincipalTop().getBackground());
        principalVenta.getFormularioEditarVenta().getTablaGraficaDescontarCuenta().setForeground(principalVenta.getPanelPrincipalTop().getBackground());

        principalVenta.getFormularioEditarVenta().getTablaGraficaCliente().setSelectionBackground(principalVenta.getPanelPrincipalTop().getBackground());
        principalVenta.getFormularioEditarVenta().getTablaGraficaCliente().setForeground(principalVenta.getPanelPrincipalTop().getBackground());
    }

    @Override
    public void transferirDatos() {
        int fila = principalVenta.getTablaGrafica().getSelectedRow();
        String valor = principalVenta.getTablaGrafica().getValueAt(fila, 3).toString();
        if (valor.equals("venta simple")) {
            principalVenta.getFormularioEditarVenta().getBoxTipoVenta().setSelectedIndex(0);
        } else {
            principalVenta.getFormularioEditarVenta().getBoxTipoVenta().setSelectedIndex(1);
        }
    }

    @Override
    public void agregarBoxes() {

    }

    @Override
    public void rellenarBoxes() {
        principalVenta.getFormularioEditarVenta().getBoxTipoVenta().addItem("Venta Simple");
        principalVenta.getFormularioEditarVenta().getBoxTipoVenta().addItem("Pedido");
    }

    private void configuracionTxtCantidadTxtTotal() {
        principalVenta.getFormularioEditarVenta().getTxtCantidad().setText("1");
        principalVenta.getFormularioEditarVenta().getTxtCantidad().setHorizontalAlignment(SwingConstants.CENTER);
        // principalVenta.getEditarVenta().getLblPrecioTotal().setText("0.0");
    }

    private void radButons() {
        principalVenta.getFormularioEditarVenta().getRadButonAbrirAlFinalizar().setEnabled(false);
        principalVenta.getFormularioEditarVenta().getRadButonImprimir().setEnabled(false);

        principalVenta.getFormularioEditarVenta().getRadButonAbrirAlFinalizar().setForeground(new Color(102, 102, 102));
        principalVenta.getFormularioEditarVenta().getRadButonImprimir().setForeground(new Color(102, 102, 102));

    }

    private void estadoInicialRadBtnDescontar(Integer idCliente) {
        if (idCliente == 1) {
            principalVenta.getFormularioEditarVenta().getRadBtnDescontar().setEnabled(false);
        }
    }

}
