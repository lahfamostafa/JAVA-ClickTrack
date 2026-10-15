package ma.youcode.click.repository;

import java.util.List;
import java.util.Optional;

import ma.youcode.click.entity.Publisher;

public interface PublisherRepository {
    List<Publisher> findAll();
    Optional<Publisher> findById(int id);
}
