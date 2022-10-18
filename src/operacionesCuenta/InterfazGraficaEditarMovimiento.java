package operacionesCuenta;

import calsesPadre.InterfazGraficaFormularioEditar;
import conexion.ConexionHibernate;
import entidades.MovimientoCuenta;
import escritorios.PrincipalCuenta;
import formularios.FormularioEditarMovimientoCuenta;
import java.awt.HeadlessException;
import java.util.Date;
import org.hibernate.Session;

/**
 * @author Hasper Franco
 */
public class InterfazGraficaEditarMovimiento extends InterfazGraficaFormularioEditar {

    private PrincipalCuenta principalCuenta;
    private TablaMovimientoCuenta tablaMovimientoCuenta;

    public PrincipalCuenta getPrincipalCuenta() {
        return principalCuenta;
    }

    public void setPrincipalCuenta(PrincipalCuenta principalCuenta) {
        this.principalCuenta = principalCuenta;
    }

    public TablaMovimientoCuenta getTablaMovimientoCuenta() {
        return tablaMovimientoCuenta;
    }

    public void setTablaMovimientoCuenta(TablaMovimientoCuenta tablaMovimientoCuenta) {
        this.tablaMovimientoCuenta = tablaMovimientoCuenta;
    }

    @Override
    public void nuevoFormularioEditar() {
        if (principalCuenta.getFormularioEditarMovimiento() == null) {
            FormularioEditarMovimientoCuenta formularioEditar = new FormularioEditarMovimientoCuenta(frame, true);
            formularioEditar.setPrincipalCuenta(principalCuenta);
            formularioEditar.setCuantaFilaSeleccionada(principalCuenta.getCuantaFilaSeleccionada());
            principalCuenta.setFormularioEditarMovimiento(formularioEditar);
            colorTema();
            transferirDatos();
        }

        principalCuenta.getFormularioEditarMovimiento().setVisible(true);
        principalCuenta.setFormularioEditarMovimiento(null);
    }

    @Override
    public void colorTema() {
        principalCuenta.getFormularioEditarMovimiento().getPanelPrincipalTop().setBackground(principalCuenta.getPanelPrincipalTop().getBackground());
    }

    @Override
    public void transferirDatos() {

        int fila = principalCuenta.getTablaGraficaMovimiento().getSelectedRow();
        if (principalCuenta.getTablaGraficaMovimiento().getValueAt(fila, 0).toString().equals("Monto Inicial")) {
            principalCuenta.getFormularioEditarMovimiento().getTxtMotivo().setEditable(false);
        }
        principalCuenta.getFormularioEditarMovimiento().getTxtMotivo().setText(principalCuenta.getTablaGraficaMovimiento().getValueAt(fila, 0).toString());
        principalCuenta.getFormularioEditarMovimiento().getTxtMonto().setText(principalCuenta.getTablaGraficaMovimiento().getValueAt(fila, 1).toString());

        fechaMovimiento();

    }

    @Deprecated
    @Override
    public void agregarBoxes() {

    }

    @Deprecated
    @Override
    public void rellenarBoxes() {

    }

    private void fechaMovimiento() {
        transferirFecha(obtenerDatos());
    }

    private Date obtenerDatos() {
        Date fecha = new Date();
        Integer id = principalCuenta.getTablaMovimientoCuenta().obtenerIdFilaSeleccionada();
        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            miSesion.beginTransaction();
            MovimientoCuenta mc = (MovimientoCuenta) miSesion.get(MovimientoCuenta.class, id);
            fecha = mc.getFecha();
            miSesion.getTransaction().commit();
        } catch (HeadlessException | NumberFormatException e) {
        }
        return fecha;
    }

    private void transferirFecha(Date fecha) {
        principalCuenta.getFormularioEditarMovimiento().getCalendario().setDatoFecha(fecha);
    }
}
