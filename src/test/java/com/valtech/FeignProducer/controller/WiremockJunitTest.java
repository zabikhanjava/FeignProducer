package com.valtech.FeignProducer.controller;

//import com.github.tomakehurst.wiremock.http.Request;
//import com.github.tomakehurst.wiremock.http.Response;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ProducerController.class)
public class WiremockJunitTest {

    @Rule
    public WireMockRule wm = new WireMockRule(wireMockConfig().port(8080));

    @Test
    public void assertWiremockSetup() throws IOException {
        // Arrange - setup wiremock stubs
        configureStubs();

        // execute request through the http client
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://localhost:8080/test/abc")
                .get()
                .build();

        // Act - call the endpoint
        Response response = client.newCall(request).execute();

        // Assert - verify the response
        assertEquals("Test success!", response.body().string());
        verify(exactly(1),getRequestedFor(urlEqualTo("/test/abc")));

    }

    // configure stubs for wiremock
    private void configureStubs() {
        configureFor("localhost", 8080);
        stubFor(get(urlEqualTo("/test/abc"))
                .willReturn(aResponse().withBody("Test success!")));
    }

}