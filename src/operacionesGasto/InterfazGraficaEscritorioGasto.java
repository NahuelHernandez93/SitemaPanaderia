package operacionesGasto;

import calsesPadre.InterfazGraficaEscritorio;
import clasesUtilidadGeneral.TextPrompt;
import escritorios.PrincipalGastos;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 * @author Hasper Franco
 */
public class InterfazGraficaEscritorioGasto extends InterfazGraficaEscritorio {

    @Override
    public void nuevaVentana() {
        if (principalAdministrador.getEscritorio().estacerrado(principalAdministrador.getGasto())) {
            PrincipalGastos principalGasto = new PrincipalGastos();
            principalAdministrador.setGasto(principalGasto);
            BasicInternalFrameTitlePane menupanel = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) principalGasto.getUI()).getNorthPane();
            int width = principalAdministrador.getEscritorio().getWidth();
            int Height = principalAdministrador.getEscritorio().getHeight();
            principalAdministrador.getGasto().remove(menupanel);
            principalAdministrador.getGasto().setSize(width, Height);
            principalAdministrador.getEscritorio().add(principalAdministrador.getGasto());
            infoTextPrompt();
            TablaGastos tablaGastos = new TablaGastos();
            tablaGastos.setPrincipalGastos(principalAdministrador.getGasto());
            tablaGastos.ejecutarRellenarTabla();
            principalAdministrador.getGasto().setTablaGasto(tablaGastos);
            //REVISAR FORMULARIO EDITAR (se crea aca y en escritorioGasto, en gastoe s necesario pero aca?)
            InterfazGraficaFormularioRegistrarGasto interfazGraficaFormularioRegistrarGasto = new InterfazGraficaFormularioRegistrarGasto();
            InterfazGraficaFormularioEditarGasto interfazGraficaFormularioEditarGasto = new InterfazGraficaFormularioEditarGasto();
            InterfazGraficaReporteGastos interfazGraficaReporteGastos = new InterfazGraficaReporteGastos();
            ABMGasto abm=new ABMGasto();
            principalAdministrador.getGasto().setInterfazGraficaRegistrar(interfazGraficaFormularioRegistrarGasto);
            principalAdministrador.getGasto().setInterfazGraficaEditar(interfazGraficaFormularioEditarGasto);
            principalAdministrador.getGasto().setInterfazGraficaReporteGastos(interfazGraficaReporteGastos);
            principalAdministrador.getGasto().setAbm(abm);
            principalAdministrador.getGasto().show();
        }
        colorInterfazEscritorio();
        principalAdministrador.getGasto().toFront();
    }

    @Override
    public void infoTextPrompt() {
        new TextPrompt("BUSCAR POR FECHA, FORMATO (AAAA-MM-DD)", principalAdministrador.getGasto().getTxtBuscar());
        principalAdministrador.getGasto().getTxtBuscar().grabFocus();
    }

    @Override
    public void colorInterfazEscritorio() {
        principalAdministrador.getGasto().getPanelPrincipalTop().setBackground(principalAdministrador.getPanelPrincipalTop().getBackground());
        principalAdministrador.getGasto().getTablaGrafica().setForeground(principalAdministrador.getPanelPrincipalTop().getBackground());
        principalAdministrador.getGasto().getTablaGrafica().setSelectionBackground(principalAdministrador.getPanelPrincipalTop().getBackground());
    }

}
