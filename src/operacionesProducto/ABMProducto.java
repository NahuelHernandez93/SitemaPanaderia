package operacionesProducto;

import calsesPadre.ABM;
import conexion.ConexionHibernate;
import ds.desktop.notify.DesktopNotify;
import entidades.Estado;
import entidades.Iva;
import entidades.PrecioProducto;
import entidades.Producto;
import formularios.FormularioEditarProducto;
import formularios.FormularioRegistrarPrecioProducto;
import formularios.FormularioRegistrarProducto;
import java.util.Date;
import java.util.List;
import escritorios.PrincipalProducto;
import com.mysql.jdbc.Blob;
import org.hibernate.Session;
import org.hibernate.type.BlobType;

/**
 *
 * @author TELCOM MPC
 */
public class ABMProducto extends ABM {

    FormularioRegistrarProducto formularioRegistrarProducto;
    FormularioEditarProducto formularioEditarProducto;
    FormularioRegistrarPrecioProducto formularioRegistrarPrecioProducto;
    //se utiliza solo para eliminar
    PrincipalProducto principalProducto;

    public PrincipalProducto getPrincipalProducto() {
        return principalProducto;
    }

    public void setPrincipalProducto(PrincipalProducto principalProducto) {
        this.principalProducto = principalProducto;
    }

    public FormularioRegistrarProducto getFormularioRegistrarProducto() {
        return formularioRegistrarProducto;
    }

    public void setFormularioRegistrarProducto(FormularioRegistrarProducto formularioRegistrarProducto) {
        this.formularioRegistrarProducto = formularioRegistrarProducto;
    }

    public FormularioEditarProducto getFormularioEditarProducto() {
        return formularioEditarProducto;
    }

    public void setFormularioEditarProducto(FormularioEditarProducto formularioEditarProducto) {
        this.formularioEditarProducto = formularioEditarProducto;
    }

    public FormularioRegistrarPrecioProducto getFormularioRegistrarPrecioProducto() {
        return formularioRegistrarPrecioProducto;
    }

    public void setFormularioRegistrarPrecioProducto(FormularioRegistrarPrecioProducto formularioRegistrarPrecioProducto) {
        this.formularioRegistrarPrecioProducto = formularioRegistrarPrecioProducto;
    }

    public boolean ejecutarRegistrarPrecio() {
        obtenerFormularioRegistrarPrecio();
        if (operacionesUtilidad.verificarCamposTextoVacios(getListaCampos())) {
            conexionTransaccionRegistrarPrecio();
            getFormularioRegistrarPrecioProducto().dispose();
            return true;
        }
        return false;
    }

