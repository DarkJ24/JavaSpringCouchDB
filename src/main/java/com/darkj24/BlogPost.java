package com.darkj24;

/**
 * Created by Jose Quesada on 9/26/2016.
 */
import org.ektorp.docref.DocumentReferences;
import org.ektorp.docref.FetchType;
import org.ektorp.support.*;
import org.joda.time.*;
import java.util.List;
import java.util.Set;

public class BlogPost extends CouchDbDocument {

    private static final long serialVersionUID = 1L;
    /**
     * @TypeDiscriminator is used to mark properties that makes this class's documents unique in the database.
     */
    @TypeDiscriminator
    private String title;

    private String body;

    private List<String> tags;

    private DateTime dateCreated;

    /**
     * @DocumentReferences is used to refer to other documents in the database, in this case comments.
     */
    @DocumentReferences(fetch = FetchType.LAZY, descendingSortOrder = true, orderBy = "dateCreated", backReference = "blogPostId")
    private Set<Comment> comments;

    public DateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(DateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}