package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceShould {

    @Mock
    UserGateway userGateway;
    @BeforeEach
    public void init(){
        Post post1 = new Post("2");
        Post post2 = new Post("2");

        when(userGateway.getPosts()).thenReturn(List.of(post1, post2));
    }

    @Test
    public void get_posts_via_gateway() {
        UserService userService = new UserService(userGateway);
        List<Post> posts = userService.getPosts("2");
        verify(userGateway).getPosts();
        Assertions.assertEquals(2, posts.size());
    }
}
