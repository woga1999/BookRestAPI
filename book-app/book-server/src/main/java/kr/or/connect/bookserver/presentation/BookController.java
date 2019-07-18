package kr.or.connect.bookserver.presentation;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.bookserver.service.BookService;
import kr.or.connect.domain.Book;

@RestController
@RequestMapping("/api/books")
public class BookController {
	private final BookService service;
	private final Logger log = LoggerFactory.getLogger(BookController.class);
	
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
	
//	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED)
//	Book create(@RequestBody Book book) {
//		return service.create(book);
//	}
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void update(@PathVariable Integer id, @RequestBody Book book) {
		book.setId(id);
		service.update(book);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	Book create(@RequestBody Book book) {
		Book newBook = service.create(book);
		log.info("book created : {}" , newBook);
		return book;
	}
}
