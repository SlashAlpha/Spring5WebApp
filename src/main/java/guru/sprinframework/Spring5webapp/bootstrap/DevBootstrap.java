package guru.sprinframework.Spring5webapp.bootstrap;


import guru.sprinframework.Spring5webapp.model.*;
import guru.sprinframework.Spring5webapp.repositories.AuthorRepository;
import guru.sprinframework.Spring5webapp.repositories.BookRepository;
import guru.sprinframework.Spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

//data boostrap

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData() {
        Publisher robertCollins = new Publisher();
        robertCollins.setName("foo");
        publisherRepository.save(robertCollins);
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", robertCollins);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);

        bookRepository.save(ddd);

        Publisher worx = new Publisher();
        worx.setName("whatever");
        publisherRepository.save(worx);
        Author rod = new Author("Rod", "Johnson");

        Book noEJB = new Book("J2EE Development", "2344", worx);
        noEJB.getAuthors().add(rod);
        authorRepository.save(rod);

        bookRepository.save(noEJB);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
