package operacionesCaja;

import calsesPadre.ABM;
import entidades.CorteCaja;
import entidades.Estado;
import formularios.FormularioEditarCorte;
import escritorios.PrincipalCaja;
import formularios.FormularioRegistrarCorte;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Franco Hasper
 */
public class ABMCaja extends ABM {

    private FormularioRegistrarCorte formularioRegistrarCorte;
    private FormularioEditarCorte formularioEditarCorte;

    private PrincipalCaja principalCaja;

    public PrincipalCaja getPrincipalCaja() {
        return principalCaja;
    }

    public void setPrincipalCaja(PrincipalCaja principalCaja) {
        this.principalCaja = principalCaja;
    }

    public FormularioRegistrarCorte getFormularioRegistrarCorte() {
        return formularioRegistrarCorte;
    }

    public void setFormularioRegistrarCorte(FormularioRegistrarCorte formularioRegistrarCorte) {
        this.formularioRegistrarCorte = formularioRegistrarCorte;
    }

    public FormularioEditarCorte getFormularioEditarCorte() {
        return formularioEditarCorte;
    }

    public void setFormularioEditarCorte(FormularioEditarCorte formularioEditarCorte) {
        this.formularioEditarCorte = formularioEditarCorte;
    }

    @Override
    public void obtenerFormularioRegistrar() {
        setFormularioRegistrar(this.getFormularioRegistrarCorte());
        setListaCampos(this.getFormularioRegistrarCorte().getListaCampos());
    }

    @Override
    public void obtenerFormularioEditar() {
        setFormularioEditar(this.getFormularioEditarCorte());
        setListaCampos(this.getFormularioEditarCorte().getListaCampos());
    }

    @Override
    public void transaccionRegistrar(Session miSesion) {

        Estado e = (Estado) miSesion.get(Estado.class, 1);
        Double totalIngreso = Double.valueOf(formularioRegistrarCorte.getTxtTotalVentas().getText());
        Double totalEgresos = Double.valueOf(formularioRegistrarCorte.getTxtTotalGastos().getText());
        Double balance = Double.valueOf(formularioRegistrarCorte.getTxtBalance().getText());
        CorteCaja c = new CorteCaja(totalIngreso, totalEgresos, balance, e);

        miSesion.save(c);

    }

    @Override
    public void transaccionEditar(Session miSesion) {

        Integer totalFilas = principalCaja.getTablaGrafica().getRowCount();
        Integer filasSeleccionada = principalCaja.getTablaGrafica().getSelectedRow();
        List<Integer> listaResutadosActuales = principalCaja.getTablaCaja().getListaResutladosActuales();
        Integer id = operacionesUtilidad.obtenerId(listaResutadosActuales, totalFilas, filasSeleccionada);

        CorteCaja c = (CorteCaja) miSesion.get(CorteCaja.class, id);
        c.setTotalIngresos(Double.valueOf(formularioEditarCorte.getTxtTotalIngresos().getText()));
        c.setTotalEgresos(Double.valueOf(formularioEditarCorte.getTxtTotalEgresos().getText()));
        c.setBalance(Double.valueOf(formularioEditarCorte.getTxtBalance().getText()));
        System.out.println(formularioEditarCorte.getrSDateChooser().getDatoFecha());
        if (formularioEditarCorte.getrSDateChooser().getDatoFecha() == (null)) {
        } else {
            c.setFecha(formularioEditarCorte.getrSDateChooser().getDatoFecha());
        }
        miSesion.saveOrUpdate(c);

    }

    @Override
    public void transaccionEliminar(Session miSesion) {
        Integer totalFilas = principalCaja.getTablaGrafica().getRowCount();
        Integer filasSeleccionada = principalCaja.getTablaGrafica().getSelectedRow();
        List<Integer> listaResutadosActuales = principalCaja.getTablaCaja().getListaResutladosActuales();
        Integer id = operacionesUtilidad.obtenerId(listaResutadosActuales, totalFilas, filasSeleccionada);

        Estado e = (Estado) miSesion.get(Estado.class, 2);
        CorteCaja c = (CorteCaja) miSesion.get(CorteCaja.class, id);
        c.setCodigoEstado(e);
        miSesion.saveOrUpdate(c);

    }

}
