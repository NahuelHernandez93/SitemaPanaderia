package operacionesLogin;

import calsesPadre.Consultas;
import ds.desktop.notify.DesktopNotify;
import entidades.Login;
import formularios.FormularioLogin;
import java.util.List;
import lanzarAplicacion.MainMenu;

/**
 * @author Hasper Franco
 */
public class Validar extends Consultas {



    public void query() {
        setConsultaList("from Login");
        obtenerListaConsulta();
    }

    public void comprobar(FormularioLogin fromularioLogin) {
        List lista = this.getListaResultados();
        boolean estadoLogin=false;
        try {
            for (Object o : lista) {
                Login l = (Login) o;
                if (l.getUser().equals(fromularioLogin.getTxtUsuario().getText()) && l.getPassword().equals(fromularioLogin.getTxtContraseña().getText())) {
                       estadoLogin=true;
                } 
            }
            if(estadoLogin){
                fromularioLogin.dispose();
                 new MainMenu().ejecutar();
            }else{
                DesktopNotify.showDesktopMessage("error ", " USUARIO O CONTRASEÑA INCORRECTOS", DesktopNotify.ERROR, 7000);
            }
        } catch (NullPointerException e) {
        }

    }

}
