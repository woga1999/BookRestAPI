package kr.or.connect;

import kr.or.connect.bookserver.persistence.BookDao;
import org.apache.commons.dbcp2.BasicDataSource;

public class BookLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:~/javaweb/db;AUTO_SERVER=TRUE;DB_CLOSE_ON_EXIT=FALSE;");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		
		BookDao dao = new BookDao(dataSource);
		int count = dao.countBooks();
		System.out.println(count);
	}

}
