package operacionesProveedor;

import calsesPadre.Tabla;
import clasesUtilidadGeneral.OperacionesUtiles;
import entidades.Direccion_Proveedor;
import entidades.Proveedor;
import entidades.TelefonoProveedor;
import escritorios.PrincipalProveedor;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TELCOM MPC
 */
public class TablaProveedor extends Tabla {

    public TablaProveedor() {
        setEstadoConsulta(0);
    }

    private PrincipalProveedor principalProveedor;
    private List<Integer> listaResutladosActuales = new ArrayList<Integer>();

    public PrincipalProveedor getPrincipalProveedor() {
        return principalProveedor;
    }

    public void setPrincipalProveedor(PrincipalProveedor principalProveedor) {
        this.principalProveedor = principalProveedor;
    }

    public List<Integer> getListaResutladosActuales() {
        return listaResutladosActuales;
    }

    public void setListaResutladosActuales(List<Integer> listaResutladosActuales) {
        this.listaResutladosActuales = listaResutladosActuales;
    }

    @Override
    public boolean verificarFilaSeleccionada() {
        try {
            int fila = principalProveedor.getTablaGrafica().getSelectedRow();
            principalProveedor.getTablaGrafica().getValueAt(fila, 0).toString();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    @Override
    public void rellenarTabla(String valorBusqueda) {
        DefaultTableModel tablaProveedor = (DefaultTableModel) getTabla().getModel();
        List lista = this.getListaResultados();
        operacionesUtilidad.removerFilas(tablaProveedor);
        //estas dos variables sirven para evitar que se repita un proveedor en la tabla por tener mas de un telefono o direccion (solamente aparece la primera registrada)
        Integer vueltaDir = 0;
        Integer vueltaTel = 0;

        try {
            this.listaResutladosActuales.clear();
        } catch (NullPointerException e) {
        }

        for (Object o : lista) {
            Proveedor pr = (Proveedor) o;
            Vector<Object> fila = new Vector<>();
            Integer resutadoComparacion = (pr.getNombre().toString().indexOf(valorBusqueda));
            boolean resultadoComparacion = OperacionesUtiles.convertirResultado(pr.getNombre(), valorBusqueda);
            if (pr.getCodigoEstado().getIdEstado().equals(1) && resultadoComparacion) {
                this.listaResutladosActuales.add(0, pr.getIdProveedor());
                fila.add(pr.getNombre());
                List<Direccion_Proveedor> direcciones = pr.getDireccionesProveedores();
                List<TelefonoProveedor> telefonos = pr.getTelefonos();
                if (pr.getDireccionesProveedores().size() == 0) {
                    fila.add("sin registros");
                    fila.add("sin registros");
                    fila.add("sin registros");
                    fila.add("sin registros");
                } else {
                    for (Direccion_Proveedor drPr : direcciones) {
                        if (vueltaDir != 1) {
                            fila.add(drPr.getNombre());
                            fila.add(drPr.getNumero());
                            fila.add(drPr.getCodigoLocalidad().getNombre());
                            fila.add(drPr.getCodigoLocalidad().getCodigoProvincia().getNombre());
                            vueltaDir = 1;
                        }
                    }
                }
                if (pr.getTelefonos().size() == 0) {
                    fila.add("sin registros");
                    fila.add("sin registros");
                } else {
                    for (TelefonoProveedor tlpr : telefonos) {
                        if (vueltaTel != 1) {
                            fila.add(tlpr.getNuemero());
                            fila.add(tlpr.getCodigoTipoTelefono().getNombre());

                            vueltaTel = 1;
                        }
                    }
                }

                vueltaDir = 0;
                vueltaTel = 0;
                tablaProveedor.addRow(fila);
            }
        }
        OperacionesUtiles.ordenarLista(listaResutladosActuales);
    }

    @Override
    public void ejecutarRellenarTabla() {
        setTabla(principalProveedor.getTablaGrafica());
        setStringConsulta("from Proveedor");
        evaluarEstadoConsulta();
        setCampoTexto(principalProveedor.getTxtBuscar());
        rellenarTabla(getCampoTexto().getText());
    }

    @Override
    public Integer obtenerIdFilaSeleccionada() {
        try {
            Integer totalFilas = principalProveedor.getTablaGrafica().getRowCount();
            Integer filasSeleccionada = principalProveedor.getTablaGrafica().getSelectedRow();
            List<Integer> listaResutadosActualesThis = principalProveedor.getTablaProveedor().getListaResutladosActuales();
            Integer id = operacionesUtilidad.obtenerId(listaResutadosActualesThis, totalFilas, filasSeleccionada);
            this.setIdTabla(id);
        } catch (Exception e) {
        }
        return idTabla;
    }
    
}