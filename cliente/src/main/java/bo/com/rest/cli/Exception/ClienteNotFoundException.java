package bo.com.rest.cli.Exception;

public class ClienteNotFoundException extends RuntimeException{
    public ClienteNotFoundException(Long id){
        super("No se pudo Encontrar al Cliente" + id);
    }
}
