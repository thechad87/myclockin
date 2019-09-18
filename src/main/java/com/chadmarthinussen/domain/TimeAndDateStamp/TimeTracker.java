package com.chadmarthinussen.domain.TimeAndDateStamp;

import com.chadmarthinussen.domain.AccessTypes.Time;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Id;

/**
 * Created by ChadMarthinussen2 on 2019/04/17.
 */

@EntityScan
public class TimeTracker {

    @Id
    private String timeTrackerID;
    private Time userCheckInTimer;
    private Time userCheckOutTimer;
    private boolean isCurrentlyCheckedIn;


    public TimeTracker(Builder builder) {
        this.timeTrackerID = builder.timeTrackerID;
        this.userCheckInTimer = userCheckInTimer;
        this.userCheckOutTimer = userCheckOutTimer;
        this.isCurrentlyCheckedIn = isCurrentlyCheckedIn;
    }

    public String getTimeTrackerID() {
        return timeTrackerID;
    }

    public Time getUserCheckInTimer() {
        return userCheckInTimer;
    }

    public Time getUserCheckOutTimer() {
        return userCheckOutTimer;
    }

    public boolean isCurrentlyCheckedIn() {
        return isCurrentlyCheckedIn;
    }

    @Override
    public String toString() {
        return "TimeTracker{" +
                "timeTrackerID=" + timeTrackerID +
                ", userCheckInTimer=" + userCheckInTimer +
                ", userCheckOutTimer=" + userCheckOutTimer +
                ", isCurrentlyCheckedIn=" + isCurrentlyCheckedIn +
                '}';
    }

    public static class Builder{

        private String timeTrackerID;
        private Time userCheckInTimer;
        private Time userCheckOutTimer;
        private boolean isCurrentlyCheckedIn;

        public Builder timeTrackerID(String timeTrackerID) {
            this.timeTrackerID = timeTrackerID;
            return this;
        }

        public Builder userCheckInTimer(Time userCheckInTimer) {
            this.userCheckInTimer = userCheckInTimer;
            return this;
        }

        public Builder userCheckOutTimer(Time userCheckOutTimer) {
            this.userCheckOutTimer = userCheckOutTimer;
            return this;
        }

        public Builder isCurrentlyCheckedIn(boolean isCurrentlyCheckedIn) {
            this.isCurrentlyCheckedIn = isCurrentlyCheckedIn;
            return this;
        }

        public Builder copy(TimeTracker timeTracker) {
            this.timeTrackerID = timeTracker.timeTrackerID;
            this.userCheckInTimer = timeTracker.userCheckInTimer;
            this.userCheckOutTimer = timeTracker.userCheckOutTimer;
            this.isCurrentlyCheckedIn = timeTracker.isCurrentlyCheckedIn;
            return this;
        }

        public TimeTracker build(){
            return new TimeTracker(this);
        }
    }
}
