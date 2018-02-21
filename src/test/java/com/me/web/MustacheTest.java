package com.me.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MustacheTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testMustacheTemplate() {
        ResponseEntity<String> entity = this.restTemplate.getForEntity("/", String.class);
        assertTrue(entity.getStatusCode().equals(HttpStatus.OK));
    }

    @Test
    public void testMustacheErrorTemplate() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.TEXT_HTML));
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = this.restTemplate
                .exchange("/not-exists", HttpMethod.GET, requestEntity, String.class);
        assertTrue(responseEntity.getStatusCode().equals(HttpStatus.NOT_FOUND));
    }

}