
package timecard.domain;

import java.util.*; 

public class Timecard {
    public String timecardId;
    public String week;
    public Double day1;
    public Double day2;
    public Double day3;
    public Double day4;
    public Double day5;
    public Double day6;
    public Double day7;
    public String projectId;
    public String userId;
    public Boolean status;

    public Timecard(String userId, String projectId, String week) {
        this.week = week;
        this.projectId = projectId;
            this.userId = userId;
            this.timecardId = userId + projectId + week;
        this.status = true;
    }

    public String getTimecardId() {
        return timecardId;
    }

    public void setTimecardId(String id) {
        this.timecardId = id;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public Double getDay1() {
        return day1;
    }

    public void setDay1(Double day1) {
        this.day1 = day1;
    }

    public Double getDay2() {
        return day2;
    }

    public void setDay2(Double day2) {
        this.day2 = day2;
    }

    public Double getDay3() {
        return day3;
    }

    public void setDay3(Double day3) {
        this.day3 = day3;
    }

    public Double getDay4() {
        return day4;
    }

    public void setDay4(Double day4) {
        this.day4 = day4;
    }

    public Double getDay5() {
        return day5;
    }

    public void setDay5(Double day5) {
        this.day5 = day5;
    }

    public Double getDay6() {
        return day6;
    }

    public void setDay6(Double day6) {
        this.day6 = day6;
    }

    public Double getDay7() {
        return day7;
    }

    public void setDay7(Double day7) {
        this.day7 = day7;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUser(String userId) {
        this.userId = userId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean open) {
        this.status = open;
    }
    
    
  
}

