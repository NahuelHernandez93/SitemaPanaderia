package operacionesProducto;

import calsesPadre.InterfazGraficaFormularioRegistrar;
import clasesUtilidadGeneral.TextPrompt;
import escritorios.PrincipalProducto;
import formularios.FormularioRegistrarPrecioProducto;

/**
 * @author Hasper Franco
 */
public class InterfazGraficaFormularioRegistrarPrecioProducto extends InterfazGraficaFormularioRegistrar {

    private PrincipalProducto principalProducto;

    public PrincipalProducto getPrincipalProducto() {
        return principalProducto;
    }

    public void setPrincipalProducto(PrincipalProducto principalProducto) {
        this.principalProducto = principalProducto;
    }

    @Deprecated
    public void nuevoFormularioRegistrar() {
    }

    public void nuevoFormularioRegistrarPrecio() {
        if (principalProducto.getFormularioRegistrarPrecioProducto() == null) {
            FormularioRegistrarPrecioProducto formularioRegistrar = new FormularioRegistrarPrecioProducto(frame, true);
            formularioRegistrar.setPrincipalProducto(principalProducto);
            principalProducto.setFormularioRegistrarPrecioProducto(formularioRegistrar);
            infoTextPrompt();
            colorTema();
        }

        principalProducto.getFormularioRegistrarPrecioProducto().setVisible(true);
        principalProducto.setFormularioRegistrarPrecioProducto(null);
    }

    @Override
    protected void infoTextPrompt() {
        new TextPrompt("PRECIO BRUTO", principalProducto.getFormularioRegistrarPrecioProducto().getTxtPrecio());
        new TextPrompt("PRECIO FINAL", principalProducto.getFormularioRegistrarPrecioProducto().getTxtPrecioFinal());
        principalProducto.getFormularioRegistrarPrecioProducto().getTxtPrecio().grabFocus();
    }

    @Override
    public void colorTema() {
        principalProducto.getFormularioRegistrarPrecioProducto().getPanelPrincipalTop().setBackground(principalProducto.getPanelPrincipalTop().getBackground());
    }

    @Deprecated
    public void agregarBoxes() {
    }

    @Deprecated
    public void rellenarBoxes() {
    }

}
