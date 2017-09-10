package app.echo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WeclomeController {
	
	@RequestMapping("/")
	public String home(){
		return "index";
	}
}
