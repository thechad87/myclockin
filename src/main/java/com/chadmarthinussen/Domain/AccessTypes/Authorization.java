package com.chadmarthinussen.Domain.AccessTypes;

import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Created by ChadMarthinussen2 on 2019/04/17.
 */
@EntityScan
public class Authorization {

        //This variable retrieves the Users ID in Order to check whether th
        private String userTypeID;
        //This variable assesses whether the user is allowed to enter the building
        private boolean verifyUserAccess;


        public Authorization(Builder builder) {
                this.verifyUserAccess = verifyUserAccess;
                this.userTypeID = userTypeID;
        }


        public boolean isVerifyUserAccess() {
                return verifyUserAccess;
        }

        public String getUserTypeID() {
                return userTypeID;
        }

        @Override
        public String toString() {
                return "Authorization{" +
                        "verifyUserAccess=" + verifyUserAccess +
                        ", userTypeID='" + userTypeID + '\'' +
                        '}';
        }

        public static class Builder{

                private boolean verifyUserAccess;
                private String userTypeID;


                public Builder verifyUserAccess(boolean verifyUserAccess) {
                        this.verifyUserAccess = verifyUserAccess;
                        return this;
                }

                public Builder userTypeID(String userTypeID) {
                        this.userTypeID = userTypeID;
                        return this;
                }

                public Authorization build(){
                        return new Authorization(this);
                }
        }
}
