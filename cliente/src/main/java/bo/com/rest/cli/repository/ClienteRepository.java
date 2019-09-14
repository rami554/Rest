package bo.com.rest.cli.repository;

import bo.com.rest.cli.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
