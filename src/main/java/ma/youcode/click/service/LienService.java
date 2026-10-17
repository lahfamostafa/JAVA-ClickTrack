package ma.youcode.click.service;

import java.util.List;
import java.util.Optional;

import ma.youcode.click.RequestDto;
import ma.youcode.click.entity.Lien;
import ma.youcode.click.entity.Publisher;
import ma.youcode.click.repository.LienRepository;
import ma.youcode.click.repository.PublisherRepository;

public class LienService {

    private final LienRepository repository;
    private final PublisherRepository publisherRepository;

    public LienService(LienRepository repository , PublisherRepository publisherRepository){
        this.repository = repository;
        this.publisherRepository = publisherRepository;
    }
    
    public Lien save(RequestDto reqDto , int publisherId){
        Publisher publisher = publisherRepository.findById(publisherId)
            .orElseThrow(()->
                new IllegalArgumentException("Publisher introuvable : " + publisherId)
            );
        Lien lien = new Lien(reqDto.getOffre(), reqDto.getUrlDestination(), publisher);
        return repository.save(lien);
    }

    public List<Lien> findAll(){
        return repository.findAll();
    }

    public List<Lien> getLiensForPublisher(int publisherId){
        Optional<Publisher> publisher = publisherRepository.findById(publisherId);
        if(publisher.isEmpty())return List.of();

        return repository.getLiensForPublisher(publisher.get());
    }

    public List<Lien> getLiensForOffres(String offre) {
        return repository.getLiensForOffres(offre);
    }

    public Optional<Lien> findById(int id) {
        return repository.findById(id);
    }
}
