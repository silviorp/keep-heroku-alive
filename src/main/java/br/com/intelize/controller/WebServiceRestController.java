package br.com.intelize.controller;

import br.com.intelize.domain.WebService;
import br.com.intelize.service.WebServiceService;
import br.com.intelize.util.RestControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/webservices")
public class WebServiceRestController {

    private final WebServiceService webServiceService;

    @Autowired
    public WebServiceRestController(WebServiceService webServiceService) {
        this.webServiceService = webServiceService;
    }

    @PostMapping(name = "/register")
    public ResponseEntity<?> registerWebService(@RequestBody @Valid WebService webService, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return RestControllerUtil.getErrorResponse(bindingResult);
        }

        try {
            webServiceService.save(webService);
            return RestControllerUtil.getCreatedResponse();
        } catch (Exception e) {
            return RestControllerUtil.getInternalErrorResponse(e);
        }
    }
}
