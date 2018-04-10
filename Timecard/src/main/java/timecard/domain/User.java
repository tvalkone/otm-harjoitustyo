
package timecard.domain;
import java.util.*;

/**
 *
 * @author tvalkone
 */
public class User {
    String userId;
    String password;
    String Forename;
    String Surname;
    Map<String, Timecard> timecards;

    /**
     *
     * @param userId
     * @param password
     * @param Forename
     * @param Surname
     */
    public User(String userId, String password, String Forename, String Surname) {
        this.userId = userId;
        this.password = password;
        this.Forename = Forename;
        this.Surname = Surname;
    }
    
    /**
     *
     * @return
     */
    public Map<String, Timecard> getTimecards() {
        return timecards;
    }

    /**
     *
     * @param timecards
     */
    public void setTimecards(Map<String, Timecard> timecards) {
        this.timecards = timecards;
    }

    /**
     *
     * @return
     */
    public String getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public String getForename() {
        return Forename;
    }

    /**
     *
     * @param Forename
     */
    public void setForename(String Forename) {
        this.Forename = Forename;
    }

    /**
     *
     * @return
     */
    public String getSurname() {
        return Surname;
    }

    /**
     *
     * @param Surname
     */
    public void setSurname(String Surname) {
        this.Surname = Surname;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "User" +this.userId +":"+this.Forename+", " +this.Surname;
    }
    
}
