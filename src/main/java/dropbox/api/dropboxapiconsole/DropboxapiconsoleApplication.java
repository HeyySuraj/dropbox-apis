package dropbox.api.dropboxapiconsole;

import dropbox.api.dropboxapiconsole.service.OAuthService;
import dropbox.api.dropboxapiconsole.service.ApiService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DropboxapiconsoleApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DropboxapiconsoleApplication.class, args);

        OAuthService oauthService = context.getBean(OAuthService.class);
        ApiService apiService = context.getBean(ApiService.class);

        System.out.println(" Requesting Access Token...");
        String accessToken = oauthService.generateAccessToken();
        System.out.println("\n ---------------------------------------------- Access Token Generated:----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n " + accessToken);
        System.out.println("\n Access Token Generated:" + accessToken);
        System.out.println("\n ---------------------------------------------- Access Token Generated:----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n " + accessToken);


        System.out.println("\n Fetching API Data...");
        String apiResponse = apiService.getTeamInfo(accessToken);
        System.out.println("\n ================================================= API RESPONSE :=================================================\n " + accessToken);

        System.out.println(" ==========================================================API Response:\n" + apiResponse);
    }
}
