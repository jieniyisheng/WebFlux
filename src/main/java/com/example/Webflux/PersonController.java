package com.example.Webflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Stream;


@RestController
public class PersonController {

    private PersonRepository repo;


    @Autowired
    public PersonController(PersonRepository repo) {
        this.repo = repo;
    }


    @GetMapping(value = "/person/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Person> getPerson(@PathVariable int id) {
        return this.repo.getPerson(id);
    }

    @GetMapping(path = "/orientation")
    public Flux<String> addOrientation() {

       return Flux.just("Flux");
    }

    @GetMapping(path = "/list")
    public Mono<List<Person>> listFlux() {
        return this.repo.list();
    }
}