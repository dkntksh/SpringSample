package app.list;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
/**
 * 一覧画面のDaoクラス
 * @author dkntksh
 *
 */
public class ListDao {

	/**
	 * 画面表示用データの取得
	 * @return
	 */
	public List<ListData> getListDataList(){
		List<ListData> resultList = new ArrayList<ListData>();
		resultList.add(this.getMakeData("田中一郎","札幌市中央区",40));
		resultList.add(this.getMakeData("山田隆","札幌市北区",35));
		resultList.add(this.getMakeData("佐藤翔一","札幌市西区",18));
		return resultList;
	}
	
	/**
	 * 表示用データの作成
	 * @param userName
	 * @param userAdress
	 * @param userAge
	 * @return 表示用データ
	 */
	private ListData getMakeData(String userName, String userAdress, int userAge) {
		ListData result = new ListData();
		result.setUserName(userName);
		result.setUserAdress(userAdress);
		result.setUserAge(userAge);
		return result;
	}
}
