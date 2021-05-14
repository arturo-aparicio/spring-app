package ai.devrev.my_spring_app.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EntityScan("ai.devrev.my_spring_app.domain")
@EnableJpaRepositories("ai.devrev.my_spring_app.repos")
@EnableTransactionManagement
public class DomainConfig {
}
