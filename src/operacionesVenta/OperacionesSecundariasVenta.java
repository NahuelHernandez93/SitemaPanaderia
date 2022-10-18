package operacionesVenta;

import calsesPadre.Consultas;
import clasesUtilidadGeneral.OperacionesUtiles;
import conexion.ConexionHibernate;
import ds.desktop.notify.DesktopNotify;
import entidades.Cliente;
import entidades.MovimientoCuenta;
import entidades.Venta_MovimientoCuenta;
import escritorios.PrincipalCliente;
import formularios.FormularioEditarVenta;
import formularios.FormularioRegistrarVenta;
import java.awt.Color;
import java.util.List;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

/**
 * @author Hasper Franco
 */
public class OperacionesSecundariasVenta extends Consultas {

    private int tipoFormulario;
    private FormularioRegistrarVenta formularioRegistrarVenta;
    private FormularioEditarVenta formularioEditarVenta;
    private PrincipalCliente principalCliente;

    public PrincipalCliente getPrincipalCliente() {
        return principalCliente;
    }

    public void setPrincipalCliente(PrincipalCliente principalCliente) {
        this.principalCliente = principalCliente;
    }

    public int getTipoFormulario() {
        return tipoFormulario;
    }

    public void setTipoFormulario(int tipoFormulario) {
        this.tipoFormulario = tipoFormulario;
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

    public void nuevaVentanaCliente() {

    }

    public void calcularVuelto() {

        switch (tipoFormulario) {
            case 1:
                vueltoRegistrar();
                break;
            case 2:
                vueltoEditar();
                break;
        }
    }

    public void mensajeTipoMovimiento(Double vuelto) {
        if (vuelto > 0) {

            DesktopNotify.showDesktopMessage("   Informacion   ", " Se agregara " + vuelto + " a la cuenta seleccionada", DesktopNotify.INFORMATION, 5000);
        } else if (vuelto < 0) {

            DesktopNotify.showDesktopMessage("   Informacion   ", " Se descontara " + vuelto + " de la cuenta seleccionada", DesktopNotify.INFORMATION, 5000);
        } else {
            DesktopNotify.showDesktopMessage("   Informacion   ", " No se realizaran movimientos en la cuenta seleccionada", DesktopNotify.INFORMATION, 5000);
        }
    }

    private void vueltoRegistrar() {
        Double sumaTotal = 0.00;
        Double pago = 0.00;
        Double descuento = 0.00;
        Double sumaConDescuento = 0.00;
        Double vuelto = 0.00;

        try {

            sumaTotal = Double.valueOf(formularioRegistrarVenta.getLblPrecioTotal().getText());
            pago = Double.valueOf(formularioRegistrarVenta.getTxtPago().getText());
            descuento = Double.valueOf(formularioRegistrarVenta.getTxtDescuento().getText());
            sumaConDescuento = sumaTotal - (descuento);
            vuelto = pago - (sumaConDescuento);
            formularioRegistrarVenta.getLblVuelto().setText(new OperacionesUtiles().formatoDouble(vuelto));
            colorLblVuelto(formularioRegistrarVenta.getLblVuelto(), vuelto);

        } catch (java.lang.NumberFormatException e) {

            sumaConDescuento = sumaTotal - (descuento);
            vuelto = pago - (sumaConDescuento);
            formularioRegistrarVenta.getLblVuelto().setText(new OperacionesUtiles().formatoDouble(vuelto));
            colorLblVuelto(formularioRegistrarVenta.getLblVuelto(), vuelto);
        }

    }

    public void colorLblVuelto(JLabel label, Double vuelto) {
        if (vuelto < 0.00) {
            label.setForeground(Color.red);
        } else if (vuelto > 0.00) {
            label.setForeground(Color.green);
        } else {
            label.setForeground(Color.black);
        }
    }

    private void vueltoEditar() {
        Double sumaTotal = 0.00;
        Double pago = 0.00;
        Double descuento = 0.00;
        Double sumaConDescuento = 0.00;
        Double vuelto = 0.00;
        try {

            sumaTotal = Double.valueOf(formularioEditarVenta.getLblPrecioTotal().getText());
            pago = Double.valueOf(formularioEditarVenta.getTxtPago().getText());
            descuento = Double.valueOf(formularioEditarVenta.getTxtDescuento().getText());
            sumaConDescuento = sumaTotal - (descuento);
            vuelto = pago - (sumaConDescuento);
            formularioEditarVenta.getLblVuelto().setText(new OperacionesUtiles().formatoDouble(vuelto));
            colorLblVuelto(formularioEditarVenta.getLblVuelto(), vuelto);
        } catch (java.lang.NumberFormatException e) {

            sumaConDescuento = sumaTotal - (descuento);
            vuelto = pago - (sumaConDescuento);
            formularioEditarVenta.getLblVuelto().setText(new OperacionesUtiles().formatoDouble(vuelto));
            colorLblVuelto(formularioEditarVenta.getLblVuelto(), vuelto);
        }

    }

    public void tipoVentaSeleccionada(String valor) {
        switch (tipoFormulario) {
            case 1:
                if (valor.equals("Pedido")) {
                    if (formularioRegistrarVenta.getRadButonConsumidorFinal().isSelected()) {
                        removerFilar();
                    }
                    formularioRegistrarVenta.getRadButonConsumidorFinal().setEnabled(false);
                    formularioRegistrarVenta.getRadButonConsumidorFinal().setSelected(false);
                    formularioRegistrarVenta.getBtnBuscarCliente().setEnabled(true);

                } else {
                    formularioRegistrarVenta.getRadButonConsumidorFinal().setEnabled(true);
                    // modeloTabla();
                }
                break;
            case 2:
                if (valor.equals("Pedido")) {
                    if (formularioEditarVenta.getRadButonConsumidorFinal().isSelected()) {
                         removerFilar();
                    }
                    formularioEditarVenta.getRadButonConsumidorFinal().setEnabled(false);
                    formularioEditarVenta.getRadButonConsumidorFinal().setSelected(false);
                    formularioEditarVenta.getBtnBuscarCliente().setEnabled(true);
                } else {
                    formularioEditarVenta.getRadButonConsumidorFinal().setEnabled(true);
                    //modeloTabla();
                }
                break;
        }
    }

    public void tipoConsumidorFinalEnabled() {
        switch (tipoFormulario) {
            case 1:
                if (formularioRegistrarVenta.getRadButonConsumidorFinal().isSelected()) {
                    formularioRegistrarVenta.getBtnBuscarCliente().setEnabled(false);
                    // modeloTabla();
                    datosventaSimpleConsumidorFinal();
                    deshabilitarBotonesCuenta();
                } else {
                    formularioRegistrarVenta.getBtnBuscarCliente().setEnabled(true);
                    //modeloTabla();
                    habilitarBotonesCuenta();
                    removerFilar();
                }
                break;
            case 2:
                if (formularioEditarVenta.getRadButonConsumidorFinal().isSelected()) {
                    formularioEditarVenta.getBtnBuscarCliente().setEnabled(false);
                    // modeloTabla();
                    datosventaSimpleConsumidorFinal();
                } else {
                    formularioEditarVenta.getBtnBuscarCliente().setEnabled(true);
                    removerFilar();
                    //   modeloTabla();
                }
                break;
        }

    }

    private void removerFilar() {
        switch (tipoFormulario) {
            case 1:
                DefaultTableModel tablaVentaCliente = (DefaultTableModel) formularioRegistrarVenta.getTablaCliente().getModel();
                OperacionesUtiles.removerFilas(tablaVentaCliente);
                break;
            case 2:
                DefaultTableModel tablaVentaClienteE = (DefaultTableModel) formularioEditarVenta.getTablaGraficaCliente().getModel();
                OperacionesUtiles.removerFilas(tablaVentaClienteE);
                break;
        }
    }

    public void transferirDatos(JTable tablaOrigen, JTable tablaDestino) {
        int fila = tablaOrigen.getSelectedRow();
        String nombreApellido = tablaOrigen.getValueAt(fila, 0).toString();
        String telefono = tablaOrigen.getValueAt(fila, 1).toString();
        String direccion = tablaOrigen.getValueAt(fila, 2).toString();

        DefaultTableModel tablaCliente = (DefaultTableModel) tablaDestino.getModel();
        OperacionesUtiles.removerFilas(tablaCliente);
        Vector datosTabla = new Vector();
        datosTabla.add(nombreApellido);
        datosTabla.add(telefono);
        datosTabla.add(direccion);
        tablaCliente.addRow(datosTabla);
    }

    public void rellenarTablaVentaCliente() {
        int fila = principalCliente.getTablaGrafica().getSelectedRow();
        String nombre = principalCliente.getTablaGrafica().getValueAt(fila, 0).toString() + " " + principalCliente.getTablaGrafica().getValueAt(fila, 1).toString();
        String telefono = principalCliente.getTablaGrafica().getValueAt(fila, 7).toString();
        String direccion = principalCliente.getTablaGrafica().getValueAt(fila, 3).toString() + "/" + principalCliente.getTablaGrafica().getValueAt(fila, 4).toString() + "-" + principalCliente.getTablaGrafica().getValueAt(fila, 5).toString() + "-" + principalCliente.getTablaGrafica().getValueAt(fila, 6).toString();

        switch (tipoFormulario) {
            case 1:
                DefaultTableModel tablaVentaCliente = (DefaultTableModel) formularioRegistrarVenta.getTablaCliente().getModel();
                OperacionesUtiles.removerFilas(tablaVentaCliente);
                Vector datosTabla = new Vector();
                datosTabla.add(nombre);
                datosTabla.add(telefono);
                datosTabla.add(direccion);
                tablaVentaCliente.addRow(datosTabla);
                break;
            case 2:
                DefaultTableModel tablaVentaClienteE = (DefaultTableModel) formularioEditarVenta.getTablaGraficaCliente().getModel();
                OperacionesUtiles.removerFilas(tablaVentaClienteE);
                Vector datosTablaE = new Vector();
                datosTablaE.add(nombre);
                datosTablaE.add(telefono);
                datosTablaE.add(direccion);
                tablaVentaClienteE.addRow(datosTablaE);
                break;
        }
    }

    public void datosventaSimpleConsumidorFinal() {
        switch (tipoFormulario) {
            case 1:
                DefaultTableModel tablaVentaCliente = (DefaultTableModel) formularioRegistrarVenta.getTablaCliente().getModel();
                OperacionesUtiles.removerFilas(tablaVentaCliente);
                Vector datosTabla = new Vector();
                datosTabla.add("Cons. Final");
                datosTabla.add("---");
                datosTabla.add("----");
                tablaVentaCliente.addRow(datosTabla);
                break;
            case 2:
                DefaultTableModel tablaVentaClienteE = (DefaultTableModel) formularioEditarVenta.getTablaGraficaCliente().getModel();
                OperacionesUtiles.removerFilas(tablaVentaClienteE);
                Vector datosTablaE = new Vector();
                datosTablaE.add("Cons. Final");
                datosTablaE.add("---");
                datosTablaE.add("----");
                tablaVentaClienteE.addRow(datosTablaE);
                break;
        }
    }

    @Deprecated
    private void modeloTabla() {
        switch (tipoFormulario) {

            case 1:
                Vector datosTabla = new Vector();
                Vector<String> encabezadoTabla = new Vector<>();
                encabezadoTabla.add("NOMBRE");
                encabezadoTabla.add("TELEFONO");
                encabezadoTabla.add("DIRECCION");
                formularioRegistrarVenta.getTablaCliente().setModel(new DefaultTableModel(datosTabla, encabezadoTabla));
                break;
            case 2:
                Vector datosTablaE = new Vector();
                Vector<String> encabezadoTablaE = new Vector<>();
                encabezadoTablaE.add("NOMBRE");
                encabezadoTablaE.add("TELEFONO");
                encabezadoTablaE.add("DIRECCION");
                formularioEditarVenta.getTablaGraficaCliente().setModel(new DefaultTableModel(datosTablaE, encabezadoTablaE));
                break;
        }

    }

    public void obtenerPrecioTotal() {

        switch (tipoFormulario) {
            case 1:
                try {
                    Double total = 0.00;
                    for (int i = 0; i < formularioRegistrarVenta.getTablaListarProductos().getRowCount(); i++) {
                        total = total + (Double.valueOf(formularioRegistrarVenta.getTablaListarProductos().getValueAt(i, 2).toString()));
                    }
                    formularioRegistrarVenta.getLblPrecioTotal().setText(OperacionesUtiles.formatoDouble(total));
                } catch (ArrayIndexOutOfBoundsException e) {
                    formularioRegistrarVenta.getLblPrecioTotal().setText("0.00");
                }
                break;
            case 2:
                try {
                    Double total = 0.00;
                    for (int i = 0; i < formularioEditarVenta.getTablaListarProductos().getRowCount(); i++) {
                        total = total + (Double.valueOf(formularioEditarVenta.getTablaListarProductos().getValueAt(i, 2).toString()));
                    }
                    formularioEditarVenta.getLblPrecioTotal().setText(OperacionesUtiles.formatoDouble(total));
                } catch (ArrayIndexOutOfBoundsException e) {
                    formularioEditarVenta.getLblPrecioTotal().setText("0.00");
                }
                break;
        }

    }

    public boolean validarListaProductos() {
        switch (tipoFormulario) {
            case 1:
                if (formularioRegistrarVenta.getTablaListarProductos().getRowCount() < 1) {

                    DesktopNotify.showDesktopMessage(" Informacion", " La tabla 'Productos Listados' debe contener almenos un producto", DesktopNotify.INFORMATION, 7000);
                    return false;
                } else {
                    return true;
                }

            case 2:
                if (formularioEditarVenta.getTablaListarProductos().getRowCount() < 1) {
                    DesktopNotify.showDesktopMessage(" Informacion", " La tabla 'Productos Listados' debe contener almenos un producto", DesktopNotify.INFORMATION, 7000);
                    return false;
                } else {
                    return true;
                }
        }
        return false;
    }

    public boolean validarFecha() {

        switch (tipoFormulario) {
            case 1:
                try {
                    if (formularioRegistrarVenta.getrSDateChooser().getDatoFecha() == null
                            || formularioRegistrarVenta.getrSDateChooser().getDatoFecha().equals(" ")) {
                        DesktopNotify.showDesktopMessage(" Informacion", " Debe seleccionar una fecha", DesktopNotify.INFORMATION, 7000);
                        return false;
                    } else {
                        return true;
                    }
                } catch (NullPointerException e) {
                    DesktopNotify.showDesktopMessage(" Informacion", " Debe seleccionar una fecha", DesktopNotify.INFORMATION, 7000);
                    return false;
                }
            case 2:
                try {
                    if (formularioEditarVenta.getrSDateChooser().getDatoFecha() == null
                            || formularioEditarVenta.getrSDateChooser().getDatoFecha().equals(" ")) {
                        DesktopNotify.showDesktopMessage(" Informacion", " Debe seleccionar una fecha", DesktopNotify.INFORMATION, 7000);
                        return false;
                    } else {
                        return true;
                    }
                } catch (NullPointerException e) {
                    DesktopNotify.showDesktopMessage(" Informacion", " Debe seleccionar una fecha", DesktopNotify.INFORMATION, 7000);
                    return false;
                }
        }
        return false;
    }

    public boolean validarTablaCliente() {
        switch (tipoFormulario) {
            case 1:
                if (formularioRegistrarVenta.getTablaCliente().getRowCount() < 1) {
                    DesktopNotify.showDesktopMessage(" Informacion", " Debe seleccionar un cliente o consumidor final", DesktopNotify.INFORMATION, 7000);
                    return false;
                } else {
                    return true;
                }
            case 2:
                if (formularioEditarVenta.getTablaGraficaCliente().getRowCount() < 1) {
                    DesktopNotify.showDesktopMessage(" Informacion", " Debe seleccionar un cliente o consumidor final", DesktopNotify.INFORMATION, 7000);
                    return false;
                } else {
                    return true;
                }
        }
        return false;
    }

    public void retornarFormularioVenta() {
        switch (tipoFormulario) {
            case 1:
                formularioRegistrarVenta.setPrincipalCliente(principalCliente);
                formularioRegistrarVenta.setVisible(true);
                formularioRegistrarVenta.toFront();

                break;
            case 2:
                formularioEditarVenta.setPrincipalCliente(principalCliente);
                formularioEditarVenta.setVisible(true);
                formularioEditarVenta.toFront();
                break;
        }
    }

    public void cuentaDisable() {
        if (formularioRegistrarVenta == null) {
            formularioEditarVenta.getRadBtnDescontar().setSelected(false);
            DefaultTableModel tablaCuenta = (DefaultTableModel) formularioEditarVenta.getTablaGraficaDescontarCuenta().getModel();
            new OperacionesUtiles().removerFilas(tablaCuenta);
            formularioEditarVenta.getLblNuevoBalance().setText("");
            formularioEditarVenta.setIdCuenta(null);
        } else {
            formularioRegistrarVenta.getRadBtnDescontar().setSelected(false);
            DefaultTableModel tablaCuenta = (DefaultTableModel) formularioRegistrarVenta.getTablaGraficaDescontarCuenta().getModel();
            new OperacionesUtiles().removerFilas(tablaCuenta);
            formularioRegistrarVenta.getLblNuevoBalance().setText("");
            formularioRegistrarVenta.setIdCuenta(null);
        }

    }

    public void deshabilitarBotonesCuenta() {
        if (formularioRegistrarVenta == null) {
            formularioEditarVenta.getRadBtnDescontar().setEnabled(false);
        } else {
            formularioRegistrarVenta.getRadBtnDescontar().setEnabled(false);

        }

    }

    private void habilitarBotonesCuenta() {
        if (formularioRegistrarVenta == null) {
            formularioEditarVenta.getRadBtnDescontar().setEnabled(true);
        } else {
            formularioRegistrarVenta.getRadBtnDescontar().setEnabled(true);

        }

    }

    /**
     * Se utiliza para calcular el balance a partir de una cuenta que ya se
     * utilizo previamente y no esta seleccionada en el formulario pero se
     * siguen agregando o quitando productos en la lista
     */
    public void ejecutarCalcularBalanceCuentaPrevio() {
        consultaMovimientoCuenta();
    }

    private void consultaMovimientoCuenta() {
        try {
            Venta_MovimientoCuenta vm = formularioEditarVenta.getTablaCuenta().obtenerVenta_MovimientoCuenta();
            Integer idMc = vm.getMovimientoCuentaId().getIdMovimientoCuenta();
            setConsultaObject("from MovimientoCuenta where idMovimientoCuenta=" + idMc);
            obtenerObjetoConsulta();
            calcularBalancePrevio();
        } catch (NullPointerException e) {
        }
    }

    public void calcularBalancePrevio() {
        Object movimientoCuenta = getObjetoResultado();
        MovimientoCuenta mc = (MovimientoCuenta) movimientoCuenta;

        Double descuento = 0.00;
        Double pagado = 0.00;
        Double balance = 0.00;
        Double totalCompra = 0.00;

        balance = mc.getCodigoCuenta().getBalance()- (mc.getMonto());

        try {
            totalCompra = Double.valueOf(formularioEditarVenta.getLblPrecioTotal().getText());
        } catch (java.lang.NumberFormatException e) {
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

}
