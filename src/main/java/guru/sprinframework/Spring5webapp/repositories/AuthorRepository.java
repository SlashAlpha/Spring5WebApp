package guru.sprinframework.Spring5webapp.repositories;

import guru.sprinframework.Spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
