package bo.com.rest.cli;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
class Cliente {

    private @Id
    @GeneratedValue
    Long id;
    private String nombre;
    private String apellido;
    private String rol;

    Cliente() {
    }

    Cliente(String nombre, String apellido, String rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
    }

    public String getnombre() {
        return this.nombre + " " + this.apellido;
    }

    public void setnombre(String name) {
        String[] parts = name.split(" ");
        this.nombre = parts[0];
        this.apellido = parts[1];
    }

    public String getrol(){return this.rol;}

    public void setrol(String role) {
        String[] parts = role.split(" ");
        this.rol = parts[2];
    }

}