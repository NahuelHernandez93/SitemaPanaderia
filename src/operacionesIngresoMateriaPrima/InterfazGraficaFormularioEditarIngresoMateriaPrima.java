package operacionesIngresoMateriaPrima;

import calsesPadre.InterfazGraficaFormularioEditar;
import clasesUtilidadGeneral.TextPrompt;
import conexion.ConexionHibernate;
import entidades.IngresoMateriaPrima;
import escritorios.PrincipalIngresoMatPrima;
import formularios.FormularioEditarIngresoMateriaPrima;
import java.awt.HeadlessException;
import java.util.Date;
import org.hibernate.Session;

/**
 * @author Hasper Franco
 */
public class InterfazGraficaFormularioEditarIngresoMateriaPrima extends InterfazGraficaFormularioEditar {

    protected PrincipalIngresoMatPrima principalIngresoMateriaPrima;
    protected TablaIngresoMateriaPrima tablaIngresoMateriaPrima;

    public PrincipalIngresoMatPrima getPrincipalIngresoMateriaPrima() {
        return principalIngresoMateriaPrima;
    }

    public void setPrincipalIngresoMateriaPrima(PrincipalIngresoMatPrima principalIngresoMateriaPrima) {
        this.principalIngresoMateriaPrima = principalIngresoMateriaPrima;
    }

    public TablaIngresoMateriaPrima getTablaIngresoMateriaPrima() {
        return tablaIngresoMateriaPrima;
    }

    public void setTablaIngresoMateriaPrima(TablaIngresoMateriaPrima tablaIngresoMateriaPrima) {
        this.tablaIngresoMateriaPrima = tablaIngresoMateriaPrima;
    }

    @Override
    public void nuevoFormularioEditar() {
        if (principalIngresoMateriaPrima.getFormularioEditarIngresoMateriaPrima() == null) {
            FormularioEditarIngresoMateriaPrima formularioEditar = new FormularioEditarIngresoMateriaPrima(frame, true);
            formularioEditar.setPrincipalIngresoMateriaPrima(principalIngresoMateriaPrima);
            principalIngresoMateriaPrima.setFormularioEditarIngresoMateriaPrima(formularioEditar);
            colorTema();
            transferirDatos();
            infoTextPrompt();
        }
        principalIngresoMateriaPrima.getFormularioEditarIngresoMateriaPrima().setVisible(true);
        principalIngresoMateriaPrima.setFormularioEditarIngresoMateriaPrima(null);
    }

    @Override
    public void colorTema() {
        principalIngresoMateriaPrima.getFormularioEditarIngresoMateriaPrima().getPanelPrincipalTop().setBackground(principalIngresoMateriaPrima.getPanelPrincipalTop().getBackground());
        principalIngresoMateriaPrima.getFormularioEditarIngresoMateriaPrima().getDateFecha().setColorBackground(principalIngresoMateriaPrima.getPanelPrincipalTop().getBackground());
        principalIngresoMateriaPrima.getFormularioEditarIngresoMateriaPrima().getDateFecha().setColorDiaActual(principalIngresoMateriaPrima.getPanelPrincipalTop().getBackground());

    }

    @Override
    public void transferirDatos() {
        new TablaIngresoMateriaPrima().setPrincipalIngresoMateriaPrima(principalIngresoMateriaPrima);
        int fila = principalIngresoMateriaPrima.getTablaGrafica().getSelectedRow();
        principalIngresoMateriaPrima.getFormularioEditarIngresoMateriaPrima().getTxtMatPr().setText(principalIngresoMateriaPrima.getTablaGrafica().getValueAt(fila, 0).toString());
        principalIngresoMateriaPrima.getFormularioEditarIngresoMateriaPrima().getTxttotalEnvases().setText(principalIngresoMateriaPrima.getTablaGrafica().getValueAt(fila, 1).toString());
        principalIngresoMateriaPrima.getFormularioEditarIngresoMateriaPrima().getTxtUdsPorEnvase().setText(principalIngresoMateriaPrima.getTablaGrafica().getValueAt(fila, 2).toString());
        principalIngresoMateriaPrima.getFormularioEditarIngresoMateriaPrima().getTxtPrecioTotal().setText(principalIngresoMateriaPrima.getTablaGrafica().getValueAt(fila, 4).toString());
        fechaIngreso();
    }

    public void infoTextPrompt() {
        new TextPrompt("TOTAL ENVASES", principalIngresoMateriaPrima.getFormularioEditarIngresoMateriaPrima().getTxttotalEnvases());
        new TextPrompt("UDS POR ENVASES", principalIngresoMateriaPrima.getFormularioEditarIngresoMateriaPrima().getTxtUdsPorEnvase());
        new TextPrompt("PRECIO TOTAL", principalIngresoMateriaPrima.getFormularioEditarIngresoMateriaPrima().getTxtPrecioTotal());
        principalIngresoMateriaPrima.getFormularioEditarIngresoMateriaPrima().getTxttotalEnvases().grabFocus();
    }

    @Deprecated
    @Override
    public void agregarBoxes() {
    }

    @Deprecated
    @Override
    public void rellenarBoxes() {
    }

    private void fechaIngreso() {
        transferirFecha(obtenerDatos());
    }

    private Date obtenerDatos() {
        Date fecha = new Date();
        Integer id = principalIngresoMateriaPrima.getTablaIngresoMateriaPrima().obtenerIdFilaSeleccionada();
        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            miSesion.beginTransaction();
            IngresoMateriaPrima i = (IngresoMateriaPrima) miSesion.get(IngresoMateriaPrima.class, id);
            fecha = i.getFecha();
            miSesion.getTransaction().commit();
        } catch (HeadlessException | NumberFormatException e) {
        }
        return fecha;
    }

    private void transferirFecha(Date fecha) {
        principalIngresoMateriaPrima.getFormularioEditarIngresoMateriaPrima().getDateFecha().setDatoFecha(fecha);
    }

}
