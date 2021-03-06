package com.chadmarthinussen.domain.AccessTypes;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Id;

/**
 * Created by ChadMarthinussen2 on 2019/04/29.
 */

@EntityScan
public class TurnStileAccess {

    @Id
    private String turnStileAccessID;
    private boolean validUserAccess;
    private Time clockingTimes;

    public TurnStileAccess(Builder builder) {
        this.turnStileAccessID = builder.turnStileAccessID;
        this.validUserAccess = builder.validUserAccess;
        this.clockingTimes = builder.clockingTimes;
    }


    public String getTurnStileAccessID() {
        return turnStileAccessID;
    }

    public boolean isValidUserAccess() {
        return validUserAccess;
    }

    public Time getClockingTimes() {
        return clockingTimes;
    }

    @Override
    public String toString() {
        return "TurnStileAccess{" +
                "turnStileAccessID='" + turnStileAccessID + '\'' +
                ", validUserAccess=" + validUserAccess +
                ", clockingTimes=" + clockingTimes +
                '}';
    }

    public static class Builder{

        private String turnStileAccessID;
        private boolean validUserAccess;
        private Time clockingTimes;

        public Builder turnStileAccessID(String turnStileAccessID) {
            this.turnStileAccessID = turnStileAccessID;
            return this;
        }

        public Builder validUserAccess(boolean validUserAccess) {
            this.validUserAccess = validUserAccess;
            return this;
        }

        public Builder clockingTimes(Time clockingTimes) {
            this.clockingTimes = clockingTimes;
            return this;
        }

        public Builder copy(TurnStileAccess turnStileAccess ){
            this.turnStileAccessID = turnStileAccess.turnStileAccessID;
            this.validUserAccess = turnStileAccess.validUserAccess;
            this.clockingTimes = turnStileAccess.clockingTimes;
            return this;
        }

        public TurnStileAccess build(){
            return new TurnStileAccess(this);
        }
    }
}
