package operacionesCuenta;

import calsesPadre.ABM;
import conexion.ConexionHibernate;
import entidades.Cuenta;
import entidades.Estado;
import entidades.MovimientoCuenta;
import escritorios.PrincipalCuenta;
import formularios.FormularioEditarMovimientoCuenta;
import java.util.List;
import org.hibernate.Session;

/**
 * @author Hasper Franco
 */
public class ABMMovimientoCuenta extends ABM {

    private PrincipalCuenta principalCuenta;
    private FormularioEditarMovimientoCuenta formularioEditarMovimiento;

    public PrincipalCuenta getPrincipalCuenta() {
        return principalCuenta;
    }

    public void setPrincipalCuenta(PrincipalCuenta principalCuenta) {
        this.principalCuenta = principalCuenta;
    }

    public FormularioEditarMovimientoCuenta getFormularioEditarmovimiento() {
        return formularioEditarMovimiento;
    }

    public void setFormularioEditarmovimiento(FormularioEditarMovimientoCuenta formularioEditarMovimiento) {
        this.formularioEditarMovimiento = formularioEditarMovimiento;
    }

    @Override
    public void obtenerFormularioRegistrar() {
        //para eviatar el nullEception
        setFormularioRegistrar(new javax.swing.JDialog());
        setListaCampos(this.principalCuenta.getListaCamposMovimientoCuenta());
    }

    @Override
    public void obtenerFormularioEditar() {

        setFormularioEditar(this.getFormularioEditarmovimiento());
        setListaCampos(this.getFormularioEditarmovimiento().getListaCampos());
    }

    @Override
    public void transaccionRegistrar(Session miSesion) {
        Estado e = (Estado) miSesion.get(Estado.class, 1);
        MovimientoCuenta mc = new MovimientoCuenta();
        mc.setMotivo(principalCuenta.getEditPaneMotivo().getText());
        mc.setMonto(Double.valueOf(principalCuenta.getTxtMonto().getText()));
        Integer id = principalCuenta.getTablaCuenta().obtenerIdFilaSeleccionada();
        Cuenta c = (Cuenta) miSesion.get(Cuenta.class, id);
        mc.setBalance(c.getBalance() + (mc.getMonto()));
        mc.setCodigoCuenta(c);
        mc.setCodigoEstado(e);
        miSesion.save(mc);
        c.setBalance(mc.getBalance());
        miSesion.saveOrUpdate(c);
    }

    @Override
    public void transaccionEditar(Session miSesion) {
        Integer id = principalCuenta.getTablaMovimientoCuenta().obtenerIdFilaSeleccionada();
        MovimientoCuenta mc = (MovimientoCuenta) miSesion.get(MovimientoCuenta.class, id);
        mc.setMonto(Double.valueOf(formularioEditarMovimiento.getTxtMonto().getText()));
        mc.setMotivo(formularioEditarMovimiento.getTxtMotivo().getText());
        Cuenta c = (Cuenta) miSesion.get(Cuenta.class, mc.getCodigoCuenta().getIdCuenta());
        if (formularioEditarMovimiento.getTxtMotivo().getText().toString().equals("Monto Inicial")) {
            mc.setBalance(mc.getMonto());
        } else {
            mc.setBalance(c.getBalance() + (mc.getMonto()));
        }
        mc.setCodigoCuenta(c);
        miSesion.save(mc);
        c.setBalance(mc.getBalance());
        miSesion.saveOrUpdate(c);

    }

    @Override
    public void transaccionEliminar(Session miSesion) {
        Estado e = (Estado) miSesion.get(Estado.class, 2);
        Integer id = principalCuenta.getTablaMovimientoCuenta().obtenerIdFilaSeleccionada();
        MovimientoCuenta mc = (MovimientoCuenta) miSesion.get(MovimientoCuenta.class, id);
        mc.setCodigoEstado(e);
        miSesion.saveOrUpdate(mc);

    }

    public void ejecutarActualizarMovimientoCuenta() {
        Integer id = principalCuenta.getTablaCuenta().obtenerIdFilaSeleccionada();
        setConsultaList("FROM MovimientoCuenta WHERE codigoCuenta=" + id + " AND codigoEstado=1");
        obtenerListaConsulta();
        conexionMovimientoCuenta();
    }

    public void actualizarMovimientoCuentaFromVenta(Integer idCuenta) {
        setConsultaList("FROM MovimientoCuenta WHERE codigoCuenta=" + idCuenta + " AND codigoEstado=1");
        obtenerListaConsulta();
        conexionMovimientoCuenta();
    }

    private void conexionMovimientoCuenta() {
        Session miSesion = ConexionHibernate.tomarConexion();
        miSesion.beginTransaction();
        actualizarMovimeintoCuenta(miSesion);
        miSesion.getTransaction().commit();;
    }

    private void actualizarMovimeintoCuenta(Session miSesion) {

        Integer idMovCuenta;
        Double monto;
        Double balance;

        List lista = this.getListaResultados();
        for (Object o : lista) {
            MovimientoCuenta resultsMC = (MovimientoCuenta) o;

            idMovCuenta = resultsMC.getIdMovimientoCuenta();
            monto = resultsMC.getMonto();
            balance = resultsMC.getBalance();

            //  Session miSesion = ConexionHibernate.tomarConexion();
            // miSesion.beginTransaction();
            MovimientoCuenta actualizarMC = (MovimientoCuenta) miSesion.get(MovimientoCuenta.class, idMovCuenta);

            Cuenta cnt = (Cuenta) miSesion.get(Cuenta.class, resultsMC.getCodigoCuenta().getIdCuenta());

            if (resultsMC.getMotivo().equals("Monto Inicial")) {
                actualizarMC.setMonto(monto);
                actualizarMC.setBalance(balance);
                cnt.setBalance(balance);
            } else {
                Double nuevoBalance = (cnt.getBalance() + (monto));
                actualizarMC.setMonto(monto);
                actualizarMC.setBalance(nuevoBalance);
                cnt.setBalance(nuevoBalance);
            }

             miSesion.saveOrUpdate(actualizarMC);
             miSesion.saveOrUpdate(cnt);
            // miSesion.getTransaction().commit();
        }

    }

}
