package app.dbCommand;

import java.util.List;
import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * DB操作画面用のフォームクラス
 * @author dkntksh
 *
 */
public class DBCommandForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Valid
	@NotEmpty(message="製品IDは必須です")
	@Pattern(regexp="[0-9]*", message="製品IDは半角数値を指定してください")
	private String productId;
	
	@Valid
	@NotEmpty(message="製品名は必須です")
	private String productName;
	
	@Valid
	@NotEmpty(message="製品コードは必須です")
	@Pattern(regexp="[0-9]*", message="製品コードは半角数値を指定してください")
	private String productCd;
	/**
	 * 画面表示項目
	 */
	private List<DispData> dispList;
	
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCd() {
		return productCd;
	}

	public void setProductCd(String productCd) {
		this.productCd = productCd;
	}

	public List<DispData> getDispList() {
		return dispList;
	}

	public void setDispList(List<DispData> dispList) {
		this.dispList = dispList;
	}
}
