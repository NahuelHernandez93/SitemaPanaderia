package operacionesGasto;

import calsesPadre.ABM;
import entidades.Estado;
import entidades.Gasto;
import formularios.FormularioEditarGasto;
import formularios.FormularioRegistrarGasto;
import escritorios.PrincipalGastos;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Hasper Franco
 */
public class ABMGasto extends ABM {

    private FormularioRegistrarGasto formularioRegistrarGasto;
    private FormularioEditarGasto formularioEditarGasto;

    //se utiliza solo para eliminar
    private PrincipalGastos principalGasto;

    public FormularioRegistrarGasto getFormularioRegistrarGasto() {
        return formularioRegistrarGasto;
    }

    public void setFormularioRegistrarGasto(FormularioRegistrarGasto formularioRegistrarGasto) {
        this.formularioRegistrarGasto = formularioRegistrarGasto;
    }

    public FormularioEditarGasto getFormularioEditarGasto() {
        return formularioEditarGasto;
    }

    public void setFormularioEditarGasto(FormularioEditarGasto formularioEditarGasto) {
        this.formularioEditarGasto = formularioEditarGasto;
    }

    public PrincipalGastos getPrincipalGasto() {
        return principalGasto;
    }

    public void setPrincipalGasto(PrincipalGastos principalGasto) {
        this.principalGasto = principalGasto;
    }

    @Override
    public void obtenerFormularioRegistrar() {
        setFormularioRegistrar(this.getFormularioRegistrarGasto());
        setListaCampos(this.getFormularioRegistrarGasto().getListaCampos());
    }

    @Override
    public void obtenerFormularioEditar() {
        setFormularioEditar(this.getFormularioEditarGasto());
        setListaCampos(this.getFormularioEditarGasto().getListaCampos());
    }

    @Override
    public void transaccionRegistrar(Session miSesion) {
        Gasto g = new Gasto();
        Estado e = (Estado) miSesion.get(Estado.class, 1);

        g.setDescripcion(formularioRegistrarGasto.getTxtDescripcion().getText());
        g.setPrecioTotal(Double.valueOf(formularioRegistrarGasto.getTxtTotlaGasatado().getText()));
        g.setFecha(formularioRegistrarGasto.getrSDateChooser().getDatoFecha());
        g.setCodigoEstado(e);
        miSesion.save(g);
    }

    @Override
    public void transaccionEditar(Session miSesion) {

        Integer totalFilas = principalGasto.getTablaGrafica().getRowCount();
        Integer filasSeleccionada = principalGasto.getTablaGrafica().getSelectedRow();
        List<Integer> listaResutadosActuales = principalGasto.getTablaGasto().getListaResutladosActuales();
        Integer id = operacionesUtilidad.obtenerId(listaResutadosActuales, totalFilas, filasSeleccionada);

        Gasto g = (Gasto) miSesion.get(Gasto.class, id);
        g.setDescripcion(formularioEditarGasto.getTxtDescripcion().getText());
        g.setPrecioTotal(Double.valueOf(formularioEditarGasto.getTxtTotalGastado().getText()));
        if(formularioEditarGasto.getrSDateChooser().getDatoFecha()!=null){
            g.setFecha(formularioEditarGasto.getrSDateChooser().getDatoFecha());
        }
        miSesion.saveOrUpdate(g);
    }

    @Override
    public void transaccionEliminar(Session miSesion) {
        Integer totalFilas = principalGasto.getTablaGrafica().getRowCount();
        Integer filasSeleccionada = principalGasto.getTablaGrafica().getSelectedRow();
        List<Integer> listaResutadosActuales = principalGasto.getTablaGasto().getListaResutladosActuales();
        Integer id = operacionesUtilidad.obtenerId(listaResutadosActuales, totalFilas, filasSeleccionada);
        
        Estado e = (Estado) miSesion.get(Estado.class, 2);
        Gasto g = (Gasto) miSesion.get(Gasto.class, id);
        g.setCodigoEstado(e);
        miSesion.saveOrUpdate(g);

    }

}
