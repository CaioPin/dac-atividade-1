package dac.projeto.services.book;

import dac.projeto.controllers.reqeuests.BookRequest;
import dac.projeto.controllers.responses.BookResponse;
import dac.projeto.domains.Book;
import dac.projeto.mappers.BookMapper;
import dac.projeto.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateBookService {
    @Autowired
    BookRepository bookRepository;

    @Transactional
    public BookResponse createBook(BookRequest request) {
        Book book = BookMapper.toEntity(request);
        bookRepository.save(book);
        return BookMapper.toResponse(book);
    }
}
