package kr.or.connect;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.or.connect.bookserver.persistence.BookDao;
import kr.or.connect.domain.Book;

public class BookLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		BookDao dao = context.getBean(BookDao.class);
		int count = dao.countBooks();
		System.out.println(count);
		
		Book book = dao.selelctById(1);
		System.out.println(book);
		
		Book book2 = new Book("성호사설", "이익",82);
		Integer newId = dao.insert(book2);
		System.out.println(newId);
		System.out.println(dao.selelctById(newId));
		
		context.close();
	}
}
