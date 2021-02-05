package com.example;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;


import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.BeforeAll;

import io.quarkus.test.junit.QuarkusTest;


/**
 * Example of using pure Jersey / Jetty API / no Spring to setup the tests.
 */


@Slf4j
public class BeerRestBase {
	public static WebTarget webTarget;


	@BeforeAll
	public static void setupTest() {
		URI baseUri = UriBuilder.fromUri("http://localhost").port(8081).build();
		Client client = ClientBuilder.newClient();
		webTarget = client.target(String.valueOf(baseUri));
	}
}
