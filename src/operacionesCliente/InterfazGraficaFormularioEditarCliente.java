package operacionesCliente;

import calsesPadre.InterfazGraficaFormularioEditar;
import clasesUtilidadGeneral.TextPrompt;
import conexion.ConexionHibernate;
import entidades.Cliente;
import escritorios.PrincipalCliente;
import formularios.FormularioEditarCliente;
import java.awt.HeadlessException;
import org.hibernate.Session;

/**
 * @author Hasper Franco
 */
public class InterfazGraficaFormularioEditarCliente extends InterfazGraficaFormularioEditar {

    public InterfazGraficaFormularioEditarCliente() {
        setEstadoConsulta(0);
    }

    protected PrincipalCliente principalCliente;
 

    public void setPrincipalCliente(PrincipalCliente principalCliente) {
        this.principalCliente = principalCliente;
    }


    @Override
    public void nuevoFormularioEditar() {
        if (principalCliente.getFormularioEditarCliente() == null) {
            FormularioEditarCliente formularioEditar = new FormularioEditarCliente(frame, true);
            formularioEditar.setPrincipalCliente(principalCliente);
            principalCliente.setFormularioEditarCliente(formularioEditar);
            colorTema();
            agregarBoxes();
            rellenarBoxes();
            estadoRazonSocial();
            infoTextPrompt();
            transferirDatos();
        }
        principalCliente.getFormularioEditarCliente().setVisible(true);
        principalCliente.setFormularioEditarCliente(null);
    }

    private void estadoRazonSocial() {
        cambiarEstadoRazonSocial(obtenerDatos());
    }

    private Integer obtenerDatos() {
        Integer idRazonSocial = 0;
        Integer id = principalCliente.getTablaCliente().obtenerIdFilaSeleccionada();
        Session miSesion = ConexionHibernate.tomarConexion();
        try {
            miSesion.beginTransaction();
            Cliente c = (Cliente) miSesion.get(Cliente.class, id);
            idRazonSocial = c.getCodigoRazonSocial().getIdRazonSocial();
            miSesion.getTransaction().commit();
        } catch (HeadlessException | NumberFormatException e) {
        }
        return idRazonSocial;
    }

    private void cambiarEstadoRazonSocial(Integer idRazonSocial) {
        if (idRazonSocial.equals(1)) {
            principalCliente.getFormularioEditarCliente().getRadioButon().setSelected(false);
            principalCliente.getFormularioEditarCliente().getTxtRazonSocial().setEnabled(false);
        } else {
            principalCliente.getFormularioEditarCliente().getRadioButon().setSelected(true);
            principalCliente.getFormularioEditarCliente().getTxtRazonSocial().setEnabled(true);
        }

    }

    @Override
    public void colorTema() {
        principalCliente.getFormularioEditarCliente().getPanelPrincipalTop().setBackground(principalCliente.getPanelPrincipalTop().getBackground());
    }

    @Override
    public void transferirDatos() {
        new TablaCliente().setPrincipalCliente(principalCliente);
        int fila = principalCliente.getTablaGrafica().getSelectedRow();
        principalCliente.getFormularioEditarCliente().getTxtNombre().setText(principalCliente.getTablaGrafica().getValueAt(fila, 0).toString());
        principalCliente.getFormularioEditarCliente().getTxtApellido().setText(principalCliente.getTablaGrafica().getValueAt(fila, 1).toString());
        principalCliente.getFormularioEditarCliente().getTxtRazonSocial().setText(principalCliente.getTablaGrafica().getValueAt(fila, 2).toString());
        principalCliente.getFormularioEditarCliente().getTxtDireccion().setText(principalCliente.getTablaGrafica().getValueAt(fila, 3).toString());
        principalCliente.getFormularioEditarCliente().getTxtnuemroDireccion().setText(principalCliente.getTablaGrafica().getValueAt(fila, 4).toString());
        principalCliente.getFormularioEditarCliente().getTxtTelefono().setText(principalCliente.getTablaGrafica().getValueAt(fila, 7).toString());

        String localidad = principalCliente.getTablaGrafica().getValueAt(fila, 5).toString();
        String provincia = principalCliente.getTablaGrafica().getValueAt(fila, 6).toString();
        String tipotelefono = principalCliente.getTablaGrafica().getValueAt(fila, 8).toString();
        autoSelectBox(provincia, localidad, tipotelefono);
    }

    private void autoSelectBox(String provincia, String localidad, String tipotelefono) {
        principalCliente.getFormularioEditarCliente().getBoxProvincia().setSelectedItem(provincia);
        principalCliente.getFormularioEditarCliente().getBoxLocalidad().setSelectedItem(localidad);
        principalCliente.getFormularioEditarCliente().getBoxTipoTelefono().setSelectedItem(tipotelefono);
    }

    public void infoTextPrompt() {
        new TextPrompt("NOMBRE", principalCliente.getFormularioEditarCliente().getTxtNombre());
        new TextPrompt("APELLIDO", principalCliente.getFormularioEditarCliente().getTxtApellido());
        new TextPrompt("DIRECCION", principalCliente.getFormularioEditarCliente().getTxtDireccion());
        new TextPrompt("RAZON SOCIAL", principalCliente.getFormularioEditarCliente().getTxtRazonSocial());
        new TextPrompt("TELEFONO", principalCliente.getFormularioEditarCliente().getTxtTelefono());
        new TextPrompt("NUMERO DE DIRECCION", principalCliente.getFormularioEditarCliente().getTxtnuemroDireccion());
        principalCliente.getFormularioEditarCliente().getTxtNombre().grabFocus();
    }

    @Override
    public void agregarBoxes() {
        this.setBoxLocalidad(principalCliente.getFormularioEditarCliente().getBoxLocalidad());
        this.setBoxProvincia(principalCliente.getFormularioEditarCliente().getBoxProvincia());
        this.setBoxTipoTelefono(principalCliente.getFormularioEditarCliente().getBoxTipoTelefono());
    }

    @Override
    public void rellenarBoxes() {
        this.consultaRellenarProvincia();
        this.consultaRellenarLocalidad();
        this.consultaRellenarTipoTelefono();
    }

}
