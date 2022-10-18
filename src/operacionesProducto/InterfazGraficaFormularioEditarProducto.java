package operacionesProducto;

import calsesPadre.InterfazGraficaFormularioEditar;
import escritorios.PrincipalProducto;
import formularios.FormularioEditarProducto;

/**
 * @author Hasper Franco
 */
public class InterfazGraficaFormularioEditarProducto extends InterfazGraficaFormularioEditar {

    protected PrincipalProducto principalProducto;
    protected TablaProducto tablaProducto;

    public PrincipalProducto getPrincipalProducto() {
        return principalProducto;
    }

    public void setPrincipalProducto(PrincipalProducto principalProducto) {
        this.principalProducto = principalProducto;
    }

    public TablaProducto getTablaProducto() {
        return tablaProducto;
    }

    public void setTablaProducto(TablaProducto tablaProducto) {
        this.tablaProducto = tablaProducto;
    }

    @Override
    public void nuevoFormularioEditar() {
        if (principalProducto.getFormularioEditarProducto() == null) {
            FormularioEditarProducto formularioEditar = new FormularioEditarProducto(frame, true);
            formularioEditar.setPrincipalProducto(principalProducto);
            principalProducto.setFormularioEditarProducto(formularioEditar);
            transferirDatos();
            colorTema();
        }
        principalProducto.getFormularioEditarProducto().setVisible(true);
        principalProducto.setFormularioEditarProducto(null);
    }

    @Override
    public void colorTema() {
        principalProducto.getFormularioEditarProducto().getPanelPrincipalTop().setBackground(principalProducto.getPanelPrincipalTop().getBackground());
    }

    @Override
    public void transferirDatos() {
        new TablaProducto().setPrincipalProducto(principalProducto);
        int fila = principalProducto.getTablaGrafica().getSelectedRow();
        principalProducto.getFormularioEditarProducto().getTxtNombre().setText(principalProducto.getTablaGrafica().getValueAt(fila, 0).toString());
        principalProducto.getFormularioEditarProducto().getTxtDescripcion().setText(principalProducto.getTablaGrafica().getValueAt(fila, 1).toString());
    }

    @Override
    public void agregarBoxes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void rellenarBoxes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
