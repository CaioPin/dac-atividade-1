package dac.projeto.mappers;

import dac.projeto.controllers.reqeuests.BookRequest;
import dac.projeto.controllers.responses.BookResponse;
import dac.projeto.domains.Book;

public class BookMapper {
    public static Book toEntity(BookRequest request) {
        return Book.builder()
                .title(request.getTitle())
                .releaseDate(request.getReleaseDate())
                .build();
    }

    public static BookResponse toResponse(Book entity) {
        return BookResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .releaseDate(entity.getReleaseDate())
                .build();
    }
}
