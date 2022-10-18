package operacionesCaja;

import calsesPadre.InterfazGraficaFormularioRegistrar;
import escritorios.PrincipalCaja;
import formularios.FormularioRegistrarCorte;

/**
 * @author Hasper Franco
 */
public class InterfazGraficaFormularioRegistrarCorte extends InterfazGraficaFormularioRegistrar {

    public InterfazGraficaFormularioRegistrarCorte() {
        setEstadoConsulta(0);
    }

    private PrincipalCaja principalCaja;

    public PrincipalCaja getPrincipalCaja() {
        return principalCaja;
    }

    public void setPrincipalCaja(PrincipalCaja principalCaja) {
        this.principalCaja = principalCaja;
    }

    @Override
    public void nuevoFormularioRegistrar() {
        if (principalCaja.getFormularioRegistrarCorte() == null) {
            FormularioRegistrarCorte formularioRegistrar = new FormularioRegistrarCorte(frame, true);
            formularioRegistrar.setPrincipalCaja(principalCaja);
            principalCaja.setFormularioRegistrarCorte(formularioRegistrar);
            colorTema();
            valoresIniciales();
            new TablaGastos().ejecutarRellenarTabla(formularioRegistrar);
            new TablaVentas().ejecutarRellenarTabla(formularioRegistrar);
            new OperacionesRegistrarCorte().calcularTotalVentas(formularioRegistrar);
            new OperacionesRegistrarCorte().calcularTotalGastos(formularioRegistrar);
            new OperacionesRegistrarCorte().calcularBalance(formularioRegistrar);
        }
        principalCaja.getFormularioRegistrarCorte().setVisible(true);
        principalCaja.setFormularioRegistrarCorte(null);
    }

    @Override
    public void colorTema() {
        principalCaja.getFormularioRegistrarCorte().getPanelPrincipalTop().setBackground(principalCaja.getPanelPrincipalTop().getBackground());
        principalCaja.getFormularioRegistrarCorte().getTablaEntradas().setSelectionBackground(principalCaja.getPanelPrincipalTop().getBackground());
        principalCaja.getFormularioRegistrarCorte().getTablaEntradas().setForeground(principalCaja.getPanelPrincipalTop().getBackground());
        principalCaja.getFormularioRegistrarCorte().getTablaSlidas().setSelectionBackground(principalCaja.getPanelPrincipalTop().getBackground());
        principalCaja.getFormularioRegistrarCorte().getTablaSlidas().setForeground(principalCaja.getPanelPrincipalTop().getBackground());

    }

    private void valoresIniciales() {
        principalCaja.getFormularioRegistrarCorte().getTxtTotalVentas().setText("0.00");
        principalCaja.getFormularioRegistrarCorte().getTxtTotalGastos().setText("0.00");
        principalCaja.getFormularioRegistrarCorte().getTxtBalance().setText("0.00");
    }

    @Deprecated
    @Override
    protected void infoTextPrompt() {
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
