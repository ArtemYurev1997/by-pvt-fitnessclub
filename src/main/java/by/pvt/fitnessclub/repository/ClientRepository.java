package by.pvt.fitnessclub.repository;

import by.pvt.fitnessclub.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