    public void conexionTransaccionRegistrarPrecio() {
        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            miSesion.beginTransaction();
            transaccionRegistrarPrecio(miSesion);
            miSesion.getTransaction().commit();
            DesktopNotify.showDesktopMessage("   exito   ", "   Nuevo registro creado con exito", DesktopNotify.SUCCESS, 7000);
        } catch (Exception e) {
            DesktopNotify.showDesktopMessage("   error    ", "   Error al intentar crear  registro", DesktopNotify.ERROR, 7000);
        }
    }

    @Override
    public void obtenerFormularioRegistrar() {
        setFormularioRegistrar(this.getFormularioRegistrarProducto());
        setListaCampos(this.getFormularioRegistrarProducto().getListaCampos());
    }

    @Override
    public void obtenerFormularioEditar() {
        setFormularioEditar(this.getFormularioEditarProducto());
        setListaCampos(this.getFormularioEditarProducto().getListaCampos());
    }

    public void obtenerFormularioRegistrarPrecio() {
        setFormularioEditar(this.getFormularioRegistrarPrecioProducto());
        setListaCampos(this.getFormularioRegistrarPrecioProducto().getListaCampos());
    }

    @Override
    public void transaccionRegistrar(Session miSesion) {
        Producto p = new Producto();

        Estado e = (Estado) miSesion.get(Estado.class, 1);

        p.setNombre(formularioRegistrarProducto.getTxtNombre().getText());
        p.setDescripcion(formularioRegistrarProducto.getTxtDescripcion().getText());
        p.setImagen(null);
        p.setCodigoEstado(e);
        
        miSesion.save(p);

        PrecioProducto prp = new PrecioProducto();

        prp.setCodigoProducto(p);

        Iva i = (Iva) miSesion.createQuery("from Iva where codigoEstado= " + e.getIdEstado()).uniqueResult();

        prp.setCodigoIva(i);
        prp.setPrecioBruto(Double.valueOf(formularioRegistrarProducto.getTxtPrecio().getText()));
        prp.setPrecioTotal(Double.valueOf(formularioRegistrarProducto.getTxtPrecioFinal().getText()));
        Date fechaActual = new Date();
        prp.setFecha(fechaActual);
        prp.setCodigoEstado(e);

        miSesion.save(prp);
    }

    public void transaccionRegistrarPrecio(Session miSesion) {
        
        Integer id = principalProducto.getTablaProducto().obtenerIdFilaSeleccionada();
        PrecioProducto prepro = (PrecioProducto) miSesion.get(PrecioProducto.class, id);
        id = prepro.getCodigoProducto().getIdProducto();

        Producto p = (Producto) miSesion.get(Producto.class, id);
        Estado ef = (Estado) miSesion.get(Estado.class, 2);

        List<PrecioProducto> precios = p.getPrecios();
        for (Object o : precios) {
            PrecioProducto pr = (PrecioProducto) o;
            pr.setCodigoEstado(ef);
            miSesion.saveOrUpdate(pr);
        }

        Estado e = (Estado) miSesion.get(Estado.class, 1);
        PrecioProducto prp = new PrecioProducto();
        prp.setCodigoProducto(p);

        Iva i = (Iva) miSesion.createQuery("from Iva where codigoEstado= " + e.getIdEstado()).uniqueResult();

        prp.setCodigoIva(i);
        prp.setPrecioBruto(Double.valueOf(formularioRegistrarPrecioProducto.getTxtPrecio().getText()));
        prp.setPrecioTotal(Double.valueOf(formularioRegistrarPrecioProducto.getTxtPrecioFinal().getText()));
        Date fechaActual = new Date();
        prp.setFecha(fechaActual);
        prp.setCodigoEstado(e);

        miSesion.save(prp);
    }

    @Override
    public void transaccionEditar(Session miSesion) {

        Integer totalFilas = principalProducto.getTablaGrafica().getRowCount();
        Integer filasSeleccionada = principalProducto.getTablaGrafica().getSelectedRow();
        List<Integer> listaResutadosActuales = principalProducto.getTablaProducto().getListaResutladosActuales();

        Integer id = operacionesUtilidad.obtenerId(listaResutadosActuales, totalFilas, filasSeleccionada);

        PrecioProducto prepro = (PrecioProducto) miSesion.get(PrecioProducto.class, id);

        id = prepro.getCodigoProducto().getIdProducto();

        Producto p = (Producto) miSesion.get(Producto.class, id);
        p.setNombre(formularioEditarProducto.getTxtNombre().getText());
        p.setDescripcion(formularioEditarProducto.getTxtDescripcion().getText());
        miSesion.saveOrUpdate(p);

    }

    @Override
    public void transaccionEliminar(Session miSesion) {
        Estado e = (Estado) miSesion.get(Estado.class, 2);
        Integer totalFilas = principalProducto.getTablaGrafica().getRowCount();
        Integer filasSeleccionada = principalProducto.getTablaGrafica().getSelectedRow();
        List<Integer> listaResutadosActuales = principalProducto.getTablaProducto().getListaResutladosActuales();

        Integer id = operacionesUtilidad.obtenerId(listaResutadosActuales, totalFilas, filasSeleccionada);

        PrecioProducto prepro = (PrecioProducto) miSesion.get(PrecioProducto.class, id);

        id = prepro.getCodigoProducto().getIdProducto();
        Producto p = (Producto) miSesion.get(Producto.class, id);
        p.setCodigoEstado(e);
        miSesion.saveOrUpdate(p);
    }

}
