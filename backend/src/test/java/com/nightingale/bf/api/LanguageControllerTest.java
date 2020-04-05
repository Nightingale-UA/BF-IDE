package com.nightingale.bf.api;

import com.nightingale.bf.model.api.LanguageRequest;
import com.nightingale.bf.model.api.LanguageResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LanguageControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldExecuteBrain() {
        assertEquals("Hello, World!",
            restTemplate.postForObject(
                "http://localhost:" + port + "/api/brain/execute",
                new LanguageRequest(
                    "+[-->-[>>+>-----<<]<--<---]>-.>>>+.>>..+++[.>]<<<<.+++.------.<<-.>>>>+.",
                    Collections.emptyList()),
                LanguageResponse.class).getResult());

    }

    @Test
    public void shouldExecuteBool() {
        assertEquals("W",
            restTemplate.postForObject(
                "http://localhost:" + port + "/api/bool/execute",
                new LanguageRequest(
                    ",,>,,;;;<;>>,,>,;>,;<;>;",
                    Collections.singletonList(0x48)),
                LanguageResponse.class).getResult());

    }

    @Test
    public void shouldExecuteSmall() {
        assertEquals("",
            restTemplate.postForObject(
                "http://localhost:" + port + "/api/small/execute",
                new LanguageRequest(
                    "",
                    Collections.emptyList()),
                LanguageResponse.class).getResult());

    }

    @Test
    public void shouldExecuteSwap() {
        assertEquals("?",
            restTemplate.postForObject(
                "http://localhost:" + port + "/api/swap/execute",
                new LanguageRequest(
                    "[.>]<[.<]..",
                    Collections.singletonList(0xE0)),
                LanguageResponse.class).getResult());

    }

    @Test
    public void shouldExecuteMiniString() {
        assertEquals("Hello, World!",
            restTemplate.postForObject(
                "http://localhost:" + port + "/api/mini-string/execute",
                new LanguageRequest(
                    "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++." +
                        "+++++++++++++++++++++++++++++.+++++++..+++." +
                        "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++." +
                        "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++." +
                        "+++++++++++++++++++++++++++++++++++++++++++++++++++++++." +
                        "++++++++++++++++++++++++.+++." +
                        "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++." +
                        "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++." +
                        "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++.",
                    Collections.emptyList()),
                LanguageResponse.class).getResult());

    }

    @Test
    public void shouldThrowForUnknownLanguage() {
        assertEquals("Language 'brai' is not supported.",
            restTemplate.postForObject(
                "http://localhost:" + port + "/api/brai/execute",
                new LanguageRequest(
                    "+[-->-[>>+>-----<<]<--<---]>-.>>>+.>>..+++[.>]<<<<.+++.------.<<-.>>>>+.",
                    Collections.emptyList()),
                Map.class).get("message"));
    }
}
