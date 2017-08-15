package br.com.intelize.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.Optional;

public class RestControllerUtil {

    public static ResponseEntity getErrorResponse(BindingResult bindingResult) {
        Optional<String> errors = bindingResult.getAllErrors().stream().map(ObjectError::toString).reduce((x, y) -> x + "," + y);
        return ResponseEntity.badRequest().body((errors.orElse("")));
    }

    public static ResponseEntity getInternalErrorResponse(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
    }

    public static ResponseEntity getCreatedResponse() {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
