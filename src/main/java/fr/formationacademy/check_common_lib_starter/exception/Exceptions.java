package fr.formationacademy.check_common_lib_starter.exception;

import org.springframework.http.HttpStatus;

/**
 * This class contains various exception types that can be used throughout the
 * application.
 * Each exception is categorized into different sections for better
 * organization.
 * 
 * Example usage:
 * 
 * throw Exceptions.Domain.Name.withData("example.com");
 * 
 */

public class Exceptions {

    public static class Global {
        // Example: error for resource not found.
        public static final ApiException Uncatched =  new ApiException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred");
    }
    

    public static class Ressource {
        // Example: error for resource not found.
        public static final ApiException NotFound =  new ApiException(HttpStatus.NOT_FOUND, "Resource not found");
        // Example: error for resource already exists.
        public static final ApiException AlreadyExists =  new ApiException(HttpStatus.CONFLICT, "Resource already exists");
    }

    public static class Domain {
        // Example: domain-related error for invalid names.
        public static final ApiException Name = new ApiException(
                HttpStatus.BAD_REQUEST, "Invalid domain name provided.");
    }

    public static class Security {
        // Example: error for missing authentication.
        public static final ApiException AuthRequired = new ApiException(
                HttpStatus.UNAUTHORIZED, "Authentication required");
        // Example: error for access denied.
        public static final ApiException Forbidden = new ApiException(
            HttpStatus.FORBIDDEN, "Access denied");
    }

    public static class Validations {
        // Example: error for bad format.
        public static final ApiException BadFormat = new ApiException(
                HttpStatus.BAD_REQUEST, "Invalid request format");
        // Example: error for invalid date.
        public static final ApiException InvalidDate = new ApiException(
                HttpStatus.CONFLICT, "Resource already exists");
        // Example: error for invalid range.
        public static final ApiException InvalidRange = new ApiException(
                HttpStatus.BAD_REQUEST, "Invalid range");
        // Example: error for invalid FileFormat.
        public static final ApiException InvalidFileFormat = new ApiException(
                HttpStatus.UNSUPPORTED_MEDIA_TYPE, "File not supported");
        
    }

    public static class Content {
        // Example: error for missing required field(s).
        public static final ApiException MissingField = new ApiException(
                HttpStatus.UNPROCESSABLE_ENTITY, "Field is required");
    }
}
