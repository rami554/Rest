package bo.com.rest.cli;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.hateoas.Resource;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RestController
class ClienteController {
    private final ClienteRepository repository;
    private final ClienteResourceAssembler assembler;

    ClienteController(ClienteRepository repository, ClienteResourceAssembler assembler){
        this.repository = repository;
        this.assembler = assembler;
    }

    //Agregando Rutas
    @GetMapping("/cliente")
    Resources<Resource<Cliente>> all() {

        List<Resource<Cliente>> cliente = repository.findAll().stream()
                .map(assembler::toResource)
                .collect(Collectors.toList());

        return new Resources<>(cliente,
                linkTo(methodOn(ClienteController.class).all()).withSelfRel());
    }
    @PostMapping("/cliente")
    Resources<Resource<Cliente>> all() {

        List<Resource<Cliente>> cliente = repository.findAll().stream()
                .map(assembler::toResource)
                .collect(Collectors.toList());

        return new Resources<>(cliente,
                linkTo(methodOn(ClienteController.class).all()).withSelfRel());
    }
    //item simple
    @GetMapping("/cliente/{id}")
    ResponseEntity<?> nuevoCliente(@RequestBody Cliente nuevoCliente) throws URISyntaxException {

        Resource<Cliente> resource = assembler.toResource(repository.save(nuevoCliente));

        return ResponseEntity
                .created(new URI(resource.getId().expand().getHref()))
                .body(resource);
    }

    @GetMapping("/employees/{id}")
    Resource<Cliente> one(@PathVariable Long id) {

        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));

        return assembler.toResource(cliente);
    }

    @PutMapping("/cliente/{id}")
    ResponseEntity<?> replaceCliente(@RequestBody Cliente nuevocliente, @PathVariable Long id) throws URISyntaxException {

        Cliente UpdateCliente = repository.findById(id)
                .map(cliente -> {
                    cliente.setnombre(nuevocliente.getnombre());
                    cliente.setrol(nuevocliente.getrol());
                    return repository.save(cliente);
                })
                .orElseGet(() -> {
                    nuevocliente.setId(id);
                    return repository.save(nuevocliente);
                });

        Resource<Cliente> resource = assembler.toResource(UpdateCliente);

        return ResponseEntity
                .created(new URI(resource.getId().expand().getHref()))
                .body(resource);
    }

    @DeleteMapping("/cliente/{id}")
    ResponseEntity<?> BorrarCliente(@PathVariable Long id) {

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
