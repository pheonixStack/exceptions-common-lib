package fr.formationacademy.check_common_lib_starter.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Représente un message standardisé utilisé dans les réponses API.
 */
@Getter
@AllArgsConstructor
public class ApiMessage {

    private String code;
    private String message;

    // Succès
    public static final ApiMessage SUCCESS = new ApiMessage("SUCCESS", "Request successful");
    public static final ApiMessage CREATED_RESOURCE = new ApiMessage("CREATED", "Resource created successfully");
    public static final ApiMessage UPDATED_RESOURCE = new ApiMessage("UPDATED", "Resource updated successfully");
    public static final ApiMessage DELETED_RESOURCE = new ApiMessage("DELETED", "Resource deleted successfully");

    // Erreurs de requête
    public static final ApiMessage INVALID_REQUEST_FORMAT = new ApiMessage("INVALID_REQUEST", "The request format is invalid");
    public static final ApiMessage VALIDATION_FAILED = new ApiMessage("VALIDATION_FAILED", "Validation failed for the request");
    public static final ApiMessage MISSING_PARAMETERS = new ApiMessage("MISSING_PARAMETERS", "Required parameters are missing");

    // Authentification / autorisation
    public static final ApiMessage AUTHENTICATION_REQUIRED = new ApiMessage("UNAUTHORIZED", "Authentication required");
    public static final ApiMessage ACCESS_DENIED = new ApiMessage("FORBIDDEN", "Access denied");

    // Ressource
    public static final ApiMessage RESOURCE_NOT_FOUND = new ApiMessage("NOT_FOUND", "Resource not found");
    public static final ApiMessage RESOURCE_ALREADY_EXISTS = new ApiMessage("ALREADY_EXISTS", "Resource already exists");

    // Erreurs serveur
    public static final ApiMessage INTERNAL_ERROR = new ApiMessage("INTERNAL_ERROR", "An unexpected error occurred on the server");
    public static final ApiMessage SERVICE_UNAVAILABLE = new ApiMessage("SERVICE_UNAVAILABLE", "Service temporarily unavailable. Please try again later.");

    // Conflits / erreurs métier
    public static final ApiMessage BUSINESS_RULE_VIOLATION = new ApiMessage("BUSINESS_ERROR", "A business rule was violated");
    public static final ApiMessage CONFLICT = new ApiMessage("CONFLICT", "A conflict occurred with the current state of the resource");
}

