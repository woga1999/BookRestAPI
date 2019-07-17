package kr.or.connect.bookserver.presentation;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.bookserver.service.BookService;
import kr.or.connect.domain.Book;

@RestController
public class BookController {
	private final BookService service;
	
	@Autowired
	public BookController(BookService service) {
		this.service = service;
	}
	
	@GetMapping
	Collection<Book> readList(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	Book read(@PathVariable Integer id) {
		return service.findById(id);
	}
}
