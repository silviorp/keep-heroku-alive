package br.com.intelize.repository;

import br.com.intelize.domain.WebService;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WebServiceRepository extends CrudRepository<WebService, Long> {

    Optional<WebService> findByServiceName(String serviceName);

}
