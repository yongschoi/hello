package yongs.temp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import yongs.temp.vo.User;

public class UserMapper implements RowMapper<User> {
    public static final String BASE_SQL = "SELECT username, password, enabled FROM users";
 
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        String userName = rs.getString("username");
        String password = rs.getString("password");
        int    enabled  = rs.getInt("enabled");
 
        return new User(userName, password, enabled);
    }  
}