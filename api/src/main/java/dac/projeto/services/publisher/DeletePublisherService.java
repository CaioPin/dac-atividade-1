package dac.projeto.services.publisher;

import dac.projeto.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeletePublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    @Transactional
    public void deletePublisher(Long id) {
        publisherRepository.deleteById(id);
    }
}
