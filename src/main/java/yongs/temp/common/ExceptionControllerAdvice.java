package yongs.temp.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionControllerAdvice {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionControllerAdvice.class);
	@ExceptionHandler(Exception.class)
	public ModelAndView exception(Exception e) {		
		logger.error("ExceptionControllerAdvice -> message ::: " + e.getMessage());
    	
		ModelAndView mav = new ModelAndView("exception");
		mav.addObject("name", e.getClass().getSimpleName());
		mav.addObject("message", e.getMessage());

		return mav;
	}
} 