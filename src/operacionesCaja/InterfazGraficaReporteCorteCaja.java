package operacionesCaja;

import escritorios.PrincipalCaja;
import formularios.FormularioReporteCorteCaja;
import formularios.FormularioReporteGastos;
import java.awt.Frame;
import java.util.Date;

/**
 * @author Hasper Franco
 */
public class InterfazGraficaReporteCorteCaja {

    private PrincipalCaja principalCaja;

    public PrincipalCaja getPrincipalCaja() {
        return principalCaja;
    }

    public void setPrincipalCaja(PrincipalCaja principalCaja) {
        this.principalCaja = principalCaja;
    }

    public void nuevoFormularioReporte() {
        FormularioReporteCorteCaja formularioReporteCorteCaja = new FormularioReporteCorteCaja(new Frame(), true);
        ReporteCorteCaja reporteCorteCaja = new ReporteCorteCaja();
        reporteCorteCaja.setFormularioReporteCorteCaja(formularioReporteCorteCaja);
        formularioReporteCorteCaja.setReporteCorteCaja(reporteCorteCaja);
        colorTema(formularioReporteCorteCaja);
        fechas(formularioReporteCorteCaja);
        formularioReporteCorteCaja.setVisible(true);
    }

    private void colorTema(FormularioReporteCorteCaja formularioReporteCorteCaja) {
        formularioReporteCorteCaja.getPanelPrincipalTop().setBackground(principalCaja.getPanelPrincipalTop().getBackground());
        formularioReporteCorteCaja.getFechaInicio().setColorBackground(principalCaja.getPanelPrincipalTop().getBackground());
        formularioReporteCorteCaja.getFechaFin().setColorBackground(principalCaja.getPanelPrincipalTop().getBackground());
    }

    private void fechas(FormularioReporteCorteCaja formularioReporteCorteCaja) {
        formularioReporteCorteCaja.getFechaInicio().setDatoFecha(new Date());
        formularioReporteCorteCaja.getFechaFin().setDatoFecha(new Date());
    }

}
