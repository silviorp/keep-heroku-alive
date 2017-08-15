package br.com.intelize.service;

import br.com.intelize.domain.WebService;
import br.com.intelize.repository.WebServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;

@Service
public class WebServiceService {

    @Autowired
    private WebServiceRepository webServiceRepository;

    public void save(WebService webService) throws Exception {
        try {
            webServiceRepository.save(webService);
        } catch (ConstraintViolationException ex) {
            webService.setId(webServiceRepository
                    .findByServiceName(webService.getServiceName())
                    .orElseThrow(() -> new Exception("Internal error"))
                    .getId());

            webServiceRepository.save(webService);
        }
    }
}
