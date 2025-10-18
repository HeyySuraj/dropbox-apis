package dropbox.api.dropboxapiconsole.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class ApiService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${oauth.apiUrl}")
    private String apiUrl;

    public String getTeamInfo(String accessToken) {
        try {
            URL url = new URL(apiUrl + "/2/team/get_info");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(false); // no body will be sent

            // Set headers
            connection.setRequestProperty("Authorization", "Bearer " + accessToken);
            connection.setRequestProperty("Accept", "application/json");

            // Get response
            int responseCode = connection.getResponseCode();
            BufferedReader reader;
            if (responseCode == HttpURLConnection.HTTP_OK) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            connection.disconnect();

            return response.toString();

        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch team info: " + e.getMessage(), e);
        }
    }

    /**
     * Calls Dropbox /2/team/get_info endpoint with Bearer token
     */
    // public String getTeamInfo(String accessToken) {
    // Set headers
    // HttpHeaders headers = new HttpHeaders();
    // headers.setContentType(MediaType.APPLICATION_JSON);
    // headers.setAccept(java.util.List.of(MediaType.APPLICATION_JSON));

    // // Authorization header
    // headers.add("Authorization", "Bearer " + accessToken);

    // // Empty JSON body
    // HttpEntity<Void> request = new HttpEntity<>(null, headers);

    // // Make POST request
    // ResponseEntity<String> response = restTemplate.exchange(
    // apiUrl + "/2/team/get_info",
    // HttpMethod.POST,
    // request,
    // String.class
    // );

    // if (response.getStatusCode() == HttpStatus.OK) {
    // return response.getBody();
    // } else {
    // throw new RuntimeException(
    // "get_info API call failed with status: " + response.getStatusCode().value() +
    // " and body: " + response.getBody()
    // );
    // }
    // }
}
