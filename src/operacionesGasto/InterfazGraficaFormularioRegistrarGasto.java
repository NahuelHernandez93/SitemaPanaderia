package operacionesGasto;

import calsesPadre.InterfazGraficaFormularioRegistrar;
import clasesUtilidadGeneral.TextPrompt;
import escritorios.PrincipalGastos;
import formularios.FormularioRegistrarGasto;
import java.util.Date;

/**
 * @author Hasper Franco
 */
public class InterfazGraficaFormularioRegistrarGasto extends InterfazGraficaFormularioRegistrar {

    public InterfazGraficaFormularioRegistrarGasto() {
        setEstadoConsulta(0);
    }

    private PrincipalGastos principalGastos;

    public PrincipalGastos getPrincipalGastos() {
        return principalGastos;
    }

    public void setPrincipalGastos(PrincipalGastos principalGastos) {
        this.principalGastos = principalGastos;
    }

    @Override
    public void nuevoFormularioRegistrar() {
        if (principalGastos.getFormularioRegistrarGasto() == null) {
            FormularioRegistrarGasto formularioRegistrar = new FormularioRegistrarGasto(frame, true);
            formularioRegistrar.setPrincipalGastos(principalGastos);
            principalGastos.setFormularioRegistrarGasto(formularioRegistrar);
            infoTextPrompt();
            colorTema();
            fecha();
        }
        principalGastos.getFormularioRegistrarGasto().setVisible(true);
        principalGastos.setFormularioRegistrarGasto(null);
    }

    @Override
    public void infoTextPrompt() {
        new TextPrompt("DESCRIPCION", principalGastos.getFormularioRegistrarGasto().getTxtDescripcion());
        new TextPrompt("TOTAL GASTADO", principalGastos.getFormularioRegistrarGasto().getTxtTotlaGasatado());
        principalGastos.getFormularioRegistrarGasto().getTxtDescripcion().grabFocus();
    }

    private void fecha() {
        principalGastos.getFormularioRegistrarGasto().getrSDateChooser().setDatoFecha(new Date());
    }

    @Deprecated
    @Override
    public void agregarBoxes() {
    }

    @Deprecated
    @Override
    public void rellenarBoxes() {
    }

    @Override
    public void colorTema() {
        principalGastos.getFormularioRegistrarGasto().getPanelPrincipalTop().setBackground(principalGastos.getPanelPrincipalTop().getBackground());
    }

}
