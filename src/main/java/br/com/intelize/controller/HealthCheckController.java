package br.com.intelize.controller;

import br.com.intelize.util.RestControllerUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/health")
public class HealthCheckController {

    @GetMapping("/check")
    public ResponseEntity check() {
        return RestControllerUtil.getOkResponse();
    }
}
