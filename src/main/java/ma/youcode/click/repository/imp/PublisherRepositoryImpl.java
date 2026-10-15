package ma.youcode.click.repository.imp;

import java.util.ArrayList;
import java.util.List;
import ma.youcode.click.entity.Publisher;
import ma.youcode.click.entity.Categorie;
import ma.youcode.click.repository.PublisherRepository;

public class PublisherRepositoryImpl implements PublisherRepository{
    List<Publisher> publishers = new ArrayList<>(List.of(
        new Publisher(1,"Mostafa","Lahfa","mostafa@gmail.com",Categorie.INFLUENCEUR),
        new Publisher(2,"Amine","Mohamed","amine@gmail.com",Categorie.BLOGUEUR),
        new Publisher(3,"Mouad","Ziyani","mouad@gmail.com",Categorie.YOUTUBEUR)
    ));

    @Override 
    public List<Publisher> findAll(){
        return publishers;
    }

}
