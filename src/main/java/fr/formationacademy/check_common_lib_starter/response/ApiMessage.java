package fr.formationacademy.check_common_lib_starter.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Represents a standardized message used in API responses.
 */
@Getter
@AllArgsConstructor
public class ApiMessage {

    private String code;
    private String message;

    public static final ApiMessage SUCCESS = new ApiMessage("SUCCESS", "Request successful");
    public static final ApiMessage CREATED_RESOURCE = new ApiMessage("CREATED", "Resource created successfully");
    public static final ApiMessage DELETED_RESOURCE = new ApiMessage("DELETED", "Resource deleted successfully");
    public static final ApiMessage INVALID_REQUEST_FORMAT = new ApiMessage("INVALID_REQUEST", "The request format is invalid");
    public static final ApiMessage AUTHENTICATION_REQUIRED = new ApiMessage("UNAUTHORIZED", "Authentication required");
    public static final ApiMessage ACCESS_DENIED = new ApiMessage("FORBIDDEN", "Access denied");
    public static final ApiMessage RESOURCE_NOT_FOUND = new ApiMessage("NOT_FOUND", "Resource not found");


}
