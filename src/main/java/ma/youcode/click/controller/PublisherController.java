package ma.youcode.click.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ma.youcode.click.entity.*;

import ma.youcode.click.service.PublisherService;

@RestController 
@RequestMapping("api/publishers")
public class PublisherController{
    
    private final PublisherService publisherService;
    public PublisherController(PublisherService publisherService){
        this.publisherService = publisherService;
    }

    @GetMapping 
    public List<Publisher> findAll(){
        return publisherService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publisher> findById(@PathVariable("id") int id){
        Optional<Publisher> publisher = publisherService.findById(id);

        return publisher
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
