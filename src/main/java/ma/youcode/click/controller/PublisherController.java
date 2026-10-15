package ma.youcode.click.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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
}
