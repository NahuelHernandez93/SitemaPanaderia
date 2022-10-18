package operacionesVenta;

import calsesPadre.ABM;
import clasesUtilidadGeneral.OperacionesUtiles;
import conexion.ConexionHibernate;
import ds.desktop.notify.DesktopNotify;
import entidades.Cliente;
import entidades.Cuenta;
import entidades.Estado;
import entidades.MovimientoCuenta;
import entidades.Producto;
import entidades.Producto_Venta;
import entidades.TipoVenta;
import entidades.Venta;
import entidades.Venta_MovimientoCuenta;
import escritorios.PrincipalCliente;
import escritorios.PrincipalVenta;
import formularios.FormularioEditarVenta;
import formularios.FormularioEstadoVenta;
import formularios.FormularioRegistrarVenta;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JTextField;
import operacionesCuenta.ABMMovimientoCuenta;
import org.hibernate.Session;

/**
 *
 * @author FRANCO
 */
public class ABMVenta extends ABM {

    private List<Integer> listaProductosListados = new ArrayList<Integer>();
    private FormularioRegistrarVenta formularioRegistrarVenta;
    private FormularioEditarVenta formularioEditarVenta;
    private FormularioEstadoVenta formularioEstadoVenta;
    //se utiliza solo para eliminar
    private PrincipalVenta principalVenta;
    //para obtener el idCliente
    private PrincipalCliente principalCliente;
    //se borran todos los productos de listados y se vuelven a cargar desde cero
    private List<Producto_Venta> listaProductosEliminar;
    private Integer idCuenta;
    private Integer idVenta;

    public List<Producto_Venta> getListaProductosEliminar() {
        return listaProductosEliminar;
    }

    public void setListaProductosEliminar(List<Producto_Venta> listaProductosEliminar) {
        this.listaProductosEliminar = listaProductosEliminar;
    }

    public PrincipalCliente getPrincipalCliente() {
        return principalCliente;
    }

    public void setPrincipalCliente(PrincipalCliente principalCliente) {
        this.principalCliente = principalCliente;
    }

    public List<Integer> getListaProductosListados() {
        return listaProductosListados;
    }

    public void setListaProductosListados(List<Integer> listaProductosListados) {
        this.listaProductosListados = listaProductosListados;
    }

    public FormularioEstadoVenta getFormularioEstadoVenta() {
        return formularioEstadoVenta;
    }

