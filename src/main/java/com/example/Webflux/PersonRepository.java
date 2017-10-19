package com.example.Webflux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author elviswang
 * @date 2017/10/18
 * @time 17:22
 * Desc TODO
 */
public interface PersonRepository {

    Mono<Person> getPerson(int index);

    Mono<List<Person>> list();

    Flux<List<Person>> listF();
}
