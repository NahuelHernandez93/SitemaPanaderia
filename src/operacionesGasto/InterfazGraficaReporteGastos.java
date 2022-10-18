package operacionesGasto;

import escritorios.PrincipalGastos;
import formularios.FormularioReporteGastos;
import formularios.FormularioReporteIngresoMateriaPrima;
import java.awt.Frame;
import java.util.Date;

/**
 * @author Hasper Franco
 */
public class InterfazGraficaReporteGastos {

    private PrincipalGastos principalGastos;

    public PrincipalGastos getPrincipalGastos() {
        return principalGastos;
    }

    public void setPrincipalGastos(PrincipalGastos principalGastos) {
        this.principalGastos = principalGastos;
    }

    public void nuevoFormularioReporte() {
        FormularioReporteGastos formularioReporteGastos = new FormularioReporteGastos(new Frame(), true);
        ReporteGastos reporteGastos = new ReporteGastos();
        reporteGastos.setFormularioReporteGastos(formularioReporteGastos);
        formularioReporteGastos.setReporteGastos(reporteGastos);
        colorTema(formularioReporteGastos);
        fechas(formularioReporteGastos);
        formularioReporteGastos.setVisible(true);
    }

    private void colorTema(FormularioReporteGastos formularioReporte) {
        formularioReporte.getPanelPrincipalTop().setBackground(principalGastos.getPanelPrincipalTop().getBackground());
        formularioReporte.getFechaInicio().setColorBackground(principalGastos.getPanelPrincipalTop().getBackground());
        formularioReporte.getFechaFin().setColorBackground(principalGastos.getPanelPrincipalTop().getBackground());
    }
    
        private void fechas(FormularioReporteGastos formularioReporte) {
        formularioReporte.getFechaInicio().setDatoFecha(new Date());
        formularioReporte.getFechaFin().setDatoFecha(new Date());
    }

}
