package operacionesCaja;

import calsesPadre.Tabla;
import clasesUtilidadGeneral.OperacionesUtiles;
import entidades.CorteCaja;
import escritorios.PrincipalCaja;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Franco Hasper
 */
public class TablaCaja extends Tabla {

    public TablaCaja() {
        setEstadoConsulta(0);
    }

    private PrincipalCaja principalCaja;
    private List<Integer> listaResutladosActuales = new ArrayList<Integer>();

    public PrincipalCaja getPrincipalCaja() {
        return principalCaja;
    }

    public void setPrincipalCaja(PrincipalCaja principalCaja) {
        this.principalCaja = principalCaja;
    }

    public List<Integer> getListaResutladosActuales() {
        return listaResutladosActuales;
    }

    public void setListaResutladosActuales(List<Integer> listaResutladosActuales) {
        this.listaResutladosActuales = listaResutladosActuales;
    }

    /**
     * Ejecuata los metodos necesarios para rellenar la tabla de la ventana
     * PrincipalCaja.
     *
     * @param p
     */
    @Override
    public void ejecutarRellenarTabla() {
        setTabla(principalCaja.getTablaGrafica());
        setStringConsulta("from CorteCaja");
        evaluarEstadoConsulta();
        setCampoTexto(principalCaja.getTxtBuscar());
        rellenarTabla(getCampoTexto().getText());
    }

    @Override
    public Integer obtenerIdFilaSeleccionada() {
        try {
            Integer totalFilas = principalCaja.getTablaGrafica().getRowCount();
            Integer filasSeleccionada = principalCaja.getTablaGrafica().getSelectedRow();
            List<Integer> listaResutadosActualesThis = principalCaja.getTablaCaja().getListaResutladosActuales();
            Integer id = operacionesUtilidad.obtenerId(listaResutadosActualesThis, totalFilas, filasSeleccionada);
            this.setIdTabla(id);
        } catch (Exception e) {
        }
        return idTabla;
    }

    @Override
    public void rellenarTabla(String valorBusqueda) {

        DefaultTableModel tablaCaja = (DefaultTableModel) getTabla().getModel();
        List lista = this.getListaResultados();
        operacionesUtilidad.removerFilas(tablaCaja);

        try {
            this.listaResutladosActuales.clear();
        } catch (NullPointerException e) {
        }

        for (Object o : lista) {
            CorteCaja corteCaja = (CorteCaja) o;
            Integer resutadoComparacion = (corteCaja.getFecha().toString().indexOf(valorBusqueda));
            if (corteCaja.getCodigoEstado().getIdEstado().equals(1) && resutadoComparacion.equals(0)) {
                this.listaResutladosActuales.add(0, corteCaja.getIdCorteCaja());
                Vector<Object> fila = new Vector<>();
                fila.add(OperacionesUtiles.formatoDouble(corteCaja.getTotalIngresos()));
                fila.add(OperacionesUtiles.formatoDouble(corteCaja.getTotalEgresos()));
                fila.add(OperacionesUtiles.formatoDouble(corteCaja.getBalance()));
                fila.add(OperacionesUtiles.formatoFechaSinHora(corteCaja.getFecha()));
                tablaCaja.addRow(fila);
            }

        }
        OperacionesUtiles.ordenarLista(listaResutladosActuales);
    }

    @Override
    public boolean verificarFilaSeleccionada() {
        try {
            int fila = principalCaja.getTablaGrafica().getSelectedRow();
            principalCaja.getTablaGrafica().getValueAt(fila, 0).toString();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

}
