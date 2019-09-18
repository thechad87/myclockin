package com.chadmarthinussen.domain.Alerts;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Id;

/**
 * Created by ChadMarthinussen2 on 2019/06/10.
 */
@EntityScan
public class Alarm {

    @Id
    private String alarmID;
    private String triggerAlarm;
    private String alert;

    public Alarm(Builder builder) {
    }

    public String getAlarmID() {
        return alarmID;
    }

    public String getTriggerAlarm() {
        return triggerAlarm;
    }

    public String getAlert() {
        return alert;
    }

    @Override
    public String toString() {
        return "Alarm{" +
                "alarmID='" + alarmID + '\'' +
                ", triggerAlarm='" + triggerAlarm + '\'' +
                ", alert='" + alert + '\'' +
                '}';
    }

    public static class Builder{

        private String alarmID;
        private String triggerAlarm;
        private String alert;


        public Builder alarmID(String alarmID) {
            this.alarmID = alarmID;
            return this;
        }

        public Builder triggerAlarm(String triggerAlarm){
            this.triggerAlarm = triggerAlarm;
            return this;
        }

        public Builder alert(String alert) {
            this.alert = alert;
            return this;
        }

        public Alarm build(){
            return new Alarm(this);
        }

        public Builder copy(Alarm alarm){
            this.alarmID = alarm.alarmID;
            this.triggerAlarm = alarm.triggerAlarm;
            this.alert = alarm.alert;
            return this;
        }

    }
}

