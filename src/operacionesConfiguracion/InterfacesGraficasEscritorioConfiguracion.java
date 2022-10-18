package operacionesConfiguracion;

import calsesPadre.InterfazGraficaEscritorio;
import clasesUtilidadGeneral.TextPrompt;
import escritorios.PrincipalConfiguracion;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author FRANCO
 */
public class InterfacesGraficasEscritorioConfiguracion extends InterfazGraficaEscritorio {

    /**
     * Crea una nuea instancia para la clase PrincipalConfiguracion (intefaz
     * grafica).
     *
     * @param p
     */
    @Override
    public void nuevaVentana() {

        if (principalAdministrador.getEscritorio().estacerrado(principalAdministrador.getConfiguracion())) {
            PrincipalConfiguracion principalConfiguracion = new PrincipalConfiguracion();
            principalAdministrador.setConfiguracion(principalConfiguracion);
            BasicInternalFrameTitlePane menupanel = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) principalConfiguracion.getUI()).getNorthPane();
            int width = principalAdministrador.getEscritorio().getWidth();
            int Height = principalAdministrador.getEscritorio().getHeight();
            principalAdministrador.getConfiguracion().remove(menupanel);
            principalAdministrador.getConfiguracion().setSize(width, Height);

            try {
                principalAdministrador.getEscritorio().add(principalAdministrador.getConfiguracion());
            } catch (IllegalArgumentException e) {
            }
            infoTextPrompt();

            ConfiguracionTxt cargarConfiguracionTxt = new ConfiguracionTxt();
            cargarConfiguracionTxt.setPrincipalAdministrador(principalAdministrador);
            cargarConfiguracionTxt.leerArchivoConfig();

            ConfiguracionTxt configuracionTxt = AutoSetColor(cargarConfiguracionTxt);

            principalConfiguracion.setConfiguracionTxt(configuracionTxt);
            principalConfiguracion.setInterfacesGraficasEscritorioConfiguracion(this);

            autoSetSaldoCuenta(cargarConfiguracionTxt.getSaldoCuenta());

            principalAdministrador.getConfiguracion().show();
        }
        colorInterfazEscritorio();
        principalAdministrador.getConfiguracion().toFront();

    }

    @Override
    public void colorInterfazEscritorio() {
        principalAdministrador.getConfiguracion().getPanelPrincipalTop().setBackground(principalAdministrador.getPanelPrincipalTop().getBackground());
    }

    @Override
    public void infoTextPrompt() {
        new TextPrompt("NOTIFICAR CUANDO EL SALDO SEA MENOR A ", principalAdministrador.getConfiguracion().getTxtSaldoCuenta());
        principalAdministrador.getConfiguracion().getTxtSaldoCuenta().grabFocus();
    }

    private void autoSetSaldoCuenta(String saldo) {
        principalAdministrador.getConfiguracion().getTxtSaldoCuenta().setText(saldo);
    }

    private ConfiguracionTxt AutoSetColor(ConfiguracionTxt configuracionTxt) {
    
        configuracionTxt.setColor(configuracionTxt.getColor().getColorPrimario().getBlue(),
                configuracionTxt.getColor().getColorPrimario().getGreen(),
                configuracionTxt.getColor().getColorPrimario().getRed(),
                configuracionTxt.getColor().getColorSecundario().getBlue(),
                configuracionTxt.getColor().getColorSecundario().getGreen(),
                configuracionTxt.getColor().getColorSecundario().getRed());
        return configuracionTxt;
    }

}
