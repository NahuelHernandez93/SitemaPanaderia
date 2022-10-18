package entidades;

import java.sql.Blob;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author TELCOM MPC
 */
@Entity
@Table(name = "productos")
public class Producto {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer idProducto;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "imagen")
    private Blob imagen;
    
    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "codigo_estado")
    private Estado codigoEstado;

    @OneToMany(mappedBy = "codigoProducto")
    private List<PrecioProducto> precios;

    @OneToMany(mappedBy = "codigoProducto")
    private List<Producto_Venta> ventas;

    public Producto() {
    }

    public Producto(String nombre, Blob imagen, String descripcion, Estado codigoEstado) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.codigoEstado = codigoEstado;
    }




    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Blob getImagen() {
        return imagen;
    }

    public void setImagen(Blob imagen) {
        this.imagen = imagen;
    }


    
    
    public Estado getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(Estado codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public List<PrecioProducto> getPrecios() {
        return precios;
    }

    public void setPrecios(List<PrecioProducto> precios) {
        this.precios = precios;
    }

    public List<Producto_Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Producto_Venta> ventas) {
        this.ventas = ventas;
    }

}
