package board.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public ModelAndView defaultExceptionHadler(HttpServletRequest request,Exception exception) {
		
		ModelAndView mv = new ModelAndView("/error/error_default");
		String errorMessage = "An error occurred: " + exception.getMessage();
		mv.addObject("errorMessage", errorMessage);
		
		log.error("exception", exception);
		
		return mv;
	}
			
	
}
