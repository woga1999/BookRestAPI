package kr.or.connect;

import javax.sql.DataSource;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.bookserver.persistence.BookDao;

public class BookLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		DataSource dataSource = context.getBean(DataSource.class);
		BookDao dao = new BookDao(dataSource);
		int count = dao.countBooks();
		System.out.println(count);
		context.close();
	}
}
