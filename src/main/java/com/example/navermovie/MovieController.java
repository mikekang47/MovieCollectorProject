package com.example.navermovie;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/")
public class MovieController {
    private final WebClient webClient;

    public MovieController() {
        this.webClient = WebClient.create("https://openapi.naver.com/v1/search/movie.json");
    }

    @Value("${naver.openapi.client.id}")
    private String id;

    @Value("${naver.openapi.client.secret}")
    private String secret;

    @GetMapping
    public Flux<MovieResponse> get(@RequestParam String name) {
        return webClient.get()
                .uri("?query=" + name)
                .header("X-Naver-Client-Id",id)
                .header("X-Naver-Client-Secret", secret)
                .retrieve()
                .bodyToFlux(MovieResponse.class);

    }
}
