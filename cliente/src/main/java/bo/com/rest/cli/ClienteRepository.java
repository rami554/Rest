package bo.com.rest.cli;

import org.springframework.data.jpa.repository.JpaRepository;

interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
