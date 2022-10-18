package operacionesMateriaPrima;

import calsesPadre.Tabla;
import entidades.MateriaPrima_Marca_Proveedor;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import escritorios.PrincipalMateriaPrima;
import clasesUtilidadGeneral.OperacionesUtiles;
import ds.desktop.notify.DesktopNotify;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * <h1>Clase TablaMatetiaPrima</h1>
 * Contiene atributos y metodos que se encargan de manejar operaciones
 * relaacionadas con JTable de la interfaz grafica materia prima
 *
 * @author Hasper Franco
 * @version 0.1
 * @since 2020-01-15
 */
public class TablaMateriaPrima extends Tabla {

    public TablaMateriaPrima() {
        setEstadoConsulta(0);
    }

    private PrincipalMateriaPrima principalMateriaPrima;
    private List<Integer> listaResutladosActuales = new ArrayList<Integer>();
    private List<Integer> listaResutladosActualesMtMrPr = new ArrayList<Integer>();

    public List<Integer> getListaResutladosActualesMtMrPr() {
        return listaResutladosActualesMtMrPr;
    }

    public void setListaResutladosActualesMtMrPr(List<Integer> listaResutladosActualesMtMrPr) {
        this.listaResutladosActualesMtMrPr = listaResutladosActualesMtMrPr;
    }

    public PrincipalMateriaPrima getPrincipalMateriaPrima() {
        return principalMateriaPrima;
    }

    public void setPrincipalMateriaPrima(PrincipalMateriaPrima principalMateriaPrima) {
        this.principalMateriaPrima = principalMateriaPrima;
    }

    public List<Integer> getListaResutladosActuales() {
        return listaResutladosActuales;
    }

    public void setListaResutladosActuales(List<Integer> listaResutladosActuales) {
        this.listaResutladosActuales = listaResutladosActuales;
    }

    @Override
    public void ejecutarRellenarTabla() {
        setTabla(principalMateriaPrima.getTablaGrafica());
        setStringConsulta("from MateriaPrima_Marca_Proveedor");
        evaluarEstadoConsulta();
        setCampoTexto(principalMateriaPrima.getTxtBuscar());
        rellenarTabla(getCampoTexto().getText());
    }

    @Override
    public Integer obtenerIdFilaSeleccionada() {
        try {
            Integer totalFilas = principalMateriaPrima.getTablaGrafica().getRowCount();
            Integer filasSeleccionada = principalMateriaPrima.getTablaGrafica().getSelectedRow();
            List<Integer> listaResutadosActualesThis = principalMateriaPrima.getTablaMateriaPrima().getListaResutladosActuales();
            Integer id = operacionesUtilidad.obtenerId(listaResutadosActualesThis, totalFilas, filasSeleccionada);
            this.setIdTabla(id);
        } catch (Exception e) {
        }
        return idTabla;
    }

    @Override
    public void rellenarTabla(String valorBusqueda) {
        DefaultTableModel tablaMateriaPrima = (DefaultTableModel) getTabla().getModel();
        List lista = this.getListaResultados();
        operacionesUtilidad.removerFilas(tablaMateriaPrima);
        try {
            this.listaResutladosActuales.clear();
            this.listaResutladosActualesMtMrPr.clear();
        } catch (NullPointerException e) {
        }

        for (Object o : lista) {
            MateriaPrima_Marca_Proveedor mpm = (MateriaPrima_Marca_Proveedor) o;

            boolean resultadoComparacion = OperacionesUtiles.convertirResultado(mpm.getCodigoMateriaPrima().getNombre(), valorBusqueda);
            if (mpm.getCodigoMateriaPrima().getCodigoEstado().getIdEstado().equals(1) && resultadoComparacion) {
                this.listaResutladosActuales.add(0, mpm.getCodigoMateriaPrima().getIdMateriaPrima());
                this.listaResutladosActualesMtMrPr.add(0, mpm.getIdMateriaPrimaMarcaProveedor());
                Vector<Object> fila = new Vector<>();
                fila.add(mpm.getCodigoMateriaPrima().getNombre());
                fila.add(mpm.getCodigoProveedor().getNombre());
                fila.add(mpm.getCodigoMarca().getNombre());
                fila.add(mpm.getCodigoMateriaPrima().getCodigoUnidaddeMedida().getNombre());
                tablaMateriaPrima.addRow(fila);
            }
        }
        OperacionesUtiles.ordenarLista(listaResutladosActuales);
        OperacionesUtiles.ordenarLista(listaResutladosActualesMtMrPr);
    }

    
    
    @Override
    public boolean verificarFilaSeleccionada() {
        try {
            int fila = principalMateriaPrima.getTablaGrafica().getSelectedRow();
            principalMateriaPrima.getTablaGrafica().getValueAt(fila, 0).toString();
            return true;
        } catch (Exception e) {
              DesktopNotify.showDesktopMessage("Informacion", "Debe seleccionar una fila", DesktopNotify.INFORMATION, 7000);
            return false;
        }
    }

}
