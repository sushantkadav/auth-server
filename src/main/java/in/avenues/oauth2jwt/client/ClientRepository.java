package in.avenues.oauth2jwt.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Serializable> {
    Optional<Client> findClientByClientId(String clientId);
}
