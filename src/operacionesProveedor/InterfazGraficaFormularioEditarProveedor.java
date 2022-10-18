package operacionesProveedor;

import calsesPadre.InterfazGraficaFormularioEditar;
import clasesUtilidadGeneral.TextPrompt;
import escritorios.PrincipalProveedor;
import formularios.FormularioEditarProveedor;

/**
 * @author Hasper Franco
 */
public class InterfazGraficaFormularioEditarProveedor extends InterfazGraficaFormularioEditar {

    public InterfazGraficaFormularioEditarProveedor() {
        setEstadoConsulta(0);
    }

    protected PrincipalProveedor principalProveedor;

    protected TablaProveedor tablaProveedor;

    public PrincipalProveedor getPrincipalProveedor() {
        return principalProveedor;
    }

    public void setPrincipalProveedor(PrincipalProveedor principalProveedor) {
        this.principalProveedor = principalProveedor;
    }

    public TablaProveedor getTablaProveedor() {
        return tablaProveedor;
    }

    public void setTablaProveedor(TablaProveedor tablaProveedor) {
        this.tablaProveedor = tablaProveedor;
    }

    @Override
    public void nuevoFormularioEditar() {
        if (principalProveedor.getFormularioEditarProveedor() == null) {
            FormularioEditarProveedor formularioEditar = new FormularioEditarProveedor(frame, true);
            formularioEditar.setPrincipalProveedor(principalProveedor);
            principalProveedor.setFormularioEditarProveedor(formularioEditar);
            colorTema();
            agregarBoxes();
            rellenarBoxes();
            infoTextPrompt();
            transferirDatos();
        }

        principalProveedor.getFormularioEditarProveedor().setVisible(true);
        principalProveedor.setFormularioEditarProveedor(null);
    }

    @Override
    public void colorTema() {
        principalProveedor.getFormularioEditarProveedor().getPanelPrincipalTop().setBackground(principalProveedor.getPanelPrincipalTop().getBackground());
    }

    @Override
    public void transferirDatos() {
        TablaProveedor tablaProveedor = new TablaProveedor();
        tablaProveedor.setPrincipalProveedor(principalProveedor);
        int fila = principalProveedor.getTablaGrafica().getSelectedRow();

        principalProveedor.getFormularioEditarProveedor().getTxtNombre().setText(principalProveedor.getTablaGrafica().getValueAt(fila, 0).toString());
        principalProveedor.getFormularioEditarProveedor().getTxtDireccion().setText(principalProveedor.getTablaGrafica().getValueAt(fila, 1).toString());
        principalProveedor.getFormularioEditarProveedor().getTxtnuemeroDireccion().setText(principalProveedor.getTablaGrafica().getValueAt(fila, 2).toString());
        principalProveedor.getFormularioEditarProveedor().getTxtTelefono().setText(principalProveedor.getTablaGrafica().getValueAt(fila, 5).toString());

        String provincia = principalProveedor.getTablaGrafica().getValueAt(fila, 4).toString();
        String localidad = principalProveedor.getTablaGrafica().getValueAt(fila, 3).toString();
        String tipotelefono = principalProveedor.getTablaGrafica().getValueAt(fila, 6).toString();

        autoSelectBox(provincia, localidad, tipotelefono);
    }

    private void autoSelectBox(String provincia, String localidad, String tipotelefono) {
        principalProveedor.getFormularioEditarProveedor().getBoxProvincia().setSelectedItem(provincia);
        principalProveedor.getFormularioEditarProveedor().getBoxLocalidad().setSelectedItem(localidad);
        principalProveedor.getFormularioEditarProveedor().getBoxTipoTelefono().setSelectedItem(tipotelefono);
    }

    protected void infoTextPrompt() {
        new TextPrompt("NOMBRE", principalProveedor.getFormularioEditarProveedor().getTxtNombre());
        new TextPrompt("DIRECCION", principalProveedor.getFormularioEditarProveedor().getTxtDireccion());
        new TextPrompt("N° DIREICCION", principalProveedor.getFormularioEditarProveedor().getTxtnuemeroDireccion());
        new TextPrompt("N° TELEFONO", principalProveedor.getFormularioEditarProveedor().getTxtTelefono());
        principalProveedor.getFormularioEditarProveedor().getTxtNombre().grabFocus();
    }

    @Override
    public void agregarBoxes() {
        this.setBoxLocalidad(principalProveedor.getFormularioEditarProveedor().getBoxLocalidad());
        this.setBoxProvincia(principalProveedor.getFormularioEditarProveedor().getBoxProvincia());
        this.setBoxTipoTelefono(principalProveedor.getFormularioEditarProveedor().getBoxTipoTelefono());
    }

    @Override
    public void rellenarBoxes() {
        this.consultaRellenarProvincia();
        this.consultaRellenarLocalidad();
        this.consultaRellenarTipoTelefono();
    }

}
