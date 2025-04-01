package com.apierrorgenerator.errorgenerator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apierrorgenerator.errorgenerator.model.ErrorDTO;

@RestController
@RequestMapping("/errorSimulation")
public class ErrorSimulatorController {

  @GetMapping("/{status}")
  public ResponseEntity<ErrorDTO> simulateError(@PathVariable String status) {
    try {
      int statusCode = Integer.parseInt(status);
      HttpStatus httpStatus = HttpStatus.resolve(statusCode);
      if (httpStatus != null) {
        return new ResponseEntity<>(new ErrorDTO(httpStatus, statusCode), httpStatus);
      } else {
        return new ResponseEntity<>(new ErrorDTO(HttpStatus.BAD_REQUEST, 400), HttpStatus.BAD_REQUEST);
      }
    } catch (NumberFormatException e) {
      return new ResponseEntity<>(new ErrorDTO(HttpStatus.BAD_REQUEST, 400), HttpStatus.BAD_REQUEST);
    }
  }
}
