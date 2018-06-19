package yongs.temp.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import yongs.temp.exception.InsufficientException;
import yongs.temp.exception.NoIdentityException;
import yongs.temp.service.UserService;
import yongs.temp.vo.User;
 
@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserService userService;

    @RequestMapping("/hello")
    public String hello(HttpServletRequest req, Model model) {
    	HttpSession session = req.getSession(false);
    	logger.debug("SESSION ID ==>|" + session.getId() + "|");
    	model.addAttribute("out", "Hello !!! ");    	
        return "result";
    }
    
    @RequestMapping("/loginPage")
    public String prelogin(HttpServletRequest req) {	
        return "loginPage";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest req, Model model) throws Exception {  	
    	String username = req.getParameter("username");
    	String password = req.getParameter("password");
        
    	logger.debug("username=> " + username);
    	logger.debug("password=> " + password);
 
    	User user = null;
    	try {
    		user = userService.findUser(username);
    	} catch (Exception e) {
    		throw new InsufficientException();
    	}
    	
    	if(!user.getPassword().equals(password)) {
    		throw new NoIdentityException();
    	}
 
        HttpSession session = req.getSession(false);
    	session.setAttribute("SESSION_USER", user);
    	
    	logger.debug("SESSION ID ==>|" + session.getId() + "|");
    	model.addAttribute("out", username);
    	
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest req, Model model) throws Exception {      	
    	HttpSession session = req.getSession(false);    	
    	////////////////////////////////////////////////////////////////////////////////////
    	if(session != null) {
    		session.removeAttribute("SESSION_USER");
    		session.invalidate();
    	}

    	return "redirect: /loginPage";
    }

	@ExceptionHandler({InsufficientException.class}) 
	public String userError(HttpServletRequest request, Model model) { 
		// Nothing to do. Returns the logical view name of an error page, passed to 
		// the view-resolver(s) in usual way. 
		// Note that the exception is _not_ available to this view (it is not added to 
		// the model) but see "Extending ExceptionHandlerExceptionResolver" below. 
		String username = request.getParameter("username");
       
		model.addAttribute("out", username+"는 존재하지 않는 사용자입니다.");
		return "loginPage";
	} 
	
	@ExceptionHandler({NoIdentityException.class}) 
	public String noIdentity(HttpServletRequest request, Model model) { 
		// Nothing to do. Returns the logical view name of an error page, passed to 
		// the view-resolver(s) in usual way. 
		// Note that the exception is _not_ available to this view (it is not added to 
		// the model) but see "Extending ExceptionHandlerExceptionResolver" below. 
		model.addAttribute("out", "Password가 틀립니다.");
		return "loginPage";
	} 
}