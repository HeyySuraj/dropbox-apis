package dropbox.api.dropboxapiconsole.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class OAuthService {

    private final RestTemplate restTemplate;

    @Value("${oauth.authUrl}")
    private String authUrl;

    @Value("${oauth.clientId}")
    private String clientId;

    @Value("${oauth.clientSecret}")
    private String clientSecret;

    @Value("${oauth.refreshToken}")
    private String refreshToken;

    public OAuthService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String generateAccessToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        String body = "grant_type=refresh_token"
                + "&refresh_token=" + refreshToken
                + "&client_id=" + clientId
                + "&client_secret=" + clientSecret;

        HttpEntity<String> request = new HttpEntity<>(body , headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(authUrl + "/oauth2/token", request, Map.class);

        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            Map<String, Object> responseBody = response.getBody();
            String accessToken = (String) responseBody.get("access_token");
            if (accessToken != null) return accessToken;
            else throw new RuntimeException("Access token not found in response: " + responseBody);
        } else {
            throw new RuntimeException("Failed to get access token, status: " + response.getStatusCode());
        }
    }
}
