package org.example.jaxrsservice;

import org.example.jaxrsservice.controller.HelloResource;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class Server {
    public static void main(final String[] args) {
        final ResourceConfig config = new ResourceConfig(HelloResource.class);

        GrizzlyHttpServerFactory.createHttpServer(URI.create("http://localhost:8080"), config);
    }
}