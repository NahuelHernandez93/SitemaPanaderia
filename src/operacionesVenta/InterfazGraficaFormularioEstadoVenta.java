package operacionesVenta;

import escritorios.PrincipalVenta;
import formularios.FormularioDetalleDeVenta;
import formularios.FormularioEstadoVenta;
import java.awt.Frame;

/**
 * @author Hasper Franco
 */
public class InterfazGraficaFormularioEstadoVenta {

    private PrincipalVenta principalVenta;

    public PrincipalVenta getPrincipalVenta() {
        return principalVenta;
    }

    public void setPrincipalVenta(PrincipalVenta principalVenta) {
        this.principalVenta = principalVenta;
    }

    public void nuevoFormularioEstadoVenta() {
        if (principalVenta.getFormularioEstadoVenta() == null) {
            FormularioEstadoVenta formularioEstadoVenta = new FormularioEstadoVenta(new Frame(), true);
            formularioEstadoVenta.setPrincipalVenta(principalVenta);
            principalVenta.setFormularioEstadoVenta(formularioEstadoVenta);
            colorTema();
            ocultarIconos();
            auotseleccionarEstadoPrevio();
        }

        principalVenta.getFormularioEstadoVenta().setVisible(true);
        principalVenta.setFormularioEstadoVenta(null);
    }

    public void colorTema() {
        principalVenta.getFormularioEstadoVenta().getPanelPrincipalTop().setBackground(principalVenta.getPanelPrincipalTop().getBackground());
    }

    private void ocultarIconos() {
        principalVenta.getFormularioEstadoVenta().getLblC().setVisible(false);
        principalVenta.getFormularioEstadoVenta().getLblP().setVisible(false);
        principalVenta.getFormularioEstadoVenta().getLblR().setVisible(false);
        principalVenta.getFormularioEstadoVenta().getLblE().setVisible(false);
    }

    private void auotseleccionarEstadoPrevio() {
        int fila = principalVenta.getTablaGrafica().getSelectedRow();
        String estado = principalVenta.getTablaGrafica().getValueAt(fila, 4).toString();
        
        switch (estado) {
            case "realizado":
                principalVenta.getFormularioEstadoVenta().getLblR().setVisible(true);
                principalVenta.getFormularioEstadoVenta().setEstado(3);
                break;
            case "pendiennte":
                principalVenta.getFormularioEstadoVenta().getLblP().setVisible(true);
                principalVenta.getFormularioEstadoVenta().setEstado(4);
                break;
            case "cancelado":
                principalVenta.getFormularioEstadoVenta().getLblC().setVisible(true);
                principalVenta.getFormularioEstadoVenta().setEstado(5);
                break;
        }

    }
    
        public void seleccionElminar(FormularioEstadoVenta f) {
        f.getLblC().setVisible(false);
        f.getLblE().setVisible(true);
        f.getLblP().setVisible(false);
        f.getLblR().setVisible(false);
    }

    public void seleccionCancelar(FormularioEstadoVenta f) {
        f.getLblC().setVisible(true);
        f.getLblE().setVisible(false);
        f.getLblP().setVisible(false);
        f.getLblR().setVisible(false);
    }

    public void seleccionPendiente(FormularioEstadoVenta f) {
        f.getLblC().setVisible(false);
        f.getLblE().setVisible(false);
        f.getLblP().setVisible(true);
        f.getLblR().setVisible(false);
    }

    public void seleccionRealizado(FormularioEstadoVenta f) {
        f.getLblC().setVisible(false);
        f.getLblE().setVisible(false);
        f.getLblP().setVisible(false);
        f.getLblR().setVisible(true);
    }

}
