package com.chadmarthinussen.Domain.UserlType;

import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Created by ChadMarthinussen2 on 2019/04/17.
 */

@EntityScan
public class Administrator {

    private String administratorID;
    private boolean isAdministrator;
    private boolean canEdit;

    public Administrator() {
    }

    public Administrator(Builder builder) {
        this.administratorID = builder.administratorID;
        this.isAdministrator = builder.isAdministrator;
        this.canEdit = builder.canEdit;
    }


    public boolean isAdministrator() {
        return isAdministrator;
    }

    public boolean getCanEdit() {
        return canEdit;
    }

    public String getAdministratorID() {
        return administratorID;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "administratorID='" + administratorID + '\'' +
                ", isAdministrator=" + isAdministrator +
                ", canEdit=" + canEdit +
                '}';
    }

    public static class Builder{

        private String administratorID;
        private boolean isAdministrator;
        private boolean canEdit;

        public Builder isAdministrator(boolean isAdministrator){
            this.isAdministrator = isAdministrator;
            return this;
        }

        public Builder canEdit(boolean canEdit){
            this.canEdit = canEdit;
            return this;
        }

        public Builder administratorID(String administratorID) {
            this.administratorID = administratorID;
            return this;
        }

        public Administrator build() {
            return new Administrator(this);
        }
    }
}
