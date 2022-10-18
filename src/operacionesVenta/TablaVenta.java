package operacionesVenta;

import calsesPadre.Tabla;
import clasesUtilidadGeneral.OperacionesUtiles;
import ds.desktop.notify.DesktopNotify;
import entidades.Cliente;
import entidades.Direccion_Cliente;
import entidades.PrecioProducto;
import entidades.Producto;
import entidades.Producto_Venta;
import entidades.TelefonoCliente;
import entidades.Venta;
import escritorios.PrincipalCliente;
import escritorios.PrincipalVenta;
import formularios.FormularioEditarVenta;
import formularios.FormularioRegistrarVenta;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import operacionesCliente.TablaCliente;

/**
 *
 * @author TELCOM MPC
 */
public class TablaVenta extends Tabla {

    public TablaVenta() {
        setEstadoConsulta(0);
    }

    private PrincipalVenta principalVenta;
    private PrincipalCliente principalCliente;
    private List<Integer> listaResutladosActuales = new ArrayList<Integer>();
    

    public PrincipalVenta getPrincipalVenta() {
        return principalVenta;
    }

    public void setPrincipalVenta(PrincipalVenta principalVenta) {
        this.principalVenta = principalVenta;
    }

    public List<Integer> getListaResutladosActuales() {
        return listaResutladosActuales;
    }

    public void setListaResutladosActuales(List<Integer> listaResutladosActuales) {
        this.listaResutladosActuales = listaResutladosActuales;
    }

    /**
     * Ejecuata los metodos necesarios para rellenar la tabla de la ventana
     * PrincipalCliente.
     *
     * @param p
     */
    @Override
    public void ejecutarRellenarTabla() {
        setTabla(principalVenta.getTablaGrafica());
        setStringConsulta("from Venta");
        evaluarEstadoConsulta();
        setCampoTexto(principalVenta.getTxtBuscar());
        rellenarTabla(getCampoTexto().getText());
    }

    @Override
    public Integer obtenerIdFilaSeleccionada() {
        try {
            Integer totalFilas = principalVenta.getTablaGrafica().getRowCount();
            Integer filasSeleccionada = principalVenta.getTablaGrafica().getSelectedRow();
            List<Integer> listaResutadosActualesThis = principalVenta.getTablaVenta().getListaResutladosActuales();
            Integer id = operacionesUtilidad.obtenerId(listaResutadosActualesThis, totalFilas, filasSeleccionada);
            this.setIdTabla(id);
        } catch (Exception e) {
        }
        return idTabla;
    }

    @Override
    public void rellenarTabla(String valorBusqueda) {
        DefaultTableModel tablaVenta = (DefaultTableModel) getTabla().getModel();
        List lista = this.getListaResultados();
        operacionesUtilidad.removerFilas(tablaVenta);

        try {
            this.listaResutladosActuales.clear();
        } catch (NullPointerException e) {
        }

        for (Object o : lista) {
            Venta vnt = (Venta) o;
            Integer resutadoComparacion = (vnt.getFechaHoraVenta().toString().indexOf(valorBusqueda));
            Vector<Object> fila = new Vector<>();
            /**
             * pedidos pendienntes*
             */
            if (vnt.getCodigoEstado().getIdEstado() != 2 && resutadoComparacion.equals(0)) {
                if (principalVenta.getRadButonSoloPedidos().isSelected()) {
                    if (principalVenta.getRadButtonPendientes().isSelected()) {
                        if ((vnt.getCodigoTipoVenta().getNombre().equals("pedido")) && (vnt.getCodigoEstado().getValor().equals("pendiennte"))) {

                            if (vnt.getCodigoCliente().getNombre().equals("Consumidor Final")) {
                                fila.add(vnt.getCodigoCliente().getNombre());
                            } else {
                                fila.add(vnt.getCodigoCliente().getNombre() + " " + vnt.getCodigoCliente().getApellido());
                            }
                            this.listaResutladosActuales.add(0, vnt.getIdVenta());
                            fila.add(OperacionesUtiles.formatoFecha(vnt.getFechaHoraVenta()));
                            fila.add(OperacionesUtiles.formatoDouble(vnt.getPrecioTotal()));
                            fila.add(vnt.getCodigoTipoVenta().getNombre());
                            fila.add(vnt.getCodigoEstado().getValor());
                            tablaVenta.addRow(fila);

                        }
                        /**
                         * pedidos todos*
                         */
                    } else {
                        if (vnt.getCodigoTipoVenta().getNombre().equals("pedido")) {
                            if (vnt.getCodigoCliente().getNombre().equals("Consumidor Final")) {
                                fila.add(vnt.getCodigoCliente().getNombre());
                            } else {
                                fila.add(vnt.getCodigoCliente().getNombre() + " " + vnt.getCodigoCliente().getApellido());
                            }
                            this.listaResutladosActuales.add(0, vnt.getIdVenta());
                            fila.add(OperacionesUtiles.formatoFecha(vnt.getFechaHoraVenta()));
                            fila.add(OperacionesUtiles.formatoDouble(vnt.getPrecioTotal()));
                            fila.add(vnt.getCodigoTipoVenta().getNombre());
                            fila.add(vnt.getCodigoEstado().getValor());
                            tablaVenta.addRow(fila);
                        }
                    }
                } else {
                    if (vnt.getCodigoCliente().getNombre().equals("Consumidor Final")) {
                        fila.add(vnt.getCodigoCliente().getNombre());
                    } else {
                        fila.add(vnt.getCodigoCliente().getNombre() + " " + vnt.getCodigoCliente().getApellido());
                    }
                    this.listaResutladosActuales.add(0, vnt.getIdVenta());
                    fila.add(OperacionesUtiles.formatoFecha(vnt.getFechaHoraVenta()));
                    fila.add(OperacionesUtiles.formatoDouble(vnt.getPrecioTotal()));
                    fila.add(vnt.getCodigoTipoVenta().getNombre());
                    fila.add(vnt.getCodigoEstado().getValor());
                    tablaVenta.addRow(fila);
                }
            }

        }
        OperacionesUtiles.ordenarLista(listaResutladosActuales);
    }

