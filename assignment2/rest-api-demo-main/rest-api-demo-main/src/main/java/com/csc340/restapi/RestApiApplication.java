package com.csc340.restapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApiApplication.class, args);
        getJonSnow();
        System.exit(0);
    }
    
    public static void getJonSnow() {
        try {
            String url = "https://anapioficeandfire.com/api/characters/583";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jSonJonSnow = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jSonJonSnow);

            String name = root.findValue("name").asText();
            String culture = root.findValue("culture").asText();

            System.out.println("**********Character**********");
            System.out.println("Name: " + name);
            System.out.println("Culture: " + culture);

        } catch (JsonProcessingException ex) {
            Logger.getLogger(RestApiApplication.class.getName()).log(
                    Level.SEVERE,
                    null, ex);
            System.out.println("error in getJonSnow");

        }
    }
}
