package operacionesMateriaPrima;

import calsesPadre.InterfazGraficaFormularioEditar;
import escritorios.PrincipalMateriaPrima;
import formularios.FormularioEditarMateriaPrima;

/**
 * @author Hasper Franco
 */
public class InterfazGraficaFormularioEditarMateriaPrima extends InterfazGraficaFormularioEditar {

    protected PrincipalMateriaPrima principalMateriaPrima;
    protected TablaMateriaPrima tablaMateriaPrima;

    public PrincipalMateriaPrima getPrincipalMateriaPrima() {
        return principalMateriaPrima;
    }

    public void setPrincipalMateriaPrima(PrincipalMateriaPrima principalMateriaPrima) {
        this.principalMateriaPrima = principalMateriaPrima;
    }

    public TablaMateriaPrima getTablaMateriaPrima() {
        return tablaMateriaPrima;
    }

    public void setTablaMateriaPrima(TablaMateriaPrima tablaMateriaPrima) {
        this.tablaMateriaPrima = tablaMateriaPrima;
    }

    @Override
    public void nuevoFormularioEditar() {
        if (principalMateriaPrima.getFormularioEditarMateriaPrima() == null) {
            FormularioEditarMateriaPrima formularioEditar = new FormularioEditarMateriaPrima(frame, true);
            formularioEditar.setPrincipalMateriaPrima(principalMateriaPrima);
            principalMateriaPrima.setFormularioEditarMateriaPrima(formularioEditar);
            agregarBoxes();
            rellenarBoxes();
            transferirDatos();
            colorTema();
        }

        principalMateriaPrima.getFormularioEditarMateriaPrima().setVisible(true);
        principalMateriaPrima.setFormularioEditarMateriaPrima(null);
    }

    @Override
    public void colorTema() {
        principalMateriaPrima.getFormularioEditarMateriaPrima().getPanelPrincipalTop().setBackground(principalMateriaPrima.getPanelPrincipalTop().getBackground());
    }

    @Override
    public void transferirDatos() {
        new TablaMateriaPrima().setPrincipalMateriaPrima(principalMateriaPrima);
        int fila = principalMateriaPrima.getTablaGrafica().getSelectedRow();
        principalMateriaPrima.getFormularioEditarMateriaPrima().getTxtNombreMAteriaPrima().setText(principalMateriaPrima.getTablaGrafica().getValueAt(fila, 0).toString());
    }

    @Override
    public void agregarBoxes() {
        this.setBoxMarca(principalMateriaPrima.getFormularioEditarMateriaPrima().getBoxMarca());
        this.setBoxProveedor(principalMateriaPrima.getFormularioEditarMateriaPrima().getBoxProveedor());
        this.setBoxUnidadMedida(principalMateriaPrima.getFormularioEditarMateriaPrima().getBoxUdeMedida());

    }

    @Override
    public void rellenarBoxes() {
        this.consultaRellenarMarca();
        this.consultaRellenarProveedor();
        this.consultaRellenarUnidadMedida();
    }

}
