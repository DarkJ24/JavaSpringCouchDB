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
@View( name="all", map = "function(doc) { if (doc.blogPostId) { emit(null, doc) } }")
public class CommentRepository extends CouchDbRepositorySupport<Comment> {

    @Autowired
    public CommentRepository(@Qualifier("blogPostDatabase") CouchDbConnector db) {
        super(Comment.class, db);
        initStandardDesignDocument();
    }

    @GenerateView
    public List<Comment> findByBlogPostId(String blogPostId) {
        return queryView("by_blogPostId", blogPostId);
    }

}