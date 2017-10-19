package com.example.Webflux;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author elviswang
 * @date 2017/10/18
 * @time 17:23
 * Desc TODO
 */

public class FluxPersonRepository implements PersonRepository{
    private final List<Person> peoples = new ArrayList<Person>();

    public FluxPersonRepository() {
        this.peoples.add(new Person("elvis", 18));
        this.peoples.add(new Person("wang", 28));
    }

    public Mono<Person> getPerson(int index) {
        return Mono.justOrEmpty(this.peoples.get(index));
    }

    @Override
    public Mono<List<Person>> list() {
        return Mono.just(this.peoples);
    }

    @Override
    public Flux<List<Person>> listF() {
        return Flux.just(this.peoples);
    }
}
