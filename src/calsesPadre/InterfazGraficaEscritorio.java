package calsesPadre;

import complementos.Cargar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import principal.PrincipalAdministrador;

/**
 * @author Hasper Franco
 * @author Nahuel Hernandez
 */
public abstract class InterfazGraficaEscritorio {

    Cargar panelCargando = new Cargar();

    protected PrincipalAdministrador principalAdministrador;

    public PrincipalAdministrador getPrincipalAdministrador() {
        return principalAdministrador;
    }

    public void setPrincipalAdministrador(PrincipalAdministrador principalAdministrador) {
        this.principalAdministrador = principalAdministrador;
    }

    public abstract void nuevaVentana();

    public abstract void infoTextPrompt();

    /**
     * Modifica el color de los elementos de la ventana segun el color de
     * PrincipalAdministador panel.
     */
    public abstract void colorInterfazEscritorio();

    /**
     * Crea y ejecuta un hilo con una instancia de la clase TareaVentana y otro
     * con una instancia de la clase Treacargando.
     */
    public void ejecutarNuevaVentana() {
        tareaCargando();
        tareaVentana();
    }

    /**
     * implemnta el metodo nuevaVentana dentro del metodo run, leugo finaliza la
     * instancia del dialog cargar.
     */
    public void tareaVentana() {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                nuevaVentana();
                panelCargando.dispose();
            }
        };
        Thread hilo = new Thread(runnable);
        hilo.start();
    }

    /**
     * Implemnta el metodo nuevoDialogCargando dentro del metodo run.
     */
    public void tareaCargando() {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                panelCargando.setVisible(true);
            }
        };
        Thread hilo = new Thread(runnable);
        hilo.start();
    }
}
