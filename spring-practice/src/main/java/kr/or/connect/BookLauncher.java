package kr.or.connect;

import java.util.Collections;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class BookLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:~/javaweb/db;AUTO_SERVER=TRUE;DB_CLOSE_ON_EXIT=FALSE;");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		
		NamedParameterJdbcTemplate jdbc = new NamedParameterJdbcTemplate(dataSource);
		String sql = "SELECT COUNT(*) FROM book";
		Map<String, Object> params = Collections.emptyMap();
		Integer count = jdbc.queryForObject(sql, params, Integer.class);
		System.out.println(count);
	}

}
