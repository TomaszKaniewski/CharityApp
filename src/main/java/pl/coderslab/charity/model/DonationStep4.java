package pl.coderslab.charity.model;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Component
public class DonationStep4 {

    @NotBlank(message = "Pole nie może być puste")
    private String street;

    @NotBlank(message = "Pole nie może być puste")
    private String city;

//    @NotBlank(message = "Pole nie może być puste")
    @Pattern(regexp = "\\d{2}-\\d{3}", message = "Wprowadź kod w postaci: xx-xxx")
    private String zipCode;

    @NotNull(message = "Proszę podać datę odbioru")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pickUpDate;

    @NotNull(message = "Proszę podać godzinę odbioru")
    @DateTimeFormat(pattern = "HH:mm")
    private Date pickUpTime;

    private String pickUpComment;

//    @NotBlank(message = "Proszę podać numer telefonu")
    @Pattern(regexp = "\\d{9}", message = "Proszę podać poprawny numer telefonu")
    private String phoneNumber;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public Date getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(Date pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public String getPickUpComment() {
        return pickUpComment;
    }

    public void setPickUpComment(String pickUpComment) {
        this.pickUpComment = pickUpComment;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
