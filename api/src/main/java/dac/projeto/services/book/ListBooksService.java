package dac.projeto.services.book;

import dac.projeto.controllers.responses.BookResponse;
import dac.projeto.mappers.BookMapper;
import dac.projeto.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListBooksService {
    @Autowired
    private BookRepository bookRepository;

    public List<BookResponse> listBooks() {
        return bookRepository.findAll()
                .stream()
                .map(BookMapper::toResponse)
                .collect(Collectors.toList());
    }
}
