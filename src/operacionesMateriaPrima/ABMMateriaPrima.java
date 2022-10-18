package operacionesMateriaPrima;

import calsesPadre.ABM;
import entidades.Estado;
import entidades.Marca;
import entidades.MateriaPrima;
import entidades.MateriaPrima_Marca;
import entidades.MateriaPrima_Marca_Proveedor;
import entidades.MateriaPrima_Proveedor;
import entidades.Proveedor;
import entidades.UnidaddeMedida;
import formularios.FormularioEditarMateriaPrima;
import formularios.FormularioRegistrarMateriaPrima;
import java.util.List;
import escritorios.PrincipalMateriaPrima;
import org.hibernate.Session;

/**
 * Contiene las 3 funciones "alta, baja y modificar" para la entidad materia
 * prima
 *
 * @author Hasper Franco
 * @version 0.1
 * @since 2020-01-16
 */
public class ABMMateriaPrima extends ABM {

    private FormularioRegistrarMateriaPrima formularioRegistrarMateriaPrima;
    private FormularioEditarMateriaPrima formularioEditarMateriaPrima;

    //se utiliza solo para eliminar y editar
    private PrincipalMateriaPrima principalMateriaPrima;

    public FormularioRegistrarMateriaPrima getFormularioRegistrarMateriaPrima() {
        return formularioRegistrarMateriaPrima;
    }

    public void setFormularioRegistrarMateriaPrima(FormularioRegistrarMateriaPrima formularioRegistrarMateriaPrima) {
        this.formularioRegistrarMateriaPrima = formularioRegistrarMateriaPrima;
    }

    public FormularioEditarMateriaPrima getFormularioEditarMateriaPrima() {
        return formularioEditarMateriaPrima;
    }

    public void setFormularioEditarMateriaPrima(FormularioEditarMateriaPrima formularioEditarMateriaPrima) {
        this.formularioEditarMateriaPrima = formularioEditarMateriaPrima;
    }

    public PrincipalMateriaPrima getPrincipalMateriaPrima() {
        return principalMateriaPrima;
    }

    public void setPrincipalMateriaPrima(PrincipalMateriaPrima principalMateriaPrima) {
        this.principalMateriaPrima = principalMateriaPrima;
    }

    @Override
    public void obtenerFormularioRegistrar() {
        setFormularioRegistrar(this.getFormularioRegistrarMateriaPrima());
        setListaCampos(this.getFormularioRegistrarMateriaPrima().getListaCampos());
    }

    @Override
    public void obtenerFormularioEditar() {
        setFormularioEditar(this.getFormularioEditarMateriaPrima());
        setListaCampos(this.getFormularioEditarMateriaPrima().getListaCampos());
    }

    @Override
    public void transaccionRegistrar(Session miSesion) {

        //objeto para guardar datos en tabla materia prima marca proveedor
        MateriaPrima_Marca_Proveedor mtmrpr = new MateriaPrima_Marca_Proveedor();
        //guardar datos en Materia Prima
        MateriaPrima m = new MateriaPrima();

        m.setNombre(formularioRegistrarMateriaPrima.getTxtNombre().getText());

        List<UnidaddeMedida> lista_uDeMedida
                = (List<UnidaddeMedida>) miSesion.createQuery("from UnidaddeMedida").list();
        for (UnidaddeMedida u : lista_uDeMedida) {
            if (u.getNombre().equals(formularioRegistrarMateriaPrima.getBoxUdeMedida().getSelectedItem())) {
                m.setCodigoUnidaddeMedida(u);
            }
        }

        Estado e = (Estado) miSesion.get(Estado.class, 1);
        m.setCodigoEstado(e);

        miSesion.save(m);

        //Guardar datos en tabla MateriaPrima_Marca
        MateriaPrima_Marca mtmr = new MateriaPrima_Marca();

        List<Marca> lista_marca
                = (List<Marca>) miSesion.createQuery("from Marca").list();
        for (Marca mr : lista_marca) {
            if (mr.getNombre().equals(formularioRegistrarMateriaPrima.getBoxMarca().getSelectedItem())) {
                mtmr.setCodigoMarca(mr);
                mtmrpr.setCodigoMarca(mr);
            }
        }
        mtmr.setCodigoMateriaPrima(m);
        miSesion.save(mtmr);

        //guardar datos en tabla MateriaPrima_Proveedor
        MateriaPrima_Proveedor mtpr = new MateriaPrima_Proveedor();

        List<Proveedor> lista_proveedor
                = (List<Proveedor>) miSesion.createQuery("from Proveedor").list();
        for (Proveedor pr : lista_proveedor) {
            if (pr.getNombre().equals(formularioRegistrarMateriaPrima.getBoxProveedor().getSelectedItem())) {
                mtpr.setCodigoProveedor(pr);
                mtmrpr.setCodigoProveedor(pr);
            }
        }
        mtpr.setCodigoMateriaPrima(m);
        mtmrpr.setCodigoMateriaPrima(m);
        miSesion.save(mtpr);
        miSesion.save(mtmrpr);

    }

