package operacionesIngresoMateriaPrima;

import escritorios.PrincipalIngresoMatPrima;
import formularios.FormularioReporteIngresoMateriaPrima;
import java.awt.Frame;
import java.util.Date;

/**
 * @author Hasper Franco
 */
public class InterfazGraficaReporteIngresos {

    private PrincipalIngresoMatPrima principalIngresoMateriaPrima;

    public PrincipalIngresoMatPrima getPrincipalIngresoMateriaPrima() {
        return principalIngresoMateriaPrima;
    }

    public void setPrincipalIngresoMateriaPrima(PrincipalIngresoMatPrima principalIngresoMateriaPrima) {
        this.principalIngresoMateriaPrima = principalIngresoMateriaPrima;
    }

    public void nuevoFormularioReporte() {
        FormularioReporteIngresoMateriaPrima formularioReporte = new FormularioReporteIngresoMateriaPrima(new Frame(), true);
        ReporteIngresos reporteIngresos = new ReporteIngresos();
        reporteIngresos.setFormularioReporteIngresoMateriaPrima(formularioReporte);
        formularioReporte.setReporteIngresos(reporteIngresos);
        colorTema(formularioReporte);
        fechas(formularioReporte);
        formularioReporte.setVisible(true);

    }

    private void colorTema(FormularioReporteIngresoMateriaPrima formularioReporte) {
        formularioReporte.getFechaInicio().setColorBackground(principalIngresoMateriaPrima.getPanelPrincipalTop().getBackground());
        formularioReporte.getFechaFin().setColorBackground(principalIngresoMateriaPrima.getPanelPrincipalTop().getBackground());
        formularioReporte.getPanelPrincipalTop().setBackground(principalIngresoMateriaPrima.getPanelPrincipalTop().getBackground());
    }

    private void fechas(FormularioReporteIngresoMateriaPrima formularioReporte) {
        formularioReporte.getFechaInicio().setDatoFecha(new Date());
        formularioReporte.getFechaFin().setDatoFecha(new Date());
    }

}
