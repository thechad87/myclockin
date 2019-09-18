package com.chadmarthinussen.domain.AccessTypes;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Id;

/**
 * Created by ChadMarthinussen2 on 2019/04/23.
 */

@EntityScan
public class Time {

    @Id
    private String timeID;
    private String seconds;
    private String minutes;
    private String hours;

    public Time(Builder builder) {
        this.timeID = builder.timeID;
        this.seconds = builder.seconds;
        this.minutes = builder.minutes;
        this.hours = builder.hours;
    }

    public String getTimeID() {
        return timeID;
    }

    public String getSeconds() {
        return seconds;
    }

    public String getMinutes() {
        return minutes;
    }

    public String getHours() {
        return hours;
    }

    @Override
    public String toString() {
        return "Time{" +
                "timeID=" + timeID +
                ", seconds=" + seconds +
                ", minutes=" + minutes +
                ", hours=" + hours +
                '}';
    }

    public static class Builder{

        private String timeID;
        private String seconds;
        private String minutes;
        private String hours;

        public Builder timeID(String timeID) {
            this.timeID = timeID;
            return this;
        }

        public Builder seconds(String seconds) {
            this.seconds = seconds;
            return this;
        }

        public Builder minutes(String minutes) {
            this.minutes = minutes;
            return this;
        }

        public Builder hours(String hours) {
            this.hours = hours;
            return this;
        }

        public Builder copy(Time time ){
            this.timeID = time.timeID;
            this.seconds = time.seconds;
            this.minutes = time.minutes;
            this.hours = time.hours;
            return this;
        }

        public Time build(){
            return new Time(this);
        }
    }
}
