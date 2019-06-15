package com.chadmarthinussen.Domain.TimeAndDateStamp;


import com.chadmarthinussen.Domain.AccessTypes.Date;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Created by ChadMarthinussen2 on 2019/04/17.
 */
@EntityScan
public class DateTracker {

    private String dateTrackerID;
    private String timestamp;
    private Date date;


    public DateTracker(Builder builder) {
        this.dateTrackerID = builder.dateTrackerID;
        this.timestamp = builder.timestamp;
        this.date = builder.date;
    }

    public String getDatetrackerID() {
        return dateTrackerID;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "DateTracker{" +
                "DatetrackerID=" + dateTrackerID +
                ", timestamp='" + timestamp + '\'' +
                ", date=" + date +
                '}';
    }

    public static class Builder{

        private String dateTrackerID;
        private String timestamp;
        private Date date;

        public Builder dateTrackerID(String dateTrackerID) {
            this.dateTrackerID = dateTrackerID;
            return this;
        }

        public Builder timestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder date(Date date) {
            this.date = date;
            return this;
        }

        public DateTracker build(){
            return new DateTracker(this);
        }
    }
}

