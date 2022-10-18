package operacionesProveedor;

import calsesPadre.InterfazGraficaFormularioRegistrar;
import clasesUtilidadGeneral.TextPrompt;
import escritorios.PrincipalProveedor;
import formularios.FormularioRegistrarProveedor;

/**
 * @author Hasper Franco
 */
public class InterfazGraficaFormularioRegistrarProveedor extends InterfazGraficaFormularioRegistrar {

    public InterfazGraficaFormularioRegistrarProveedor() {
        setEstadoConsulta(0);
    }

    private PrincipalProveedor principalProveedor;

    public PrincipalProveedor getPrincipalProveedor() {
        return principalProveedor;
    }

    public void setPrincipalProveedor(PrincipalProveedor principalProveedor) {
        this.principalProveedor = principalProveedor;
    }

    @Override
    public void nuevoFormularioRegistrar() {
        if (principalProveedor.getFormularioRegistrarProveedor() == null) {
            FormularioRegistrarProveedor formularioRegistrar = new FormularioRegistrarProveedor(frame, true);
            formularioRegistrar.setPrincipalProveedor(principalProveedor);
            principalProveedor.setFormularioRegistrarProveedor(formularioRegistrar);
            colorTema();
            agregarBoxes();
            rellenarBoxes();
            infoTextPrompt();
            autoseccionarBoxes();
        }

        principalProveedor.getFormularioRegistrarProveedor().setVisible(true);
        principalProveedor.setFormularioRegistrarProveedor(null);
    }

    private void autoseccionarBoxes() {
        String localidad = "Oberá";
        String provincia = "Misiones";
        String tipotelefono = "movil";
        principalProveedor.getFormularioRegistrarProveedor().getBoxProvincia().setSelectedItem(provincia);
        principalProveedor.getFormularioRegistrarProveedor().getBoxLocalidad().setSelectedItem(localidad);
        principalProveedor.getFormularioRegistrarProveedor().getBoxTipoTelefono().setSelectedItem(tipotelefono);
    }

    @Override
    protected void infoTextPrompt() {
        new TextPrompt("NOMBRE", principalProveedor.getFormularioRegistrarProveedor().getTxtNombre());
        new TextPrompt("DIRECCION", principalProveedor.getFormularioRegistrarProveedor().getTxtDireccion());
        new TextPrompt("N° DIREICCION", principalProveedor.getFormularioRegistrarProveedor().getTxtnuemroDireccion());
        new TextPrompt("N° TELEFONO", principalProveedor.getFormularioRegistrarProveedor().getTxtTelefono());
        principalProveedor.getFormularioRegistrarProveedor().getTxtNombre().grabFocus();
    }

    @Override
    public void colorTema() {
        principalProveedor.getFormularioRegistrarProveedor().getPanelPrincipalTop().setBackground(principalProveedor.getPanelPrincipalTop().getBackground());
    }

    @Override
    public void agregarBoxes() {
        this.setBoxLocalidad(principalProveedor.getFormularioRegistrarProveedor().getBoxLocalidad());
        this.setBoxProvincia(principalProveedor.getFormularioRegistrarProveedor().getBoxProvincia());
        this.setBoxTipoTelefono(principalProveedor.getFormularioRegistrarProveedor().getBoxTipoTelefono());
    }

    @Override
    public void rellenarBoxes() {
        this.consultaRellenarProvincia();
        this.consultaRellenarLocalidad();
        this.consultaRellenarTipoTelefono();
    }

}
