package app.list;

/**
 * 一覧の表示内容用クラス
 * @author dkntksh
 *
 */
public class ListData {
	/**
	 * id
	 */
	private long id;
	/**
	 * ユーザ名
	 */
	private String userName;
	/**
	 * ユーザ住所
	 */
	private String userAdress;
	/**
	 * ユーザ年齢
	 */
	private int userAge;
	/**
	 * ユーザ名取得
	 * @return ユーザ名
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * ユーザ名設定
	 * @param userName　ユーザ名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * ユーザ住所取得
	 * @return
	 */
	public String getUserAdress() {
		return userAdress;
	}
	/**
	 * ユーザ住所設定
	 * @param userAdress
	 */
	public void setUserAdress(String userAdress) {
		this.userAdress = userAdress;
	}
	/**
	 * ユーザ年齢取得
	 * @return
	 */
	public int getUserAge() {
		return userAge;
	}
	/**
	 * ユーザ年齢設定
	 * @param userAge
	 */
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	/**
	 * IDの取得
	 * @return
	 */
	public long getId() {
		return id;
	}
	/**
	 * IDの設定
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}
	
}
