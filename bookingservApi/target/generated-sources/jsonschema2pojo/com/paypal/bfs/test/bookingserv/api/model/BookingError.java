
package com.paypal.bfs.test.bookingserv.api.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Booking error
 * <p>
 * Booking error object
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "timestamp",
    "status",
    "error",
    "message",
    "path",
    "errorCode"
})
public class BookingError {

    /**
     * timestamp of the exception
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    @JsonPropertyDescription("timestamp of the exception")
    private LocalDateTime timestamp;
    /**
     * HttpStatus
     * (Required)
     * 
     */
    @JsonProperty("status")
    @JsonPropertyDescription("HttpStatus")
    private String status;
    /**
     * error Type
     * 
     */
    @JsonProperty("error")
    @JsonPropertyDescription("error Type")
    private String error;
    /**
     * ErrorMessage
     * (Required)
     * 
     */
    @JsonProperty("message")
    @JsonPropertyDescription("ErrorMessage")
    private String message;
    /**
     * api url
     * 
     */
    @JsonProperty("path")
    @JsonPropertyDescription("api url")
    private String path;
    /**
     * error Code
     * 
     */
    @JsonProperty("errorCode")
    @JsonPropertyDescription("error Code")
    private Object errorCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * timestamp of the exception
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * timestamp of the exception
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * HttpStatus
     * (Required)
     * 
     */
    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * HttpStatus
     * (Required)
     * 
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * error Type
     * 
     */
    @JsonProperty("error")
    public String getError() {
        return error;
    }

    /**
     * error Type
     * 
     */
    @JsonProperty("error")
    public void setError(String error) {
        this.error = error;
    }

    /**
     * ErrorMessage
     * (Required)
     * 
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * ErrorMessage
     * (Required)
     * 
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * api url
     * 
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * api url
     * 
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * error Code
     * 
     */
    @JsonProperty("errorCode")
    public Object getErrorCode() {
        return errorCode;
    }

    /**
     * error Code
     * 
     */
    @JsonProperty("errorCode")
    public void setErrorCode(Object errorCode) {
        this.errorCode = errorCode;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(BookingError.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("timestamp");
        sb.append('=');
        sb.append(((this.timestamp == null)?"<null>":this.timestamp));
        sb.append(',');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("error");
        sb.append('=');
        sb.append(((this.error == null)?"<null>":this.error));
        sb.append(',');
        sb.append("message");
        sb.append('=');
        sb.append(((this.message == null)?"<null>":this.message));
        sb.append(',');
        sb.append("path");
        sb.append('=');
        sb.append(((this.path == null)?"<null>":this.path));
        sb.append(',');
        sb.append("errorCode");
        sb.append('=');
        sb.append(((this.errorCode == null)?"<null>":this.errorCode));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
