package com.Ved.MovieTicketBooking.Controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin(origins = "http://127.0.0.1:5500", allowCredentials = "true")
class ProxyController {

    @GetMapping("/city")
    public ResponseEntity<?> getCity(@RequestParam double latitude, @RequestParam double longitude) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange("https://api.3geonames.org/" + latitude + "," + longitude + ".json", HttpMethod.GET, entity, String.class);

        return ResponseEntity.ok(response.getBody());
    }
}