package br.com.intelize.domain;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Data
@Entity
public class WebService {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "The field serviceName cannot be empty or null")
    @Column(unique = true)
    private String serviceName;
    @NotEmpty(message = "The field serviceUrl cannot be empty or null")
    private String serviceUrl;
    @NotEmpty(message = "The field healthEndpoint cannot be empty or null")
    private String healthEndpoint;

    public String getFullHealthUrl() {
        formatServiceUrl();
        formatHealthEndpoint();
        return serviceUrl + healthEndpoint;
    }

    private void formatServiceUrl() {
        if (serviceUrl == null) {
            throw new NullPointerException("Service URL value cannot be empty");
        }

        if (!serviceUrl.endsWith("/")) {
            serviceUrl += "/";
        }
    }

    private void formatHealthEndpoint() {
        if (healthEndpoint == null) {
            throw new NullPointerException("Service URL value cannot be empty");
        }

        if (!healthEndpoint.startsWith("/")) {
            serviceUrl = String.join("", "/", serviceUrl);
        }
    }

    @Override
    public String toString() {
        return "WebService{" +
                "id=" + id +
                ", serviceName='" + serviceName + '\'' +
                ", serviceUrl='" + serviceUrl + '\'' +
                ", healthEndpoint='" + healthEndpoint + '\'' +
                '}';
    }
}
