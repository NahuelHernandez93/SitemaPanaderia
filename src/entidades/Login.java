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

@Table(name = "login")
public class Login {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;

    @Column(name = "user")
    private String user;

    @Column(name = "password")
    private String password;
    
     @ManyToOne
    @JoinColumn(name = "codigo_estado")
    private Estado codigoEstado;

    public Login() {
    }

     
    public Login(String user, String password, Estado codigoEstado) {
        this.user = user;
        this.password = password;
        this.codigoEstado = codigoEstado;
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Estado getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(Estado codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

     
     
     
     
     
}
