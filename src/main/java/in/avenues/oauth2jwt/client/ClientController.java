package in.avenues.oauth2jwt.client;

import in.avenues.oauth2jwt.security.service.SecureClientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/client")
public class ClientController {

    @Autowired
    private SecureClientDetailsService secureClientDetailsService;

    @GetMapping
    public void getClient(){
       var client = secureClientDetailsService.loadClientByClientId("web2");
        System.out.println(client.getClientId() +" " +client.getClientSecret());
    }
}
