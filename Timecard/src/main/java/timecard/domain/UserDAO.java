
package timecard.domain;

import java.util.*;
import java.sql.*;

/**
 *
 * @author tvalkone
 */
public class UserDAO implements DAO<User, String> {
    private Database database;
    
    /**
     *
     * @param database
     */
    public UserDAO(Database database) {
        this.database = database;
    }
    
    /**
     *
     * @param key
     * @return
     * @throws SQLException
     */
    @Override
    public User findOne(String key) throws SQLException {
        
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE userId = ?");
        stmt.setString(1, key);
        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.next();
        if (!hasOne) {
            return null;
        }
        User a = new User(rs.getString("userId"), rs.getString("password"),
            rs.getString("Forename"), rs.getString("Surname"));
        stmt.close();
        rs.close();
        conn.close();
        return a;
    }
    
    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List<User> findAll() throws SQLException {
       
        List<User> users = new ArrayList<>();
        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users");
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            User a = new User(rs.getString("userId"), rs.getString("password"),
                rs.getString("Forename"), rs.getString("Surname"));
            users.add(a);
        }
        stmt.close();
        rs.close();
        conn.close();
        return users;
    }
    
    /**
     *
     * @param object
     * @return
     * @throws SQLException
     */
    @Override
    public User saveOrGet(User object) throws SQLException {
       
        if (findOne(object.getUserId()) == null) {
            return save(object);
        } else {
            return findOne(object.getUserId());
        }
    }
    
    private User save(User user) throws SQLException {

        Connection conn = database.getConnection();
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO users"
                + " (userId, password, Forename, Surname)"
                + " VALUES (?, ?, ?, ?)");
        stmt.setString(1, user.getUserId());
        stmt.setString(2, user.getPassword());
        stmt.setString(3, user.getForename());
        stmt.setString(4, user.getSurname());
   
        stmt.executeUpdate();
        stmt.close();

        stmt = conn.prepareStatement("SELECT * FROM users"
                + " WHERE userId = ?");
        stmt.setString(1, user.getUserId());
      

        ResultSet rs = stmt.executeQuery();
        rs.next(); // vain 1 tulos

        User a = new User(rs.getString("userId"), rs.getString("password"),
            rs.getString("Forename"), rs.getString("Surname"));
        stmt.close();
        rs.close();
        conn.close();
        return a;
    }
    
}
