
package timecard.domain;
import java.util.*;

    
public class User {
    String userId;
    String password;
    String Forename;
    String Surname;
    Map<String, timecard> timecards;

    public User(String userId, String password, String Forename, String Surname) {
        this.userId = userId;
        this.password = password;
        this.Forename = Forename;
        this.Surname = Surname;
    }
    
    public Map<String, timecard> getTimecards() {
        return timecards;
    }

    public void setTimecards(Map<String, timecard> timecards) {
        this.timecards = timecards;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getForename() {
        return Forename;
    }

    public void setForename(String Forename) {
        this.Forename = Forename;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }
    
    
}
