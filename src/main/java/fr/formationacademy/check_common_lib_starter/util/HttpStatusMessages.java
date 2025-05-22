package fr.formationacademy.check_common_lib_starter.util;

import fr.formationacademy.check_common_lib_starter.response.ApiMessage;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

/**
 * Utility class to provide default messages for HTTP status codes.
 */
public final class HttpStatusMessages {

    private static final Map<HttpStatus, ApiMessage> DEFAULT_MESSAGES;

    static {
        Map<HttpStatus, ApiMessage> messages = new EnumMap<>(HttpStatus.class);
        messages.put(HttpStatus.OK, ApiMessage.SUCCESS);
        messages.put(HttpStatus.CREATED, ApiMessage.CREATED_RESOURCE);
        messages.put(HttpStatus.NO_CONTENT, ApiMessage.DELETED_RESOURCE);
        messages.put(HttpStatus.BAD_REQUEST, ApiMessage.INVALID_REQUEST_FORMAT);
        messages.put(HttpStatus.UNAUTHORIZED, ApiMessage.AUTHENTICATION_REQUIRED);
        messages.put(HttpStatus.FORBIDDEN, ApiMessage.ACCESS_DENIED);
        messages.put(HttpStatus.NOT_FOUND, ApiMessage.RESOURCE_NOT_FOUND);

        DEFAULT_MESSAGES = Collections.unmodifiableMap(messages);
    }

    public static ApiMessage getDefaultMessage(HttpStatus status) {
        return DEFAULT_MESSAGES.getOrDefault(status, ApiMessage.SUCCESS);
    }
}
