package yongs.temp.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import yongs.temp.vo.User;

@Repository
public class UserRoleDao extends JdbcDaoSupport {
    @Autowired
    public UserRoleDao(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
    
    public List<String> findRole(User user) {
        String role_sql = "SELECT user_role FROM user_roles WHERE username = ?";
 
        Object[] params = new Object[] { user.getUserName() };
        List<String> userRoles = this.getJdbcTemplate().queryForList(role_sql, String.class, params);

        return userRoles;
    }
    
    public void updateRole(String username, List<String> roles) {
        String role_delete_sql = "DELETE FROM user_roles WHERE username = ?";
        String role_insert_sql = "INSERT INTO user_roles (username, user_role) VALUES (?, ?) ";
      
        Object[] params = new Object[] { username };      
        this.getJdbcTemplate().update(role_delete_sql, params);
        
        int size = roles.size();
        for(int idx=0; idx < size; idx++) {
            logger.debug("===> roles : " + roles.get(idx).toString());
            
            params = new Object[] { username, roles.get(idx) };      
            this.getJdbcTemplate().update(role_insert_sql, params);          	
        }    
    }
}