    @Override
    public boolean verificarFilaSeleccionada() {
        try {
            int fila = principalVenta.getTablaGrafica().getSelectedRow();
            principalVenta.getTablaGrafica().getValueAt(fila, 0).toString();
            return true;
        } catch (Exception e) {
            DesktopNotify.showDesktopMessage("Informacion", "Debe seleccionar una fila", DesktopNotify.INFORMATION, 5000);
            return false;
        }
    }

    public void rellenarTablaProductoSinFeha() {
        DefaultTableModel tablaPrducto = (DefaultTableModel) getTabla().getModel();
        List lista = this.getListaResultados();
        OperacionesUtiles.removerFilas(tablaPrducto);
        List<PrecioProducto> lista_producto
                = (List<PrecioProducto>) lista;
        for (Object o : lista_producto) {

            PrecioProducto pr = (PrecioProducto) o;
            if (pr.getCodigoEstado().getIdEstado().equals(1)) {
                Vector<Object> fila = new Vector<>();
                fila.add(pr.getCodigoProducto().getIdProducto());
                fila.add(pr.getCodigoProducto().getNombre());
                fila.add(pr.getCodigoProducto().getDescripcion());
                fila.add(pr.getPrecioTotal());
                tablaPrducto.addRow(fila);

            }
        }
    }

    public void rellenarTablaProductoSinFechaBusqueda() {
        DefaultTableModel tablaPrducto = (DefaultTableModel) getTabla().getModel();
        List lista = this.getListaResultados();
        OperacionesUtiles.removerFilas(tablaPrducto);
        List<Producto> lista_producto
                = (List<Producto>) lista;

        for (Producto pr : lista_producto) {
            List<PrecioProducto> listaPre = pr.getPrecios();

            for (PrecioProducto p : listaPre) {

                if (p.getCodigoEstado().getIdEstado().equals(1)) {
                    Vector<Object> fila = new Vector<>();
                    fila.add(p.getCodigoProducto().getIdProducto());
                    fila.add(p.getCodigoProducto().getNombre());
                    fila.add(p.getCodigoProducto().getDescripcion());
                    fila.add(String.valueOf(p.getPrecioTotal()));
                    tablaPrducto.addRow(fila);
                }

            }
        }
    }



    public void ejecutarRellenarDatosEditarVenta(FormularioEditarVenta f) {

        Integer totalFilas = principalVenta.getTablaGrafica().getRowCount();
        Integer filasSeleccionada = principalVenta.getTablaGrafica().getSelectedRow();
        List<Integer> listaResutadosActuales = principalVenta.getTablaVenta().getListaResutladosActuales();
        Integer id = operacionesUtilidad.obtenerId(listaResutadosActuales, totalFilas, filasSeleccionada);

        setTabla(f.getTablaListarProductos());
        setConsultaList("from Producto_Venta where codigo_venta=" + id);
        obtenerListaConsulta();
        rellenarTablaListaProducto();
        setTabla(f.getTablaGraficaCliente());
        setConsultaObject("from Producto_Venta where codigo_venta=" + id);
        obtenerObjetoConsulta();
        cambiarEstadoBoxTipoVenta(f);
        insertarFechaVenta(f);
        rellenatTablaClienteFormularioEditar();

    }

