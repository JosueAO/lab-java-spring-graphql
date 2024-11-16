package br.com.josueao.lab_graphql;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ForumCrontroller {

    @Autowired
    PostService postService;

    @Autowired
    CommentService commentService;

    @QueryMapping
    public Post postById(@Argument String id) {
        return postService.postById(id);
    }

    @MutationMapping
    public Collection<Post> createPost(@Argument String content) {
        return postService.createPost(content);
    }

    @MutationMapping
    public Collection<Comment> createComment(@Argument String postId, @Argument String content) {
        return commentService.createComment(postId, content);
    }
}
