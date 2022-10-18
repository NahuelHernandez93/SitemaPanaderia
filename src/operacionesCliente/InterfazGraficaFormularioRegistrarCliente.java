package operacionesCliente;

import calsesPadre.InterfazGraficaFormularioRegistrar;
import clasesUtilidadGeneral.TextPrompt;
import escritorios.PrincipalCliente;
import formularios.FormularioRegistrarCliente;

/**
 * @author Hasper Franco
 */
public class InterfazGraficaFormularioRegistrarCliente extends InterfazGraficaFormularioRegistrar {
    
    public InterfazGraficaFormularioRegistrarCliente() {
        setEstadoConsulta(0);
    }
    
    private PrincipalCliente principalCliente;
    
    public void setPrincipalCliente(PrincipalCliente principalCliente) {
        this.principalCliente = principalCliente;
    }
    
    public PrincipalCliente getPrincipalCliente() {
        return principalCliente;
    }
    
    @Override
    public void nuevoFormularioRegistrar() {
        if (principalCliente.getFormularioRegistrarCliente() == null) {
            FormularioRegistrarCliente formularioRegistrar = new FormularioRegistrarCliente(frame, true);
            formularioRegistrar.setPrincipalCliente(principalCliente);
            principalCliente.setFormularioRegistrarCliente(formularioRegistrar);
            colorTema();
            agregarBoxes();
            rellenarBoxes();
            razonSocialDisabled();
            infoTextPrompt();
            autoseccionarBoxes();
        }
        
        principalCliente.getFormularioRegistrarCliente().setVisible(true);
        principalCliente.setFormularioRegistrarCliente(null);
    }

    private void razonSocialDisabled() {
        principalCliente.getFormularioRegistrarCliente().getTxtRazonSocial().setEnabled(false);
    }
    
    private void autoseccionarBoxes() {
        String localidad = "Oberá";
        String provincia = "Misiones";
        String tipotelefono = "movil";
        principalCliente.getFormularioRegistrarCliente().getBoxProvincia().setSelectedItem(provincia);
        principalCliente.getFormularioRegistrarCliente().getBoxLocalidad().setSelectedItem(localidad);
        principalCliente.getFormularioRegistrarCliente().getBoxTipoTelefono().setSelectedItem(tipotelefono);
    }
    
    @Override
    public void infoTextPrompt() {
        new TextPrompt("NOMBRE", principalCliente.getFormularioRegistrarCliente().getTxtNombre());
        new TextPrompt("APELLIDO", principalCliente.getFormularioRegistrarCliente().getTxtApellido());
        new TextPrompt("DIRECCION", principalCliente.getFormularioRegistrarCliente().getTxtDireccion());
        new TextPrompt("RAZON SOCIAL", principalCliente.getFormularioRegistrarCliente().getTxtRazonSocial());
        new TextPrompt("TELEFONO", principalCliente.getFormularioRegistrarCliente().getTxtTelefono());
        new TextPrompt("NUMERO DE DIRECCION", principalCliente.getFormularioRegistrarCliente().getTxtnuemroDireccion());
        principalCliente.getFormularioRegistrarCliente().getTxtNombre().grabFocus();
    }
    
    @Override
    public void agregarBoxes() {
        this.setBoxLocalidad(principalCliente.getFormularioRegistrarCliente().getBoxLocalidad());
        this.setBoxProvincia(principalCliente.getFormularioRegistrarCliente().getBoxProvincia());
        this.setBoxTipoTelefono(principalCliente.getFormularioRegistrarCliente().getBoxTipoTelefono());
    }
    
    @Override
    public void rellenarBoxes() {
        this.consultaRellenarProvincia();
        this.consultaRellenarLocalidad();
        this.consultaRellenarTipoTelefono();
    }
    
    @Override
    public void colorTema() {
        principalCliente.getFormularioRegistrarCliente().getPanelPrincipalTop().setBackground(principalCliente.getPanelPrincipalTop().getBackground());
    }
    
}
