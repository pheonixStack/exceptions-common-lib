package fr.formationacademy.check_common_lib_starter.response;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * A generic class representing an API response.
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
