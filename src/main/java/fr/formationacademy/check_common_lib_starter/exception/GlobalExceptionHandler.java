package fr.formationacademy.check_common_lib_starter.exception;

import fr.formationacademy.check_common_lib_starter.response.ApiMessage;
import fr.formationacademy.check_common_lib_starter.response.ApiResponse;
import fr.formationacademy.check_common_lib_starter.response.ApiResponseBuilder;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles all custom ApiException instances.
     */
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiResponse<Object>> handleApiException(ApiException ex, HttpServletRequest request) {
        List<ApiMessage> messages = ex.getMessages().stream()
                .map(msg -> new ApiMessage("ERROR", msg))
                .collect(Collectors.toList());

        return ApiResponseBuilder.build(ex.getStatus(), ex.getData(), messages, request);
    }
}
