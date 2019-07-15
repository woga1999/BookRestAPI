package kr.or.connect.bookserver.persistence;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.AppConfig;
import kr.or.connect.domain.Book; 

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@Transactional
public class BookDaoTest {
	@Autowired
	private BookDao dao;
	
	@Test
	public void shouldCount() {
		int count = dao.countBooks();
		System.out.println(count);
	}
	
	@Test
	public void shouldInsertAndSelect() {
		Book book = new Book("Java 웹개발", "네이버",342);
		
		Integer id = dao.insert(book);
		
		Book selected = dao.selectById(id);
		System.out.println(selected);
		
		assertThat(selected.getTitle(), is("Java 웹개발"));
	}
	
	@Test
	public void shouldDelete() {
		Book book = new Book("네이버 자바", "네이버", 142);
		Integer id = dao.insert(book);

		int affected = dao.deleteById(id);

		assertThat(affected, is(1));
	}
	@Test
	public void shouldUpdate() {
		// Given
		Book book = new Book("네이버 자바", "네이버", 142);
		Integer id = dao.insert(book);

		// When
		book.setId(id);
		book.setTitle("네이버 자바2");
		int affected = dao.update(book);

		// Then
		assertThat(affected, is(1));
		Book updated = dao.selectById(id);
		assertThat(updated.getTitle(), is("네이버 자바2"));
	}
}
