package operacionesCaja;

import calsesPadre.InterfazGraficaFormularioEditar;
import conexion.ConexionHibernate;
import entidades.CorteCaja;
import escritorios.PrincipalCaja;
import formularios.FormularioEditarCorte;
import java.awt.HeadlessException;
import java.util.Date;
import org.hibernate.Session;

/**
 * @author Hasper Franco
 */
public class InterfazGraficaFormularioEditarCorte extends InterfazGraficaFormularioEditar {

    protected PrincipalCaja principalCaja;


    public PrincipalCaja getPrincipalCaja() {
        return principalCaja;
    }

    public void setPrincipalCaja(PrincipalCaja principalCaja) {
        this.principalCaja = principalCaja;
    }

    @Override
    public void nuevoFormularioEditar() {
        if (principalCaja.getFormularioEditarCorte()== null) {
            FormularioEditarCorte formularioEditar = new FormularioEditarCorte(frame, true);
            formularioEditar.setPrincipalCaja(principalCaja);
            principalCaja.setFormularioEditarCorte(formularioEditar);
            transferirDatos();
            colorTema();
        }

        principalCaja.getFormularioEditarCorte().setVisible(true);
        principalCaja.setFormularioEditarCorte(null);
    }

    @Override
    public void colorTema() {
        principalCaja.getFormularioEditarCorte().getPanelPrincipalTop().setBackground(principalCaja.getPanelPrincipalTop().getBackground());
        principalCaja.getFormularioEditarCorte().getrSDateChooser().setColorBackground(principalCaja.getPanelPrincipalTop().getBackground());
    }

    @Override
    public void transferirDatos() {
        new TablaCaja().setPrincipalCaja(principalCaja);
        int fila = principalCaja.getTablaGrafica().getSelectedRow();
        principalCaja.getFormularioEditarCorte().getTxtTotalIngresos().setText(principalCaja.getTablaGrafica().getValueAt(fila, 0).toString());
        principalCaja.getFormularioEditarCorte().getTxtTotalEgresos().setText(principalCaja.getTablaGrafica().getValueAt(fila, 1).toString());
        principalCaja.getFormularioEditarCorte().getTxtBalance().setText(principalCaja.getTablaGrafica().getValueAt(fila, 2).toString());
        fechaCorte();
    }

    @Override
    public void agregarBoxes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void rellenarBoxes() {

    }

    private void fechaCorte() {
        transferirFecha(obtenerDatos());
    }

    private Date obtenerDatos() {
        Date fecha = new Date();
        Integer id = principalCaja.getTablaCaja().obtenerIdFilaSeleccionada();
        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            miSesion.beginTransaction();
            CorteCaja c = (CorteCaja) miSesion.get(CorteCaja.class, id);
            fecha = c.getFecha();
            miSesion.getTransaction().commit();
        } catch (HeadlessException | NumberFormatException e) {
        }
        return fecha;
    }

    private void transferirFecha(Date fecha) {
        principalCaja.getFormularioEditarCorte().getrSDateChooser().setDatoFecha(fecha);
    }

}
