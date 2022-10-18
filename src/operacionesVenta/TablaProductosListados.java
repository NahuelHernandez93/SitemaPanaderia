package operacionesVenta;

import calsesPadre.Tabla;
import clasesUtilidadGeneral.OperacionesUtiles;
import conexion.ConexionHibernate;
import ds.desktop.notify.DesktopNotify;
import entidades.Direccion_Cliente;
import entidades.PrecioProducto;
import entidades.Producto_Venta;
import entidades.TelefonoCliente;
import entidades.Venta;
import escritorios.PrincipalVenta;
import formularios.FormularioEditarVenta;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

/**
 * @author Hasper Franco
 */
public class TablaProductosListados extends Tabla {

    public TablaProductosListados() {
        setEstadoConsulta(0);
    }

    private Integer idVenta;
    private PrincipalVenta principalVenta;

    private TablaProductosDisponibles tablaProductosDisponibles;

    private List<Integer> listaProductosListados = new ArrayList<Integer>();

    private FormularioEditarVenta formularioEditarVenta;

    private JTable tablaProductosListados;

    private int tipoFormulario;

    private List<Producto_Venta> listaProductosEliminar;

    public List<Producto_Venta> getListaProductosEliminar() {
        return listaProductosEliminar;
    }

    public void setListaProductosEliminar(List<Producto_Venta> listaProductosEliminar) {
        this.listaProductosEliminar = listaProductosEliminar;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public JTable getTablaProductosListados() {
        return tablaProductosListados;
    }

    public void setTablaProductosListados(JTable tablaProductosListados) {
        this.tablaProductosListados = tablaProductosListados;
    }

    public PrincipalVenta getPrincipalVenta() {
        return principalVenta;
    }

    public void setPrincipalVenta(PrincipalVenta principalVenta) {
        this.principalVenta = principalVenta;
    }

    public TablaProductosDisponibles getTablaProductosDisponibles() {
        return tablaProductosDisponibles;
    }

    public void setTablaProductosDisponibles(TablaProductosDisponibles tablaProductosDisponibles) {
        this.tablaProductosDisponibles = tablaProductosDisponibles;
    }

    public List<Integer> getListaProductosListados() {
        return listaProductosListados;
    }

    public void setListaProductosListados(List<Integer> listaProductosListados) {
        this.listaProductosListados = listaProductosListados;
    }

    public int getTipoFormulario() {
        return tipoFormulario;
    }

    public void setTipoFormulario(int tipoFormulario) {
        this.tipoFormulario = tipoFormulario;
    }

    public FormularioEditarVenta getFormularioEditarVenta() {
        return formularioEditarVenta;
    }

    public void setFormularioEditarVenta(FormularioEditarVenta formularioEditarVenta) {
        this.formularioEditarVenta = formularioEditarVenta;
    }

    /**
     * ejecuta los metodos necesarios para listar un nuevo producto en la tabla
     * productos listados.
     */
    public void ejecutarAgregarProducto() {
        switch (tipoFormulario) {
            case 1:
                setTabla(principalVenta.getFromularioRegistrarVenta().getTablaGraficaProductosDisponibles());
                setTablaProductosListados(principalVenta.getFromularioRegistrarVenta().getTablaListarProductos());
                agregarProducto();
                break;

            case 2:
                setTabla(principalVenta.getFormularioEditarVenta().getTablaGraficaProductosDisponibles());
                setTablaProductosListados(principalVenta.getFormularioEditarVenta().getTablaListarProductos());
                agregarProducto();
                break;

        }

    }

    public void vaciarTabla() {
        DefaultTableModel tablaProductosListados = (DefaultTableModel) getTablaProductosListados().getModel();
        operacionesUtilidad.removerFilas(tablaProductosListados);
        try {
            this.listaProductosListados.clear();
        } catch (NullPointerException e) {
        }
    }

    public void agregarProducto() {
        DefaultTableModel tablaProductosListados = (DefaultTableModel) getTablaProductosListados().getModel();
        DefaultTableModel tablaProductosDisponibles = (DefaultTableModel) getTabla().getModel();
        int filaSeleccionada = getTabla().getSelectedRow();
        Vector<Object> fila = new Vector<>();
        fila.add(tablaProductosDisponibles.getValueAt(filaSeleccionada, 0).toString());
        Double total;
        switch (tipoFormulario) {
            case 1:
                fila.add(principalVenta.getFromularioRegistrarVenta().getTxtCantidad().getText());
                total = Double.valueOf(tablaProductosDisponibles.getValueAt(filaSeleccionada, 2).toString()) * Double.valueOf(principalVenta.getFromularioRegistrarVenta().getTxtCantidad().getText());
                fila.add(OperacionesUtiles.formatoDouble(total));
                tablaProductosListados.addRow(fila);
                break;
            case 2:
                fila.add(principalVenta.getFormularioEditarVenta().getTxtCantidad().getText());
                total = Double.valueOf(tablaProductosDisponibles.getValueAt(filaSeleccionada, 2).toString()) * Double.valueOf(principalVenta.getFormularioEditarVenta().getTxtCantidad().getText());
                fila.add(OperacionesUtiles.formatoDouble(total));
                tablaProductosListados.addRow(fila);
                break;
        }
        conexion();
    }

    /**
     * abre una conexion para obtener la id de los prouctos listados desde
     * precio_producto
     */
    private void conexion() {
        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            miSesion.beginTransaction();
            agregarIdsEnLista(miSesion);
            miSesion.getTransaction().commit();
        } catch (Exception e) {
        }
    }

