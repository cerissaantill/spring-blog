package com.codeup.blog.blog;

import org.springframework.data.repository.CrudRepository;
import java.security.Principal;



public interface PostRepository extends CrudRepository<Post, Long> {

}

