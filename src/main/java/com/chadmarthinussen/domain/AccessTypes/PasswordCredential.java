package com.chadmarthinussen.domain.AccessTypes;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by ChadMarthinussen2 on 2019/04/30.
 */

@Entity
public class PasswordCredential {

    @Id
    private String userPasswordCredentials;
    private String userName;
    private String userEmailAddress;


    public PasswordCredential() {
    }

    public PasswordCredential(Builder builder) {
        this.userPasswordCredentials = builder.userPasswordCredentials;
        this.userName = builder.userName;
        this.userEmailAddress = builder.userEmailAddress;
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

        public Builder copy(PasswordCredential passwordCredential){
            this.userPasswordCredentials = passwordCredential.userPasswordCredentials;
            this.userName = passwordCredential.userName;
            this.userEmailAddress = passwordCredential.userEmailAddress;
            return this;
        }

        public PasswordCredential build(){
            return new PasswordCredential(this);
        }
    }
}
