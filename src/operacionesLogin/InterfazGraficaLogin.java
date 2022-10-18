package operacionesLogin;

import clasesUtilidadGeneral.TextPrompt;
import complementos.Cargar;
import formularios.FormularioLogin;
import java.awt.Frame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import lanzarAplicacion.Iniciar;
import operacionesConfiguracion.ConfiguracionTxt;

/**
 * @author Hasper Franco
 */
public class InterfazGraficaLogin {

    public void ejecutar() {
        Cargar cargando = new Cargar();
        cargando.setVisible(true);
        FormularioLogin login = new FormularioLogin(new Frame(), true);
        colorTema(login.getPanelPrincipalTop());
        infoTextPrompt(login.getTxtUsuario(), login.getTxtContraseña());
        Validar validar = new Validar();
        validar.query();
        login.setValidar(validar);
        cargando.dispose();
        login.setVisible(true);
    }

    private void colorTema(JPanel panel) {
        ConfiguracionTxt configuracion = new ConfiguracionTxt();
        configuracion.leerArchivoConfig();
        configuracion.setColorPanel(panel);
    }

    public void infoTextPrompt(JTextField usuario, JTextField contraseña) {
        new TextPrompt("USUARIO", usuario);
        new TextPrompt("CONTRASEÑA", contraseña);
        usuario.grabFocus();
    }
}
