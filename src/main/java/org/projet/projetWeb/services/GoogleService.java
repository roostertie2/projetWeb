package org.projet.projetWeb.services;

//import lombok.Value;
import org.projet.projetWeb.model.GeocodeResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GoogleService {
    @Value("${tomtom.api.key}")
    private String apiKey;
    private final RestTemplate restTemplate;

    public GoogleService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public GeocodeResponse geocode(String address) {
        String url = "https://api.tomtom.com/search/2/geocode/{address}.json?key={apiKey}";

        return restTemplate.getForObject(url, GeocodeResponse.class, address, apiKey);
    }

}
