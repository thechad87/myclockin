package com.chadmarthinussen.Domain.AccessTypes;

import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Created by ChadMarthinussen2 on 2019/04/22.
 */

@EntityScan
public class Date {

    private String dateID;
    private String day;
    private String month;
    private String year;


    public Date(Builder builder) {
        this.dateID = builder.dateID;
        this.day = builder.day;
        this.month = builder.month;
        this.year = builder.year;
    }

    public String getDateID() {
        return dateID;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }


    @Override
    public String toString() {
        return "Date{" +
                "dateID='" + dateID + '\'' +
                ", day='" + day + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    public static class Builder{

        private String dateID;
        private String day;
        private String month;
        private String year;

        public Builder dateID(String dateID) {
            this.dateID = dateID;
            return this;
        }

        public Builder day(String day) {
            this.day = day;
            return this;
        }

        public Builder month(String month) {
            this.month = month;
            return this;
        }

        public Builder year(String year) {
            this.year = year;
            return this;
        }

        public Date build(){
            return new Date(this);
        }
    }
}

