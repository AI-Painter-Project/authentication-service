package Configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("secrets")
@Getter
@Setter
public class Secrets {
    private String oauthClientKey;
    private String oauthClientSecret;
    private String oauthIssuerUri;
}
