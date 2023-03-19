package dac.projeto.services.book;

import dac.projeto.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteBookService {
    @Autowired
    private BookRepository bookRepository;

    @Transactional
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
