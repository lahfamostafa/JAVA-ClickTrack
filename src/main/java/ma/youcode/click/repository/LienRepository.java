package ma.youcode.click.repository;

import java.util.List;
import java.util.Optional;

import ma.youcode.click.dto.ClickDto;
import ma.youcode.click.dto.OffreDto;
import ma.youcode.click.entity.*;

public interface LienRepository {
    Lien save(Lien lien);
    List<ClickDto> findAll();
    List<ClickDto> getLiensForPublisher(Publisher publisher);
    List<OffreDto> getOffresForPublisher(int publisherId);
    Optional<Lien> findById(int id);
    Optional<Lien> incremente(int lienId);
}
