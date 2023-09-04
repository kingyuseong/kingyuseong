/**
 * 
 */
package com.javaclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author korea
 *
 */
@Controller
public class MainController {
	
	@RequestMapping("/{step}.do")
	   public String viewPage(@PathVariable String step) {
	    return step;
	}
	
	@RequestMapping("./diary/{step}.do")
	   public String serveViewPage(@PathVariable String step) {
	    return step;
	}
	
}
