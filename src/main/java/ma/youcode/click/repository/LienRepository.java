package ma.youcode.click.repository;

import java.util.List;
import java.util.Optional;

import ma.youcode.click.entity.*;

public interface LienRepository {
    Lien save(Lien lien);
    List<Lien> findAll();
    List<Lien> getLiensForPublisher(Publisher publisher);
    List<Lien> getLiensForOffres(String offre);
    Optional<Lien> findById(int id);
}
