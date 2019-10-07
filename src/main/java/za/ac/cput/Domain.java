package za.ac.cput;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Domain!
 *
 */
@EnableJpaRepositories(basePackages = "za.ac.cput.repository")
@SpringBootApplication
public class Domain
{
    public static void main( String[] args )
    {
        SpringApplication.run(Domain.class,args);
    }
}
