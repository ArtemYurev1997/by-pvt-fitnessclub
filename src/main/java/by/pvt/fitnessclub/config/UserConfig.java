package by.pvt.fitnessclub.config;

import by.pvt.fitnessclub.repository.ClientDaoRepository;
import by.pvt.fitnessclub.repository.jpa.ClientRepositoryHibernate;
import by.pvt.fitnessclub.service.ClientService;
import by.pvt.fitnessclub.service.impl.ClientServiceDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("by.pvt.fitnessclub")
public class UserConfig {

    @Bean
    public ClientService clientServiceJpa() {
        return new ClientServiceDao(clientDaoRepository());
    }

    @Bean
    public ClientDaoRepository clientDaoRepository() {
        return new ClientRepositoryHibernate();
    }
}
