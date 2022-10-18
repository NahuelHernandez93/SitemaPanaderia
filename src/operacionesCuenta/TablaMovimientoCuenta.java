package operacionesCuenta;

import calsesPadre.Tabla;
import clasesUtilidadGeneral.OperacionesUtiles;
import ds.desktop.notify.DesktopNotify;
import entidades.MovimientoCuenta;
import escritorios.PrincipalCuenta;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 * @author Hasper Franco
 */
public class TablaMovimientoCuenta extends Tabla {

    private Integer idCuenta;
    private PrincipalCuenta principalCuenta;
    private List<Integer> listaResutladosActuales = new ArrayList<Integer>();

    public TablaMovimientoCuenta() {
        setEstadoConsulta(0);
    }

    public PrincipalCuenta getPrincipalCuenta() {
        return principalCuenta;
    }

    public void setPrincipalCuenta(PrincipalCuenta principalCuenta) {
        this.principalCuenta = principalCuenta;
    }

    public List<Integer> getListaResutladosActuales() {
        return listaResutladosActuales;
    }

    public void setListaResutladosActuales(List<Integer> listaResutladosActuales) {
        this.listaResutladosActuales = listaResutladosActuales;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    /**
     * Ejecuata los metodos necesarios para rellenar la tabla cuentas de la
     * ventana PrincipalCuenta.
     *
     * @param p
     */
    @Override
    public void ejecutarRellenarTabla() {
        setTabla(principalCuenta.getTablaGraficaMovimiento());
        setStringConsulta("from MovimientoCuenta where codigoCuenta=" + this.idCuenta);
        evaluarEstadoConsulta();
        setCampoTexto(principalCuenta.getTxtBuscar());
        rellenarTabla(getCampoTexto().getText());
    }

    @Override
    public Integer obtenerIdFilaSeleccionada() {
        try {
            Integer totalFilas = principalCuenta.getTablaGraficaMovimiento().getRowCount();
            Integer filasSeleccionada = principalCuenta.getTablaGraficaMovimiento().getSelectedRow();
            List<Integer> listaResutadosActualesThis = principalCuenta.getTablaMovimientoCuenta().getListaResutladosActuales();
            Integer id = operacionesUtilidad.obtenerId(listaResutadosActualesThis, totalFilas, filasSeleccionada);
            this.setIdTabla(id);
        } catch (Exception e) {
        }
        return idTabla;
    }

    @Override
    public void rellenarTabla(String valorBusqueda) {

        DefaultTableModel tablaMovimientoCuenta = (DefaultTableModel) getTabla().getModel();
        List lista = this.getListaResultados();
        operacionesUtilidad.removerFilas(tablaMovimientoCuenta);

        try {
            this.listaResutladosActuales.clear();
        } catch (NullPointerException e) {
        }

        for (Object o : lista) {
            MovimientoCuenta mc = (MovimientoCuenta) o;
            boolean resultadoComparacion = OperacionesUtiles.convertirResultado(mc.getFecha().toString(), valorBusqueda);
            if (resultadoComparacion && mc.getCodigoEstado().getIdEstado().equals(1)) {
                this.listaResutladosActuales.add(0, mc.getIdMovimientoCuenta());
                Vector<Object> fila = new Vector<>();
                fila.add(mc.getMotivo());
                fila.add(OperacionesUtiles.formatoDouble(mc.getMonto()));
                fila.add(OperacionesUtiles.formatoDouble(mc.getBalance()));
                fila.add(new OperacionesUtiles().formatoFechaSinHora(mc.getFecha()));
                tablaMovimientoCuenta.addRow(fila);
            }

        }
        OperacionesUtiles.ordenarLista(listaResutladosActuales);
    }

    @Deprecated
    public boolean verficarNoMontoInicial() {
        if (obtenerIdFilaSeleccionada().equals(1)) {
            DesktopNotify.showDesktopMessage("   Informacion    ", "  No se puede editar ni eliminar monto inicial", DesktopNotify.INFORMATION, 7000);
            return false;
        }
        return true;
    }

    @Override
    public boolean verificarFilaSeleccionada() {
        try {
            int fila = principalCuenta.getTablaGraficaMovimiento().getSelectedRow();
            principalCuenta.getTablaGraficaMovimiento().getValueAt(fila, 0).toString();
            return true;
        } catch (Exception e) {
            DesktopNotify.showDesktopMessage("Informacion", "Debe seleccionar una fila", DesktopNotify.INFORMATION, 7000);
            return false;
        }
    }

    public boolean verificarNoMontoInicial() {
        if (principalCuenta.getTablaGraficaMovimiento().getSelectedRow() == 0) {
            DesktopNotify.showDesktopMessage("Informacion", "No Se puede eliminar Monto Inicial Solamente Modificar su valor", DesktopNotify.ERROR, 7000);
            return false;
        }
        return true;
    }

}
