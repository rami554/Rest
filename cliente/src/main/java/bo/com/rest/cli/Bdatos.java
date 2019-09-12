package bo.com.rest.cli;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class Bdatos {
    @Bean
    CommandLineRunner initDatabase(ClienteRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Cliente("Ramiro Menendez", "Premium")));
            log.info("Preloading " + repository.save(new Cliente("Carlos Cabrera", "Standar")));
        };
    }

}
