package mk.ukim.finki.emtlab.config;



import mk.ukim.finki.emtlab.model.Author;
import mk.ukim.finki.emtlab.model.Country;
import mk.ukim.finki.emtlab.model.enums.BookCategory;
import mk.ukim.finki.emtlab.service.AuthorService;
import mk.ukim.finki.emtlab.service.BookService;
import mk.ukim.finki.emtlab.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;




@Component
public class DataHolder {

    private final BookService bookService;
    private final CountryService countryService;
    private final AuthorService authorService;


    public DataHolder(BookService bookService, CountryService countryService, AuthorService authorService) {
        this.bookService = bookService;
        this.countryService = countryService;
        this.authorService = authorService;
    }
    @PostConstruct
    public void initData(){
        Country country1 = new Country(1L,"Russia","Europe");
        this.countryService.create(1L,"Russia","Europe");
        Country country2 = new Country(2L,"France","Europe");
        this.countryService.create(2L,"France","Europe");

        Author author1 = new Author(1L,"Leo","Tolstoy", country1);
        this.authorService.create(1L,"Leo","Tolstoy", country1);
        Author author2 = new Author(2L,"Jules","Verne", country2);
        this.authorService.create(2L,"Jules","Verne", country2);

        this.bookService.create(1L,"Book1", BookCategory.NOVEL,author1,3);
        this.bookService.create(2L,"Book2",BookCategory.DRAMA,author1,1);
        this.bookService.create(3L,"Book3",BookCategory.THRILER,author1,7);
        this.bookService.create(4L,"Book4",BookCategory.CLASSICS,author2,2);

    }
}
