package org.example.jaxrsservice.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.jaxrsservice.model.Data;

@Path("/")
public class EndpointsController
{
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String ping()
    {
        return "Pong";
    }

    @Path("/hello-world")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello()
    {
        return "Hello, World!";
    }

    @Path("/complex")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Data complex(@QueryParam("name") final String name, @QueryParam("age") final int age)
    {
        final var result = new Data();
        result.setName(name);
        result.setAge(age);
        return result;
    }

    @Path("/complex2")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Data complex2(final Data data)
    {
        final var result = new Data();
        result.setName(data.getName() + " 2");
        result.setAge(data.getAge() * 2);
        return result;
    }

    @Path("/terminate")
    @GET
    public Response terminate(@QueryParam("timeout") final long timeout)
    {
        new Thread(() ->
        {
            try
            {
                Thread.sleep(timeout);
            }
            catch (final InterruptedException e)
            {
                e.printStackTrace();
            }
            finally
            {
                System.exit(0);
            }
        }).start();

        return Response.ok().build();
    }
}
