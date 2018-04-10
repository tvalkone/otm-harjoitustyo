package timecard.domain;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tvalkone
 */
public class TimecardService {
    private Map<String, List<Timecard>> UsersAndTimecards;
    private Database database;
    private UserDAO userdao;
    
    /**
     *
     * @param d
     */
    public TimecardService(Database d){
       this.userdao = new UserDAO(d);
       this.database = d;   
    }
       
    /**
     *
     * @param userId
     * @return
     * @throws SQLException
     */
    public Boolean CheckUser(String userId)throws SQLException{
            if(this.userdao.findOne(userId) != null){
                return true;
            }
        return false;   
    } 
    
    /**
     *
     * @param userId
     * @param password
     * @return
     * @throws SQLException
     */
    public Boolean CheckPassWord(String userId, String password) throws SQLException{
 
        if(this.userdao.findOne(userId).getPassword().equals(password)){
            return true;
        }else{
            return false;   
        }
    }       

    /**
     *
     * @return
     */
    public Database getDatabase() {
        return database;
    }

    /**
     *
     * @return
     */
    public UserDAO getUserdao() {
        return userdao;
    }
}    
           
        
           
    
