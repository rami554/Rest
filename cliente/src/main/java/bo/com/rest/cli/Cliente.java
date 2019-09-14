package bo.com.rest.cli;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Cliente {

    private @Id
    @GeneratedValue
    Long id;
    private String nombre;
    private String apellido;
    private String rol;
    Cliente(){}
    public Cliente(String nombre, String apellido, String rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
    }

}