    public void setFormularioEstadoVenta(FormularioEstadoVenta formularioEstadoVenta) {
        this.formularioEstadoVenta = formularioEstadoVenta;
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

    public PrincipalVenta getPrincipalVenta() {
        return principalVenta;
    }

    public void setPrincipalVenta(PrincipalVenta principalVenta) {
        this.principalVenta = principalVenta;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    @Override
    public boolean ejecutarRegistrar() {
        obtenerFormularioRegistrar();
        if (operacionesUtilidad.verificarCamposTextoVacios(getListaCampos())) {
            conexionTransaccionRegistrar();
            return true;
        }
        return false;
    }

    @Override
    public void obtenerFormularioRegistrar() {
        setFormularioRegistrar(this.getFormularioRegistrarVenta());
        List listCamposTexto = new ArrayList();
        JTextField simularCampo = new JTextField();
        simularCampo.setText("00");
        listCamposTexto.add(simularCampo);
        setListaCampos(listCamposTexto);
    }

    @Override
    public void obtenerFormularioEditar() {
        setFormularioEditar(this.getFormularioEditarVenta());
        List listCamposTexto = new ArrayList();
        JTextField simularCampo = new JTextField();
        simularCampo.setText("00");
        listCamposTexto.add(simularCampo);
        setListaCampos(listCamposTexto);
    }

    @Override
    public void transaccionRegistrar(Session miSesion) {
        Double totalunidades;
        Double precioTotal;
        Double pagado;
        Double descuento;
        Double vuelto;

        Venta v = new Venta();
        if (formularioRegistrarVenta.getRadButonConsumidorFinal().isSelected()) {
            Cliente c = (Cliente) miSesion.get(Cliente.class, 1);
            v.setCodigoCliente(c);
        } else {
            Integer id = formularioRegistrarVenta.getIdCliente();
            Cliente c = (Cliente) miSesion.get(Cliente.class, id);
            v.setCodigoCliente(c);
        }
        v.setFechaHoraVenta(formularioRegistrarVenta.getrSDateChooser().getDatoFecha());
        v.setPrecioTotal(Double.valueOf(formularioRegistrarVenta.getLblPrecioTotal().getText()));

        if (formularioRegistrarVenta.getBoxTipoVenta().getSelectedItem().equals("Venta Simple")) {
            TipoVenta tvs = (TipoVenta) miSesion.get(TipoVenta.class, 1);
            v.setCodigoTipoVenta(tvs);
            Estado e = (Estado) miSesion.get(Estado.class, 3);
            v.setCodigoEstado(e);
        } else {
            TipoVenta tvp = (TipoVenta) miSesion.get(TipoVenta.class, 2);
            v.setCodigoTipoVenta(tvp);
            Estado e = (Estado) miSesion.get(Estado.class, 4);
            v.setCodigoEstado(e);
        }

        try {
            pagado = Double.valueOf(OperacionesUtiles.formatoDouble(Double.valueOf(formularioRegistrarVenta.getTxtPago().getText())));
            v.setPagado(pagado);
        } catch (java.lang.NumberFormatException e) {
            v.setPagado(0.00);
        }

        try {
            descuento = Double.valueOf(OperacionesUtiles.formatoDouble(Double.valueOf(formularioRegistrarVenta.getTxtDescuento().getText())));
            v.setDescuento(descuento);
        } catch (java.lang.NumberFormatException e) {
            v.setDescuento(0.00);
        }

        try {
            vuelto = Double.valueOf(OperacionesUtiles.formatoDouble(Double.valueOf(formularioRegistrarVenta.getLblVuelto().getText())));
            v.setVuelto(vuelto);
        } catch (java.lang.NumberFormatException e) {
            v.setVuelto(0.00);
        }

        miSesion.save(v);

        this.setIdVenta(v.getIdVenta());

        for (int i = 0; i < listaProductosListados.size(); i++) {
            Producto_Venta pv = new Producto_Venta();
            Integer id = listaProductosListados.get(i);
            Producto p = (Producto) miSesion.get(Producto.class, id);
            totalunidades = Double.valueOf(formularioRegistrarVenta.getTablaListarProductos().getValueAt(i, 1).toString());
            precioTotal = Double.valueOf(formularioRegistrarVenta.getTablaListarProductos().getValueAt(i, 2).toString());
            pv.setCodigoProducto(p);
            pv.setCodigoVenta(v);
            pv.setTotalUnidades(totalunidades);
            pv.setPrecioTotal(Double.valueOf(OperacionesUtiles.formatoDouble(precioTotal)));
            miSesion.save(pv);

        }

        //seccion descontar cuenta
        if (formularioRegistrarVenta.getRadBtnDescontar().isSelected()) {
            Estado e = (Estado) miSesion.get(Estado.class, 1);

            MovimientoCuenta mc = new MovimientoCuenta();

            //verificar si la suma es positiva o negativa
            String positivoNegativo = String.valueOf(formularioRegistrarVenta.getLblVuelto().getText().charAt(0));
            if (positivoNegativo.equals("-")) {
                mc.setMonto(Double.valueOf(formularioRegistrarVenta.getLblVuelto().getText().toString()));
                mc.setMotivo("compra de productos");
            } else {
                mc.setMonto(Double.valueOf(formularioRegistrarVenta.getLblVuelto().getText().toString()));
                mc.setMotivo("restante de compra");
            }

            Integer id = formularioRegistrarVenta.getIdCuenta();
            Cuenta c = (Cuenta) miSesion.get(Cuenta.class, id);
            mc.setBalance(c.getBalance() + (mc.getMonto()));

            mc.setFecha(new Date());
            mc.setCodigoEstado(e);
            mc.setCodigoCuenta(c);

            miSesion.save(mc);

            c.setBalance(mc.getBalance());
            miSesion.saveOrUpdate(c);

            Venta_MovimientoCuenta vmc = new Venta_MovimientoCuenta();
            vmc.setVentaId(v);
            vmc.setMovimientoCuentaId(mc);

            miSesion.save(vmc);

        }
    }

    @Override
    public void transaccionEliminar(Session miSesion) {

        Integer id = principalVenta.getTablaVenta().obtenerIdFilaSeleccionada();

        Estado eE = (Estado) miSesion.get(Estado.class, 2);
        Estado eR = (Estado) miSesion.get(Estado.class, 3);
        Estado eP = (Estado) miSesion.get(Estado.class, 4);
        Estado eC = (Estado) miSesion.get(Estado.class, 5);
        Venta v = (Venta) miSesion.get(Venta.class, id);
        switch (formularioEstadoVenta.getEstado()) {
            case 2:
                v.setCodigoEstado(eE);
                obtenerMovimientoCuenta(miSesion, id);
                break;
            case 3:
                v.setCodigoEstado(eR);
                break;
            case 4:
                v.setCodigoEstado(eP);
                break;
            case 5:
                v.setCodigoEstado(eC);
                break;
        }
        miSesion.saveOrUpdate(v);

    }

    private void obtenerMovimientoCuenta(Session miSesion, Integer id) {
        try {
            setConsultaObject("from Venta_MovimientoCuenta where ventaId=" + id);
            obtenerObjetoConsulta();
            Object ventaMovimiento = getObjetoResultado();
            Venta_MovimientoCuenta vm = (Venta_MovimientoCuenta) ventaMovimiento;
            eliminarMovimientoCuenta(miSesion, vm);
        } catch (NullPointerException e) {
        }

    }

    private void eliminarMovimientoCuenta(Session miSesion, Venta_MovimientoCuenta vm) {
        try {
            MovimientoCuenta mc = (MovimientoCuenta) miSesion.get(MovimientoCuenta.class, vm.getMovimientoCuentaId().getIdMovimientoCuenta());
            Estado eDisable = (Estado) miSesion.get(Estado.class, 2);
            mc.setCodigoEstado(eDisable);
            Integer idCuenta = vm.getMovimientoCuentaId().getCodigoCuenta().getIdCuenta();
            miSesion.delete(vm);
            miSesion.saveOrUpdate(mc);
            new ABMMovimientoCuenta().actualizarMovimientoCuentaFromVenta(idCuenta);
        } catch (NullPointerException e) {
        }

    }

    @Override
    public void transaccionEditar(Session miSesion) {
        Integer idCliente;
        Integer idVenta;
        Double totalunidades;
        Double precioTotal;
        Double pagado;
        Double descuento;
        Double vuelto;

        idVenta = principalVenta.getTablaVenta().obtenerIdFilaSeleccionada();

        idCliente = formularioEditarVenta.getIdCliente();

        List lista = getListaProductosEliminar();

        for (Object o : lista) {
            Producto_Venta pr = (Producto_Venta) o;
            Producto_Venta productoEliminar = (Producto_Venta) miSesion.get(Producto_Venta.class, pr.getIdProductoVenta());
            miSesion.delete(productoEliminar);
        }
        Venta v = (Venta) miSesion.get(Venta.class, idVenta);

        if (formularioEditarVenta.getRadButonConsumidorFinal().isSelected()) {
            Cliente c = (Cliente) miSesion.get(Cliente.class, 1);
            v.setCodigoCliente(c);
        } else {
            Cliente c = (Cliente) miSesion.get(Cliente.class, idCliente);
            v.setCodigoCliente(c);
        }

        v.setFechaHoraVenta(formularioEditarVenta.getrSDateChooser().getDatoFecha());
        v.setPrecioTotal(Double.valueOf(formularioEditarVenta.getLblPrecioTotal().getText()));

        if (formularioEditarVenta.getBoxTipoVenta().getSelectedItem().equals("Venta Simple")) {
            TipoVenta tvs = (TipoVenta) miSesion.get(TipoVenta.class, 1);
            v.setCodigoTipoVenta(tvs);
            Estado e = (Estado) miSesion.get(Estado.class, 3);
            v.setCodigoEstado(e);
        } else {
            TipoVenta tvp = (TipoVenta) miSesion.get(TipoVenta.class, 2);
            v.setCodigoTipoVenta(tvp);
            Estado e = (Estado) miSesion.get(Estado.class, 4);
            v.setCodigoEstado(e);
        }
        try {
            pagado = Double.valueOf(OperacionesUtiles.formatoDouble(Double.valueOf(formularioEditarVenta.getTxtPago().getText())));
            v.setPagado(pagado);
        } catch (java.lang.NumberFormatException e) {
            v.setPagado(0.00);
        }

        try {
            descuento = Double.valueOf(OperacionesUtiles.formatoDouble(Double.valueOf(formularioEditarVenta.getTxtDescuento().getText())));
            v.setDescuento(descuento);
        } catch (java.lang.NumberFormatException e) {
            v.setDescuento(0.00);
        }

        try {
            vuelto = Double.valueOf(OperacionesUtiles.formatoDouble(Double.valueOf(formularioEditarVenta.getLblVuelto().getText())));
            v.setVuelto(vuelto);
        } catch (java.lang.NumberFormatException e) {
            v.setVuelto(0.00);
        }

        miSesion.saveOrUpdate(v);
        this.setIdVenta(v.getIdVenta());

        for (int i = 0; i < listaProductosListados.size(); i++) {
            Producto_Venta pv = new Producto_Venta();
            Integer id = listaProductosListados.get(i);
            Producto p = (Producto) miSesion.get(Producto.class, id);
            totalunidades = Double.valueOf(formularioEditarVenta.getTablaListarProductos().getValueAt(i, 1).toString());
            precioTotal = Double.valueOf(formularioEditarVenta.getTablaListarProductos().getValueAt(i, 2).toString());
            pv.setCodigoProducto(p);
            pv.setCodigoVenta(v);
            pv.setTotalUnidades(totalunidades);
            pv.setPrecioTotal(precioTotal);
            miSesion.save(pv);

        }

        //seccion descontar cuenta
        if (formularioEditarVenta.getRadBtnDescontar().isSelected()) {
            if (formularioEditarVenta.getLblVuelto().getText() == ".00") {
                //borrar movCuenta anterior
                //Si no se registro un movimiento, el objeto es nulo y no hay nada que borrar, salta a la siguiente funcion
                try {
                    Venta_MovimientoCuenta vm = formularioEditarVenta.getTablaCuenta().obtenerVenta_MovimientoCuenta();
                    MovimientoCuenta mc = (MovimientoCuenta) miSesion.get(MovimientoCuenta.class, vm.getMovimientoCuentaId().getIdMovimientoCuenta());
                    Estado eDisable = (Estado) miSesion.get(Estado.class, 2);
                    mc.setCodigoEstado(eDisable);
                    miSesion.delete(vm);
                    miSesion.saveOrUpdate(mc);
                    Integer idCuenta = vm.getMovimientoCuentaId().getCodigoCuenta().getIdCuenta();
                    new ABMMovimientoCuenta().actualizarMovimientoCuentaFromVenta(idCuenta);

                } catch (NullPointerException e) {
                }
            } else {
                //borrar movCuenta anterior
                //Si no se registro un movimiento, el objeto es nullo y no hay nada que borrar, salta a la siguiente funcion
                try {
                    Venta_MovimientoCuenta vm = formularioEditarVenta.getTablaCuenta().obtenerVenta_MovimientoCuenta();
                    MovimientoCuenta mc = (MovimientoCuenta) miSesion.get(MovimientoCuenta.class, vm.getMovimientoCuentaId().getIdMovimientoCuenta());
                    Estado eDisable = (Estado) miSesion.get(Estado.class, 2);
                    mc.setCodigoEstado(eDisable);
                    miSesion.delete(vm);
                    miSesion.saveOrUpdate(mc);
                    Integer idCuenta = vm.getMovimientoCuentaId().getCodigoCuenta().getIdCuenta();
                    new ABMMovimientoCuenta().actualizarMovimientoCuentaFromVenta(idCuenta);
                } catch (NullPointerException e) {
                }

                //Crear nuevoMovimiento
                Estado eEnable = (Estado) miSesion.get(Estado.class, 1);

                MovimientoCuenta newmc = new MovimientoCuenta();
                //verificar si la suma es positiva o negativa
                String positivoNegativo = String.valueOf(formularioEditarVenta.getLblVuelto().getText().charAt(0));
                if (positivoNegativo.equals("-")) {
                    newmc.setMonto(Double.valueOf(formularioEditarVenta.getLblVuelto().getText().toString()));
                    newmc.setMotivo("compra de productos");
                } else {
                    newmc.setMonto(Double.valueOf(formularioEditarVenta.getLblVuelto().getText().toString()));
                    newmc.setMotivo("restante de compra");
                }

                Integer id = formularioEditarVenta.getIdCuenta();
                Cuenta c = (Cuenta) miSesion.get(Cuenta.class, id);
                newmc.setBalance(c.getBalance() + (newmc.getMonto()));

                newmc.setFecha(new Date());
                newmc.setCodigoEstado(eEnable);
                newmc.setCodigoCuenta(c);

                miSesion.save(newmc);

                c.setBalance(newmc.getBalance());
                miSesion.saveOrUpdate(c);

                Venta_MovimientoCuenta vmc = new Venta_MovimientoCuenta();
                vmc.setVentaId(v);
                vmc.setMovimientoCuentaId(newmc);

                miSesion.save(vmc);

                Integer idCuenta = vmc.getMovimientoCuentaId().getCodigoCuenta().getIdCuenta();
                new ABMMovimientoCuenta().actualizarMovimientoCuentaFromVenta(idCuenta);

            }

        } else {

            String monto = formularioEditarVenta.getLblVuelto().getText();

            Venta_MovimientoCuenta vm = formularioEditarVenta.getTablaCuenta().obtenerVenta_MovimientoCuenta();
            try {
                Integer idMc = vm.getMovimientoCuentaId().getIdMovimientoCuenta();

                MovimientoCuenta mc = (MovimientoCuenta) miSesion.get(MovimientoCuenta.class, idMc);

                //verificar si la suma es positiva o negativa
                String positivoNegativo = String.valueOf(formularioEditarVenta.getLblVuelto().getText().charAt(0));
                if (positivoNegativo.equals("-")) {
                    mc.setMonto(Double.valueOf(monto));
                    mc.setMotivo("compra de productos");
                } else {
                    mc.setMonto(Double.valueOf(formularioEditarVenta.getLblVuelto().getText().toString()));
                    mc.setMotivo("restante de compra");
                }

                // mc.setBalance(balance+(monto));
                // Integer id = formularioEditarVenta.getIdCuenta();
                //LE PONGO FECHA?
                //mc.setFecha(new Date());
                miSesion.saveOrUpdate(mc);
                
            } catch (NullPointerException e) {
            }

        }

    }

}
