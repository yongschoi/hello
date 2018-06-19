package yongs.temp.dao;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import yongs.temp.mapper.UserMapper;
import yongs.temp.vo.User;

@Repository
public class UserDao extends JdbcDaoSupport {
    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);
    
    @Autowired
    public UserDao(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
    
    public User findUser(String username) {
        String user_sql = UserMapper.BASE_SQL + " WHERE username = ? and enabled = 1";
 
        Object[] params = new Object[] { username };
        logger.debug("findUser ==> " + username); 
        UserMapper mapper = new UserMapper();        
        User user = this.getJdbcTemplate().queryForObject(user_sql, params, mapper);
        
        return user;
    }
 
    public void createUser(User user) {
        String user_sql = "INSERT INTO users (username, password, enabled) VALUES (?, ?, ?) ";
               
        Object[] params = new Object[] { user.getUserName(), user.getPassword(), user.getEnabled() };
        this.getJdbcTemplate().update(user_sql, params);
    }
}
