package operacionesIngresoMateriaPrima;

import calsesPadre.InterfazGraficaFormularioRegistrar;
import clasesUtilidadGeneral.TextPrompt;
import escritorios.PrincipalIngresoMatPrima;
import escritorios.PrincipalMateriaPrima;
import formularios.FormularioRegistrarIngresoMateriaPrima;
import operacionesMateriaPrima.TablaMateriaPrima;

/**
 * @author Hasper Franco
 */
public class InterfazGraficaFormularioRegistrarIngresoMateriaPrima extends InterfazGraficaFormularioRegistrar {

    public InterfazGraficaFormularioRegistrarIngresoMateriaPrima() {
        setEstadoConsulta(0);
    }

    private PrincipalMateriaPrima principalMateriaPrima;
    private PrincipalIngresoMatPrima principalIngresoMateriaPrima;

    public PrincipalMateriaPrima getPrincipalMateriaPrima() {
        return principalMateriaPrima;
    }

    public void setPrincipalMateriaPrima(PrincipalMateriaPrima principalMateriaPrima) {
        this.principalMateriaPrima = principalMateriaPrima;
    }

    public PrincipalIngresoMatPrima getPrincipalIngresoMateriaPrima() {
        return principalIngresoMateriaPrima;
    }

    public void setPrincipalIngresoMateriaPrima(PrincipalIngresoMatPrima principalIngresoMateriaPrima) {
        this.principalIngresoMateriaPrima = principalIngresoMateriaPrima;
    }

    @Override
    public void nuevoFormularioRegistrar() {
        if (principalMateriaPrima.getFormularioRegistrarIngresoMateriaPrima() == null) {
            FormularioRegistrarIngresoMateriaPrima formularioRegistrar = new FormularioRegistrarIngresoMateriaPrima(frame, true);
            formularioRegistrar.setPrincipalMateriaPrima(principalMateriaPrima);
            formularioRegistrar.setPrincipalIngresoMateriaPrima(getPrincipalIngresoMateriaPrima());
            principalMateriaPrima.setFormularioRegistrarIngresoMateriaPrima(formularioRegistrar);
            colorTema();
            transferirDatos();
            infoTextPrompt();
        }
        principalMateriaPrima.getFormularioRegistrarIngresoMateriaPrima().setVisible(true);
        principalMateriaPrima.setFormularioRegistrarIngresoMateriaPrima(null);
    }

    @Override
    public void infoTextPrompt() {
        new TextPrompt("TOTAL ENVASES", principalMateriaPrima.getFormularioRegistrarIngresoMateriaPrima().getTxttotalEnvases());
        new TextPrompt("UDS POR ENVASES", principalMateriaPrima.getFormularioRegistrarIngresoMateriaPrima().getTxtUdsPorEnvase());
        new TextPrompt("PRECIO TOTAL", principalMateriaPrima.getFormularioRegistrarIngresoMateriaPrima().getTxtPrecioTotal());
        principalMateriaPrima.getFormularioRegistrarIngresoMateriaPrima().getTxttotalEnvases().grabFocus();
    }

    public void transferirDatos() {
        new TablaMateriaPrima().setPrincipalMateriaPrima(principalMateriaPrima);
        int fila = principalMateriaPrima.getTablaGrafica().getSelectedRow();
        principalMateriaPrima.getFormularioRegistrarIngresoMateriaPrima().getTxtMatPr().setText(principalMateriaPrima.getTablaGrafica().getValueAt(fila, 0).toString());
    }

    @Override
    public void colorTema() {
        principalMateriaPrima.getFormularioRegistrarIngresoMateriaPrima().getPanelPrincipalTop().setBackground(principalMateriaPrima.getPanelPrincipalTop().getBackground());
    }

    @Deprecated
    @Override
    public void agregarBoxes() {
    }

    @Deprecated
    @Override
    public void rellenarBoxes() {
    }

}
