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
		this.settingCheckBoxes(form);
		model.addAttribute(form);
		return "echo/input";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String echo(@Valid EchoForm form, BindingResult result){
		// 入力チェック
		if(result.hasErrors()){
			settingSelectBox(form);
			this.settingCheckBoxes(form);
			return "echo/input";
		}
		return "echo/output";
	}
	
	/**
	 * コンボボックスの初期設定
	 * @param model
	 */
	private void settingSelectBox(EchoForm form){
		List<SelectTestBean> selectBoxList = new ArrayList<SelectTestBean>();
				
		selectBoxList.add(new SelectTestBean(0, ""));
		selectBoxList.add(new SelectTestBean(1, "test"));
		selectBoxList.add(new SelectTestBean(2, "テスト"));
		selectBoxList.add(new SelectTestBean(3, "てすと"));		
		form.setSelectTestList(selectBoxList);
	}
	
	private void settingCheckBoxes(EchoForm form){
		List<CheckBoxesTestBean> selectTestList = new ArrayList<CheckBoxesTestBean>();
		selectTestList.add(new CheckBoxesTestBean(123, "Spring"));
		selectTestList.add(new CheckBoxesTestBean(456, "Framework"));
		selectTestList.add(new CheckBoxesTestBean(789, "MVC"));		
		form.setCheckBoxesList(selectTestList);
		
	}
}
