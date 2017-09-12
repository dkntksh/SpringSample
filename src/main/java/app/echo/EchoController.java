package app.echo;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("echo")
public class EchoController {
	/**
	 * リストボックスの選択肢
	 */
	final static List<SelectTestBean> SELECT_ITEMS =
		    new ArrayList<SelectTestBean>() {
		    {
		    	add(new SelectTestBean(0, ""));
				add(new SelectTestBean(1, "test"));
				add(new SelectTestBean(2, "テスト"));
				add(new SelectTestBean(3, "てすと"));
		    }
	};
	
	/**
	 * チェックボックスの選択肢
	 */
	final static List<CheckBoxesTestBean> SELECT_CHECKBOX_ITEMS =
		    new ArrayList<CheckBoxesTestBean>() {
		    {
		    	add(new CheckBoxesTestBean(123, "Spring"));
				add(new CheckBoxesTestBean(456, "Framework"));
				add(new CheckBoxesTestBean(789, "MVC"));		
		    }
	};
	
	@RequestMapping(method = RequestMethod.GET)
	public String viewInput(Model model){
		// 初期値設定
		EchoForm form = new EchoForm();
		form.setSelectTestList(SELECT_ITEMS);
		form.setCheckBoxesList(SELECT_CHECKBOX_ITEMS);
		model.addAttribute(form);
		return "echo/input";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String echo(@Valid EchoForm form, BindingResult result){
		// 入力チェック
		if(result.hasErrors()){
			form.setSelectTestList(SELECT_ITEMS);
			form.setCheckBoxesList(SELECT_CHECKBOX_ITEMS);
			return "echo/input";
		}
		return "echo/output";
	}
}
