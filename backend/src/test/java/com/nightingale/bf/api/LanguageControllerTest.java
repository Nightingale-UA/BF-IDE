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

    @Test
    public void shouldTranspileFromBrain() {
        assertEquals(
            "*p += 1\n" +
                "while (*p) {\n" +
                "    *p -= 2\n" +
                "    p += 1\n" +
                "    *p -= 1\n" +
                "    while (*p) {\n" +
                "        p += 2\n" +
                "        *p += 1\n" +
                "        p += 1\n" +
                "        *p -= 5\n" +
                "        p -= 2\n" +
                "    }\n" +
                "    p -= 1\n" +
                "    *p -= 2\n" +
                "    p -= 1\n" +
                "    *p -= 3\n" +
                "}\n",
            restTemplate.postForObject(
                "http://localhost:" + port + "/api/brain/transpile-from-bf",
                new LanguageRequest(
                    "+[-->-[>>+>-----<<]<--<---]",
                    Collections.emptyList()),
                LanguageResponse.class).getResult()
        );
    }

    @Test
    public void shouldTranspileFromBool() {
        assertEquals(
            "printBit(*p)\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n" +
                "printBit(*p)\n" +
                "*p ^= 1\n",
            restTemplate.postForObject(
                "http://localhost:" + port + "/api/bool/transpile-from-bf",
                new LanguageRequest(
                    ";;;+;+",
                    Collections.emptyList()),
                LanguageResponse.class).getResult()
        );
    }

    @Test
    public void shouldTranspileFromSwap() {
        assertEquals(
            "p += 2\n" +
                "printBit(*p)\n" +
                "printBit(*p)\n" +
                "storeBit(*p)\n" +
                "printBit(*p)\n" +
                "*p = getStoredBit()\n",
            restTemplate.postForObject(
                "http://localhost:" + port + "/api/swap/transpile-from-bf",
                new LanguageRequest(
                    ">>..@.@",
                    Collections.emptyList()),
                LanguageResponse.class).getResult()
        );
    }

    @Test
    public void shouldTranspileFromSmall() {
        assertEquals(
            "*p ^= 1\n" +
                "p += 2\n" +
                "*p ^= 1\n",
            restTemplate.postForObject(
                "http://localhost:" + port + "/api/small/transpile-from-bf",
                new LanguageRequest(
                    "*>>*",
                    Collections.emptyList()),
                LanguageResponse.class).getResult()
        );
    }

    @Test
    public void shouldTranspileFromMiniString() {
        assertEquals(
            "*p += 7\n" +
                "printChar(*p)\n" +
                "*p += 2\n",
            restTemplate.postForObject(
                "http://localhost:" + port + "/api/mini-string/transpile-from-bf",
                new LanguageRequest(
                    "+++++++.++",
                    Collections.emptyList()),
                LanguageResponse.class).getResult()
        );
    }
}
