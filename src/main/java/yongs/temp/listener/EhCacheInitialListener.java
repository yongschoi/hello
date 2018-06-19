package yongs.temp.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class EhCacheInitialListener implements ServletContextListener {
	
	public void contextDestroyed(ServletContextEvent event) {
	}

	public void contextInitialized(ServletContextEvent sc) {
		ServletContext ctx = sc.getServletContext();
		WebApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(ctx);
		EhCacheCacheManager cacheManager = (EhCacheCacheManager) springContext.getBean("cacheManager");

		Cache cache = cacheManager.getCache("tempCache");
		cache.put("root", "root");			
	}
}