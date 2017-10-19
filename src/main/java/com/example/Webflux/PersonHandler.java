


package com.example.Webflux;


import reactor.core.publisher.Mono;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

public class PersonHandler {

	private final PersonRepository repository;

	public PersonHandler(PersonRepository repository) {
        this.repository = repository;
	}

	public Mono<ServerResponse> getPerson(ServerRequest request) {
		int personId = Integer.valueOf(request.pathVariable("id"));
		Mono<Person> personMono = this.repository.getPerson(personId);
		return personMono
				.flatMap(person -> ServerResponse.ok().body(fromObject(person)))
				.switchIfEmpty(ServerResponse.notFound().build());
	}
}