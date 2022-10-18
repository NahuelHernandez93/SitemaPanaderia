package operacionesCuenta;

import calsesPadre.Tabla;
import clasesUtilidadGeneral.OperacionesUtiles;
import ds.desktop.notify.DesktopNotify;
import entidades.Cuenta;
import escritorios.PrincipalCuenta;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 * @author Hasper Franco
 */
public class TablaCuenta extends Tabla {

    private Integer idCliente;
    private PrincipalCuenta principalCuenta;
    private List<Integer> listaResutladosActuales = new ArrayList<Integer>();

    public TablaCuenta() {
        setEstadoConsulta(0);
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
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

    /**
     * Ejecuata los metodos necesarios para rellenar la tabla cuentas de la
     * ventana PrincipalCuenta.
     *
     * @param p
     */
    @Override
    public void ejecutarRellenarTabla() {
        setTabla(principalCuenta.getTablaGraficaCuenta());
        setStringConsulta("from Cuenta where codigoCliente=" + this.idCliente);
        evaluarEstadoConsulta();
        //setCampoTexto(principalCuenta.getTxtBuscar());
        rellenarTabla("");
    }

    @Override
    public Integer obtenerIdFilaSeleccionada() {
        try {
            Integer totalFilas = principalCuenta.getTablaGraficaCuenta().getRowCount();
            Integer filasSeleccionada = principalCuenta.getTablaGraficaCuenta().getSelectedRow();
            List<Integer> listaResutadosActualesThis = principalCuenta.getTablaCuenta().getListaResutladosActuales();
            Integer id = operacionesUtilidad.obtenerId(listaResutadosActualesThis, totalFilas, filasSeleccionada);
            this.setIdTabla(id);
        } catch (Exception e) {
        }
        return idTabla;
    }

    @Override
    public void rellenarTabla(String valorBusqueda) {

        DefaultTableModel tablaCuenta = (DefaultTableModel) getTabla().getModel();
        List lista = this.getListaResultados();
        operacionesUtilidad.removerFilas(tablaCuenta);

        try {
            this.listaResutladosActuales.clear();
        } catch (NullPointerException e) {
        }

        for (Object o : lista) {
            Cuenta c = (Cuenta) o;
            if (c.getCodigoEstado().getIdEstado().equals(1)) {
                this.listaResutladosActuales.add(0, c.getIdCuenta());
                Vector<Object> fila = new Vector<>();
                fila.add(c.getIdCuenta());
                fila.add(c.getBalance());
                tablaCuenta.addRow(fila);
            }

        }
        OperacionesUtiles.ordenarLista(listaResutladosActuales);
    }

    @Override
    public boolean verificarFilaSeleccionada() {
        try {
            int fila = principalCuenta.getTablaGraficaCuenta().getSelectedRow();
            principalCuenta.getTablaGraficaCuenta().getValueAt(fila, 0).toString();
            return true;
        } catch (Exception e) {
            DesktopNotify.showDesktopMessage("Informacion", "Debe seleccionar una Cuenta", DesktopNotify.INFORMATION, 7000);
            return false;
        }
    }

    public Integer filaSeleccionada() {
        int fila = principalCuenta.getTablaGraficaCuenta().getSelectedRow();
        return fila;
    }

}
