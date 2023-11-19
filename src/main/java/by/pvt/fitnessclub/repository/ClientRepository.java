package by.pvt.fitnessclub.repository;

import by.pvt.fitnessclub.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("select c from Client c where c.login=:login")
    Client findByLogin(@Param("login") String login);
}
