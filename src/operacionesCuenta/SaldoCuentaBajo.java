package operacionesCuenta;

import calsesPadre.Consultas;
import ds.desktop.notify.DesktopNotify;
import entidades.Cuenta;
import java.util.List;

/**
 * @author Hasper Franco
 */
public class SaldoCuentaBajo  extends Consultas {

    public void ejecutar(String saldoCuenta){
        queryCuentas(saldoCuenta);
        notificar();
    }
    
    private void queryCuentas(String saldoCuenta){
        setConsultaList("from Cuenta where balance< "+saldoCuenta+"AND codigoEstado=1");
        obtenerListaConsulta();
    }
    
    private void notificar(){
     List lista = this.getListaResultados();
     for (Object o : lista) {
        Cuenta c = (Cuenta) o;
         DesktopNotify.showDesktopMessage("Alerta de saldo del la cuenta bajo", 
                 "Cliente: " +c.getCodigoCliente().getNombre()+" "+c.getCodigoCliente().getApellido()+"\nN° Cuenta: "+c.getIdCuenta().toString()+"\nSaldo actual: "+c.getBalance().toString()
                 , DesktopNotify.INFORMATION);
     }
         
    }
    
    
    
    
}
