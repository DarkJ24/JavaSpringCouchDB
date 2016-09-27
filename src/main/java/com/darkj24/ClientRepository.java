package com.darkj24;

/**
 * Created by Jose Quesada on 9/26/2016.
 */
import java.util.*;
import org.ektorp.*;
import org.ektorp.support.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
public class ClientRepository extends CouchDbRepositorySupport<Client> {

    @Autowired
    public ClientRepository(@Qualifier("myDatabase") CouchDbConnector db) {
        super(Client.class, db);
        initStandardDesignDocument();
    }

    @Override
    public List<Client> getAll() {
        List<Client> clients = new ArrayList<Client>();
        List<String> ids = db.getAllDocIds();
        for (int i = 0; i < ids.size() - 1; i++){
            clients.add(this.get(ids.get(i)));
        }
        return clients;
    }

    @GenerateView
    public List<Client> findByName(String name) {
        return queryView("by_name", name);
    }

}