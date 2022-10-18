package operacionesVenta;

import clasesUtilidadGeneral.SwingBrowser;
import formularios.PaginasWeb;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import principal.PrincipalAdministrador;

/**
 * @author Hasper Franco
 */
public class InterfazGraficaFormularioWebAFIP {

    private PrincipalAdministrador principalAdministrador;

    public PrincipalAdministrador getPrincipalAdministrador() {
        return principalAdministrador;
    }

    public void setPrincipalAdministrador(PrincipalAdministrador principalAdministrador) {
        this.principalAdministrador = principalAdministrador;
    }



    public void nuevaVentana() {
        if (principalAdministrador.getEscritorio().estacerrado(principalAdministrador.getWebAFIP())) {
            PaginasWeb m = new PaginasWeb();
            principalAdministrador.setWebAFIP(m);
            BasicInternalFrameTitlePane menupanel = (BasicInternalFrameTitlePane) ((BasicInternalFrameUI) m.getUI()).getNorthPane();
            int width = principalAdministrador.getEscritorio().getWidth();
            int Height = principalAdministrador.getEscritorio().getHeight();
            principalAdministrador.getWebAFIP().remove(menupanel);
            principalAdministrador.getWebAFIP().setSize(width, Height);
            try {
                principalAdministrador.getEscritorio().add(principalAdministrador.getWebAFIP());
            } catch (IllegalArgumentException e) {
            }
            principalAdministrador.getWebAFIP().show();
        }
        insertarPagina(principalAdministrador);
        principalAdministrador.getWebAFIP().toFront();
    }
    


    private void insertarPagina(PrincipalAdministrador p) {
        SwingBrowser browser = new SwingBrowser();
        browser.loadURL("https://auth.afip.gob.ar/contribuyente_/login.xhtml");
        browser.setBounds(1, 1, p.getWebAFIP().getJPanel().getWidth() - 1, p.getWebAFIP().getJPanel().getHeight() - 1);
        p.getWebAFIP().getJPanel().add(browser);
    }
    
    
}

