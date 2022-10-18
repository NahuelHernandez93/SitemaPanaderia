package operacionesVenta;

import calsesPadre.InterfazGraficaEscritorio;
import clasesUtilidadGeneral.TextPrompt;
import escritorios.PrincipalVenta;
import java.awt.Color;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 * @author Hasper Franco
 */
public class InterfazGraficaEscritorioVenta extends InterfazGraficaEscritorio {

    @Override
    public void nuevaVentana() {
        if (principalAdministrador.getEscritorio().estacerrado(principalAdministrador.getVenta())) {
            PrincipalVenta principalVenta = new PrincipalVenta();
            principalAdministrador.setVenta(principalVenta);
            BasicInternalFrameTitlePane menupanel = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) principalVenta.getUI()).getNorthPane();
            int width = principalAdministrador.getEscritorio().getWidth();
            int Height = principalAdministrador.getEscritorio().getHeight();
            principalAdministrador.getVenta().remove(menupanel);
            principalAdministrador.getVenta().setSize(width, Height);
            principalAdministrador.getEscritorio().add(principalAdministrador.getVenta());
            infoTextPrompt();
            TablaVenta tablaVenta = new TablaVenta();
            tablaVenta.setPrincipalVenta(principalAdministrador.getVenta());
            tablaVenta.ejecutarRellenarTabla();
            principalAdministrador.getVenta().setTablaVenta(tablaVenta);
            //REVISAR FORMULARIO EDITAR (se crea aca y en escritorioGasto, en gastoe s necesario pero aca?)
            InterfazGraficaFormularioRegistrarVenta interfazGraficaFormularioRegistrarVenta = new InterfazGraficaFormularioRegistrarVenta();
            InterfazGraficaFormularioEditarVenta interfazGraficaFormularioEditarVenta = new InterfazGraficaFormularioEditarVenta();
            InterfazGraficaDetalleVenta interfazGraficaDetalleVenta = new InterfazGraficaDetalleVenta();
            InterfazGraficaFormularioEstadoVenta interfazGraficaFormularioEstadoVenta = new InterfazGraficaFormularioEstadoVenta();

            principalAdministrador.getVenta().setInterfazGraficaEstadoVenta(interfazGraficaFormularioEstadoVenta);
            principalAdministrador.getVenta().setInterfazGraficaRegistrar(interfazGraficaFormularioRegistrarVenta);
            principalAdministrador.getVenta().setInterfazGraficaEditar(interfazGraficaFormularioEditarVenta);
            principalAdministrador.getVenta().setInterfazGraficaDetalleVenta(interfazGraficaDetalleVenta);
            principalAdministrador.getVenta().setPrincipalAdministrador(principalAdministrador);
            radBrn();
            principalAdministrador.getVenta().show();
        }
        colorInterfazEscritorio();
        principalAdministrador.getVenta().toFront();
    }

    @Override
    public void infoTextPrompt() {
        new TextPrompt("BUSCAR POR FECHA, FORMATO (AAAA-MM-DD)", principalAdministrador.getVenta().getTxtBuscar());
        principalAdministrador.getVenta().getTxtBuscar().grabFocus();
    }

    @Override
    public void colorInterfazEscritorio() {
        principalAdministrador.getVenta().getPanelPrincipalTop().setBackground(principalAdministrador.getPanelPrincipalTop().getBackground());
        principalAdministrador.getVenta().getTablaGrafica().setForeground(principalAdministrador.getPanelPrincipalTop().getBackground());
        principalAdministrador.getVenta().getTablaGrafica().setSelectionBackground(principalAdministrador.getPanelPrincipalTop().getBackground());
    }

    private void radBrn() {
        principalAdministrador.getVenta().getRadButtonPendientes().setEnabled(false);
        principalAdministrador.getVenta().getRadButtonPendientes().setForeground(new Color(102, 102, 102));
    }

}
