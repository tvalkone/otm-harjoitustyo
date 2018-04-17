package timecard.domain;
import java.util.*;
import java.sql.*;
import timecard.domain.DAO;
import timecard.domain.Database;
import timecard.domain.Timecard;
import timecard.domain.UserDAO;


public class TimecardDAO implements DAO<Timecard, String> {
    private Database database;
    private UserDAO userdao;
    
    /**
     *
     * @param database
     */
    public TimecardDAO(Database database, UserDAO userdao) {
        this.database = database;
        this.userdao = userdao;
    }
    
    /**
     *
     * @param key
     * @return
     * @throws SQLException
     */
    @Override
    public Timecard findOne(String key) throws SQLException {
        
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM timecards WHERE timecardId = ?");
        stmt.setString(1, key);
        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.next();
        if (!hasOne) {
            return null;
        }
        Timecard c = new Timecard(rs.getString("userId"), rs.getString("projectId"), rs.getString("week"));
        c.setTimecardId(rs.getString("timecardId"));
        c.setStatus(rs.getBoolean("status"));
        c.setDay1(rs.getDouble("day1"));
        c.setDay2(rs.getDouble("day2"));
        c.setDay3(rs.getDouble("day3"));
        c.setDay4(rs.getDouble("day4"));
        c.setDay5(rs.getDouble("day5"));
        c.setDay6(rs.getDouble("day6"));
        c.setDay7(rs.getDouble("day7"));
        stmt.close();
        rs.close();
        conn.close();
        return c;
    }
    
    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List<Timecard> findAll() throws SQLException {
       
        List<Timecard> timecards = new ArrayList<>();
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM timecards");
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            Timecard c = new Timecard(rs.getString("userId"), rs.getString("projectId"), rs.getString("week"));
            c.setTimecardId(rs.getString("timecardId"));
            c.setStatus(rs.getBoolean("status"));
            c.setDay1(rs.getDouble("day1"));
            c.setDay2(rs.getDouble("day2"));
            c.setDay3(rs.getDouble("day3"));
            c.setDay4(rs.getDouble("day4"));
            c.setDay5(rs.getDouble("day5"));
            c.setDay6(rs.getDouble("day6"));
            c.setDay7(rs.getDouble("day7"));
            timecards.add(c);
        }
        stmt.close();
        rs.close();
        conn.close();
        return timecards;
    }
    
    /**
     *
     * @param object
     * @return
     * @throws SQLException
     */
    @Override
    public Timecard saveOrGet(Timecard object) throws SQLException {
       
        if (findOne(object.getTimecardId()) == null) {
            return save(object);
        } else {
            return findOne(object.getTimecardId());
        }
    }
    
    public Timecard save(Timecard timecard) throws SQLException {

        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO timecards"
                + " (timecardId, userId, projectId, status, week, day1, day2, day3, day4, day5, day6, day7)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        stmt.setString(1, timecard.getTimecardId());
        stmt.setString(2, timecard.getUserId());
        stmt.setString(3, timecard.getProjectId());
        stmt.setBoolean(4, timecard.getStatus());
        stmt.setString(4, timecard.getWeek());
        stmt.setDouble(5, timecard.getDay1());
        stmt.setDouble(6, timecard.getDay2());
        stmt.setDouble(7, timecard.getDay3());
        stmt.setDouble(8, timecard.getDay4());
        stmt.setDouble(9, timecard.getDay5());
        stmt.setDouble(10, timecard.getDay6());
        stmt.setDouble(11, timecard.getDay7());
       
        stmt.executeUpdate();
        stmt.close();

        stmt = conn.prepareStatement("SELECT * FROM timecards"
                + " WHERE timecardId = ?");
        stmt.setString(1, timecard.getTimecardId());
      
        ResultSet rs = stmt.executeQuery();
        rs.next(); 

        Timecard c = new Timecard(rs.getString("userId"), rs.getString("projectId"), rs.getString("week"));
        c.setTimecardId(rs.getString("timecardId"));
        c.setStatus(rs.getBoolean("status"));
        c.setDay1(rs.getDouble("day1"));
        c.setDay2(rs.getDouble("day2"));
        c.setDay3(rs.getDouble("day3"));
        c.setDay4(rs.getDouble("day4"));
        c.setDay5(rs.getDouble("day5"));
        c.setDay6(rs.getDouble("day6"));
        c.setDay7(rs.getDouble("day7"));
        stmt.close();
        rs.close();
        conn.close();
        return c;
    }
    
}
