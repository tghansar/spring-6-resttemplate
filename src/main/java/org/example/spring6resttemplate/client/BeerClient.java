package org.example.spring6resttemplate.client;

import org.example.spring6resttemplate.model.BeerDto;
import org.springframework.data.domain.Page;

public interface BeerClient {

    Page<BeerDto> listBeers();
}
