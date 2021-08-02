
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
    "api_url",
    "timestamp",
    "status",
    "message",
    "errorCode"
})
public class BookingError {

    /**
     * api url
     * 
     */
    @JsonProperty("api_url")
    @JsonPropertyDescription("api url")
    private String apiUrl;
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
     * ErrorMessage
     * (Required)
     * 
     */
    @JsonProperty("message")
    @JsonPropertyDescription("ErrorMessage")
    private String message;
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
     * api url
     * 
     */
    @JsonProperty("api_url")
    public String getApiUrl() {
        return apiUrl;
    }

    /**
     * api url
     * 
     */
    @JsonProperty("api_url")
    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

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
        sb.append("apiUrl");
        sb.append('=');
        sb.append(((this.apiUrl == null)?"<null>":this.apiUrl));
        sb.append(',');
        sb.append("timestamp");
        sb.append('=');
        sb.append(((this.timestamp == null)?"<null>":this.timestamp));
        sb.append(',');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("message");
        sb.append('=');
        sb.append(((this.message == null)?"<null>":this.message));
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
