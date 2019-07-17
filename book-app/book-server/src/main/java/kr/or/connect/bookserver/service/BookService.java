package kr.or.connect.bookserver.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import kr.or.connect.domain.Book;

@Service
public class BookService {
	private ConcurrentMap<Integer, Book> repo = new ConcurrentHashMap<>();
	private AtomicInteger maxId = new AtomicInteger(0);

	public Book findById(Integer id) {
		return repo.get(id);
	}

	public Collection<Book> findAll() {
		return repo.values();
	}

	public Book create(Book book) {
		Integer id = maxId.addAndGet(1);
		book.setId(id);
		repo.put(id, book);
		return book;
	}
	public boolean update(Book book) {
		Book old = repo.put(book.getId(), book);
		return old != null;
	}
	public boolean delete(Integer id) {
		Book old = repo.remove(id);
		return old != null;
	}
}
