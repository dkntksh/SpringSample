package app.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@PropertySource("classpath:jdbc_mysql.properies")
public class PoolingDataSourceConfig {
	
	@Bean(destroyMethod="close")
	public DataSource dataSource(
			@Value("${database.driverClassName}") String driverClassName,
			@Value("${database.url}") String url,
			@Value("${database.userName}") String userName,
			@Value("${database.password}") String password,
			@Value("${cp.maxTotal}") int maxTotal,
			@Value("${cp.maxIdle}") int maxIdle,
			@Value("${cp.minIdle}") int minIdle,
			@Value("${cp.maxWaitMillis}") long maxWaitMillis) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
//		dataSource.setPassword(password);
		dataSource.setDefaultAutoCommit(true);
		dataSource.setMaxTotal(maxTotal);
		dataSource.setMaxIdle(maxIdle);
		dataSource.setMinIdle(minIdle);
		dataSource.setMaxWaitMillis(maxWaitMillis);
		return dataSource;
	}
	
	// JDBCの設定
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
