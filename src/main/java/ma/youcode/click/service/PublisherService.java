package ma.youcode.click.service;

import java.util.List;
import ma.youcode.click.entity.Publisher;
import ma.youcode.click.repository.PublisherRepository;

public class PublisherService {
    private final PublisherRepository repository;

    public PublisherService(PublisherRepository repository){
        this.repository = repository;
    }

    public List<Publisher> findAll(){
        return repository.findAll();
    }
}
