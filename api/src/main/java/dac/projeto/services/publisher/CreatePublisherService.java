package dac.projeto.services.publisher;

import dac.projeto.controllers.reqeuests.PublisherRequest;
import dac.projeto.controllers.responses.PublisherResponse;
import dac.projeto.domains.Publisher;
import dac.projeto.mappers.PublisherMapper;
import dac.projeto.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreatePublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    @Transactional
    public PublisherResponse createPublisher(PublisherRequest request) {
        Publisher publisher = PublisherMapper.toEntity(request);
        publisherRepository.save(publisher);
        return PublisherMapper.toResponse(publisher);
    }
}
