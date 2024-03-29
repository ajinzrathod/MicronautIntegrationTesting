package com.example;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

@MicronautTest
public class UserControllerTest {

    @Inject
    @Client("/")
    HttpClient httpClient;

    @Test
    public void get_post_user_id() {
        List<Map> posts = httpClient.toBlocking().retrieve(HttpRequest.GET("/users/2/posts"), Argument.listOf(Map.class));
        Assertions.assertFalse(posts.isEmpty());
    }
}
