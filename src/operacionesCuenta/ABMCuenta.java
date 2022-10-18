package operacionesCuenta;

import calsesPadre.ABM;
import entidades.Cliente;
import entidades.Cuenta;
import entidades.Estado;
import entidades.MovimientoCuenta;
import escritorios.PrincipalCuenta;
import org.hibernate.Session;

/**
 * @author Hasper Franco
 */
public class ABMCuenta extends ABM {

    private PrincipalCuenta principalCuenta;
   

    public PrincipalCuenta getPrincipalCuenta() {
        return principalCuenta;
    }

    public void setPrincipalCuenta(PrincipalCuenta principalCuenta) {
        this.principalCuenta = principalCuenta;
    }

 

    @Override
    public void obtenerFormularioRegistrar() {
        //para eviatar el nullEception
        setFormularioRegistrar(new javax.swing.JDialog());
        setListaCampos(this.principalCuenta.getListaCamposCuenta());
    }

    @Override
    public void obtenerFormularioEditar() {
       
    }

    @Override
    public void transaccionRegistrar(Session miSesion) {
        Estado e = (Estado) miSesion.get(Estado.class, 1);
        Cliente cl = (Cliente) miSesion.get(Cliente.class, principalCuenta.getIdCliente());
        Cuenta cu = new Cuenta();
        cu.setBalance(Double.valueOf(principalCuenta.getTxtMontoInicial().getText()));
        cu.setCodigoCliente(cl);
        cu.setCodigoEstado(e);
        miSesion.save(cu);
        MovimientoCuenta mc = new MovimientoCuenta();
        mc.setMotivo("Monto Inicial");
        mc.setMonto(Double.valueOf(principalCuenta.getTxtMontoInicial().getText()));
        mc.setBalance(Double.valueOf(principalCuenta.getTxtMontoInicial().getText()));
        mc.setCodigoEstado(e);
        mc.setCodigoCuenta(cu);
        miSesion.save(mc);
    }

    @Override
    public void transaccionEditar(Session miSesion) {
      
    }

    @Override
    public void transaccionEliminar(Session miSesion) {
        Estado e = (Estado) miSesion.get(Estado.class, 2);
        Integer id = principalCuenta.getTablaCuenta().obtenerIdFilaSeleccionada();
        Cuenta c = (Cuenta) miSesion.get(Cuenta.class, id);
        c.setCodigoEstado(e);
        miSesion.saveOrUpdate(c);
    }

}
