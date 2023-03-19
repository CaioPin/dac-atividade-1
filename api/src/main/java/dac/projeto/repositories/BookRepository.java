package dac.projeto.repositories;

import dac.projeto.domains.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