    public void agregarIdsEnLista(Session miSesion) {
        Integer totalFilasProductosDisponibles = getTabla().getRowCount();
        Integer filasSeleccionadaProductosDisponibles = getTabla().getSelectedRow();
        List<Integer> listaResutadosActuales = tablaProductosDisponibles.getListaResutladosActuales();
        Integer id = operacionesUtilidad.obtenerId(listaResutadosActuales, totalFilasProductosDisponibles, filasSeleccionadaProductosDisponibles);
        PrecioProducto prepro = (PrecioProducto) miSesion.get(PrecioProducto.class, id);
        Integer idProductosDisponibles = prepro.getCodigoProducto().getIdProducto();
        listaProductosListados.add(idProductosDisponibles);
    }

    public void quitarProducto() {
        quitarIdsEnLista();
        DefaultTableModel tablaProductosListados = (DefaultTableModel) getTablaProductosListados().getModel();
        int filaSeleccionada = getTablaProductosListados().getSelectedRow();
        tablaProductosListados.removeRow(filaSeleccionada);
    }

    public void quitarIdsEnLista() {
        DefaultTableModel tablaProductosListados = (DefaultTableModel) getTablaProductosListados().getModel();
        int filaSeleccionada = getTablaProductosListados().getSelectedRow();
        listaProductosListados.remove(filaSeleccionada);
    }

    /**
     * Agrega la id del producto listado en un arreglo que se usara para guardar
     * en el registro de venta en la bd.
     *
     * @author Hasper Franco
     * @version 1.0
     * @since 2020-12-07
     */
    @Override
    public boolean verificarFilaSeleccionada() {

        switch (tipoFormulario) {
            case 1:
                try {
                    int fila = principalVenta.getFromularioRegistrarVenta().getTablaListarProductos().getSelectedRow();
                    principalVenta.getFromularioRegistrarVenta().getTablaListarProductos().getValueAt(fila, 0).toString();
                    return true;
                } catch (Exception e) {
                    DesktopNotify.showDesktopMessage("  Iinformación   ", " Debe seleccionar una fila ", DesktopNotify.INFORMATION, 5000);
                    return false;
                }

            case 2:
                try {
                    int fila = principalVenta.getFormularioEditarVenta().getTablaListarProductos().getSelectedRow();
                    principalVenta.getFormularioEditarVenta().getTablaListarProductos().getValueAt(fila, 0).toString();
                    return true;
                } catch (Exception e) {
                    DesktopNotify.showDesktopMessage("  Iinformación   ", " Debe seleccionar una fila ", DesktopNotify.INFORMATION, 5000);
                    return false;
                }
        }
        return false;

    }

