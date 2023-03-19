package dac.projeto.controllers;

import dac.projeto.controllers.reqeuests.PublisherRequest;
import dac.projeto.controllers.responses.PublisherResponse;
import dac.projeto.services.publisher.CreatePublisherService;
import dac.projeto.services.publisher.DeletePublisherService;
import dac.projeto.services.publisher.EditPublisherService;
import dac.projeto.services.publisher.ListPublishersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/publishers")
public class PublisherController {
    @Autowired
    private CreatePublisherService createPublisherService;

    @Autowired
    private DeletePublisherService deletePublisherService;

    @Autowired
    private EditPublisherService editPublisherService;

    @Autowired
    private ListPublishersService listPublishersService;

    @GetMapping
    public List<PublisherResponse> listPublishers() {
        return listPublishersService.listPublishers();
    }

    @PostMapping
    public PublisherResponse createPublisher(@Valid @RequestBody PublisherRequest request) {
        return createPublisherService.createPublisher(request);
    }

    @PutMapping("/{id}")
    public PublisherResponse editPublisher(@PathVariable Long id, @Valid @RequestBody PublisherRequest request) {
        return editPublisherService.editPublisher(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePublisher(@PathVariable Long id) {
        deletePublisherService.deletePublisher(id);
    }
}
