package dev.inovexx.test.controllers;

import dev.inovexx.exception_handler.models.ServerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/exception-handler-test")
@RestController
public class ExceptionHandlerTestController {

    @GetMapping("/runtime-exception")
    public ResponseEntity<Object> getRuntimeExceptionResponse() {
        throw new RuntimeException("Threw RuntimeException");
    }

    @GetMapping("/server-exception/{code}")
    public ResponseEntity<Object> getServerExceptionResponse(@PathVariable int code) {
        throw new ServerException("Threw ServerException", HttpStatus.valueOf(code));
    }
}
