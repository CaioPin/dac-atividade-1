package dac.projeto.controllers.responses;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class BookResponse {
    private Long id;
    private String title;
    private LocalDate releaseDate;
}
