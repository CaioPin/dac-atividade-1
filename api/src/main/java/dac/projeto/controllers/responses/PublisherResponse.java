package dac.projeto.controllers.responses;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PublisherResponse {
    private Long id;
    private String name;
    private String origin;
}
