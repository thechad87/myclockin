package com.chadmarthinussen.domain.PersonalDetails;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Id;

/**
 * Created by ChadMarthinussen2 on 2019/04/17.
 */

@EntityScan
public class ContactDetails {
    @Id
    private String contactDetailsID;
    private String tellPhoneNumber;
    private String cellPhoneNumber;
    private String emailAddress;


    private ContactDetails(){}

    public ContactDetails(ContactDetails.Builder builder) {
        this.contactDetailsID = builder.contactDetailsID;
        this.tellPhoneNumber = builder.tellPhoneNumber;
        this.cellPhoneNumber = builder.cellPhoneNumber;
        this.emailAddress = builder.emailAddress;

    }

    public String getContactDetailsID() {
        return contactDetailsID;
    }

    public String getTellPhoneNumber() {
        return tellPhoneNumber;
    }

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public String emailAddress() {
        return emailAddress;
    }


    @Override
    public String toString() {
        return "ContactDetails{" +
                "contactDetailsID=" + contactDetailsID +
                ", tellPhoneNumber=" + tellPhoneNumber +
                ", cellPhoneNumber=" + cellPhoneNumber +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }

    public static class Builder{

        private String contactDetailsID;
        private String tellPhoneNumber;
        private String cellPhoneNumber;
        private String emailAddress;

        public Builder contactDetailsID(String contactDetailsID) {
            this.contactDetailsID = contactDetailsID;
            return this;
        }

        public Builder tellPhoneNumber(String tellPhoneNumber){
            this.tellPhoneNumber = tellPhoneNumber;
            return this;
        }

        public Builder cellPhoneNumber(String cellPhoneNumber){
            this.cellPhoneNumber = cellPhoneNumber;
            return this;
        }

        public Builder emailAddress(String emailAddress){
            this.emailAddress = emailAddress;
            return this;
        }

        public Builder copy(ContactDetails contactDetails) {
            this.contactDetailsID = contactDetails.contactDetailsID;
            this.tellPhoneNumber = contactDetails.tellPhoneNumber;
            this.cellPhoneNumber = contactDetails.cellPhoneNumber;
            this.emailAddress = contactDetails.emailAddress;
            return this;
        }

        public ContactDetails build() {
            return new ContactDetails(this);
        }
    }
}
