package yongs.temp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import yongs.temp.vo.User;

@Service("cacheService")
public class CacheService {

	@Autowired 
	private CacheManager cacheManager;

	public String getValue(String key)  {
		Cache cache = cacheManager.getCache("tempCache");
		return (String) cache.get(key).get();
	}
	
	public void putCacheMap(String key, String value)  {
		Cache cache = cacheManager.getCache("tempCache");
		cache.putIfAbsent(key, value);	
	}
	
	public void createUser(User user)  {
		putCacheMap(user.getUserName(), user.getPassword());	
	}
	
	public User findUser(String username)  {
		return new User(username, getValue(username), 1);	
	}
}
