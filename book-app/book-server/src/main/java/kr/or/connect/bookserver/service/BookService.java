package kr.or.connect.bookserver.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import kr.or.connect.bookserver.persistence.BookDao;
import kr.or.connect.domain.Book;


@Service
public class BookService {
	private BookDao dao;

	public BookService(BookDao dao) {
		this.dao = dao;
	}

	public Book findById(Integer id) {
		return dao.selectById(id);
	}

	public Collection<Book> findAll() {
		return dao.selectAll();
	}

	public Book create(Book book) {
		Integer id = dao.insert(book);
		book.setId(id);
		return book;
	}

	public boolean update(Book book) {
		int affected = dao.update(book);
		return affected == 1;
	}

	public boolean delete(Integer id) {
		int affected = dao.deleteById(id);
		return affected == 1;
	}
}
