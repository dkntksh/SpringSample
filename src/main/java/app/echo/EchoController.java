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
	
	@RequestMapping(method = RequestMethod.GET)
	public String viewInput(Model model){
		
		
		// 初期値設定
		EchoForm form = new EchoForm();
		this.settingSelectBox(form);
		model.addAttribute(form);
		return "echo/input";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String echo(@Valid EchoForm form, BindingResult result){
		// 入力チェック
		if(result.hasErrors()){
			settingSelectBox(form);
			return "echo/input";
		}
		return "echo/output";
	}
	
	/**
	 * コンボボックスの初期設定
	 * @param model
	 */
	private void settingSelectBox(EchoForm form){
		List<SelectTestBean> selectTestList = new ArrayList<SelectTestBean>();
				
		selectTestList.add(new SelectTestBean(0, ""));
		selectTestList.add(new SelectTestBean(1, "test"));
		selectTestList.add(new SelectTestBean(2, "テスト"));
		selectTestList.add(new SelectTestBean(3, "てすと"));		
		form.setSelectTestList(selectTestList);
	}
}
