package operacionesGasto;

import calsesPadre.InterfazGraficaFormularioEditar;
import clasesUtilidadGeneral.TextPrompt;
import conexion.ConexionHibernate;
import entidades.Gasto;
import escritorios.PrincipalGastos;
import formularios.FormularioEditarGasto;
import java.awt.HeadlessException;
import java.util.Date;
import org.hibernate.Session;

/**
 * @author Hasper Franco
 */
public class InterfazGraficaFormularioEditarGasto extends InterfazGraficaFormularioEditar {

    protected PrincipalGastos principalGastos;
    protected TablaGastos tablaGastos;

    public PrincipalGastos getPrincipalGastos() {
        return principalGastos;
    }

    public void setPrincipalGastos(PrincipalGastos principalGastos) {
        this.principalGastos = principalGastos;
    }

    public TablaGastos getTablaGastos() {
        return tablaGastos;
    }

    public void setTablaGastos(TablaGastos tablaGastos) {
        this.tablaGastos = tablaGastos;
    }

    @Override
    public void nuevoFormularioEditar() {
        if (principalGastos.getFormularioEditarGasto() == null) {
            FormularioEditarGasto formularioEditar = new FormularioEditarGasto(frame, true);
            formularioEditar.setPrincipalGastos(principalGastos);
            principalGastos.setFormularioEditarGasto(formularioEditar);
            colorTema();
            transferirDatos();
            infoTextPrompt();
        }
        principalGastos.getFormularioEditarGasto().setVisible(true);
        principalGastos.setFormularioEditarGasto(null);
    }

    @Override
    public void colorTema() {
        principalGastos.getFormularioEditarGasto().getPanelPrincipalTop().setBackground(principalGastos.getPanelPrincipalTop().getBackground());
    }

    @Override
    public void transferirDatos() {
        //  new TablaGastos().setPrincipalGastos(principalGastos);
        int fila = principalGastos.getTablaGrafica().getSelectedRow();
        principalGastos.getFormularioEditarGasto().getTxtDescripcion().setText(principalGastos.getTablaGrafica().getValueAt(fila, 0).toString());
        principalGastos.getFormularioEditarGasto().getTxtTotalGastado().setText(principalGastos.getTablaGrafica().getValueAt(fila, 1).toString());
        fechagasto();
    }

    @Deprecated
    @Override
    public void agregarBoxes() {

    }

    @Deprecated
    @Override
    public void rellenarBoxes() {

    }

    private void fechagasto() {
        transferirFecha(obtenerDatos());
    }

    public void infoTextPrompt() {
        new TextPrompt("DESCRIPCION", principalGastos.getFormularioEditarGasto().getTxtDescripcion());
        new TextPrompt("TOTAL GASTADO", principalGastos.getFormularioEditarGasto().getTxtTotalGastado());
        principalGastos.getFormularioEditarGasto().getTxtDescripcion().grabFocus();
    }

    private Date obtenerDatos() {
        Date fecha = new Date();
        Integer id = principalGastos.getTablaGasto().obtenerIdFilaSeleccionada();
        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            miSesion.beginTransaction();
            Gasto g = (Gasto) miSesion.get(Gasto.class, id);
            fecha = g.getFecha();
            miSesion.getTransaction().commit();
        } catch (HeadlessException | NumberFormatException e) {
        }
        return fecha;
    }

    private void transferirFecha(Date fecha) {
        principalGastos.getFormularioEditarGasto().getrSDateChooser().setDatoFecha(fecha);
    }

}
