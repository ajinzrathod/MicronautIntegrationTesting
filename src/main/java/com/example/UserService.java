package com.example;

import jakarta.inject.Singleton;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Singleton
public class UserService {
    private UserGateway userGateway;

    public UserService(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public List<Post> getPosts(String userId) {
        return this.userGateway.getPosts().stream().filter(post -> post.getId().equals(userId)).collect(Collectors.toList());
    }
}
