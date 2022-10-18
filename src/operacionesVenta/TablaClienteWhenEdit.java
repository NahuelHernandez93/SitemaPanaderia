package operacionesVenta;

import calsesPadre.Consultas;
import clasesUtilidadGeneral.OperacionesUtiles;
import entidades.Cliente;
import entidades.Direccion_Cliente;
import entidades.TelefonoCliente;
import entidades.Venta;
import formularios.FormularioEditarVenta;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 * @author Hasper Franco
 */
public class TablaClienteWhenEdit extends Consultas {

    private String nombreApellido;
    private String telefono;
    private String direccion;
    private Integer idCliente;
    private FormularioEditarVenta formularioEditarVenta;
    private Integer idVenta;

    public FormularioEditarVenta getFormularioEditarVenta() {
        return formularioEditarVenta;
    }

    public void setFormularioEditarVenta(FormularioEditarVenta formularioEditarVenta) {
        this.formularioEditarVenta = formularioEditarVenta;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public void ejecutarRellenenarTabla() {
        obtenerDatos();
        rellenartabla();
    }

    private void obtenerDatos() {
        Integer idCliente;
        setConsultaObject("from Venta where idVenta=" + idVenta.toString());
        obtenerObjetoConsulta();
        Object venta = this.getObjetoResultado();
        Venta v = (Venta) venta;
        idCliente = v.getCodigoCliente().getIdCliente();
        this.setIdCliente(idCliente);

        setConsultaObject("from Cliente where idCliente=" + idCliente.toString());
        obtenerObjetoConsulta();
        Object cliente = this.getObjetoResultado();
        Cliente c = (Cliente) cliente;
        this.setNombreApellido(c.getNombre() + " " + c.getApellido());

        setConsultaObject("from TelefonoCliente where codigoCliente=" + idCliente.toString());
        obtenerObjetoConsulta();
        Object telefonoCliente = this.getObjetoResultado();
        TelefonoCliente tc = (TelefonoCliente) telefonoCliente;
        try {
            this.setTelefono(tc.getNuemero());
        } catch (NullPointerException e) {
            this.setTelefono("sin regisros");
        }

        setConsultaObject("from Direccion_Cliente where codigoCliente=" + idCliente.toString());
        obtenerObjetoConsulta();
        Object direccionCliente = this.getObjetoResultado();
        Direccion_Cliente dc = (Direccion_Cliente) direccionCliente;

        try {
           this.setDireccion(dc.getNombre() + "(" + dc.getNumero() + ")" + " " + dc.getCodigoLocalidad().getNombre() + "-" + dc.getCodigoLocalidad().getCodigoProvincia().getNombre());
        } catch (NullPointerException e) {
            this.setDireccion("sin regisros");
        }


      

    }

    private void rellenartabla() {

        DefaultTableModel tablaVentaClienteE = (DefaultTableModel) formularioEditarVenta.getTablaGraficaCliente().getModel();
        OperacionesUtiles.removerFilas(tablaVentaClienteE);
        Vector datosTabla = new Vector();
        datosTabla.add(this.getNombreApellido());
        datosTabla.add(this.getTelefono());
        datosTabla.add(this.getDireccion());
        tablaVentaClienteE.addRow(datosTabla);
    }

}
