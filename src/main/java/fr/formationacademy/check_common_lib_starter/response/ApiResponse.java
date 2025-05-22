package fr.formationacademy.check_common_lib_starter.response;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * A generic class representing an API response.
 * 
 * This class is used to standardize the structure of API responses across the application.
 * It contains a status code, a data payload, and a list of messages.
 * 
 * @param <T> the type of the data in the response
 * 
 * @author Housseyn TALEB
 * @version 1.0
 * @since 2025-04-13
 * 
 * @see fr.formationacademy.check_common_lib_starter.response.ApiResponseBuilder
 */
@Getter
@Setter
public class ApiResponse<T> {

    private int status;
    private String path;
    private Instant timestamp;
    private String code;
    private T data;
    private List<ApiMessage> messages;

    public ApiResponse() {
        this.timestamp = Instant.now();
        this.messages = new ArrayList<>();
    }
}