    public boolean verificarValor() {
        switch (tipoFormulario) {
            case 1:
                if (principalVenta.getFromularioRegistrarVenta().getTxtCantidad().getText().equals("")) {
                    DesktopNotify.showDesktopMessage("  Iinformación   ", " El campo (cantidad) debe contener un valor ", DesktopNotify.INFORMATION, 5000);
                    return false;
                } else {
                    return true;
                }
            case 2:
                if (principalVenta.getFormularioEditarVenta().getTxtCantidad().getText().equals("")) {
                    DesktopNotify.showDesktopMessage("  Iinformación   ", " El campo (cantidad) debe contener un valor ", DesktopNotify.INFORMATION, 5000);
                    return false;
                } else {
                    return true;
                }
        }
        return false;
    }

    @Deprecated
    @Override
    public Integer obtenerIdFilaSeleccionada() {
        return 0;
    }

    public void autoRellenarDatosSecundarios() {
        setConsultaObject("from Venta where idVenta=" + this.idVenta.toString());
        obtenerObjetoConsulta();
        rellenarCampos();
    }

    private void rellenarCampos() {
        Object objeto = this.getObjetoResultado();
        Venta v = (Venta) objeto;
        formularioEditarVenta.getTxtPago().setText(v.getPagado().toString());
        formularioEditarVenta.getTxtDescuento().setText(v.getDescuento().toString());
        formularioEditarVenta.getLblVuelto().setText(v.getVuelto().toString());
    }

    @Override
    public void ejecutarRellenarTabla() {
        setTabla(formularioEditarVenta.getTablaGraficaProductosListados());
        setStringConsulta("from Producto_Venta where codigoVenta=" + this.idVenta.toString());
        evaluarEstadoConsulta();
        setCampoTexto(formularioEditarVenta.getTxtBuscar());
        rellenarTabla(getCampoTexto().getText());
    }

    @Override
    public void rellenarTabla(String valorBusqueda) {
        Double sumaTotal = 0.0;
        Date fechaVenta = new Date();

        DefaultTableModel tablaProducto = (DefaultTableModel) getTabla().getModel();
        List lista = this.getListaResultados();
        this.setListaProductosEliminar(lista);
        operacionesUtilidad.removerFilas(tablaProducto);

        try {
            this.listaProductosListados.clear();
        } catch (NullPointerException e) {
        }

        for (Object o : lista) {

            Producto_Venta p = (Producto_Venta) o;
            Vector<Object> fila = new Vector<>();
            boolean resultadoComparacion = OperacionesUtiles.convertirResultado(p.getCodigoProducto().getNombre(), valorBusqueda);
            if (resultadoComparacion) {
                //caso especial :v
                this.listaProductosListados.add(0, p.getCodigoProducto().getIdProducto());
                fila.add(p.getCodigoProducto().getNombre());
                fila.add(p.getTotalUnidades());
                fila.add(OperacionesUtiles.formatoDouble(p.getPrecioTotal()));
                tablaProducto.addRow(fila);

                //SECCION DATOS SECUNDARIOS CAMBIAR DE LUGAR 
                sumaTotal += p.getPrecioTotal();
                fechaVenta = p.getCodigoVenta().getFechaHoraVenta();

            }
        }
        OperacionesUtiles.ordenarLista(listaProductosListados);
        totalFecha(sumaTotal, fechaVenta);
    }

    private void totalFecha(Double sumaTotal, Date fecha) {
        formularioEditarVenta.getLblPrecioTotal().setText(OperacionesUtiles.formatoDouble(sumaTotal));
        formularioEditarVenta.getrSDateChooser().setDatoFecha(fecha);

    }

}
