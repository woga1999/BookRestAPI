package kr.or.connect.bookserver.service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.stereotype.Service;

import kr.or.connect.domain.Book;

@Service
public class BookService {
	
	public Book findById(Integer id) {
		return new Book(1,"Java 이렇게 공부하자", "김자바", 300);
	}
	
	public Collection<Book> findAll(){
		return Arrays.asList(
				new Book(1, "네이버 네비 좋아요","김광근",321),
				new Book(2,"HTTP 완벽 이해하기", "박웹프", 126)
				);
	}
}
