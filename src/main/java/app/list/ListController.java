package app.list;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("list")
/**
 * 一覧画面のコントローラークラス
 * @author dkntksh
 *
 */
public class ListController {
	@RequestMapping(method = RequestMethod.GET)
	public String init(Model model){
		// 初期値設定
		ListForm form = new ListForm();
		model.addAttribute(form);
		return "list/list";
	}
	
}
