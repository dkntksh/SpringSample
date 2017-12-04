package app.list;

import java.io.Serializable;
import java.util.List;

/**
 * 一覧画面のフォームクラス
 * @author dkntksh
 *
 */
public class ListForm implements Serializable {
		
		private static final long serialVersionUID = 1L;
		/**
		 * 表示用ユーザリスト
		 */
		private List<ListData> userList;

		public List<ListData> getUserList() {
			return userList;
		}

		public void setUserList(List<ListData> userList) {
			this.userList = userList;
		}
}
