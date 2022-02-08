package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserControllerShould {

    @Mock
    private UserService userService;
    private UserController userController;

    @BeforeEach
    public void init(){
        userController = new UserController(userService);
    }

    @Test
    public void get_posts_via_service() {
        List<Post> posts = userController.getPosts("2");
        verify(userService).getPosts("2");
    }
}
