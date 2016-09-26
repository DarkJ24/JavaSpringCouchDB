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
public class BlogPostRepository extends CouchDbRepositorySupport<BlogPost> {

    @Autowired
    public BlogPostRepository(@Qualifier("blogPostDatabase") CouchDbConnector db) {
        super(BlogPost.class, db);
        initStandardDesignDocument();
    }

    @GenerateView @Override
    public List<BlogPost> getAll() {
        ViewQuery q = createQuery("all").descending(true);
        return db.queryView(q, BlogPost.class);
    }

    @GenerateView
    public List<BlogPost> findByTag(String tag) {
        return queryView("by_tag", tag);
    }

}