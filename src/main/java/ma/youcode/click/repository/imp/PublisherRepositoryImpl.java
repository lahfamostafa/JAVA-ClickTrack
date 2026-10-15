package ma.youcode.click.repository.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ma.youcode.click.entity.Publisher;
import ma.youcode.click.entity.Categorie;
import ma.youcode.click.repository.PublisherRepository;

public class PublisherRepositoryImpl implements PublisherRepository{
    private final List<Publisher> publishers = new ArrayList<>(List.of(
        new Publisher(1,"Mostafa","Lahfa","mostafa@gmail.com",Categorie.INFLUENCEUR),
        new Publisher(2,"Amine","Mohamed","amine@gmail.com",Categorie.BLOGUEUR),
        new Publisher(3,"Mouad","Ziyani","mouad@gmail.com",Categorie.YOUTUBEUR)
    ));

    @Override 
    public List<Publisher> findAll(){
        return publishers;
    }

    @Override
    public Optional<Publisher> findById(int id) {
        return publishers.stream().filter(p->p.getId() == id).findFirst();
    }

}
