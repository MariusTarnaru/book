package book.demo;


import book.demo.Model.Book;
import book.demo.Repository.BookRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

public class BookstoreApplication {

    @Bean
    ApplicationRunner init (BookRepository bookRepository){

        return args -> {
            Stream.of(new Book(null, "Horton Hears a Who", "Dr. Seuss"),
                    new Book(null, "Brave new World", "Aldous Huxley")).forEach(book -> {
                        bookRepository.save(book);
            });
            bookRepository.findAll().forEach(System.out::println);
        };
    }

}
