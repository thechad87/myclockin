package com.chadmarthinussen.domain.UserlType;

import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Created by ChadMarthinussen2 on 2019/04/17.
 */

@EntityScan
public class Intern {

    private boolean isIntern;
    private String internID;


    public Intern(Builder builder) {
        this.isIntern = builder.isIntern;
        this.internID = builder.internID;
    }

    public boolean isIntern() {
        return isIntern;
    }

    public String getInternID() {
        return internID;
    }


    @Override
    public String toString() {
        return "Intern{" +
                "isIntern=" + isIntern +
                ", internID=" + internID +
                '}';
    }

    public static class Builder{

        //variables
        private boolean isIntern;
        private String internID;


        public Builder isIntern(boolean isIntern) {
            this.isIntern = isIntern;
            return this;
        }

        public Builder internID(String internID) {
            this.internID = internID;
            return this;
        }

        public Builder copy(Intern intern) {
            this.isIntern = intern.isIntern;
            this.internID = intern.internID;
            return this;
        }


        public Intern build(){
            return new Intern(this);
        }
    }
}
