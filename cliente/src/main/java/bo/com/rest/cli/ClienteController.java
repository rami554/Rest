package bo.com.rest.cli;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class ClienteController {
    private final ClienteRepository repository;

    ClienteController(ClienteRepository repository){
        this.repository = repository;
    }

    //Agregando Rutas
    @GetMapping("/getcliente")
    List<Cliente> all() {
        return repository.findAll();
    }
    @PostMapping("/postcliente")
    Cliente nuevoCliente(@RequestBody Cliente nuevoCliente) {
        return repository.save(nuevoCliente);
    }
    //item simple
    @GetMapping("/getcliente/{id}")
    Cliente one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));
    }

    @PutMapping("/putcliente/{id}")
    Cliente replaceCliente(@RequestBody Cliente nuevoCliente, @PathVariable Long id) {

        return repository.findById(id)
                .map(Cliente -> {
                    Cliente.setNombre(nuevoCliente.getNombre());
                    Cliente.setApellido(nuevoCliente.getApellido());
                    Cliente.setRol(nuevoCliente.getRol());
                    return repository.save(Cliente);
                })
                .orElseGet(() -> {
                    nuevoCliente.setId(id);
                    return repository.save(nuevoCliente);
                });
    }

    @DeleteMapping("/delcliente/{id}")
    void deleteCliente(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
