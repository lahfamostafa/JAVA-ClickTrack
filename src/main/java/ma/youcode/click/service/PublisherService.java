package ma.youcode.click.service;

import ma.youcode.click.repository.PublisherRepository;

public class PublisherService {
    private final PublisherRepository repository;

    public PublisherService(PublisherRepository repository){
        this.repository = repository;
    }
}
