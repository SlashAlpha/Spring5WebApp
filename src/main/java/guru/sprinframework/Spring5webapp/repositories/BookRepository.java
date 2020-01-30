package guru.sprinframework.Spring5webapp.repositories;

import guru.sprinframework.Spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
