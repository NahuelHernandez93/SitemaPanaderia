package operacionesProducto;

import calsesPadre.InterfazGraficaEscritorio;
import clasesUtilidadGeneral.TextPrompt;
import escritorios.PrincipalProducto;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 * @author Hasper Franco
 */
public class InterfazGraficaEscritorioProducto extends InterfazGraficaEscritorio {

    @Override
    public void nuevaVentana() {
        if (principalAdministrador.getEscritorio().estacerrado(principalAdministrador.getProducto())) {
            PrincipalProducto principalProducto = new PrincipalProducto();
            principalAdministrador.setProducto(principalProducto);
            BasicInternalFrameTitlePane menupanel = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) principalProducto.getUI()).getNorthPane();
            int width = principalAdministrador.getEscritorio().getWidth();
            int Height = principalAdministrador.getEscritorio().getHeight();
            principalAdministrador.getProducto().remove(menupanel);
            principalAdministrador.getProducto().setSize(width, Height);
            principalAdministrador.getEscritorio().add(principalAdministrador.getProducto());
            infoTextPrompt();
            TablaProducto tablaProducto = new TablaProducto();
            tablaProducto.setPrincipalProducto(principalAdministrador.getProducto());
            tablaProducto.ejecutarRellenarTabla();
            principalAdministrador.getProducto().setTablaProducto(tablaProducto);

            InterfazGraficaFormularioRegistrarProducto interfazGraficaRegistrar = new InterfazGraficaFormularioRegistrarProducto();
            InterfazGraficaFormularioEditarProducto interfazGraficaEditar = new InterfazGraficaFormularioEditarProducto();
            InterfazGraficaFormularioRegistrarPrecioProducto interfazGraficaPrecio = new InterfazGraficaFormularioRegistrarPrecioProducto();
            ABMProducto abm=new ABMProducto();
            OperacionesSecundariasProducto operacionesSecundariasProducto=new OperacionesSecundariasProducto();
            
            principalAdministrador.getProducto().setInterfazGraficaRegistrar(interfazGraficaRegistrar);
            principalAdministrador.getProducto().setInterfazGraficaEditar(interfazGraficaEditar);
            principalAdministrador.getProducto().setInterfazGraficaPrecio(interfazGraficaPrecio);
            principalAdministrador.getProducto().setAbm(abm);
            principalAdministrador.getProducto().setOperacionesSecundariasProducto(operacionesSecundariasProducto);
            
            principalAdministrador.getProducto().show();
        }
        colorInterfazEscritorio();
        principalAdministrador.getProducto().toFront();
    }

    @Override
    public void infoTextPrompt() {
        principalAdministrador.getProducto().getPanelPrincipalTop().setBackground(principalAdministrador.getPanelPrincipalTop().getBackground());
        principalAdministrador.getProducto().getTablaGrafica().setForeground(principalAdministrador.getPanelPrincipalTop().getBackground());
        principalAdministrador.getProducto().getTablaGrafica().setSelectionBackground(principalAdministrador.getPanelPrincipalTop().getBackground());
    }

    @Override
    public void colorInterfazEscritorio() {
        new TextPrompt("BUSCAR POR NOMBRE", principalAdministrador.getProducto().getTxtBuscar());
        principalAdministrador.getProducto().getTxtBuscar().grabFocus();
    }

}
