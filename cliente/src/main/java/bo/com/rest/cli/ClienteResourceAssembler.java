package bo.com.rest.cli;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

@Component
class ClienteResourceAssembler implements ResourceAssembler<Cliente, Resource<Cliente>> {

    @Override
    public Resource<Cliente> toResource(Cliente cliente) {

        return new Resource<>(cliente,
                linkTo(methodOn(ClienteController.class).one(Cliente.getId())).withSelfRel(),
                linkTo(methodOn(ClienteController.class).all()).withRel("Clientes"));
    }
}
