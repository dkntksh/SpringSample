package app.dbCommand;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * DB操作画面用Dao
 * @author dkntksh
 *
 */
@Component
public class DBCommandDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/**
	 * 商品MAX＋1を取得
	 * @param id 商品ID
	 * @return
	 */
	public long getUseProductId() {
		String sql = "SELECT MAX(id)+1 FROM PRODUCT ";
		Long max = jdbcTemplate.queryForObject(sql, Long.class);
		if(max == null) {
			return 1L;
		}
		return max;
	}
	
	/**
	 * 画面表示用データ取得
	 * @param id 商品ID
	 * @return
	 */
	public List<DispData> getDispDataList() {
		String sql = "SELECT id, name, productCd FROM product ORDER BY id";
		List<Map<String, Object>> resultMapList = jdbcTemplate.queryForList(sql);
		List<DispData> dispDataList = new ArrayList<DispData>();
		for(Map<String, Object> result :resultMapList) {
			DispData dispData = new DispData();
			dispData.setProductId((String)result.get("id"));
			dispData.setPrductName((String)result.get("name"));
			dispData.setProductCd(String.valueOf((Integer)result.get("productCd")));
			dispDataList.add(dispData);
		}
		return dispDataList;
	}
	
	
	/**
	 * 商品IDで検索
	 * @param id 商品ID
	 * @return
	 */
	public int findByProductId(String id) {
		String sql = "SELECT COUNT(1) FROM PRODUCT WHERE ID = " + id;
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	/**
	 * 製品の登録
	 * @param id
	 * @param name
	 * @param productCd
	 */
	@Transactional
	public void registProduct(String id, String name, String productCd) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO product(id, name, productCd)");
		sql.append(" VALUES (?, ?, ?)");
		jdbcTemplate.update(sql.toString(), id, name, productCd);
	}
}
