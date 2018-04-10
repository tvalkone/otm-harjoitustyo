package timecard.domain;

import java.sql.*;
import java.util.*;

/**
 *
 * @author tvalkone
 * @param <T>
 * @param <K>
 */
public interface DAO<T, K> {

    /**
     *
     * @param key
     * @return
     * @throws SQLException
     */
    T findOne(K key) throws SQLException;

    /**
     *
     * @return
     * @throws SQLException
     */
    List<T> findAll() throws SQLException;

    /**
     *
     * @param object
     * @return
     * @throws SQLException
     */
    T saveOrGet(T object) throws SQLException;
   //void delete(K key) throws SQLException;
}