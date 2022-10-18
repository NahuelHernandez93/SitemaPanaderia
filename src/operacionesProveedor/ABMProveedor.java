package operacionesProveedor;

import calsesPadre.ABM;
import entidades.Direccion_Proveedor;
import entidades.Estado;
import entidades.Localidad;
import entidades.Proveedor;
import entidades.Provincia;
import entidades.TelefonoProveedor;
import entidades.TipoTelefono;
import escritorios.PrincipalProveedor;
import formularios.FormularioEditarProveedor;
import formularios.FormularioRegistrarProveedor;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author TELCOM MPC
 */
public class ABMProveedor extends ABM {

    FormularioRegistrarProveedor formularioRegistrarProveedor;
    FormularioEditarProveedor formularioEditarProveedor;

    //se utiliza solo para eliminar
    PrincipalProveedor principalProveedor;

    public FormularioRegistrarProveedor getFormularioRegistrarProveedor() {
        return formularioRegistrarProveedor;
    }

    public void setFormularioRegistrarProveedor(FormularioRegistrarProveedor formularioRegistrarProveedor) {
        this.formularioRegistrarProveedor = formularioRegistrarProveedor;
    }

    public FormularioEditarProveedor getFormularioEditarProveedor() {
        return formularioEditarProveedor;
    }

    public void setFormularioEditarProveedor(FormularioEditarProveedor formularioEditarProveedor) {
        this.formularioEditarProveedor = formularioEditarProveedor;
    }

    public PrincipalProveedor getPrincipalProveedor() {
        return principalProveedor;
    }

    public void setPrincipalProveedor(PrincipalProveedor principalProveedor) {
        this.principalProveedor = principalProveedor;
    }

    @Override
    public void obtenerFormularioRegistrar() {
        setFormularioRegistrar(this.getFormularioRegistrarProveedor());
        setListaCampos(this.getFormularioRegistrarProveedor().getListaCampos());
    }

    @Override
    public void obtenerFormularioEditar() {
        setFormularioEditar(this.getFormularioEditarProveedor());
        setListaCampos(this.getFormularioEditarProveedor().getListaCampos());
    }

    @Override
    public void transaccionRegistrar(Session miSesion) {

        Estado e = (Estado) miSesion.get(Estado.class, 1);
        Proveedor p = new Proveedor();
        p.setNombre(formularioRegistrarProveedor.getTxtNombre().getText());
        p.setCodigoEstado(e);
        miSesion.save(p);

        TelefonoProveedor tp = new TelefonoProveedor();
        tp.setCodigoProveedor(p);
        tp.setNuemero(formularioRegistrarProveedor.getTxtTelefono().getText());

        List<TipoTelefono> lista_tipotelefono
                = (List<TipoTelefono>) miSesion.createQuery("from TipoTelefono").list();
        for (TipoTelefono tt : lista_tipotelefono) {
            if (tt.getNombre().equals(formularioRegistrarProveedor.getBoxTipoTelefono().getSelectedItem())) {
                tp.setCodigoTipoTelefono(tt);
            }
        }
        miSesion.save(tp);

        Direccion_Proveedor d = new Direccion_Proveedor();

        d.setCodigoProveedor(p);
        d.setNombre(formularioRegistrarProveedor.getTxtDireccion().getText());
        d.setNumero(Integer.parseInt(formularioRegistrarProveedor.getTxtnuemroDireccion().getText()));

        List<Localidad> lista_Lc
                = (List<Localidad>) miSesion.createQuery("from Localidad").list();
        List<Provincia> lista_Pr
                = (List<Provincia>) miSesion.createQuery("from Provincia").list();

        for (Localidad lc : lista_Lc) {
            if (lc.getNombre().equals(formularioRegistrarProveedor.getBoxLocalidad().getSelectedItem())) {
                d.setCodigoLocalidad(lc);
                for (Provincia pr : lista_Pr) {
                    if (pr.getNombre().equals(formularioRegistrarProveedor.getBoxProvincia().getSelectedItem())) {
                        lc.setCodigoProvincia(pr);
                    }
                }
            }
        }
        miSesion.save(d);

    }

    @Override
    public void transaccionEditar(Session miSesion) {

        Integer id = principalProveedor.getTablaProveedor().obtenerIdFilaSeleccionada();

        Proveedor p = (Proveedor) miSesion.get(Proveedor.class, id);
        p.setNombre(formularioEditarProveedor.getTxtNombre().getText());
        miSesion.saveOrUpdate(p);

        //Telefono

        List<TelefonoProveedor> telefonos = p.getTelefonos();
        List<TipoTelefono> lista_tipotelefono
                = (List<TipoTelefono>) miSesion.createQuery("from TipoTelefono").list();
        for (TelefonoProveedor tp : telefonos) {
            tp.setNuemero(formularioEditarProveedor.getTxtTelefono().getText());
            
            for (TipoTelefono tt : lista_tipotelefono) {
                if (tt.getNombre().equals(formularioEditarProveedor.getBoxTipoTelefono().getSelectedItem())) {
                    tp.setCodigoTipoTelefono(tt);
                }
            }
            miSesion.saveOrUpdate(tp);
        }
        
        //Direccion

        List<Direccion_Proveedor> direcciones = p.getDireccionesProveedores();
        List<Localidad> lista_Lc
                = (List<Localidad>) miSesion.createQuery("from Localidad").list();
        List<Provincia> lista_Pr
                = (List<Provincia>) miSesion.createQuery("from Provincia").list();
        for (Direccion_Proveedor d : direcciones) {
            d.setNombre(formularioEditarProveedor.getTxtDireccion().getText());
            d.setNumero(Integer.valueOf(formularioEditarProveedor.getTxtnuemeroDireccion().getText()));
            for (Localidad lc : lista_Lc) {
                if (lc.getNombre().equals(formularioEditarProveedor.getBoxLocalidad().getSelectedItem())) {
                    d.setCodigoLocalidad(lc);
                    for (Provincia pr : lista_Pr) {
                        if (pr.getNombre().equals(formularioEditarProveedor.getBoxProvincia().getSelectedItem())) {
                            lc.setCodigoProvincia(pr);
                        }
                    }
                }
            }
            miSesion.saveOrUpdate(d);
        }
    }

    @Override
    public void transaccionEliminar(Session miSesion) {

        Estado e = (Estado) miSesion.get(Estado.class, 2);
        Integer totalFilas = principalProveedor.getTablaGrafica().getRowCount();
        Integer filasSeleccionada = principalProveedor.getTablaGrafica().getSelectedRow();
        List<Integer> listaResutadosActuales = principalProveedor.getTablaProveedor().getListaResutladosActuales();
        Integer id = operacionesUtilidad.obtenerId(listaResutadosActuales, totalFilas, filasSeleccionada);
        Proveedor p = (Proveedor) miSesion.get(Proveedor.class, id);
        p.setCodigoEstado(e);
        miSesion.saveOrUpdate(p);

    }

}
