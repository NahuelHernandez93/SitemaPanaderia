package lanzarAplicacion;

import clasesUtilidadGeneral.ApiDolar;
import operacionesConfiguracion.ConfiguracionTxt;
import operacionesCuenta.SaldoCuentaBajo;
import principal.PrincipalAdministrador;

/**
 * @author Hasper Franco
 */
public class MainMenu {

    public void ejecutar() {

        PrincipalAdministrador principalAdministrador = new PrincipalAdministrador();
        ConfiguracionTxt configuracion = new ConfiguracionTxt();
        configuracion.leerArchivoConfig();
        configuracion.setPrincipalAdministrador(principalAdministrador);
        configuracion.setTemaPrincipalAdministrador();
        principalAdministrador.setVisible(true);
        new SaldoCuentaBajo().ejecutar(configuracion.getSaldoCuenta());
        ejecutarPrecioDolar(principalAdministrador);
    }

    public void ejecutarPrecioDolar(PrincipalAdministrador p) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        new ApiDolar().precioDolarOficial(p);
                        //detener el hilo por 10 seg
                        Thread.sleep(60000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (Exception ex) {
                    }
                }
            }
        };
        Thread hilo = new Thread(runnable);
        hilo.start();
    }

}
