package bo.com.rest.cli;

class ClienteNotFoundException extends RuntimeException{
    ClienteNotFoundException(Long id){
        super("No se pudo Encontrar al Cliente" + id);
    }
}
