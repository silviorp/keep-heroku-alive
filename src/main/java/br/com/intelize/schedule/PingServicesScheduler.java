package br.com.intelize.schedule;

import br.com.intelize.domain.WebService;
import br.com.intelize.repository.WebServiceRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Component
public class PingServicesScheduler {

    private Logger log = Logger.getLogger(PingServicesScheduler.class);

    private final WebServiceRepository webServiceRepository;

    @Autowired
    public PingServicesScheduler(WebServiceRepository webServiceRepository) {
        this.webServiceRepository = webServiceRepository;
    }

    @Scheduled(fixedDelay = 5000)
    public void ping() {
        for (WebService webService : webServiceRepository.findAll()) {

            log.debug(webService.toString());

            try {
                String response = new URL(webService.getFullHealthUrl()).getContent().toString();
                log.debug(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
