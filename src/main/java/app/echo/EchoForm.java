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

	public boolean isCheckTest() {
		return checkTest;
	}

	public void setCheckTest(boolean checkTest) {
		this.checkTest = checkTest;
	}
}
