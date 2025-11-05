package org.example.spring6resttemplate.client;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.example.spring6resttemplate.model.BeerDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BeerClientImpl implements BeerClient {

    private final RestTemplateBuilder restTemplateBuilder;

    private static final String BASE_URL = "http://localhost:8080";
    private static final String GET_BEER_PATH = "/api/v1/beer";

    @Override
    public Page<BeerDto> listBeers() {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//
//        ResponseEntity<BeerDtoPageImpl> responsePage =
//                restTemplate.getForEntity(String.format("%s%s", BASE_URL, GET_BEER_PATH), BeerDtoPageImpl.class);

        return null;
    }

    public void listBeersDemos() {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<String> responseString =
                restTemplate.getForEntity(String.format("%s%s", BASE_URL, GET_BEER_PATH), String.class);

        ResponseEntity<Map> responseMap =
                restTemplate.getForEntity(String.format("%s%s", BASE_URL, GET_BEER_PATH), Map.class);

        ResponseEntity<JsonNode> jsonResponse =
                restTemplate.getForEntity(String.format("%s%s", BASE_URL, GET_BEER_PATH), JsonNode.class);

        Optional.of(jsonResponse)
                .map(ResponseEntity::getBody)
                .map(body -> body.findPath("_embedded"))
                .map(node -> node.findPath("beers")) // confirm "beer" or "beers" based on your API response
                .ifPresent(contentNode -> contentNode.elements()
                        .forEachRemaining(node ->
                                System.out.println(node.get("beerName").asText())
                        )
                );
    }
}


/*
        System.out.println("---- JSON Response Body ----");
        Optional.of(jsonResponse)
                .map(ResponseEntity::getBody)
                .ifPresent(System.out::println);
        System.out.println("----------------------------");

        jsonResponse.getBody().findPath("_embedded").findPath("beers")
                .elements().forEachRemaining(node -> {
                    System.out.println(node.get("beerName").asText());
                });
*/