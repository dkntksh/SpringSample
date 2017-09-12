package app.echo;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class EchoForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// 入力項目
	@NotEmpty
	@Size(max = 3)
	private String text;
	
	// セレクトボックスの選択値
	private int selectTest;
	// セレクトボックスの選択肢
	private List<SelectTestBean> selectTestList;
	
	// チェックボックス
	private boolean checkTest;
	
	// 複数選択チェックボックス
	private int[] checkBoxesTest;

	private List<CheckBoxesTestBean> checkBoxesList;
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public int getSelectTest() {
		return selectTest;
	}

	public void setSelectTest(int selectTest) {
		this.selectTest = selectTest;
	}

	public List<SelectTestBean> getSelectTestList() {
		return selectTestList;
	}

	public void setSelectTestList(List<SelectTestBean> selectTestList) {
		this.selectTestList = selectTestList;
	}

	public boolean getCheckTest() {
		return checkTest;
	}

	public void setCheckTest(boolean checkTest) {
		this.checkTest = checkTest;
	}

	public int[] getCheckBoxesTest() {
		return checkBoxesTest;
	}

	public void setCheckBoxesTest(int[] checkBoxesTest) {
		this.checkBoxesTest = checkBoxesTest;
	}

	public List<CheckBoxesTestBean> getCheckBoxesList() {
		return checkBoxesList;
	}

	public void setCheckBoxesList(List<CheckBoxesTestBean> checkBoxesList) {
		this.checkBoxesList = checkBoxesList;
	}
}
