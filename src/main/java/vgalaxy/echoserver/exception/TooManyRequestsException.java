package vgalaxy.echoserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.TOO_MANY_REQUESTS, reason="Too many requests")  // 429
public class TooManyRequestsException extends RuntimeException {
}
