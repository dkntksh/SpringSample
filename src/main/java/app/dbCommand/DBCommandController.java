package app.dbCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * DB操作用画面のコントローラクラス
 * @author dkntksh
 *
 */
@Controller
@RequestMapping("db")
public class DBCommandController {
	@Autowired
	DBCommandDao dao;
	@Autowired
	DBCommandValidator dBCommandValidator;
	
	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		binder.addValidators(dBCommandValidator);
	}
	
	/**
	 * 初期表示
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String init(Model model){
		DBCommandForm form = new DBCommandForm();
		// フォームの初期化
		this.initForm(form);
		model.addAttribute("dBCommandForm", form);
		return "db/dbCommand";
	}

	/**
	 * 登録
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, path="/regist")
	public String regist(Model model, DBCommandForm form, BindingResult result) {
		// 入力チェック
		if(result.hasErrors()){
			model.addAttribute("dBCommandForm", form);
			return "db/dbCommand";
		}
		// データを登録
		dao.registProduct(form.getProductId(), form.getProductName(), form.getProductCd());
		this.initForm(form);
		model.addAttribute("dBCommandForm", form);
		return "db/dbCommand";
	}
	/**
	 * フォームを初期化する
	 * @param form
	 */
	private void initForm(DBCommandForm form) {
		long maxId = dao.getUseProductId();
		form.setProductId(String.valueOf(maxId));
		form.setDispList(dao.getDispDataList());
	}
}
