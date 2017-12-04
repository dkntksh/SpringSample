package app.detail;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("detail")
/**
 * 詳細画面のコントローラークラス
 * @author dkntksh
 *
 */
public class DetailController {
	
	@RequestMapping(value="/{userId}", method = RequestMethod.GET)
	public String init(Model model, @PathVariable("userId") String userId){
		DetailFrom form = new DetailFrom();
		form.setUserId(userId);
		model.addAttribute(form);
		return "detail/detail";
	}
}
