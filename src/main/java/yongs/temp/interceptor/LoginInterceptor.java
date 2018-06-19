package yongs.temp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import yongs.temp.vo.User;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {         
        HttpSession session = request.getSession(false);
        if(session != null) 
        	logger.debug("SESSION ID ==>|" + session.getId() + "|");      
        else 
        	logger.debug("SESSION ID ==>|" + session + "|");      	

        if(session == null) {           
            response.sendRedirect(request.getContextPath() + "/loginPage");
        	return false;
        }
        
        User user = (User) session.getAttribute("SESSION_USER");
        logger.debug("user ======================================>|" + user + "|"); 
        if(user == null) {        	
        	response.sendRedirect(request.getContextPath() + "/loginPage");
        	return false;       	
        }
        
        return true;
    }
 
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    	logger.info("\n-------- LoginInterceptor.postHandle --- ");
 
        // You can add attributes in the modelAndView
        // and use that in the view page
    }
 
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    	logger.info("\n-------- LoginInterceptor.afterCompletion --- ");
 
    }   
}