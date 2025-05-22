package fr.formationacademy.check_common_lib_starter.response;

import fr.formationacademy.check_common_lib_starter.util.HttpStatusMessages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

/**
 * Utility class to build standardized API responses.
 */
public class ApiResponseBuilder {

    // General builder method (single message)
    public static <T> ResponseEntity<ApiResponse<T>> build(
            HttpStatus status, T data, ApiMessage customMessage, HttpServletRequest request) {

        ApiResponse<T> response = new ApiResponse<>();
        response.setStatus(status.value());
        response.setData(data);
        response.setPath(request.getRequestURI());
        response.setMessages(Collections.singletonList(
                customMessage != null ? customMessage : HttpStatusMessages.getDefaultMessage(status)
        ));
        response.setCode(response.getMessages().get(0).getCode());
        return ResponseEntity.status(status).body(response);
    }

    // General builder method (multiple messages)
    public static <T> ResponseEntity<ApiResponse<T>> build(
            HttpStatus status, T data, List<ApiMessage> customMessages, HttpServletRequest request) {

        ApiResponse<T> response = new ApiResponse<>();
        response.setStatus(status.value());
        response.setData(data);
        response.setPath(request.getRequestURI());
        List<ApiMessage> messages = (customMessages == null || customMessages.isEmpty())
                ? Collections.singletonList(HttpStatusMessages.getDefaultMessage(status))
                : customMessages;
        response.setMessages(messages);
        response.setCode(messages.get(0).getCode());
        return ResponseEntity.status(status).body(response);
    }

    // Convenience methods
    public static <T> ResponseEntity<ApiResponse<T>> success(T data, HttpServletRequest request) {
        return build(HttpStatus.OK, data, ApiMessage.SUCCESS, request);
    }

    public static <T> ResponseEntity<ApiResponse<T>> created(T data, HttpServletRequest request) {
        return build(HttpStatus.CREATED, data, ApiMessage.CREATED_RESOURCE, request);
    }

    public static ResponseEntity<ApiResponse<Void>> deleted(HttpServletRequest request) {
        return build(HttpStatus.NO_CONTENT, null, ApiMessage.DELETED_RESOURCE, request);
    }

    public static ResponseEntity<ApiResponse<Void>> noContent(HttpServletRequest request) {
        return build(HttpStatus.NO_CONTENT, null, HttpStatusMessages.getDefaultMessage(HttpStatus.NO_CONTENT), request);
    }

    public static ResponseEntity<ApiResponse<Void>> badRequest(List<ApiMessage> messages, HttpServletRequest request) {
        return build(HttpStatus.BAD_REQUEST, null, messages, request);
    }

    public static ResponseEntity<ApiResponse<Void>> notFound(ApiMessage message, HttpServletRequest request) {
        return build(HttpStatus.NOT_FOUND, null, message, request);
    }
}