    @Override
    public void transaccionEditar(Session miSesion) {
        Integer totalFilas = principalMateriaPrima.getTablaGrafica().getRowCount();
        Integer filasSeleccionada = principalMateriaPrima.getTablaGrafica().getSelectedRow();
        List<Integer> listaResutadosActuales = principalMateriaPrima.getTablaMateriaPrima().getListaResutladosActuales();
        Integer id = operacionesUtilidad.obtenerId(listaResutadosActuales, totalFilas, filasSeleccionada);

        MateriaPrima m = (MateriaPrima) miSesion.get(MateriaPrima.class, id);
        

        m.setNombre(formularioEditarMateriaPrima.getTxtNombreMAteriaPrima().getText());

        List<UnidaddeMedida> lista_uDeMedida
                = (List<UnidaddeMedida>) miSesion.createQuery("from UnidaddeMedida").list();
        for (UnidaddeMedida u : lista_uDeMedida) {
            if (u.getNombre().equals(formularioEditarMateriaPrima.getBoxUdeMedida().getSelectedItem())) {
                m.setCodigoUnidaddeMedida(u);
            }
        }

        miSesion.saveOrUpdate(m);

        List<Integer> listaResutadosActualesMtMrPr = principalMateriaPrima.getTablaMateriaPrima().getListaResutladosActualesMtMrPr();
        Integer idMtMrPr = operacionesUtilidad.obtenerId(listaResutadosActualesMtMrPr, totalFilas, filasSeleccionada);

        MateriaPrima_Marca_Proveedor mtmrpr = (MateriaPrima_Marca_Proveedor) miSesion.get(MateriaPrima_Marca_Proveedor.class, idMtMrPr);

        System.out.println(mtmrpr.getIdMateriaPrimaMarcaProveedor());
        
        List<Marca> lista_marca
                = (List<Marca>) miSesion.createQuery("from Marca").list();
        for (Marca mr : lista_marca) {
            if (mr.getNombre().equals(formularioEditarMateriaPrima.getBoxMarca().getSelectedItem())) {
                mtmrpr.setCodigoMarca(mr);
            }
        }

        List<Proveedor> lista_proveedor
                = (List<Proveedor>) miSesion.createQuery("from Proveedor").list();
        for (Proveedor pr : lista_proveedor) {
            if (pr.getNombre().equals(formularioEditarMateriaPrima.getBoxProveedor().getSelectedItem())) {
                mtmrpr.setCodigoProveedor(pr);
            }
        }
        miSesion.saveOrUpdate(mtmrpr);

    }

    @Override
    public void transaccionEliminar(Session miSesion) {
        Integer totalFilas = principalMateriaPrima.getTablaGrafica().getRowCount();
        Integer filasSeleccionada = principalMateriaPrima.getTablaGrafica().getSelectedRow();
        List<Integer> listaResutadosActuales = principalMateriaPrima.getTablaMateriaPrima().getListaResutladosActuales();
        Integer id = operacionesUtilidad.obtenerId(listaResutadosActuales, totalFilas, filasSeleccionada);

        Estado e = (Estado) miSesion.get(Estado.class, 2);
        MateriaPrima m = (MateriaPrima) miSesion.get(MateriaPrima.class, id);
        m.setCodigoEstado(e);
        miSesion.saveOrUpdate(m);

    }

    public void transaccionEliminarMateriaPrima() {

    }

}
