package de.ble.demo.product;

import java.text.SimpleDateFormat;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ProductRepository repository) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        return args -> {
            log.info("Preloading " + repository.save(new Product("Weizen", 50000L, formatter.parse("2020-01-01"))));
            log.info("Preloading " + repository.save(new Product("Weizen", 10040L, formatter.parse("2020-03-01"))));
            log.info("Preloading " + repository.save(new Product("Weizen", 30000L, formatter.parse("2020-02-01"))));
            log.info("Preloading " + repository.save(new Product("Roggen", 30000L, formatter.parse("2020-03-01"))));
            log.info("Preloading " + repository.save(new Product("Roggen", 40000L, formatter.parse("2020-02-01"))));
            log.info("Preloading " + repository.save(new Product("Roggen", 30000L, formatter.parse("2020-01-01"))));
            log.info("Preloading " + repository.save(new Product("Roggen", 28000L, formatter.parse("2020-02-15"))));
            log.info("Preloading " + repository.save(new Product("Roggen", 35000L, formatter.parse("2020-03-15"))));

        };
    }
}
