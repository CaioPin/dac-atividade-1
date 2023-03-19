package dac.projeto.controllers.reqeuests;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class PublisherRequest {
    @NotBlank
    @Size(max = 200)
    private String name;

    @NotBlank
    @Size(max = 200)
    private String origin;
}
