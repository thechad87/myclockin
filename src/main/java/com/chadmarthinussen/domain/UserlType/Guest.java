package com.chadmarthinussen.domain.UserlType;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Id;

/**
 * Created by ChadMarthinussen2 on 2019/04/17.
 */

@EntityScan
public class Guest {

    private String organizationsName;
    private String guestAssignedID;
    private String fullName;
    private String contactDetails;

    private Guest(){
    }

    public Guest(Builder builder) {
        this.organizationsName = builder.organizationsName;
        this.guestAssignedID = builder.guestAssignedID;
        this.fullName = builder.fullName;
        this.contactDetails = builder.contactDetails;

    }

    public String getOrganizationsName() {
        return organizationsName;
    }

    public String getGuestAssignedID() {
        return guestAssignedID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getContactDetails() {
        return contactDetails;
    }


    @Override
    public String toString() {
        return "Guest{" +
                "organizationsName='" + organizationsName + '\'' +
                ", guestAssignedID=" + guestAssignedID +
                ", fullName='" + fullName + '\'' +
                ", contactDetails='" + contactDetails + '\'' +
                '}';
    }

    public static class Builder{

        private String organizationsName;
        @Id
        private String guestAssignedID;
        private String fullName;
        private String contactDetails;

        public Builder organizationsName(String organizationsName){
            this.organizationsName = organizationsName;
            return this;
        }

        public Builder guestAssignedID(String guestAssignedID){
            this.guestAssignedID = guestAssignedID;
            return this;
        }

        public Builder fullName(String fullName){
            this.fullName = fullName;
            return this;
        }

        public Builder contactDetails(String contactDetails){
            this.contactDetails = contactDetails;
            return this;
        }

        public Builder copy(Guest guest) {
            this.organizationsName = guest.organizationsName;
            this.guestAssignedID = guest.guestAssignedID;
            this.fullName = guest.fullName;
            this.contactDetails = guest.contactDetails;
            return this;
        }

        public Guest build() {
            return new Guest(this);
        }
    }
}

