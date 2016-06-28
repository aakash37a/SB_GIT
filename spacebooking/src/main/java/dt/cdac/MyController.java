package dt.cdac;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class MyController {
	
	
	@RequestMapping("/hello")
	private String GethelloMessage(){
		return "hi";
	}
	
	@RequestMapping("/")
	private String Getindex(){
		return "index";
	}
	
	

}
