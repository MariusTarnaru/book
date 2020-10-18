package book.demo.Controller;

import book.demo.Model.Book;
import book.demo.Repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {
    BookRepository bookRepository;

    public BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books/")
    public Iterable<Book> getBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") Long id){
        return bookRepository.findById(id).get();
    }

    @PostMapping("/books/")
    public HttpStatus addBook(@RequestBody Book book){
        bookRepository.save(book);
        return HttpStatus.CREATED;
    }
}
