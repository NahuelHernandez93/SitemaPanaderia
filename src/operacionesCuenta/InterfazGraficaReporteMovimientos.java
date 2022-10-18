package operacionesCuenta;

import escritorios.PrincipalCuenta;
import formularios.FormularioReporteMovimientos;
import java.awt.Frame;
import java.util.Date;

/**
 * @author Hasper Franco
 */
public class InterfazGraficaReporteMovimientos {

    private PrincipalCuenta principalCuenta;

    public PrincipalCuenta getPrincipalCuenta() {
        return principalCuenta;
    }

    public void setPrincipalCuenta(PrincipalCuenta principalCuenta) {
        this.principalCuenta = principalCuenta;
    }

    public void nuevoFormularioReporte() {
        FormularioReporteMovimientos formularioReporte = new FormularioReporteMovimientos(new Frame(), true);
        ReporteMovimientos reporteMovimientos = new ReporteMovimientos();
        reporteMovimientos.setIdCuenta(principalCuenta.getTablaCuenta().obtenerIdFilaSeleccionada());
        reporteMovimientos.setFormularioReporteMovimientos(formularioReporte);
        formularioReporte.setReporteMovimientos(reporteMovimientos);
        colorTema(formularioReporte);
        transferirDatos(formularioReporte);
        autoSetFechas(formularioReporte);
        formularioReporte.setVisible(true);

    }

    private void colorTema(FormularioReporteMovimientos formularioReporte) {
        formularioReporte.getFechaInicio().setColorBackground(principalCuenta.getPanelPrincipalTop().getBackground());
        formularioReporte.getFechaFin().setColorBackground(principalCuenta.getPanelPrincipalTop().getBackground());
        formularioReporte.getPanelPrincipalTop().setBackground(principalCuenta.getPanelPrincipalTop().getBackground());
    }

    private void transferirDatos(FormularioReporteMovimientos formularioReporte) {
        formularioReporte.getLblCliente().setText(principalCuenta.getLblNombre().getText());
        Integer filasSeleccionada = principalCuenta.getTablaGraficaCuenta().getSelectedRow();
        formularioReporte.getLblNroCuenta().setText(principalCuenta.getTablaGraficaCuenta().getValueAt(filasSeleccionada, 0).toString());
        formularioReporte.getLblBalance().setText("$" + principalCuenta.getTablaGraficaCuenta().getValueAt(filasSeleccionada, 1).toString());
    }

    private void autoSetFechas(FormularioReporteMovimientos formularioReporte) {
        formularioReporte.getFechaInicio().setDatoFecha(new Date());
        formularioReporte.getFechaFin().setDatoFecha(new Date());
    }

}