    public void insertarFechaVenta(FormularioEditarVenta f) {
        Object objeto = this.getObjetoResultado();
        Producto_Venta pr = (Producto_Venta) objeto;
        try {
            f.getrSDateChooser().setDatoFecha(pr.getCodigoVenta().getFechaHoraVenta());
        } catch (NullPointerException e) {
        }

    }

    public void cambiarEstadoBoxTipoVenta(FormularioEditarVenta f) {
        Object objeto = this.getObjetoResultado();
        Producto_Venta pr = (Producto_Venta) objeto;
        try {
            switch (pr.getCodigoVenta().getCodigoTipoVenta().getIdTipoVenta()) {
                case (1):
                    f.getBoxTipoVenta().setSelectedIndex(0);
                    break;
                case (2):
                    f.getBoxTipoVenta().setSelectedIndex(1);
            }
        } catch (NullPointerException e) {
        }

    }



    public void rellenatTablaClienteFormularioEditar() {
        try {

            DefaultTableModel tablaCliente = (DefaultTableModel) getTabla().getModel();
            OperacionesUtiles.removerFilas(tablaCliente);
            Integer vueltaDir = 0;
            Integer vueltaTel = 0;
            Object objeto = this.getObjetoResultado();
            Producto_Venta pr = (Producto_Venta) objeto;

            Vector<Object> fila = new Vector<>();
            fila.add(pr.getCodigoVenta().getCodigoCliente().getNombre() + " - " + pr.getCodigoVenta().getCodigoCliente().getApellido());

            List<Direccion_Cliente> direcciones = pr.getCodigoVenta().getCodigoCliente().getDireccionesclientes();
            List<TelefonoCliente> telefonos = pr.getCodigoVenta().getCodigoCliente().getTelefonos();

            if (pr.getCodigoVenta().getCodigoCliente().getTelefonos().size() == 0) {
                fila.add("ningun registro encontrado");
            } else {
                for (TelefonoCliente tlcl : telefonos) {
                    if (vueltaTel != 1) {
                        fila.add(tlcl.getNuemero() + " / " + tlcl.getCodigoTipoTelefono().getNombre());
                        vueltaTel = 1;
                    }
                }
            }

            if (pr.getCodigoVenta().getCodigoCliente().getDireccionesclientes().size() == 0) {
                fila.add("ningun registro encontrado");
            } else {
                for (Direccion_Cliente drCl : direcciones) {
                    if (vueltaDir != 1) {
                        fila.add(drCl.getNombre() + " - " + drCl.getNumero() + " - " + drCl.getCodigoLocalidad().getNombre());
                        vueltaDir = 1;
                    }
                }
            }
            vueltaDir = 0;
            vueltaTel = 0;
            tablaCliente.addRow(fila);

        } catch (NullPointerException e) {

        }

    }



    public void rellenarTablaListaProducto() {
        DefaultTableModel tablaDetallesVenta = (DefaultTableModel) getTabla().getModel();
        List lista = this.getListaResultados();
        OperacionesUtiles.removerFilas(tablaDetallesVenta);
        for (Object o : lista) {
            Producto_Venta pr = (Producto_Venta) o;
            Vector<Object> fila = new Vector<>();
            fila.add(pr.getCodigoProducto().getIdProducto());
            fila.add(pr.getCodigoProducto().getNombre());
            fila.add(pr.getTotalUnidades());
            List<PrecioProducto> precios
                    = pr.getCodigoProducto().getPrecios();
            for (PrecioProducto pre : precios) {
                if (pre.getCodigoEstado().getIdEstado().equals(1)) {
                    fila.add(pr.getTotalUnidades() * pre.getPrecioTotal());
                }
            }
            tablaDetallesVenta.addRow(fila);
        }
    }

    public void ejecutarRellenarTablaProductoSinFecha(FormularioRegistrarVenta p) {
//        setTabla(p.getTablaBuscarProducto());
//        setConsultaList("from PrecioProducto");
//        obtenerListaConsulta();
//        rellenarTablaProductoSinFeha();
    }

    public void ejecutarRellenarTablaProductoSinFecha(FormularioEditarVenta p) {
        setTabla(p.getTablaBuscarProducto());
        setConsultaList("from PrecioProducto");
        obtenerListaConsulta();
        rellenarTablaProductoSinFeha();
    }

