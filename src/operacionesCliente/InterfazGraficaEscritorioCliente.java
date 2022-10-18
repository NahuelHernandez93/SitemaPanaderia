package operacionesCliente;

import calsesPadre.InterfazGraficaEscritorio;
import escritorios.PrincipalCliente;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import clasesUtilidadGeneral.TextPrompt;

/**
 *
 * @author Hasper Franco
 */
public class InterfazGraficaEscritorioCliente extends InterfazGraficaEscritorio {

    @Override
    public void nuevaVentana() {

        if (principalAdministrador.getEscritorio().estacerrado(principalAdministrador.getCliente())) {
            PrincipalCliente principalCliente = new PrincipalCliente();
            principalAdministrador.setCliente(principalCliente);
            BasicInternalFrameTitlePane menupanel = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) principalCliente.getUI()).getNorthPane();
            int width = principalAdministrador.getEscritorio().getWidth();
            int Height = principalAdministrador.getEscritorio().getHeight();
            principalAdministrador.getCliente().remove(menupanel);
            principalAdministrador.getCliente().setSize(width, Height);
            principalAdministrador.getEscritorio().add(principalAdministrador.getCliente());
            infoTextPrompt();
            TablaCliente tablaCliente = new TablaCliente();
            tablaCliente.setPrincipalCliente(principalAdministrador.getCliente());
            tablaCliente.ejecutarRellenarTabla();
            principalAdministrador.getCliente().setTablaCliente(tablaCliente);
            InterfazGraficaFormularioRegistrarCliente interfazGraficaRegistrar = new InterfazGraficaFormularioRegistrarCliente();
            InterfazGraficaFormularioEditarCliente interfazGraficaEditar = new InterfazGraficaFormularioEditarCliente();
            principalAdministrador.getCliente().setInterfazGraficaRegistrar(interfazGraficaRegistrar);
            principalAdministrador.getCliente().setInterfazGraficaEditar(interfazGraficaEditar);
            //solo para pasar admin al EscritorioCuenta
            principalAdministrador.getCliente().setPrincipalAdministrador(principalAdministrador);
            principalAdministrador.getCliente().show();
        }
        colorInterfazEscritorio();
        principalAdministrador.getCliente().toFront();

    }

    @Override
    public void colorInterfazEscritorio() {
        principalAdministrador.getCliente().getPanelPrincipalTop().setBackground(principalAdministrador.getPanelPrincipalTop().getBackground());
        principalAdministrador.getCliente().getTablaGrafica().setForeground(principalAdministrador.getPanelPrincipalTop().getBackground());
        principalAdministrador.getCliente().getTablaGrafica().setSelectionBackground(principalAdministrador.getPanelPrincipalTop().getBackground());
    }

    @Override
    public void infoTextPrompt() {
        new TextPrompt("BUSCAR POR NOMBRE", principalAdministrador.getCliente().getTxtBuscar());
        principalAdministrador.getCliente().getTxtBuscar().grabFocus();
    }

}
