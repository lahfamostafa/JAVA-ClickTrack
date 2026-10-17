package ma.youcode.click.repository.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ma.youcode.click.entity.Lien;
import ma.youcode.click.entity.Publisher;
import ma.youcode.click.repository.*;

public class LienRepositoryImpl implements LienRepository {

    private final List<Lien> liens = new ArrayList<>();
    private int nextId = 1;

    @Override
    public Lien save(Lien lien) {
        lien.setId(nextId++);
        lien.setClicks(0);
        liens.add(lien);
        return lien;
    }

    @Override
    public List<Lien> getLiensForPublisher(Publisher publisher) {
        return liens.stream().filter(p->p.getPublisher().getId() == publisher.getId()).toList();
    }

    @Override
    public List<Lien> getLiensForOffres(String offre) {
        return liens.stream().filter(o->o.getOffre().equals(offre)).toList();
    }

    @Override
    public Optional<Lien> findById(int id) {
        return liens.stream().filter(i->i.getId() == id).findFirst();
    }

    @Override
    public List<Lien> findAll() {
        return liens;
    }
    
}
