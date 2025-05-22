package fr.formationacademy.check_common_lib_starter.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

/**
 * Custom exception class for handling API errors.
 * This class extends RuntimeException and includes an HTTP status code and optional data.
 * 
 * It is used in Exceptions to build DSL-based Exception handling.
 * 
 * @see fr.formationacademy.check_common_lib_starter.exception.Exceptions
 * @see fr.formationacademy.check_common_lib_starter.response.ApiResponse
 * @see fr.formationacademy.check_common_lib_starter.response.ApiResponseBuilder
 */
@Getter
public class ApiException extends RuntimeException {
    private final HttpStatus status;
    private final Object data;
    
    private final List<String> messages;

    // Basic constructor without extra data.
    public ApiException(HttpStatus status, String message) {
        super(message);
        this.status = status;
        this.data = null;
        this.messages = Collections.singletonList(message);
    }

      // New constructor for multiple messages.
      public ApiException(HttpStatus status, List<String> messages) {
        // Use the first message as the exception message (or an empty string if none provided)
        super((messages != null && !messages.isEmpty()) ? messages.get(0) : "");
        this.status = status;
        this.data = null;
        this.messages = messages;
    }
    // Private constructor used when attaching extra data.
    // Private constructor used by fluent methods.
    private ApiException(HttpStatus status, List<String> messages, Object data) {
        super((messages != null && !messages.isEmpty()) ? messages.get(0) : "");
        this.status = status;
        this.data = data;
        this.messages = messages;
    }

    // Fluent method to attach data and return a new instance.
     // Fluent method to attach extra data.
     public ApiException withData(Object data) {
        return new ApiException(this.status, this.messages, data);
    }
    
 
    // Fluent method to attach or override the messages.
    public ApiException withMessages(List<String> messages) {
        return new ApiException(this.status, messages, this.data);
    }
}
