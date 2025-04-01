package com.apierrorgenerator.errorgenerator.model;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDTO {
  private HttpStatus status;
  private int statusCode;

  public ErrorDTO(HttpStatus status, int statusCode) {
    this.status = status;
    this.statusCode = statusCode;
  }

}
