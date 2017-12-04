package app.list;

import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
	ListDao listDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public String init(Model model){
		// 初期値設定
		ListForm form = new ListForm();
		// 表示用データの取得と設定
		form.setUserList(listDao.getListDataList());
		model.addAttribute(form);
		return "list/list";
	}
	
}
