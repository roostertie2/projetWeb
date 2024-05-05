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
        String url = "https://api.tomtom.com/search/2/geocode/{encodedAddress}.json?storeResult=false&view=Unified&key={apiKey}";
        url = url.replace("{encodedAddress}", address);
        url = url.replace("{apiKey}",apiKey);
        return restTemplate.getForObject(url, GeocodeResponse.class);
    }

}
