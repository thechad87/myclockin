package com.chadmarthinussen.domain.UserlType;

import com.chadmarthinussen.domain.PersonalDetails.Name;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Created by ChadMarthinussen2 on 2019/04/10.
 * student number : 208031197
 *
 */
@EntityScan
public class Staff {

    private Name name;
    private String staffID;

    private Staff(){}

    public Staff(Builder builder) {
        this.name = builder.name;
        this.staffID = builder.staffID;
    }

    public Name getName() {
        return name;
    }


    public String getStaffID() {
        return staffID;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name=" + name +
                ", staffID=" + staffID +
                '}';
    }

    public static class Builder{

        private Name name;
        private String staffID;

        public Builder name(Name name){
            this.name = name;
            return this;
        }


        public Builder staffID(String staffID){
            this.staffID = staffID;
            return this;
        }

        public Builder copy(Staff staff) {
            this.name = staff.name;
            this.staffID = staff.staffID;
            return this;
        }


        public Staff build() {
            return new Staff(this);
        }
    }
}

