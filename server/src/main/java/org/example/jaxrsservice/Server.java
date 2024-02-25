package org.example.jaxrsservice;

import org.example.jaxrsservice.controller.EndpointsController;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class Server
{
    public static void main(final String[] args)
    {
        final ResourceConfig config = new ResourceConfig(EndpointsController.class);
        config.register(EndpointsController.class);

        GrizzlyHttpServerFactory.createHttpServer(URI.create("http://localhost:8080"), config);
    }
}
