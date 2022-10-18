package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Hasper Franco
 */
@Entity
//en la bd tiene este nombre (distinto al de mi clase)
@Table(name = "Venta_MovimientoCuenta")

public class Venta_MovimientoCuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Venta ventaId;

    @ManyToOne
    @JoinColumn(name = "movimientocuenta_id")
    private MovimientoCuenta movimientoCuentaId;

    public Venta_MovimientoCuenta() {
    }

    public Venta_MovimientoCuenta(Venta ventaId, MovimientoCuenta movimientoCuentaId) {
        this.ventaId = ventaId;
        this.movimientoCuentaId = movimientoCuentaId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Venta getVentaId() {
        return ventaId;
    }

    public void setVentaId(Venta ventaId) {
        this.ventaId = ventaId;
    }

    public MovimientoCuenta getMovimientoCuentaId() {
        return movimientoCuentaId;
    }

    public void setMovimientoCuentaId(MovimientoCuenta movimientoCuentaId) {
        this.movimientoCuentaId = movimientoCuentaId;
    }
    
    
    
    
    

}
