package dac.projeto.mappers;

import dac.projeto.controllers.reqeuests.PublisherRequest;
import dac.projeto.controllers.responses.PublisherResponse;
import dac.projeto.domains.Publisher;

public class PublisherMapper {
    public static Publisher toEntity(PublisherRequest request) {
        return Publisher.builder()
                .name(request.getName())
                .origin(request.getOrigin())
                .build();
    }

    public static PublisherResponse toResponse(Publisher entity) {
        return PublisherResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .origin(entity.getOrigin())
                .build();
    }
}
