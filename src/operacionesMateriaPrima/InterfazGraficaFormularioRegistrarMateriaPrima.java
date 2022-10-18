package operacionesMateriaPrima;

import calsesPadre.InterfazGraficaFormularioRegistrar;
import clasesUtilidadGeneral.TextPrompt;
import escritorios.PrincipalMateriaPrima;
import formularios.FormularioRegistrarMateriaPrima;

/**
 * @author Hasper Franco
 */
public class InterfazGraficaFormularioRegistrarMateriaPrima extends InterfazGraficaFormularioRegistrar {

    public InterfazGraficaFormularioRegistrarMateriaPrima() {
        setEstadoConsulta(0);
    }

    private PrincipalMateriaPrima principalMateriaPrima;

    public PrincipalMateriaPrima getPrincipalMateriaPrima() {
        return principalMateriaPrima;
    }

    public void setPrincipalMateriaPrima(PrincipalMateriaPrima principalMateriaPrima) {
        this.principalMateriaPrima = principalMateriaPrima;
    }

    @Override
    public void nuevoFormularioRegistrar() {
        if (principalMateriaPrima.getFormularioRegistrarMateriaPrima() == null) {
            FormularioRegistrarMateriaPrima formularioRegistrar = new FormularioRegistrarMateriaPrima(frame, true);
            formularioRegistrar.setPrincipalMateriaPrima(principalMateriaPrima);
            principalMateriaPrima.setFormularioRegistrarMateriaPrima(formularioRegistrar);
            agregarBoxes();
            rellenarBoxes();
            infoTextPrompt();
            colorTema();
        }
        principalMateriaPrima.getFormularioRegistrarMateriaPrima().setVisible(true);
        principalMateriaPrima.setFormularioRegistrarMateriaPrima(null);
    }

    @Override
    public void infoTextPrompt() {
        new TextPrompt("NOMBRE", principalMateriaPrima.getFormularioRegistrarMateriaPrima().getTxtNombre());
        principalMateriaPrima.getFormularioRegistrarMateriaPrima().getTxtNombre().grabFocus();
    }

    @Override
    public void agregarBoxes() {
        this.setBoxMarca(principalMateriaPrima.getFormularioRegistrarMateriaPrima().getBoxMarca());
        this.setBoxProveedor(principalMateriaPrima.getFormularioRegistrarMateriaPrima().getBoxProveedor());
        this.setBoxUnidadMedida(principalMateriaPrima.getFormularioRegistrarMateriaPrima().getBoxUdeMedida());

    }

    @Override
    public void rellenarBoxes() {
        this.consultaRellenarMarca();
        this.consultaRellenarProveedor();
        this.consultaRellenarUnidadMedida();
    }

    @Override
    public void colorTema() {
        principalMateriaPrima.getFormularioRegistrarMateriaPrima().getPanelPrincipalTop().setBackground(principalMateriaPrima.getPanelPrincipalTop().getBackground());
    }

}
