package operacionesVenta;

import calsesPadre.Tabla;
import clasesUtilidadGeneral.OperacionesUtiles;
import ds.desktop.notify.DesktopNotify;
import entidades.Cliente;
import entidades.Direccion_Cliente;
import entidades.TelefonoCliente;
import formularios.FormularioEditarVenta;
import formularios.FormularioRegistrarVenta;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Hasper Franco
 */
public class TablaClienteLista extends Tabla {

    public TablaClienteLista() {
        setEstadoConsulta(0);
    }

    private FormularioRegistrarVenta formularioRegistrarVenta;
    private FormularioEditarVenta formularioEditarVenta;
    private List<Integer> listaIds = new ArrayList<Integer>();
    private Integer idClientePrevio;

    public FormularioRegistrarVenta getFormularioRegistrarVenta() {
        return formularioRegistrarVenta;
    }

    public void setFormularioRegistrarVenta(FormularioRegistrarVenta formularioRegistrarVenta) {
        this.formularioRegistrarVenta = formularioRegistrarVenta;
    }

    public FormularioEditarVenta getFormularioEditarVenta() {
        return formularioEditarVenta;
    }

    public void setFormularioEditarVenta(FormularioEditarVenta formularioEditarVenta) {
        this.formularioEditarVenta = formularioEditarVenta;
    }

    public List<Integer> getListaIds() {
        return listaIds;
    }

    public void setListaIds(List<Integer> listaIds) {
        this.listaIds = listaIds;
    }

    public Integer getIdClientePrevio() {
        return idClientePrevio;
    }

    public void setIdClientePrevio(Integer idClientePrevio) {
        this.idClientePrevio = idClientePrevio;
    }

    @Override
    public void ejecutarRellenarTabla() {
        if (getFormularioRegistrarVenta() == null) {
            setTabla(formularioEditarVenta.getTablaGraficaListaCliente());
            setStringConsulta("from Cliente");
            evaluarEstadoConsulta();
            setCampoTexto(formularioEditarVenta.getTxtBuscarClientes());
            rellenarTabla(getCampoTexto().getText());

        } else {
            setTabla(formularioRegistrarVenta.getTablaGraficaListaCliente());
            setStringConsulta("from Cliente");
            evaluarEstadoConsulta();
            setCampoTexto(formularioRegistrarVenta.getTxtBuscarClientes());
            rellenarTabla(getCampoTexto().getText());
        }
    }

    @Override
    public void rellenarTabla(String valorBusqueda) {
        DefaultTableModel tablaCliente = (DefaultTableModel) getTabla().getModel();
        List lista = this.getListaResultados();
        operacionesUtilidad.removerFilas(tablaCliente);
        Integer vueltaDir = 0;
        Integer vueltaTel = 0;

        try {
            this.listaIds.clear();
        } catch (NullPointerException e) {
        }

        for (Object o : lista) {
            Cliente c = (Cliente) o;
            boolean resultadoComparacion = OperacionesUtiles.convertirResultado(c.getNombre(), valorBusqueda);
            //***********************
            if (c.getCodigoEstado().getIdEstado().equals(1) && resultadoComparacion && c.getIdCliente() != 1
                    && c.getIdCliente() != idClientePrevio) {
                this.listaIds.add(0, c.getIdCliente());
                Vector<Object> fila = new Vector<>();
                fila.add(c.getNombre() + " " + c.getApellido());
                List<Direccion_Cliente> direcciones = c.getDireccionesclientes();
                List<TelefonoCliente> telefonos = c.getTelefonos();
                //if (c.getTelefonos().isEmpty()) {

                if (c.getTelefonos().isEmpty()) {
                    fila.add("sin registros");
                } else {
                    for (TelefonoCliente tlcl : telefonos) {
                        if (vueltaTel != 1) {
                            fila.add(tlcl.getNuemero() + " - " + tlcl.getCodigoTipoTelefono().getNombre());
                            vueltaTel = 1;
                        }
                    }
                }
                if (c.getDireccionesclientes().isEmpty()) {
                    fila.add("sin registros");
                } else {
                    for (Direccion_Cliente drCl : direcciones) {
                        if (vueltaDir != 1) {
                            fila.add(drCl.getNombre() + " (" + drCl.getNumero() + ") " + drCl.getCodigoLocalidad().getNombre() + " - " + drCl.getCodigoLocalidad().getCodigoProvincia().getNombre());
                            vueltaDir = 1;
                        }
                    }
                }

                vueltaDir = 0;
                vueltaTel = 0;
                tablaCliente.addRow(fila);
            }
        }
        OperacionesUtiles.ordenarLista(listaIds);
    }

    @Override
    public boolean verificarFilaSeleccionada() {
        int fila;
        try {
            if (getFormularioRegistrarVenta() == null) {
                fila = formularioEditarVenta.getTablaGraficaListaCliente().getSelectedRow();
                formularioEditarVenta.getTablaGraficaListaCliente().getValueAt(fila, 0).toString();
            } else {
                fila = formularioRegistrarVenta.getTablaGraficaListaCliente().getSelectedRow();
                formularioRegistrarVenta.getTablaGraficaListaCliente().getValueAt(fila, 0).toString();
            }

            return true;
        } catch (Exception e) {

            DesktopNotify.showDesktopMessage("Informacion", "Debe seleccionar una fila", DesktopNotify.INFORMATION, 7000);
            return false;
        }
    }

    public boolean verficarClienteNoconsumidorFinal() {
        if (obtenerIdFilaSeleccionada().equals(1)) {
            JOptionPane.showMessageDialog(null, "Seleccione la casilla consumidor final", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Integer obtenerIdFilaSeleccionada() {
        Integer totalFilas;
        Integer filasSeleccionada;
        List<Integer> listaIds;
        Integer id;
        try {
            if (getFormularioRegistrarVenta() == null) {
                totalFilas = formularioEditarVenta.getTablaGraficaListaCliente().getRowCount();
                filasSeleccionada = formularioEditarVenta.getTablaGraficaListaCliente().getSelectedRow();
                listaIds = formularioEditarVenta.getTablaClienteLista().getListaIds();
                id = operacionesUtilidad.obtenerId(listaIds, totalFilas, filasSeleccionada);
                this.setIdTabla(id);
            } else {
                totalFilas = formularioRegistrarVenta.getTablaGraficaListaCliente().getRowCount();
                filasSeleccionada = formularioRegistrarVenta.getTablaGraficaListaCliente().getSelectedRow();
                listaIds = formularioRegistrarVenta.getTablaClienteLista().getListaIds();
                id = operacionesUtilidad.obtenerId(listaIds, totalFilas, filasSeleccionada);
                this.setIdTabla(id);
            }

        } catch (Exception e) {
        }
        return idTabla;
    }

}
