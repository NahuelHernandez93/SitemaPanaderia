package operacionesIngresoMateriaPrima;

import calsesPadre.Tabla;
import clasesUtilidadGeneral.OperacionesUtiles;
import entidades.IngresoMateriaPrima;
import escritorios.PrincipalIngresoMatPrima;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Hasper Franco
 */
public class TablaIngresoMateriaPrima extends Tabla {

    public TablaIngresoMateriaPrima() {
        setEstadoConsulta(0);
    }

    private PrincipalIngresoMatPrima principalIngresoMateriaPrima;
    private List<Integer> listaResutladosActuales = new ArrayList<Integer>();

    public PrincipalIngresoMatPrima getPrincipalIngresoMateriaPrima() {
        return principalIngresoMateriaPrima;
    }

    public void setPrincipalIngresoMateriaPrima(PrincipalIngresoMatPrima principalIngresoMateriaPrima) {
        this.principalIngresoMateriaPrima = principalIngresoMateriaPrima;
    }

    public List<Integer> getListaResutladosActuales() {
        return listaResutladosActuales;
    }

    public void setListaResutladosActuales(List<Integer> listaResutladosActuales) {
        this.listaResutladosActuales = listaResutladosActuales;
    }

    @Override
    public void ejecutarRellenarTabla() {
        setTabla(principalIngresoMateriaPrima.getTablaGrafica());
        setStringConsulta("from IngresoMateriaPrima");
        evaluarEstadoConsulta();
        setCampoTexto(principalIngresoMateriaPrima.getTxtBuscar());
        rellenarTabla(getCampoTexto().getText());
    }

    @Override
    public Integer obtenerIdFilaSeleccionada() {
        try {
              Integer totalFilas = principalIngresoMateriaPrima.getTablaGrafica().getRowCount();
            Integer filasSeleccionada = principalIngresoMateriaPrima.getTablaGrafica().getSelectedRow();
            List<Integer> listaResutadosActualesThis = principalIngresoMateriaPrima.getTablaIngresoMateriaPrima().getListaResutladosActuales();
            Integer id = operacionesUtilidad.obtenerId(listaResutadosActualesThis, totalFilas, filasSeleccionada);
            this.setIdTabla(id);
        } catch (Exception e) {
        }
        return idTabla;
    }

    @Override
    public void rellenarTabla(String valorBusqueda) {
        DefaultTableModel tablaIngresoMateriaPrima = (DefaultTableModel) getTabla().getModel();
        List lista = this.getListaResultados();
        operacionesUtilidad.removerFilas(tablaIngresoMateriaPrima);
        try {
            this.listaResutladosActuales.clear();
        } catch (NullPointerException e) {
        }
        
          for (Object o : lista) {
            IngresoMateriaPrima inmt = (IngresoMateriaPrima) o;
           
            Integer resutadoComparacion = (OperacionesUtiles.formatoFechaSinHora(inmt.getFecha()).toString().indexOf(valorBusqueda));
            
            if (inmt.getCodigoEstado().getIdEstado().equals(1) && (resutadoComparacion.equals(0))) {
                this.listaResutladosActuales.add(0, inmt.getIdIngresoMateriaPrima());
                 Vector<Object> fila = new Vector<>();
                fila.add(inmt.getCodigoMateriaPrima().getNombre());
                fila.add(inmt.getTotalEnvases());
                fila.add(inmt.getUdPorEnvase());
                fila.add(inmt.getCodigoMateriaPrima().getCodigoUnidaddeMedida().getNombre());
                fila.add(inmt.getPrecioTotal());
                fila.add(OperacionesUtiles.formatoFechaSinHora(inmt.getFecha()));
                tablaIngresoMateriaPrima.addRow(fila);
            }
        }
        OperacionesUtiles.ordenarLista(listaResutladosActuales);
    }
    
    @Override
    public boolean verificarFilaSeleccionada() {
        try {
            int fila = principalIngresoMateriaPrima.getTablaGrafica().getSelectedRow();
            principalIngresoMateriaPrima.getTablaGrafica().getValueAt(fila, 0).toString();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
    
    
    
    
    
}
