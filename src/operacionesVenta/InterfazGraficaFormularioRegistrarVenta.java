package operacionesVenta;

import calsesPadre.InterfazGraficaFormularioRegistrar;
import clasesUtilidadGeneral.TextPrompt;
import complementos.Cargar;
import escritorios.PrincipalVenta;
import formularios.FormularioRegistrarVenta;
import java.awt.Color;
import java.util.Date;
import javax.swing.SwingConstants;
import principal.PrincipalAdministrador;

/**
 * @author Hasper Franco
 */
public class InterfazGraficaFormularioRegistrarVenta extends InterfazGraficaFormularioRegistrar {

    public InterfazGraficaFormularioRegistrarVenta() {
        setEstadoConsulta(0);
    }

    private PrincipalVenta principalVenta;

    private PrincipalAdministrador principalAdministrador;

    public PrincipalAdministrador getPrincipalAdministrador() {
        return principalAdministrador;
    }

    public void setPrincipalAdministrador(PrincipalAdministrador principalAdministrador) {
        this.principalAdministrador = principalAdministrador;
    }

    public PrincipalVenta getPrincipalVenta() {
        return principalVenta;
    }

    public void setPrincipalVenta(PrincipalVenta principalVenta) {
        this.principalVenta = principalVenta;
    }

    @Override
    public void nuevoFormularioRegistrar() {
        Cargar cargando = new Cargar();
        cargando.setVisible(true);
        if (principalVenta.getFromularioRegistrarVenta() == null) {
            //seccion formulario
            FormularioRegistrarVenta formularioRegistrar = new FormularioRegistrarVenta(frame, true);
            formularioRegistrar.setPrincipalVenta(principalVenta);
            formularioRegistrar.setPrincipalAdministrador(principalAdministrador);
            principalVenta.setFromularioRegistrarVenta(formularioRegistrar);
            infoTextPrompt();
            colorTema();

            //Seccion Tabla Productos Disponibles
            TablaProductosDisponibles tablaProductosDisponibles = new TablaProductosDisponibles();
            tablaProductosDisponibles.setTipoFormulario(1);
            tablaProductosDisponibles.setPrincipalVenta(principalVenta);
            tablaProductosDisponibles.ejecutarRellenarTabla();
            principalVenta.getFromularioRegistrarVenta().setTablaProductosDisponibles(tablaProductosDisponibles);

            //Seccion Tabla Productos Listados
            TablaProductosListados tablaProductosListados = new TablaProductosListados();
            tablaProductosListados.setTipoFormulario(1);
            principalVenta.getFromularioRegistrarVenta().setTablaProductosListados(tablaProductosListados);
            configuracionTxtCantidadTxtTotal();

            //Seccion Operaciones Secundarias
            //creo el objeto operaciones secundarias
            OperacionesSecundariasVenta operacionesSecundariasVenta = new OperacionesSecundariasVenta();
            //le pego el formulario con el que va a trabajar
            operacionesSecundariasVenta.setFormularioRegistrarVenta(formularioRegistrar);
            //le asigno el valor del tipo de formulario para los switchs(si es registrar 1 va a trabajar de una forma si es editar 2 va a trabajar de otra)
            operacionesSecundariasVenta.setTipoFormulario(1);
            //guardo el la instancia en el formulario grafico
            principalVenta.getFromularioRegistrarVenta().setOperacionesSecundariasVenta(operacionesSecundariasVenta);

            TablaClienteLista tablaClienteLista = new TablaClienteLista();
            tablaClienteLista.setFormularioRegistrarVenta(principalVenta.getFromularioRegistrarVenta());
            tablaClienteLista.ejecutarRellenarTabla();
            formularioRegistrar.setTablaClienteLista(tablaClienteLista);

            TablaCuenta tablaCuenta = new TablaCuenta();
            tablaCuenta.setFormularioRegistrarVenta(formularioRegistrar);
            formularioRegistrar.setTablaCuenta(tablaCuenta);

            //deshabilitar boton descontar cuenta
            principalVenta.getFromularioRegistrarVenta().getRadBtnDescontar().setEnabled(false);

            ComprobanteVenta comprobante = new ComprobanteVenta();
            formularioRegistrar.setComprobante(comprobante);
            radButons();
            rellenarBoxes();
            fechaActual();
        }
        cargando.dispose();
        principalVenta.getFromularioRegistrarVenta().setVisible(true);
        principalVenta.setFromularioRegistrarVenta(null);
    }

