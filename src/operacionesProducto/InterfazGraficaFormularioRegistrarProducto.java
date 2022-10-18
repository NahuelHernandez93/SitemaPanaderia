package operacionesProducto;

import calsesPadre.InterfazGraficaFormularioRegistrar;
import clasesUtilidadGeneral.TextPrompt;
import escritorios.PrincipalProducto;
import formularios.FormularioRegistrarProducto;

/**
 * @author Hasper Franco
 */
public class InterfazGraficaFormularioRegistrarProducto extends InterfazGraficaFormularioRegistrar {

    private PrincipalProducto principalProducto;

    public PrincipalProducto getPrincipalProducto() {
        return principalProducto;
    }

    public void setPrincipalProducto(PrincipalProducto principalProducto) {
        this.principalProducto = principalProducto;
    }

    @Override
    public void nuevoFormularioRegistrar() {
        if (principalProducto.getFormularioRegistrarProducto() == null) {
            FormularioRegistrarProducto formularioRegistrar = new FormularioRegistrarProducto(frame, true);
            formularioRegistrar.setPrincipalProducto(principalProducto);
            principalProducto.setFormularioRegistrarProducto(formularioRegistrar);
            infoTextPrompt();
            colorTema();
        }

        principalProducto.getFormularioRegistrarProducto().setVisible(true);
        principalProducto.setFormularioRegistrarProducto(null);
    }

    @Override
    protected void infoTextPrompt() {
        new TextPrompt("NOMBRE", principalProducto.getFormularioRegistrarProducto().getTxtNombre());
        new TextPrompt("DESCRIPCION", principalProducto.getFormularioRegistrarProducto().getTxtDescripcion());
        new TextPrompt("PRECIO BRUTO", principalProducto.getFormularioRegistrarProducto().getTxtPrecio());
        new TextPrompt("PRECIO FINAL", principalProducto.getFormularioRegistrarProducto().getTxtPrecioFinal());
        principalProducto.getFormularioRegistrarProducto().getTxtNombre().grabFocus();
    }

    @Override
    public void colorTema() {
        principalProducto.getFormularioRegistrarProducto().getPanelPrincipalTop().setBackground(principalProducto.getPanelPrincipalTop().getBackground());
    }

    @Deprecated
    public void agregarBoxes() {
    }

    @Deprecated
    public void rellenarBoxes() {
    }

}
