package br.com.drope.vuttrapi.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ApiException extends Exception {
  private static final long serialVersionUID = -7889689748304646968L;

  private final HttpStatus code;
  private final String reason;
  private final Integer statusCode;

  @Builder
  public ApiException(HttpStatus notFound, String reason, String message, Integer statusCode) {
    super(message);
    this.code = notFound;
    this.reason = reason;
    this.statusCode = statusCode;
  }

  public static ApiException badRequest(String reason, String message) {
    return new ApiException(HttpStatus.BAD_REQUEST, reason, message, HttpStatus.BAD_REQUEST.value());
  }

  public static ApiException unauthorized(String reason, String message) {
    return new ApiException(HttpStatus.UNAUTHORIZED, reason, message,
        HttpStatus.UNAUTHORIZED.value());
  }

  public static ApiException forbidden(String reason, String message) {
    return new ApiException(HttpStatus.FORBIDDEN, reason, message, HttpStatus.FORBIDDEN.value());
  }

  public static ApiException notFound(String reason, String message) {
    return new ApiException(HttpStatus.NOT_FOUND, reason, message, HttpStatus.NOT_FOUND.value());
  }

  public static ApiException conflict(String reason, String message) {
    return new ApiException(HttpStatus.CONFLICT, reason, message, HttpStatus.CONFLICT.value());
  }

  public static ApiException preconditionFailed(String reason, String message) {
    return new ApiException(HttpStatus.PRECONDITION_FAILED, reason, message,
        HttpStatus.PRECONDITION_FAILED.value());
  }

  public static ApiException internalError(String reason, String message) {
    return new ApiException(HttpStatus.INTERNAL_SERVER_ERROR, reason, message,
        HttpStatus.INTERNAL_SERVER_ERROR.value());
  }

  public static ApiException notImplemented(String reason, String message) {
    return new ApiException(HttpStatus.NOT_IMPLEMENTED, reason, message,
        HttpStatus.NOT_IMPLEMENTED.value());
  }

  public static ApiException serviceUnavailable(String reason, String message) {
    return new ApiException(HttpStatus.SERVICE_UNAVAILABLE, reason, message,
        HttpStatus.SERVICE_UNAVAILABLE.value());
  }

  public static ApiException accepted(String reason, String message) {
    return new ApiException(HttpStatus.ACCEPTED, reason, message, HttpStatus.ACCEPTED.value());
  }
}
