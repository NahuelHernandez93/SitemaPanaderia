package operacionesCuenta;

import calsesPadre.InterfazGraficaEscritorio;
import clasesUtilidadGeneral.TextPrompt;
import escritorios.PrincipalCuenta;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 * @author Hasper Franco
 */
public class InterfazGraficaEscritorioCuenta extends InterfazGraficaEscritorio {

    private Integer idCliente;

    private String nombreCliente;

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    @Override
    public void nuevaVentana() {
        if (principalAdministrador.getEscritorio().estacerrado(principalAdministrador.getCuenta())) {
            PrincipalCuenta principalCuenta = new PrincipalCuenta();
            principalAdministrador.setCuenta(principalCuenta);
            BasicInternalFrameTitlePane menupanel = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) principalCuenta.getUI()).getNorthPane();
            int width = principalAdministrador.getEscritorio().getWidth();
            int Height = principalAdministrador.getEscritorio().getHeight();
            principalAdministrador.getCuenta().remove(menupanel);
            principalAdministrador.getCuenta().setSize(width, Height);
            principalAdministrador.getEscritorio().add(principalAdministrador.getCuenta());
            infoTextPrompt();
            TablaCuenta tablaCuenta = new TablaCuenta();
            tablaCuenta.setPrincipalCuenta(principalAdministrador.getCuenta());
            tablaCuenta.setIdCliente(idCliente);
            tablaCuenta.ejecutarRellenarTabla();
            principalAdministrador.getCuenta().setIdCliente(idCliente);
            TablaMovimientoCuenta tablaMovimientoCuenta = new TablaMovimientoCuenta();
            tablaMovimientoCuenta.setPrincipalCuenta(principalAdministrador.getCuenta());
            insertarNombreCliente();
            principalAdministrador.getCuenta().setTablaCuenta(tablaCuenta);
            principalAdministrador.getCuenta().setTablaMovimientoCuenta(tablaMovimientoCuenta);
            InterfazGraficaEditarMovimiento interfazGraficaEditarMovimiento = new InterfazGraficaEditarMovimiento();  
            principalAdministrador.getCuenta().setInterfazGraficaEditarMovimiento(interfazGraficaEditarMovimiento);
            estadoInicialVentanaCuenta();
            principalAdministrador.getCuenta().show();
        }
        colorInterfazEscritorio();
        principalAdministrador.getCuenta().toFront();
    }

    @Override
    public void infoTextPrompt() {
        new TextPrompt("BUSCAR POR FECHA, FORMATO (AAAA-MM-DD)", principalAdministrador.getCuenta().getTxtBuscar());
        new TextPrompt("MONTO INICIAL", principalAdministrador.getCuenta().getTxtMontoInicial());
        new TextPrompt("MONTO", principalAdministrador.getCuenta().getTxtMonto());
        new TextPrompt("MOTIVO", principalAdministrador.getCuenta().getEditPaneMotivo());
        principalAdministrador.getCuenta().getTxtBuscar().grabFocus();
    }

    @Override
    public void colorInterfazEscritorio() {
        principalAdministrador.getCuenta().getPanelPrincipalTop().setBackground(principalAdministrador.getPanelPrincipalTop().getBackground());
        principalAdministrador.getCuenta().getTablaGraficaCuenta().setForeground(principalAdministrador.getPanelPrincipalTop().getBackground());
        principalAdministrador.getCuenta().getTablaGraficaCuenta().setSelectionBackground(principalAdministrador.getPanelPrincipalTop().getBackground());

        principalAdministrador.getCuenta().getTablaGraficaMovimiento().setForeground(principalAdministrador.getPanelPrincipalTop().getBackground());
        principalAdministrador.getCuenta().getTablaGraficaMovimiento().setSelectionBackground(principalAdministrador.getPanelPrincipalTop().getBackground());
    }
    
        /**
     * Establece el estado inicial de los elementos de la pestaña Cuenta.
     */
    private void estadoInicialVentanaCuenta() {
        principalAdministrador.getCuenta().getBtnGuardarCuenta().setEnabled(false);
        principalAdministrador.getCuenta().getEditPaneMotivo().setEnabled(false);
        principalAdministrador.getCuenta().getTxtMontoInicial().setEnabled(false);
        principalAdministrador.getCuenta().getBtnGuardarMovimiento().setEnabled(false);
    }

    private void insertarNombreCliente() {
        principalAdministrador.getCuenta().getLblNombre().setText(this.nombreCliente);
    }

    public void habilitarNuevaCuenta(PrincipalCuenta p) {
        p.getTxtMontoInicial().setEnabled(true);
        p.getBtnGuardarCuenta().setEnabled(true);
    }

    public void habilitarNuevoMovimientoCuenta(PrincipalCuenta p) {
        p.getEditPaneMotivo().setEnabled(true);
        p.getTxtMonto().setEnabled(true);
        p.getBtnGuardarMovimiento().setEnabled(true);
    }

    public void desHabilitarNuevoMovimientoCuenta(PrincipalCuenta p) {
        p.getEditPaneMotivo().setEnabled(false);
        p.getTxtMonto().setEnabled(false);
        p.getBtnGuardarMovimiento().setEnabled(false);
        p.getEditPaneMotivo().setText("");
        p.getTxtMonto().setText("");

    }

    public void desHabilitarNuevaCuenta(PrincipalCuenta p) {
        p.getTxtMontoInicial().setEnabled(false);
        p.getBtnGuardarCuenta().setEnabled(false);
        p.getTxtMontoInicial().setText("");
    }
    
    
    

}
