package com.chadmarthinussen.Domain.PersonalDetails;

import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Created by ChadMarthinussen2 on 2019/04/17.
 */

@EntityScan
public class Name {

    private String nameID;
    private String firstName;
    private String middleName;
    private String lastName;

    public Name(Builder builder) {
        this.nameID = builder.nameID;
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
    }

    public String getNameID() {
        return nameID;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static class Builder{

        private String nameID;
        private String firstName;
        private String middleName;
        private String lastName;

        public Builder nameID(String nameID) {
            this.nameID = nameID;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Name build(){
            return new Name(this);
        }
    }
}
