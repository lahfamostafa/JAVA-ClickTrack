package ma.youcode.click.repository;

import java.util.List;
import java.util.Optional;

import ma.youcode.click.dto.OffreDto;
import ma.youcode.click.entity.*;

public interface LienRepository {
    Lien save(Lien lien);
    List<Lien> findAll();
    List<Lien> getLiensForPublisher(Publisher publisher);
    List<OffreDto> getOffresForPublisher(int publisherId);
    Optional<Lien> findById(int id);
}
