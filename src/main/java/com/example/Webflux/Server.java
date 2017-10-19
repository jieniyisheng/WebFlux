package com.example.Webflux;


import reactor.ipc.netty.http.server.HttpServer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.server.adapter.WebHttpHandlerBuilder;


public class Server {

	public static final String HOST = "localhost";

	public static final int PORT = 8080;

	public static void main(String[] args) throws Exception {
        Server server = new Server();

		HttpHandler httpHandler = server.applicationContext();
		server.startReactorServer(httpHandler);

		System.in.read();
	}

	public void startReactorServer(HttpHandler httpHandler) throws InterruptedException {
		ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);
		HttpServer server = HttpServer.create(HOST, PORT);
		server.newHandler(adapter).block();
	}



	public HttpHandler applicationContext() {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(RoutingConfiguration.class);
		return WebHttpHandlerBuilder.applicationContext(applicationContext)
				.build();

	}

}