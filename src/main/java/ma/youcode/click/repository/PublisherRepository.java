package ma.youcode.click.repository;

import java.util.List;

import ma.youcode.click.model.Publisher;

public interface PublisherRepository {
    List<Publisher> findAll();
}
