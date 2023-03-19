package dac.projeto.controllers.reqeuests;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
public class BookRequest {
    @NotBlank
    @Size(max = 200)
    private String title;

    @NotNull
    private LocalDate releaseDate;
}