    public void ejecutarRellenarTablaProductoSinFechaBusqueda(FormularioRegistrarVenta f) {
//        setTabla(f.getTablaBuscarProducto());
//        if (f.getTxtBuscar().getText().equals("")) {
//            setConsultaList("from PrecioProducto");
//            obtenerListaConsulta();
//            rellenarTablaProductoSinFeha();
//        } else {
//            setConsultaList("from Producto where nombre like '" + f.getTxtBuscar().getText() + "%'");
//            obtenerListaConsulta();
//            rellenarTablaProductoSinFechaBusqueda();
//        }
    }

    public void ejecutarRellenarTablaProductoSinFechaBusqueda(FormularioEditarVenta f) {
        setTabla(f.getTablaBuscarProducto());
        if (f.getTxtBuscar().getText().equals("")) {
            setConsultaList("from PrecioProducto");
            obtenerListaConsulta();
            rellenarTablaProductoSinFeha();
        } else {
            setConsultaList("from Producto where nombre like '" + f.getTxtBuscar().getText() + "%'");
            obtenerListaConsulta();
            rellenarTablaProductoSinFechaBusqueda();
        }
    }

    public boolean RellenarTablaClienteRegistrar(FormularioRegistrarVenta f) {
        if (new TablaCliente().verificarFilaSeleccionada()) {
            setTabla(f.getTablaCliente());
            Integer totalFilas = principalCliente.getTablaGrafica().getRowCount();
            Integer filasSeleccionada = principalCliente.getTablaGrafica().getSelectedRow();
            List<Integer> listaResutadosActualesThis = principalCliente.getTablaCliente().getListaResutladosActuales();
            Integer id = operacionesUtilidad.obtenerId(listaResutadosActualesThis, totalFilas, filasSeleccionada);

            setConsultaList("from Cliente where id_cliente=" + id);
            obtenerListaConsulta();
            rellenarTablaClientedeVenta();
            f.toFront();
            return true;
        }
        return false;
    }

    public boolean RellenarTablaClienteEditar(FormularioEditarVenta f) {
        if (new TablaCliente().verificarFilaSeleccionada()) {
            setTabla(f.getTablaGraficaCliente());
            Integer totalFilas = principalCliente.getTablaGrafica().getRowCount();
            Integer filasSeleccionada = principalCliente.getTablaGrafica().getSelectedRow();
            List<Integer> listaResutadosActualesThis = principalCliente.getTablaCliente().getListaResutladosActuales();
            Integer id = operacionesUtilidad.obtenerId(listaResutadosActualesThis, totalFilas, filasSeleccionada);

            setConsultaList("from Cliente where id_cliente=" + id);
            obtenerListaConsulta();
            rellenarTablaClientedeVenta();
            f.toFront();
            return true;
        }
        return false;
    }

    public void rellenarTablaClientedeVenta() {
        try {
            DefaultTableModel tablaCliente = (DefaultTableModel) getTabla().getModel();
            List lista = this.getListaResultados();
            operacionesUtilidad.removerFilas(tablaCliente);
            Integer vueltaDir = 0;
            Integer vueltaTel = 0;
            for (Object o : lista) {
                Cliente c = (Cliente) o;
                Vector<Object> fila = new Vector<>();
                fila.add(c.getNombre() + " - " + c.getApellido());

                List<Direccion_Cliente> direcciones = c.getDireccionesclientes();
                List<TelefonoCliente> telefonos = c.getTelefonos();

                //****************************//
                if (c.getTelefonos().size() == 0) {
                    fila.add("ningun registro encontrado");
                } else {
                    for (TelefonoCliente tlcl : telefonos) {
                        if (vueltaTel != 1) {
                            fila.add(tlcl.getNuemero() + " / " + tlcl.getCodigoTipoTelefono().getNombre());
                            vueltaTel = 1;
                        }
                    }
                }
                //****************************//
                if (c.getDireccionesclientes().size() == 0) {
                    fila.add("ningun registro encontrado");
                } else {
                    for (Direccion_Cliente drCl : direcciones) {
                        if (vueltaDir != 1) {
                            fila.add(drCl.getNombre() + " - " + drCl.getNumero() + " - " + drCl.getCodigoLocalidad().getNombre());
                            vueltaDir = 1;
                        }
                    }
                }

                vueltaDir = 0;
                vueltaTel = 0;
                tablaCliente.addRow(fila);
            }
        } catch (Exception e) {
        }

    }

}
