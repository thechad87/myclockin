package com.chadmarthinussen.domain.UserlType;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Id;

/**
 * Created by ChadMarthinussen2 on 2019/04/17.
 */
@EntityScan
public class Contractor {

    @Id
    private boolean isContactor;
    private String timePeriodMonths;
    private String contractorID;

    public Contractor(Builder builder) {
        this.isContactor = builder.isContactor;
        this.timePeriodMonths = builder.timePeriodMonths;
        this.contractorID = builder.contractorID;
    }

    public boolean isContactor() {
        return isContactor;
    }

    public String getTimePeriodMonths() {
        return timePeriodMonths;
    }

    public String getContractorID() {
        return contractorID;
    }

    @Override
    public String toString() {
        return "Contractor{" +
                "isContactor=" + isContactor +
                ", timePeriodMonths=" + timePeriodMonths +
                ", contractorID='" + contractorID + '\'' +
                '}';
    }

    public static class Builder{

        private boolean isContactor;
        private String timePeriodMonths;
        private String contractorID;


        public Builder isContactor(Boolean isContactor){
            this.isContactor = isContactor;
            return this;
        }

        public Builder timePeriodMonths(String timePeriodMonths){
            this.timePeriodMonths = timePeriodMonths;
            return this;
        }

        public Builder contractorID(String contractorID){
            this.contractorID = contractorID;
            return this;
        }

        public Builder copy(Contractor contractor) {
            this.isContactor = contractor.isContactor;
            this.timePeriodMonths = contractor.timePeriodMonths;
            this.contractorID = contractor.contractorID;
            return this;
        }

        public Contractor build() {
            return new Contractor(this);
        }
    }
}

