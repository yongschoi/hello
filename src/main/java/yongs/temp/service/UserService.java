package yongs.temp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yongs.temp.dao.UserDao;
import yongs.temp.dao.UserRoleDao;
import yongs.temp.vo.User;

@Service("userService")
public class UserService {

	@Autowired 
	private UserDao userDao;

	@Autowired
	private UserRoleDao userRoleDao;
	
	public User findUser(String username) {
		User user = userDao.findUser(username);
        user.setUserRoles(userRoleDao.findRole(user));
        
		return user;
	}
	
	public void createUser(User user) {
		userDao.createUser(user);
		List<String> roles = new ArrayList<String>();
		roles.add("USER");
		userRoleDao.updateRole(user.getUserName(), roles);
	}
}
