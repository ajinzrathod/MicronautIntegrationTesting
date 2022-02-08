package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

import java.util.List;

@Controller("/users")
public class UserController {

    @Inject
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Get("/{userId}/posts")
    public List<Post> getPosts(String userId) {
        return this.userService.getPosts(userId);
    }
}
