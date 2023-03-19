package dac.projeto.services.publisher;

import dac.projeto.controllers.responses.PublisherResponse;
import dac.projeto.mappers.PublisherMapper;
import dac.projeto.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListPublishersService {
    @Autowired
    private PublisherRepository publisherRepository;

    public List<PublisherResponse> listPublishers() {
        return publisherRepository.findAll()
                .stream()
                .map(PublisherMapper::toResponse)
                .collect(Collectors.toList());
    }
}
