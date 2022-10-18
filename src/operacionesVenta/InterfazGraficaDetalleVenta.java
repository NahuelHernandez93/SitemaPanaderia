package operacionesVenta;

import clasesUtilidadGeneral.OperacionesUtiles;
import escritorios.PrincipalVenta;
import formularios.FormularioDetalleDeVenta;
import formularios.FormularioEstadoVenta;
import java.awt.Frame;

/**
 * @author Hasper Franco
 */
public class InterfazGraficaDetalleVenta {

    private PrincipalVenta principalVenta;

    public PrincipalVenta getPrincipalVenta() {
        return principalVenta;
    }

    public void setPrincipalVenta(PrincipalVenta principalVenta) {
        this.principalVenta = principalVenta;
    }

    public void nuevoFormularioDetalleDeVenta() {

        FormularioDetalleDeVenta formularioDetalleVenta = new FormularioDetalleDeVenta(new Frame(), true);
        formularioDetalleVenta.setPrincipalVenta(principalVenta);
        principalVenta.setFormularioDetalleVenta(formularioDetalleVenta);
        colorTema();
        //TABIENRELLENA LOS LABELS LOS LABELS
        TablaDetalleVenta tablaDetalleVenta = new TablaDetalleVenta();
        tablaDetalleVenta.setPrincipalVenta(principalVenta);
        tablaDetalleVenta.ejecutarRellenarTabla();
        principalVenta.getFormularioDetalleVenta().setIdVenta(tablaDetalleVenta.getIdVenta());

        ComprobanteVenta comprobante = new ComprobanteVenta();
        formularioDetalleVenta.setComprobante(comprobante);

        principalVenta.getFormularioDetalleVenta().setVisible(true);
    }

    public void colorTema() {
        principalVenta.getFormularioDetalleVenta().getPanelPrincipalTop().setBackground(principalVenta.getPanelPrincipalTop().getBackground());
    }

}
