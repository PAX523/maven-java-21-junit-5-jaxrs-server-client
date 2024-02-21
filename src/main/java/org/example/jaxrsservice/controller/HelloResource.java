package org.example.jaxrsservice.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import org.example.jaxrsservice.model.Data;

public class HelloResource {
    @Path("/")
    @GET
    @Produces("text/plain")
    public String ping() {
        return "Pong";
    }

    @Path("/hello-world")
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }

    @Path("/complex")
    @POST
    @Produces("text/json")
    public Data complex(@QueryParam("name") final String name, @QueryParam("age") final int age) {
        final var result = new Data();
        result.setName(name);
        result.setAge(age);
        return result;
    }
}