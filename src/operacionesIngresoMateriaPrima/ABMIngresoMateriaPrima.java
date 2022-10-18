package operacionesIngresoMateriaPrima;

import calsesPadre.ABM;
import entidades.Estado;
import entidades.IngresoMateriaPrima;
import entidades.MateriaPrima;
import escritorios.PrincipalIngresoMatPrima;
import escritorios.PrincipalMateriaPrima;
import formularios.FormularioEditarIngresoMateriaPrima;
import formularios.FormularioRegistrarIngresoMateriaPrima;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 * @author Hasper Franco
 */
public class ABMIngresoMateriaPrima extends ABM {

    private FormularioRegistrarIngresoMateriaPrima formularioRegistraringresoMateriaPrima;
    private FormularioEditarIngresoMateriaPrima formularioEditarIngresoMateriaPrima;

    //se utiliza solo para nuevo 
    private PrincipalMateriaPrima principalMateriaPrima;
    //editar y eliminar
    private PrincipalIngresoMatPrima principalIngresoMateriaPrima;

    public PrincipalIngresoMatPrima getPrincipalIngresoMateriaPrima() {
        return principalIngresoMateriaPrima;
    }

    public void setPrincipalIngresoMateriaPrima(PrincipalIngresoMatPrima principalIngresoMateriaPrima) {
        this.principalIngresoMateriaPrima = principalIngresoMateriaPrima;
    }

    public PrincipalMateriaPrima getPrincipalMateriaPrima() {
        return principalMateriaPrima;
    }

    public void setPrincipalMateriaPrima(PrincipalMateriaPrima principalMateriaPrima) {
        this.principalMateriaPrima = principalMateriaPrima;
    }

    public FormularioRegistrarIngresoMateriaPrima getFormularioRegistraringresoMateriaPrima() {
        return formularioRegistraringresoMateriaPrima;
    }

    public void setFormularioRegistraringresoMateriaPrima(FormularioRegistrarIngresoMateriaPrima formularioRegistraringresoMateriaPrima) {
        this.formularioRegistraringresoMateriaPrima = formularioRegistraringresoMateriaPrima;
    }

    public FormularioEditarIngresoMateriaPrima getFormularioEditarIngresoMateriaPrima() {
        return formularioEditarIngresoMateriaPrima;
    }

    public void setFormularioEditarIngresoMateriaPrima(FormularioEditarIngresoMateriaPrima formularioEditarIngresoMateriaPrima) {
        this.formularioEditarIngresoMateriaPrima = formularioEditarIngresoMateriaPrima;
    }

    @Override
    public void obtenerFormularioRegistrar() {
        setFormularioRegistrar(this.getFormularioRegistraringresoMateriaPrima());
        setListaCampos(this.getFormularioRegistraringresoMateriaPrima().getListaCampos());
    }

    @Override
    public void obtenerFormularioEditar() {
        setFormularioEditar(this.getFormularioEditarIngresoMateriaPrima());
        setListaCampos(this.getFormularioEditarIngresoMateriaPrima().getListaCampos());
    }

    @Override
    public void transaccionRegistrar(Session miSesion) {

        Integer totalFilas = principalMateriaPrima.getTablaGrafica().getRowCount();
        Integer filasSeleccionada = principalMateriaPrima.getTablaGrafica().getSelectedRow();
        List<Integer> listaResutadosActuales = principalMateriaPrima.getTablaMateriaPrima().getListaResutladosActuales();
        Integer id = operacionesUtilidad.obtenerId(listaResutadosActuales, totalFilas, filasSeleccionada);
        
        MateriaPrima m = (MateriaPrima) miSesion.get(MateriaPrima.class, id);
        Estado e = (Estado) miSesion.get(Estado.class, 1);
        IngresoMateriaPrima g = new IngresoMateriaPrima();

        g.setCodigoMateriaPrima(m);
        g.setTotalEnvases(Double.parseDouble(formularioRegistraringresoMateriaPrima.getTxttotalEnvases().getText()));
        g.setUdPorEnvase(Double.parseDouble(formularioRegistraringresoMateriaPrima.getTxtUdsPorEnvase().getText()));
        g.setPrecioTotal(Double.parseDouble(formularioRegistraringresoMateriaPrima.getTxtPrecioTotal().getText()));
        g.setCodigoEstado(e);
        miSesion.save(g);


    }

    @Override
    public void transaccionEditar(Session miSesion) {
        Date date = new Date();

        
        Integer totalFilas = principalIngresoMateriaPrima.getTablaGrafica().getRowCount();
        Integer filasSeleccionada = principalIngresoMateriaPrima.getTablaGrafica().getSelectedRow();
        List<Integer> listaResutadosActuales = principalIngresoMateriaPrima.getTablaIngresoMateriaPrima().getListaResutladosActuales();
        Integer id = operacionesUtilidad.obtenerId(listaResutadosActuales, totalFilas, filasSeleccionada);

        IngresoMateriaPrima im = (IngresoMateriaPrima) miSesion.get(IngresoMateriaPrima.class, id);
        im.setTotalEnvases(Double.parseDouble(formularioEditarIngresoMateriaPrima.getTxttotalEnvases().getText()));
        im.setUdPorEnvase(Double.parseDouble(formularioEditarIngresoMateriaPrima.getTxtUdsPorEnvase().getText()));
        im.setPrecioTotal(Double.parseDouble(formularioEditarIngresoMateriaPrima.getTxtPrecioTotal().getText()));
        im.setFecha(formularioEditarIngresoMateriaPrima.getDateFecha().getDatoFecha());
        miSesion.saveOrUpdate(im);


    }

    @Override
    public void transaccionEliminar(Session miSesion) {


        Integer totalFilas = principalIngresoMateriaPrima.getTablaGrafica().getRowCount();
        Integer filasSeleccionada = principalIngresoMateriaPrima.getTablaGrafica().getSelectedRow();
        List<Integer> listaResutadosActuales = principalIngresoMateriaPrima.getTablaIngresoMateriaPrima().getListaResutladosActuales();
        Integer id = operacionesUtilidad.obtenerId(listaResutadosActuales, totalFilas, filasSeleccionada);
        
        Estado e = (Estado) miSesion.get(Estado.class, 2);
        IngresoMateriaPrima im = (IngresoMateriaPrima) miSesion.get(IngresoMateriaPrima.class, id);
        im.setCodigoEstado(e);
        miSesion.saveOrUpdate(im);
  
    }

}
