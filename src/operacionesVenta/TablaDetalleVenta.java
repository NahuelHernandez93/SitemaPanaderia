package operacionesVenta;

import calsesPadre.Tabla;
import clasesUtilidadGeneral.OperacionesUtiles;
import entidades.PrecioProducto;
import entidades.Producto_Venta;
import escritorios.PrincipalVenta;
import formularios.FormularioDetalleDeVenta;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 * @author Hasper Franco
 */
public class TablaDetalleVenta extends Tabla {

    private Integer idVenta;

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    //listaresultadosActuales es para evitar realizar consultas cada vez que se tipea 1 caracter, aca no se tipea nada por eso no se usa,
    //setEstado consulta 0 es para cuando se realiza una edicion, reg, o elimina entonces aca tampoco se usa.
    private PrincipalVenta principalVenta;

    public PrincipalVenta getPrincipalVenta() {
        return principalVenta;
    }

    public void setPrincipalVenta(PrincipalVenta principalVenta) {
        this.principalVenta = principalVenta;
    }

    /**
     * Rellena los labels y la tabla de DetalleDeVenta con los datos de la fila
     * de la ventana Venta seleccionada.
     */
    @Override
    public void ejecutarRellenarTabla() {
        Integer id = principalVenta.getTablaVenta().obtenerIdFilaSeleccionada();
        setIdVenta(id);
        setConsultaObject("from Producto_Venta where codigo_venta=" + id);
        obtenerObjetoConsulta();
        rellenarLabelsDetalleDeVenta(principalVenta.getFormularioDetalleVenta());

        setTabla(principalVenta.getFormularioDetalleVenta().getTablaListaProductos());
        setConsultaList("from Producto_Venta where codigo_venta=" + id);
        obtenerListaConsulta();
        rellenarTabla("");
    }

    @Override
    public void rellenarTabla(String valorBusqueda) {
        DefaultTableModel tablaDetallesVenta = (DefaultTableModel) getTabla().getModel();
        List lista = this.getListaResultados();
        OperacionesUtiles.removerFilas(tablaDetallesVenta);
        for (Object o : lista) {
            Producto_Venta pr = (Producto_Venta) o;
            Vector<Object> fila = new Vector<>();
            fila.add(pr.getCodigoProducto().getNombre());
            fila.add(pr.getTotalUnidades());
            fila.add(pr.getPrecioTotal());
            tablaDetallesVenta.addRow(fila);
        }
    }

    public void rellenarLabelsDetalleDeVenta(FormularioDetalleDeVenta f) {
        Object objeto = this.getObjetoResultado();
        Producto_Venta pro = (Producto_Venta) objeto;
        try {
            f.getLblCliente().setText(pro.getCodigoVenta().getCodigoCliente().getNombre() + "  " + pro.getCodigoVenta().getCodigoCliente().getApellido());
            f.getLblFecha().setText(OperacionesUtiles.formatoFecha(pro.getCodigoVenta().getFechaHoraVenta()).toString());
            f.getLblTipoVenta().setText(pro.getCodigoVenta().getCodigoTipoVenta().getNombre());
            f.getLblImporteTotal().setText(pro.getCodigoVenta().getPrecioTotal().toString());
            f.getLblPagado().setText(pro.getCodigoVenta().getPagado().toString());
            f.getLblDescuento().setText(pro.getCodigoVenta().getDescuento().toString());
            f.getLblVuelto().setText(pro.getCodigoVenta().getVuelto().toString());
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }

    @Deprecated
    @Override
    public boolean verificarFilaSeleccionada() {
        return true;
    }

    @Deprecated
    @Override
    public Integer obtenerIdFilaSeleccionada() {
        return 0;
    }

}