    @Override
    public void infoTextPrompt() {
        new TextPrompt("CANTIDAD", principalVenta.getFromularioRegistrarVenta().getTxtCantidad());
        new TextPrompt("BUSCAR POR NOMBRE", principalVenta.getFromularioRegistrarVenta().getTxtBuscar());
        new TextPrompt("BUSCAR POR NOMBRE", principalVenta.getFromularioRegistrarVenta().getTxtBuscarClientes());
        new TextPrompt("MONTO PAGADO", principalVenta.getFromularioRegistrarVenta().getTxtPago());
        new TextPrompt("DESCUENTO", principalVenta.getFromularioRegistrarVenta().getTxtDescuento());
        principalVenta.getFromularioRegistrarVenta().getTxtBuscar().grabFocus();
    }

    @Deprecated
    @Override
    public void agregarBoxes() {
    }

    @Override
    public void rellenarBoxes() {
        principalVenta.getFromularioRegistrarVenta().getBoxTipoVenta().addItem("Venta Simple");
        principalVenta.getFromularioRegistrarVenta().getBoxTipoVenta().addItem("Pedido");
    }

    @Override
    public void colorTema() {
        principalVenta.getFromularioRegistrarVenta().getPanelPrincipalTop().setBackground(principalVenta.getPanelPrincipalTop().getBackground());
        principalVenta.getFromularioRegistrarVenta().getrSDateChooser().setColorBackground(principalVenta.getPanelPrincipalTop().getBackground());

        principalVenta.getFromularioRegistrarVenta().getTablaGraficaListaCliente().setSelectionBackground(principalVenta.getPanelPrincipalTop().getBackground());
        principalVenta.getFromularioRegistrarVenta().getTablaGraficaListaCliente().setForeground(principalVenta.getPanelPrincipalTop().getBackground());

        principalVenta.getFromularioRegistrarVenta().getTablaGraficaProductosDisponibles().setSelectionBackground(principalVenta.getPanelPrincipalTop().getBackground());
        principalVenta.getFromularioRegistrarVenta().getTablaGraficaProductosDisponibles().setForeground(principalVenta.getPanelPrincipalTop().getBackground());

        principalVenta.getFromularioRegistrarVenta().getTablaListarProductos().setSelectionBackground(principalVenta.getPanelPrincipalTop().getBackground());
        principalVenta.getFromularioRegistrarVenta().getTablaListarProductos().setForeground(principalVenta.getPanelPrincipalTop().getBackground());

        principalVenta.getFromularioRegistrarVenta().getTablaGraficaDescontarCuenta().setSelectionBackground(principalVenta.getPanelPrincipalTop().getBackground());
        principalVenta.getFromularioRegistrarVenta().getTablaGraficaDescontarCuenta().setForeground(principalVenta.getPanelPrincipalTop().getBackground());

        principalVenta.getFromularioRegistrarVenta().getTablaCliente().setSelectionBackground(principalVenta.getPanelPrincipalTop().getBackground());
        principalVenta.getFromularioRegistrarVenta().getTablaCliente().setForeground(principalVenta.getPanelPrincipalTop().getBackground());

    }

    private void configuracionTxtCantidadTxtTotal() {
        principalVenta.getFromularioRegistrarVenta().getTxtCantidad().setText("1");
        principalVenta.getFromularioRegistrarVenta().getTxtCantidad().setHorizontalAlignment(SwingConstants.CENTER);
        principalVenta.getFromularioRegistrarVenta().getLblPrecioTotal().setText("0.00");
        principalVenta.getFromularioRegistrarVenta().getLblVuelto().setText("0.00");
        principalVenta.getFromularioRegistrarVenta().getLblNuevoBalance().setText("0.00");
    }

    private void fechaActual() {
        Date fechaActual = new Date();
        principalVenta.getFromularioRegistrarVenta().getrSDateChooser().setDatoFecha(fechaActual);
    }

    private void radButons() {
        principalVenta.getFromularioRegistrarVenta().getRadButonAbrirAlFinalizar().setEnabled(false);
        principalVenta.getFromularioRegistrarVenta().getRadButonImprimir().setEnabled(false);
        principalVenta.getFromularioRegistrarVenta().getRadButonAbrirAlFinalizar().setForeground(new Color(102, 102, 102));
        principalVenta.getFromularioRegistrarVenta().getRadButonImprimir().setForeground(new Color(102, 102, 102));
    }

}
