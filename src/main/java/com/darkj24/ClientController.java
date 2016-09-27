package com.darkj24;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by darkj24 on 9/26/16.
 */
@RestController
public class ClientController {

    @Autowired
    ClientRepository clientRepo;

    @RequestMapping( value = "/clients", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Client> viewAll() {
        return clientRepo.getAll();
    }

    @RequestMapping( value = "/clients", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody Client submitClient(@ModelAttribute("command") Client client) {
        String id = "";
        if (client.isNew()) {
            id = createId(client.getName());
            client.setId(id);
        }
        clientRepo.update(client);
        return clientRepo.get(id);
    }

    private String createId(String name) {
        return name.replaceAll("\\s", "-");
    }

    @RequestMapping(value = "/clients/{clientId}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Client viewClient(@PathVariable("clientId") String clientId) {
        return clientRepo.get(clientId);
    }

    @RequestMapping(value = "/clients/{clientId}", method = RequestMethod.DELETE, produces = "application/json")
    public @ResponseBody Client removeClient(@PathVariable("clientId") String clientId) {
        Client client = clientRepo.get(clientId);
        clientRepo.remove(client);
        return client;
    }
}
