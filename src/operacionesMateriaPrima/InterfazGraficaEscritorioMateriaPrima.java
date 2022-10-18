package operacionesMateriaPrima;

import calsesPadre.InterfazGraficaEscritorio;
import clasesUtilidadGeneral.TextPrompt;
import escritorios.PrincipalMateriaPrima;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import operacionesIngresoMateriaPrima.ABMIngresoMateriaPrima;
import operacionesIngresoMateriaPrima.InterfazGraficaFormularioRegistrarIngresoMateriaPrima;

/**
 * @author Hasper Franco
 */
public class InterfazGraficaEscritorioMateriaPrima extends InterfazGraficaEscritorio {
    
    @Override
    public void nuevaVentana() {
        if (principalAdministrador.getEscritorio().estacerrado(principalAdministrador.getMateriaPrima())) {
            PrincipalMateriaPrima principalMateriaPrima = new PrincipalMateriaPrima();
            principalAdministrador.setMateriaPrima(principalMateriaPrima);
            BasicInternalFrameTitlePane menupanel = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) principalMateriaPrima.getUI()).getNorthPane();
            int width = principalAdministrador.getEscritorio().getWidth();
            int Height = principalAdministrador.getEscritorio().getHeight();
            principalAdministrador.getMateriaPrima().remove(menupanel);
            principalAdministrador.getMateriaPrima().setSize(width, Height);
            principalAdministrador.getEscritorio().add(principalAdministrador.getMateriaPrima());
            infoTextPrompt();
            TablaMateriaPrima tablaMateriaPrima = new TablaMateriaPrima();
            tablaMateriaPrima.setPrincipalMateriaPrima(principalAdministrador.getMateriaPrima());
            tablaMateriaPrima.ejecutarRellenarTabla();
            principalAdministrador.getMateriaPrima().setTablaMateriaPrima(tablaMateriaPrima);
            //REVISAR FORMULARIO EDITAR (se crea aca y en escritorioGasto, en gastoe s necesario pero aca?)
            InterfazGraficaFormularioRegistrarMateriaPrima InterfazGraficaRegistrar = new InterfazGraficaFormularioRegistrarMateriaPrima();
            InterfazGraficaFormularioEditarMateriaPrima InterfazGraficaEditar = new InterfazGraficaFormularioEditarMateriaPrima();
            InterfazGraficaFormularioRegistrarIngresoMateriaPrima InterfazGraficaRegistrarIngreso = new InterfazGraficaFormularioRegistrarIngresoMateriaPrima();
            ABMMateriaPrima abm = new ABMMateriaPrima();
            ABMIngresoMateriaPrima abmIngreso = new ABMIngresoMateriaPrima();
            principalAdministrador.getMateriaPrima().setInterfazGraficaRegistrar(InterfazGraficaRegistrar);
            principalAdministrador.getMateriaPrima().setInterfazGraficaEditar(InterfazGraficaEditar);
            principalAdministrador.getMateriaPrima().setInterfazGraficaRegistrarIngreso(InterfazGraficaRegistrarIngreso);
            principalAdministrador.getMateriaPrima().setAbm(abm);
            principalAdministrador.getMateriaPrima().setAbmIngreso(abmIngreso);
            principalAdministrador.getMateriaPrima().show();
        }
        colorInterfazEscritorio();
        principalAdministrador.getMateriaPrima().toFront();
    }
    
    @Override
    public void infoTextPrompt() {
        new TextPrompt("BUSCAR POR NOMBRE", principalAdministrador.getMateriaPrima().getTxtBuscar());
        principalAdministrador.getMateriaPrima().getTxtBuscar().grabFocus();
    }
    
    @Override
    public void colorInterfazEscritorio() {
        principalAdministrador.getMateriaPrima().getPanelPrincipalTop().setBackground(principalAdministrador.getPanelPrincipalTop().getBackground());
        principalAdministrador.getMateriaPrima().getTablaGrafica().setForeground(principalAdministrador.getPanelPrincipalTop().getBackground());
        principalAdministrador.getMateriaPrima().getTablaGrafica().setSelectionBackground(principalAdministrador.getPanelPrincipalTop().getBackground());
    }
    
}
