package operacionesGasto;


import calsesPadre.Tabla;
import clasesUtilidadGeneral.OperacionesUtiles;
import ds.desktop.notify.DesktopNotify;
import entidades.Gasto;
import escritorios.PrincipalGastos;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TELCOM MPC
 */


public class TablaGastos extends Tabla {

    public TablaGastos() {
        setEstadoConsulta(0);
    }

    private PrincipalGastos principalGastos;
    private List<Integer> listaResutladosActuales = new ArrayList<Integer>();

    public PrincipalGastos getPrincipalGastos() {
        return principalGastos;
    }

    public void setPrincipalGastos(PrincipalGastos principalGastos) {
        this.principalGastos = principalGastos;
    }

    public List<Integer> getListaResutladosActuales() {
        return listaResutladosActuales;
    }

    public void setListaResutladosActuales(List<Integer> listaResutladosActuales) {
        this.listaResutladosActuales = listaResutladosActuales;
    }

    @Override
    public void ejecutarRellenarTabla() {
        setTabla(principalGastos.getTablaGrafica());
        setStringConsulta("from Gasto");
        evaluarEstadoConsulta();
        setCampoTexto(principalGastos.getTxtBuscar());
        rellenarTabla(getCampoTexto().getText());
    }

    @Override
    public Integer obtenerIdFilaSeleccionada() {
        try {
            Integer totalFilas = principalGastos.getTablaGrafica().getRowCount();
            Integer filasSeleccionada = principalGastos.getTablaGrafica().getSelectedRow();
            List<Integer> listaResutadosActualesThis = principalGastos.getTablaGasto().getListaResutladosActuales();
            Integer id = operacionesUtilidad.obtenerId(listaResutadosActualesThis, totalFilas, filasSeleccionada);
            this.setIdTabla(id);
        } catch (Exception e) {
        }
        return idTabla;
    }

    @Override
    public void rellenarTabla(String valorBusqueda) {

        DefaultTableModel tablaGastos = (DefaultTableModel) getTabla().getModel();
        List lista = this.getListaResultados();
        operacionesUtilidad.removerFilas(tablaGastos);
        try {
            this.listaResutladosActuales.clear();
        } catch (NullPointerException e) {
        }

        for (Object o : lista) {
            Gasto g = (Gasto) o;
            Integer resutadoComparacion = (g.getFecha().toString().indexOf(valorBusqueda));

            if (g.getCodigoEstado().getIdEstado().equals(1) && resutadoComparacion.equals(0)) {
                this.listaResutladosActuales.add(0, g.getIdGasto());
                Vector<Object> fila = new Vector<>();
                fila.add(g.getDescripcion());
                fila.add(OperacionesUtiles.formatoDouble(g.getPrecioTotal()));
                fila.add(OperacionesUtiles.formatoFechaSinHora(g.getFecha()));
                tablaGastos.addRow(fila);
            }

        }
        OperacionesUtiles.ordenarLista(listaResutladosActuales);
    }

    @Override
    public boolean verificarFilaSeleccionada() {
        try {
            int fila = principalGastos.getTablaGrafica().getSelectedRow();
            principalGastos.getTablaGrafica().getValueAt(fila, 0).toString();
            return true;
        } catch (Exception e) {
             DesktopNotify.showDesktopMessage("Informacion", "Debe seleccionar una fila", DesktopNotify.INFORMATION, 5000);
            return false;
        }
    }

}
