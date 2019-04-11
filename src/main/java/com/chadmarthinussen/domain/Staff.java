package com.chadmarthinussen.domain;

/**
 * Created by ChadMarthinussen2 on 2019/04/10.
 * student number : 208031197
 *
 */



public class Staff {

    private String name;
    private String surname;
    private long staffID;
    private double baseHours;

    private Staff(Builder builder){}

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public long getStaffID() {
        return staffID;
    }

    public double getBaseHours() {
        return baseHours;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "  name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", staffID=" + staffID +
                ", baseHours=" + baseHours +
                '}';
    }

    public static class Builder{

        private String name, surname;
        private long staffID;
        private double baseHours;

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder surname(String surname){
            this.surname = surname;
            return this;
        }

        public Builder staffID(long staffID){
            this.staffID = staffID;
            return this;
        }

        public Builder baseHours(double baseHours){
            this.baseHours = baseHours;
            return this;
        }

        public Staff build(){
            return new Staff(this);
        }


    }
}
