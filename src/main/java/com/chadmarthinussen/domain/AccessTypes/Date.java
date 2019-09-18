package com.chadmarthinussen.domain.AccessTypes;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Id;

/**
 * Created by ChadMarthinussen2 on 2019/04/22.
 */

@EntityScan
public class Date {

    @Id
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

        public Builder copy(Date date ){
            this.dateID = date.dateID;
            this.day = date.day;
            this.month = date.month;
            this.year = date.year;
            return this;
        }

        public Date build(){
            return new Date(this);
        }
    }
}

