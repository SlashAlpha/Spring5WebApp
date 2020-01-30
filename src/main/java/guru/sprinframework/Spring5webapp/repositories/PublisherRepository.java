package guru.sprinframework.Spring5webapp.repositories;

import guru.sprinframework.Spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
