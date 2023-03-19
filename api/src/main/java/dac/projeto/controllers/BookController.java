package dac.projeto.controllers;

import dac.projeto.controllers.reqeuests.BookRequest;
import dac.projeto.controllers.responses.BookResponse;
import dac.projeto.services.book.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private CreateBookService createBookService;

    @Autowired
    private DeleteBookService deleteBookService;

    @Autowired
    private EditBookService editBookService;

    @Autowired
    private ListBooksService listBooksService;

    @GetMapping
    public List<BookResponse> getBooks() {
        return listBooksService.listBooks();
    }

    @PostMapping
    public BookResponse createBook(@Valid @RequestBody BookRequest request) {
        return createBookService.createBook(request);
    }

    @PutMapping("/{id}")
    public BookResponse editBook(@PathVariable Long id, @Valid @RequestBody BookRequest request) {
        return editBookService.editBook(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id) {
        deleteBookService.deleteBook(id);
    }
}
