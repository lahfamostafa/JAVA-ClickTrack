package ma.youcode.click.repository;

import java.util.List;

import ma.youcode.click.entity.Publisher;

public interface PublisherRepository {
    List<Publisher> findAll();
}
