package in.avenues.oauth2jwt.client;

import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client getByClientId(String clientId) {

        Optional<Client> clientOptional = clientRepository.findClientByClientId(clientId);
        if (clientOptional.isPresent()) {
            return clientOptional.get();
        } else {
            throw new ClientRegistrationException("client not found!");
        }
    }
}
