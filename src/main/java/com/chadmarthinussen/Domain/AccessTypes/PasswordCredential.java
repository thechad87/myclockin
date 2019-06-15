package com.chadmarthinussen.Domain.AccessTypes;

import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Created by ChadMarthinussen2 on 2019/04/30.
 */

@EntityScan
public class PasswordCredential {

    private String userPasswordCredentials;
    private String userName;
    private String userEmailAddress;

    public PasswordCredential(Builder builder) {
        this.userPasswordCredentials = userPasswordCredentials;
        this.userName = userName;
        this.userEmailAddress = userEmailAddress;
    }


    public String getUserPasswordCredentials() {
        return userPasswordCredentials;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmailAddress() {
        return userEmailAddress;
    }

    @Override
    public String toString() {
        return "PasswordCredential{" +
                "userPasswordCredentials='" + userPasswordCredentials + '\'' +
                ", userName='" + userName + '\'' +
                ", userEmailAddress='" + userEmailAddress + '\'' +
                '}';
    }


    public static class Builder{

        private String userPasswordCredentials;
        private String userName;
        private String userEmailAddress;


        public Builder userPasswordCredentials(String userPasswordCredentials) {
            this.userPasswordCredentials = userPasswordCredentials;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder userEmailAddress(String userEmailAddress) {
            this.userEmailAddress = userEmailAddress;
            return this;
        }

        public PasswordCredential build(){
            return new PasswordCredential(this);
        }
    }
}
