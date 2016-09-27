package com.darkj24;

import org.ektorp.support.CouchDbDocument;
import org.ektorp.support.TypeDiscriminator;

import java.util.List;

/**
 * Created by darkj24 on 9/26/16.
 */
public class Client extends CouchDbDocument {

    private static final long serialVersionUID = 1L;
    /**
     * @TypeDiscriminator is used to mark properties that makes this class's documents unique in the database.
     */
    @TypeDiscriminator
    private String id;

    private String name;

    private List<String> phones;

    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = title;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> tags) {
        this.phones = tags;
    }
}