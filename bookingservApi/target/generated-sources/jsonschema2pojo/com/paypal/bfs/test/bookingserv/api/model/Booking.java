
package com.paypal.bfs.test.bookingserv.api.model;

import java.time.LocalDate;
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
 * Booking resource
 * <p>
 * Booking resource object
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "first_name",
    "last_name",
    "date_of_birth",
    "checkin",
    "checkout",
    "total_price",
    "deposit",
    "address"
})
public class Booking {

    /**
     * Booking id
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Booking id")
    private Integer id;
    /**
     * First name
     * (Required)
     * 
     */
    @JsonProperty("first_name")
    @JsonPropertyDescription("First name")
    private String firstName;
    /**
     * Last name
     * (Required)
     * 
     */
    @JsonProperty("last_name")
    @JsonPropertyDescription("Last name")
    private String lastName;
    /**
     * Date Of Birth
     * (Required)
     * 
     */
    @JsonProperty("date_of_birth")
    @JsonPropertyDescription("Date Of Birth")
    private LocalDate dateOfBirth;
    /**
     * Checkin date and time
     * (Required)
     * 
     */
    @JsonProperty("checkin")
    @JsonPropertyDescription("Checkin date and time")
    private LocalDateTime checkin;
    /**
     * Checkout date and time
     * (Required)
     * 
     */
    @JsonProperty("checkout")
    @JsonPropertyDescription("Checkout date and time")
    private LocalDateTime checkout;
    /**
     * Total Booking Price
     * (Required)
     * 
     */
    @JsonProperty("total_price")
    @JsonPropertyDescription("Total Booking Price")
    private Double totalPrice;
    /**
     * Deposit Amount
     * (Required)
     * 
     */
    @JsonProperty("deposit")
    @JsonPropertyDescription("Deposit Amount")
    private Double deposit;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("address")
    private AddressType address;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Booking id
     * 
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * Booking id
     * 
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * First name
     * (Required)
     * 
     */
    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    /**
     * First name
     * (Required)
     * 
     */
    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Last name
     * (Required)
     * 
     */
    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    /**
     * Last name
     * (Required)
     * 
     */
    @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Date Of Birth
     * (Required)
     * 
     */
    @JsonProperty("date_of_birth")
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Date Of Birth
     * (Required)
     * 
     */
    @JsonProperty("date_of_birth")
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Checkin date and time
     * (Required)
     * 
     */
    @JsonProperty("checkin")
    public LocalDateTime getCheckin() {
        return checkin;
    }

    /**
     * Checkin date and time
     * (Required)
     * 
     */
    @JsonProperty("checkin")
    public void setCheckin(LocalDateTime checkin) {
        this.checkin = checkin;
    }

    /**
     * Checkout date and time
     * (Required)
     * 
     */
    @JsonProperty("checkout")
    public LocalDateTime getCheckout() {
        return checkout;
    }

    /**
     * Checkout date and time
     * (Required)
     * 
     */
    @JsonProperty("checkout")
    public void setCheckout(LocalDateTime checkout) {
        this.checkout = checkout;
    }

    /**
     * Total Booking Price
     * (Required)
     * 
     */
    @JsonProperty("total_price")
    public Double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Total Booking Price
     * (Required)
     * 
     */
    @JsonProperty("total_price")
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Deposit Amount
     * (Required)
     * 
     */
    @JsonProperty("deposit")
    public Double getDeposit() {
        return deposit;
    }

    /**
     * Deposit Amount
     * (Required)
     * 
     */
    @JsonProperty("deposit")
    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("address")
    public AddressType getAddress() {
        return address;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("address")
    public void setAddress(AddressType address) {
        this.address = address;
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
        sb.append(Booking.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("firstName");
        sb.append('=');
        sb.append(((this.firstName == null)?"<null>":this.firstName));
        sb.append(',');
        sb.append("lastName");
        sb.append('=');
        sb.append(((this.lastName == null)?"<null>":this.lastName));
        sb.append(',');
        sb.append("dateOfBirth");
        sb.append('=');
        sb.append(((this.dateOfBirth == null)?"<null>":this.dateOfBirth));
        sb.append(',');
        sb.append("checkin");
        sb.append('=');
        sb.append(((this.checkin == null)?"<null>":this.checkin));
        sb.append(',');
        sb.append("checkout");
        sb.append('=');
        sb.append(((this.checkout == null)?"<null>":this.checkout));
        sb.append(',');
        sb.append("totalPrice");
        sb.append('=');
        sb.append(((this.totalPrice == null)?"<null>":this.totalPrice));
        sb.append(',');
        sb.append("deposit");
        sb.append('=');
        sb.append(((this.deposit == null)?"<null>":this.deposit));
        sb.append(',');
        sb.append("address");
        sb.append('=');
        sb.append(((this.address == null)?"<null>":this.address));
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
