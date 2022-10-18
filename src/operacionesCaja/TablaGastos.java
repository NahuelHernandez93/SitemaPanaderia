package operacionesCaja;

import calsesPadre.Tabla;
import clasesUtilidadGeneral.OperacionesUtiles;
import entidades.Gasto;
import entidades.IngresoMateriaPrima;
import formularios.FormularioRegistrarCorte;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 * @author Hasper Franco
 */
public class TablaGastos extends Tabla {

    public void ejecutarRellenarTabla(FormularioRegistrarCorte formularioRegistrarCorte) {
        setTabla(formularioRegistrarCorte.getTablaSlidas());
        datosGastos();
        datosIngresosMateriaPrima();
    }

    /**
     * Ejecuata los metodos necesarios para rellenar la tabla de la salidas en
     * la ventana Corte de caja con los resultados de la consulta de gastos.
     *
     * @param p
     */
    public void datosGastos() {
        setConsultaList("from Gasto");
        obtenerListaConsulta();
        rellenarTablaFromGastos();
    }

    /**
     * Ejecuata los metodos necesarios para rellenar la tabla de la salidas en
     * la ventana Corte de caja con los resultados de la consulta de ingreso de
     * materia prima.
     *
     * @param p
     */
    public void datosIngresosMateriaPrima() {

        setConsultaList("from IngresoMateriaPrima");
        obtenerListaConsulta();
        rellenarTablaFromIngresoMatPrima();
    }

    
    /**
     * Toma los resultados de la consulta ingreso materia prima y los agrega en
     * la tabla salidas de la ventana Corte de Caja.
     */
    public void rellenarTablaFromIngresoMatPrima() {
        DefaultTableModel tablaSalidas = (DefaultTableModel) getTabla().getModel();
        List lista = this.getListaResultados();

        for (Object o : lista) {
            IngresoMateriaPrima i = (IngresoMateriaPrima) o;
            Vector<Object> fila = new Vector<>();
            if ( operacionesUtilidad.compararFecha(i.getFecha())&&i.getCodigoEstado().getIdEstado().equals(1)) {
                fila.add(i.getCodigoMateriaPrima().getNombre());
                fila.add("Ingreso de materia prima");
                fila.add(OperacionesUtiles.formatoDouble(i.getPrecioTotal()));
                tablaSalidas.addRow(fila);
            }
        }

    }
    
        /**
     * Toma los resultados de la consulta gastos y los agrega en la tabla
     * salidas de la ventana Corte de Caja.
     */
    public void rellenarTablaFromGastos() {
        DefaultTableModel tablaSalidas = (DefaultTableModel) getTabla().getModel();
        List lista = this.getListaResultados();
        
        for (Object o : lista) {
            Gasto g = (Gasto) o;
            Vector<Object> fila = new Vector<>();
            if (operacionesUtilidad.compararFecha(g.getFecha())&&g.getCodigoEstado().getIdEstado().equals(1)) {
                fila.add("otros");
                fila.add(g.getDescripcion());
                fila.add(OperacionesUtiles.formatoDouble(g.getPrecioTotal()));

                tablaSalidas.addRow(fila);
            }
        }

    }
    
    
    
    
    
    
    
    
    
    
    
    
    @Deprecated
    @Override
    public void ejecutarRellenarTabla() {

    }

    @Deprecated
    @Override
    public void rellenarTabla(String valorBusqueda) {

    }

    @Deprecated
    @Override
    public Integer obtenerIdFilaSeleccionada() {
        return 0;
    }

    @Deprecated
    @Override
    public boolean verificarFilaSeleccionada() {
        return false;
    }
}
