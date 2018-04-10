
package timecard.domain;

import java.sql.*;
        
/**
 *
 * @author tvalkone
 */
public class Database {
    private String databaseAddress;

    /**
     *
     * @param databaseAddress
     * @throws ClassNotFoundException
     */
    public Database(String databaseAddress) throws ClassNotFoundException {
        this.databaseAddress = databaseAddress;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(databaseAddress);
    }
}
