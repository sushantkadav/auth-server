package in.avenues.oauth2jwt.security.service;

import in.avenues.oauth2jwt.client.Client;
import in.avenues.oauth2jwt.client.ClientRepository;
import in.avenues.oauth2jwt.client.ClientService;
import in.avenues.oauth2jwt.security.SecureClientDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Component;

@Component
public class SecureClientDetailsService implements ClientDetailsService {

    @Autowired
    private ClientService clientService;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        Client client = clientService.getByClientId(clientId);
        return new SecureClientDetails(client);
    }
}
