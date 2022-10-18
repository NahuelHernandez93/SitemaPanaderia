package operacionesProducto;

import calsesPadre.Tabla;
import entidades.PrecioProducto;
import escritorios.PrincipalProducto;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import clasesUtilidadGeneral.OperacionesUtiles;
import ds.desktop.notify.DesktopNotify;
import escritorios.PrincipalCliente;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author TELCOM MPC
 */
public class TablaProducto extends Tabla {

    public TablaProducto() {
        setEstadoConsulta(0);
    }

    private PrincipalProducto principalProducto;
    private List<Integer> listaResutladosActuales = new ArrayList<Integer>();

    public PrincipalProducto getPrincipalProducto() {
        return principalProducto;
    }

    public void setPrincipalProducto(PrincipalProducto principalProducto) {
        this.principalProducto = principalProducto;
    }

    public List<Integer> getListaResutladosActuales() {
        return listaResutladosActuales;
    }

    public void setListaResutladosActuales(List<Integer> listaResutladosActuales) {
        this.listaResutladosActuales = listaResutladosActuales;
    }

    @Override
    public void ejecutarRellenarTabla() {
        setTabla(principalProducto.getTablaGrafica());
        setStringConsulta("from PrecioProducto");
        evaluarEstadoConsulta();
        setCampoTexto(principalProducto.getTxtBuscar());
        rellenarTabla(getCampoTexto().getText());
    }

    @Override
    public void rellenarTabla(String valorBusqueda) {
        DefaultTableModel tablaProducto = (DefaultTableModel) getTabla().getModel();
        List lista = this.getListaResultados();
        operacionesUtilidad.removerFilas(tablaProducto);

        try {
            this.listaResutladosActuales.clear();
        } catch (NullPointerException e) {
        }

        for (Object o : lista) {
            PrecioProducto pr = (PrecioProducto) o;
            Vector<Object> fila = new Vector<>();
            boolean resultadoComparacion = OperacionesUtiles.convertirResultado(pr.getCodigoProducto().getNombre(), valorBusqueda);
            if (pr.getCodigoEstado().getIdEstado().equals(1)
                    && pr.getCodigoProducto().getCodigoEstado().getIdEstado().equals(1) && resultadoComparacion) {
                //caso especial :v
                this.listaResutladosActuales.add(0, pr.getIdPrecio());
                fila.add(pr.getCodigoProducto().getNombre());
                fila.add(pr.getCodigoProducto().getDescripcion());
                fila.add(pr.getPrecioTotal());
                fila.add(new OperacionesUtiles().formatoFechaSinHora(pr.getFecha()));
                tablaProducto.addRow(fila);
            }
        }
        OperacionesUtiles.ordenarLista(listaResutladosActuales);
    }

    @Override
    public boolean verificarFilaSeleccionada() {
        try {
            int fila = principalProducto.getTablaGrafica().getSelectedRow();
            principalProducto.getTablaGrafica().getValueAt(fila, 0).toString();
            return true;
        } catch (Exception e) {
            DesktopNotify.showDesktopMessage("   información   ", "  Debe seleccionar una fila", DesktopNotify.INFORMATION, 5000);
            return false;
        }
    }

    //id precioproducto
    @Override
    public Integer obtenerIdFilaSeleccionada() {
        try {
            Integer totalFilas = principalProducto.getTablaGrafica().getRowCount();
            Integer filasSeleccionada = principalProducto.getTablaGrafica().getSelectedRow();
            List<Integer> listaResutadosActualesThis = principalProducto.getTablaProducto().getListaResutladosActuales();
            Integer id = operacionesUtilidad.obtenerId(listaResutadosActualesThis, totalFilas, filasSeleccionada);
            this.setIdTabla(id);
        } catch (Exception e) {
        }
        return idTabla;
    }

}
