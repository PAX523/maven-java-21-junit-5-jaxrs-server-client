package org.example.jaxrsservice;

import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.Response;
import org.example.jaxrsservice.model.Data;

public class Client
{
    private static final String baseUri = "http://localhost:8080";

    private static final jakarta.ws.rs.client.Client client = ClientBuilder.newClient();

    public static void main(final String[] args)
    {
        var response = requestPing();
        printResult(response, String.class);

        response = requestHelloWorld();
        printResult(response, String.class);

        response = requestComplex("PAX", 7 + 6 * 5);
        printResult(response, Data.class);

        response = requestComplex2("PAX", 7 + 6 * 5);
        printResult(response, Data.class);

        response = requestTermination(1000);
        printResult(response, Void.class);

        client.close();
    }

    private static Response requestPing()
    {
        return client.target(baseUri)
                .path("/")
                .request()
                .get(Response.class);
    }

    private static Response requestHelloWorld()
    {
        return client.target(baseUri)
                .path("/hello-world")
                .request()
                .get(Response.class);
    }

    private static Response requestComplex(final String name, final int age)
    {
        return client.target(baseUri)
                .path("/complex")
                .queryParam("name", "PAX")
                .queryParam("age", 7 + 6 * 5)
                .request().post(null);
    }

    private static Response requestComplex2(final String name, final int age)
    {
        final var data = new Data();
        data.setName("Schakal");
        data.setAge(42);
        return client.target(baseUri)
                .path("/complex2")
                .request().post(Entity.json(data));
    }

    private static Response requestTermination(final long timeout)
    {
        return client.target(baseUri)
                .path("/terminate")
                .queryParam("timeout", timeout)
                .request().get();
    }

    private static void printResult(final Response response, final Class<?> responseType)
    {
        if (response.getStatus() == Response.Status.OK.getStatusCode())
        {
            final var result = response.readEntity(responseType);
            System.out.println("Response: " + result);
        } else
            System.err.println("Error: " + response.getStatusInfo());
    }
}
