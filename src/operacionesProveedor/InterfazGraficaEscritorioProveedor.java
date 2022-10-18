package operacionesProveedor;

import calsesPadre.InterfazGraficaEscritorio;
import clasesUtilidadGeneral.TextPrompt;
import escritorios.PrincipalProveedor;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 * @author Hasper Franco
 */
public class InterfazGraficaEscritorioProveedor extends InterfazGraficaEscritorio {

    @Override
    public void nuevaVentana() {
        if (principalAdministrador.getEscritorio().estacerrado(principalAdministrador.getProveedor())) {
            PrincipalProveedor principalProveedor = new PrincipalProveedor();
            principalAdministrador.setProveedor(principalProveedor);
            BasicInternalFrameTitlePane menupanel = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) principalProveedor.getUI()).getNorthPane();
            int width = principalAdministrador.getEscritorio().getWidth();
            int Height = principalAdministrador.getEscritorio().getHeight();
            principalAdministrador.getProveedor().remove(menupanel);
            principalAdministrador.getProveedor().setSize(width, Height);
            principalAdministrador.getEscritorio().add(principalAdministrador.getProveedor());
            infoTextPrompt();
            TablaProveedor tablaProveedor = new TablaProveedor();
            tablaProveedor.setPrincipalProveedor(principalAdministrador.getProveedor());
            tablaProveedor.ejecutarRellenarTabla();
            principalAdministrador.getProveedor().setTablaProveedor(tablaProveedor);
            InterfazGraficaFormularioRegistrarProveedor interfazGraficaFormularioRegistrarProveedor = new InterfazGraficaFormularioRegistrarProveedor();
            InterfazGraficaFormularioEditarProveedor interfazGraficaFormularioEditarProveedor = new InterfazGraficaFormularioEditarProveedor();
            ABMProveedor abm=new ABMProveedor();
            
            principalAdministrador.getProveedor().setInterfazGraficaRegistrar(interfazGraficaFormularioRegistrarProveedor);
            principalAdministrador.getProveedor().setInterfazGraficaEditar(interfazGraficaFormularioEditarProveedor);
            principalAdministrador.getProveedor().setAbm(abm);
            
            principalAdministrador.getProveedor().show();
        }
        colorInterfazEscritorio();
        principalAdministrador.getProveedor().toFront();
    }

    @Override
    public void infoTextPrompt() {
        new TextPrompt("BUSCAR POR NOMBRE", principalAdministrador.getProveedor().getTxtBuscar());
        principalAdministrador.getProveedor().getTxtBuscar().grabFocus();
    }

    @Override
    public void colorInterfazEscritorio() {
        principalAdministrador.getProveedor().getPanelPrincipalTop().setBackground(principalAdministrador.getPanelPrincipalTop().getBackground());
        principalAdministrador.getProveedor().getTablaGrafica().setForeground(principalAdministrador.getPanelPrincipalTop().getBackground());
        principalAdministrador.getProveedor().getTablaGrafica().setSelectionBackground(principalAdministrador.getPanelPrincipalTop().getBackground());
    }

}
