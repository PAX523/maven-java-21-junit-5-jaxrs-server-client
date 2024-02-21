package org.example.jaxrsservice;

import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class Client {
    public static void main(final String[] args) {
        final String baseUri = "http://localhost:8080";
        final String resourcePath = "/complex";

        final jakarta.ws.rs.client.Client client = ClientBuilder.newClient();

        final Response response = client.target(baseUri)
                .path(resourcePath)
                .queryParam("name", "PAX")
                .queryParam("age", 7 + 6 * 5)
                .request(MediaType.APPLICATION_JSON)
                .get();

        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            final String result = response.readEntity(String.class);
            System.out.println("Response: " + result);
        } else {
            System.out.println("Error: " + response.getStatusInfo());
        }

        client.close();
    }
}
