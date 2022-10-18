package operacionesVenta;

import calsesPadre.Tabla;
import clasesUtilidadGeneral.OperacionesUtiles;
import ds.desktop.notify.DesktopNotify;
import entidades.Cuenta;
import entidades.MovimientoCuenta;
import entidades.Venta_MovimientoCuenta;
import formularios.FormularioEditarVenta;
import formularios.FormularioRegistrarVenta;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 * @author Hasper Franco
 */
public class TablaCuenta extends Tabla {

    private Integer idCliente;
    private Integer idVenta;
    private Integer idCuentaPrevia;
    private boolean first;
    private FormularioRegistrarVenta formularioRegistrarVenta;
    private FormularioEditarVenta formularioEditarVenta;
    private List<Integer> listaIds = new ArrayList<Integer>();

    public TablaCuenta() {
        setEstadoConsulta(0);
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Integer getIdCuentaPrevia() {
        return idCuentaPrevia;
    }

    public void setIdCuentaPrevia(Integer idCuentaPrevia) {
        this.idCuentaPrevia = idCuentaPrevia;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public FormularioRegistrarVenta getFormularioRegistrarVenta() {
        return formularioRegistrarVenta;
    }

    public void setFormularioRegistrarVenta(FormularioRegistrarVenta formularioRegistrarVenta) {
        this.formularioRegistrarVenta = formularioRegistrarVenta;
    }

    public FormularioEditarVenta getFormularioEditarVenta() {
        return formularioEditarVenta;
    }

    public void setFormularioEditarVenta(FormularioEditarVenta formularioEditarVenta) {
        this.formularioEditarVenta = formularioEditarVenta;
    }

    public List<Integer> getListaIds() {
        return listaIds;
    }

    public void setListaIds(List<Integer> listaIds) {
        this.listaIds = listaIds;
    }

    /**
     * Ejecuata los metodos necesarios para rellenar la tabla cuentas de la
     * ventana PrincipalCuenta.
     *
     * @param p
     */
    @Override
    public void ejecutarRellenarTabla() {
        if (getFormularioRegistrarVenta() == null) {
            setTabla(formularioEditarVenta.getTablaGraficaDescontarCuenta());
            setStringConsulta("from Cuenta where codigoCliente=" + this.idCliente);
            evaluarEstadoConsulta();
            rellenarTabla("");
        } else {
            setTabla(formularioRegistrarVenta.getTablaGraficaDescontarCuenta());
            setStringConsulta("from Cuenta where codigoCliente=" + this.idCliente);
            evaluarEstadoConsulta();
            rellenarTabla("");
        }

    }

    @Override
    public Integer obtenerIdFilaSeleccionada() {
        try {
            if (getFormularioRegistrarVenta() == null) {
                Integer totalFilas = formularioEditarVenta.getTablaGraficaDescontarCuenta().getRowCount();
                Integer filasSeleccionada = formularioEditarVenta.getTablaGraficaDescontarCuenta().getSelectedRow();
                List<Integer> listaResutadosActualesThis = formularioEditarVenta.getTablaCuenta().listaIds;
                Integer id = operacionesUtilidad.obtenerId(listaResutadosActualesThis, totalFilas, filasSeleccionada);
                this.setIdTabla(id);
            } else {
                Integer totalFilas = formularioRegistrarVenta.getTablaGraficaDescontarCuenta().getRowCount();
                Integer filasSeleccionada = formularioRegistrarVenta.getTablaGraficaDescontarCuenta().getSelectedRow();
                List<Integer> listaResutadosActualesThis = formularioRegistrarVenta.getTablaCuenta().listaIds;
                Integer id = operacionesUtilidad.obtenerId(listaResutadosActualesThis, totalFilas, filasSeleccionada);
                this.setIdTabla(id);
            }

        } catch (Exception e) {
        }
        return idTabla;
    }

    @Override
    public void rellenarTabla(String valorBusqueda) {
        DefaultTableModel tablaCuenta = (DefaultTableModel) getTabla().getModel();
        List lista = this.getListaResultados();
        operacionesUtilidad.removerFilas(tablaCuenta);

        try {
            this.listaIds.clear();
        } catch (NullPointerException e) {
        }

        if (this.first) {

            for (Object o : lista) {
                Cuenta c = (Cuenta) o;
                this.listaIds.add(0, c.getIdCuenta());
                Vector<Object> fila = new Vector<>();
                fila.add(c.getIdCuenta());
                fila.add(OperacionesUtiles.formatoDouble(c.getBalance()));
                tablaCuenta.addRow(fila);
            }
            OperacionesUtiles.ordenarLista(listaIds);
            this.setFirst(false);
        } else {
            if (this.idCuentaPrevia != null) {
                for (Object o : lista) {
                    Cuenta c = (Cuenta) o;
                    if (c.getIdCuenta() != this.idCuentaPrevia) {
                        this.listaIds.add(0, c.getIdCuenta());
                        Vector<Object> fila = new Vector<>();
                        fila.add(c.getIdCuenta());
                        fila.add(OperacionesUtiles.formatoDouble(c.getBalance()));
                        tablaCuenta.addRow(fila);
                    }
                }
                OperacionesUtiles.ordenarLista(listaIds);

            } else {
                for (Object o : lista) {
                    Cuenta c = (Cuenta) o;
                    this.listaIds.add(0, c.getIdCuenta());
                    Vector<Object> fila = new Vector<>();
                    fila.add(c.getIdCuenta());
                    fila.add(OperacionesUtiles.formatoDouble(c.getBalance()));
                    tablaCuenta.addRow(fila);
                }
                OperacionesUtiles.ordenarLista(listaIds);
            }

        }

    }

    @Override
    public boolean verificarFilaSeleccionada() {
        try {

            if (getFormularioRegistrarVenta() == null) {
                int fila = formularioEditarVenta.getTablaGraficaDescontarCuenta().getSelectedRow();
                formularioEditarVenta.getTablaGraficaDescontarCuenta().getValueAt(fila, 0).toString();
                return true;
            } else {
                int fila = formularioRegistrarVenta.getTablaGraficaDescontarCuenta().getSelectedRow();
                formularioRegistrarVenta.getTablaGraficaDescontarCuenta().getValueAt(fila, 0).toString();
                return true;
            }

        } catch (Exception e) {
            DesktopNotify.showDesktopMessage("Informacion", "Debe seleccionar una fila", DesktopNotify.INFORMATION, 7000);
            return false;
        }
    }

    public void cacularNuevoBalance() {

        if (getFormularioRegistrarVenta() == null) {
            balanceEditar();
        } else {
            balanceRegistrar();
        }

    }

    private void balanceRegistrar() {
        Double descuento = 0.00;
        Double pagado = 0.00;
        Double balance = 0.00;
        int fila = formularioRegistrarVenta.getTablaGraficaDescontarCuenta().getSelectedRow();
        Double totalCompra = Double.valueOf(formularioRegistrarVenta.getLblPrecioTotal().getText());
        try {
            balance = Double.valueOf(formularioRegistrarVenta.getTablaGraficaDescontarCuenta().getValueAt(fila, 1).toString());
        } catch (ArrayIndexOutOfBoundsException e) {
            DesktopNotify.showDesktopMessage("   Informacion   ", "   Seleccione una cuenta o desactive el boton descontar cuenta", DesktopNotify.INFORMATION, 5000);

        }

        try {
            descuento = Double.valueOf(OperacionesUtiles.formatoDouble(Double.valueOf(formularioRegistrarVenta.getTxtDescuento().getText())));
        } catch (java.lang.NumberFormatException e) {
        }

        try {
            pagado = Double.valueOf(OperacionesUtiles.formatoDouble(Double.valueOf(formularioRegistrarVenta.getTxtPago().getText())));

        } catch (java.lang.NumberFormatException e) {

        }

        Double compraDescuento = totalCompra - (descuento);
        Double pagadoDescuento = compraDescuento - (pagado);

        Double nuevoBalance = balance - pagadoDescuento;
        formularioRegistrarVenta.getLblNuevoBalance().setText(OperacionesUtiles.formatoDouble(nuevoBalance));
    }

    private void balanceEditar() {
        Double descuento = 0.00;
        Double pagado = 0.00;
        Double balance = 0.00;
        int fila = formularioEditarVenta.getTablaGraficaDescontarCuenta().getSelectedRow();
        Double totalCompra = Double.valueOf(formularioEditarVenta.getLblPrecioTotal().getText());
        try {
            balance = Double.valueOf(formularioEditarVenta.getTablaGraficaDescontarCuenta().getValueAt(fila, 1).toString());
        } catch (ArrayIndexOutOfBoundsException e) {
            DesktopNotify.showDesktopMessage("   Informacion   ", "   Seleccione una cuenta o desactive el boton descontar cuenta", DesktopNotify.INFORMATION, 5000);

        }

        try {
            descuento = Double.valueOf(OperacionesUtiles.formatoDouble(Double.valueOf(formularioEditarVenta.getTxtDescuento().getText())));
        } catch (java.lang.NumberFormatException e) {
        }

        try {
            pagado = Double.valueOf(OperacionesUtiles.formatoDouble(Double.valueOf(formularioEditarVenta.getTxtPago().getText())));

        } catch (java.lang.NumberFormatException e) {

        }

        Double compraDescuento = totalCompra - (descuento);
        Double pagadoDescuento = compraDescuento - (pagado);

        Double nuevoBalance = balance - pagadoDescuento;
        formularioEditarVenta.getLblNuevoBalance().setText(OperacionesUtiles.formatoDouble(nuevoBalance));

    }

    public Venta_MovimientoCuenta obtenerVenta_MovimientoCuenta() {
        setConsultaObject("from Venta_MovimientoCuenta where ventaId=" + this.idVenta);
        obtenerObjetoConsulta();
        Object ventaMovimiento = getObjetoResultado();
        Venta_MovimientoCuenta vm = (Venta_MovimientoCuenta) ventaMovimiento;
        return vm;
    }

    public Integer obtenerIdCuenta() {
        try {
            setConsultaObject("from Venta_MovimientoCuenta where ventaId=" + this.idVenta);
            obtenerObjetoConsulta();
            Object ventaMovimiento = getObjetoResultado();
            Venta_MovimientoCuenta vm = (Venta_MovimientoCuenta) ventaMovimiento;
            Integer idCuenta = vm.getMovimientoCuentaId().getCodigoCuenta().getIdCuenta();
            return idCuenta;
        } catch (NullPointerException e) {
        }
        return null;
    }

    public void evaluarDescuentoPrevio() {
        Venta_MovimientoCuenta vm = obtenerVenta_MovimientoCuenta();
        if (vm != null) {
            transferirDatos(vm.getMovimientoCuentaId().getCodigoCuenta().getIdCuenta());
        }
    }

    private void transferirDatos(Integer idCuenta) {
        this.setIdCuentaPrevia(idCuenta);
        this.setFirst(true);
        formularioEditarVenta.getRadBtnDescontar().setText("CAMBIAR DE CUENTA");
        setTabla(formularioEditarVenta.getTablaGraficaDescontarCuenta());
        setStringConsulta("from Cuenta where idCuenta=" + idCuenta);
        evaluarEstadoConsulta();
        rellenarTabla("");
        formularioEditarVenta.getTablaGraficaDescontarCuenta().setEnabled(false);
    }

}
