package mk.ukim.finki.emt.lab.web;


import mk.ukim.finki.emt.lab.model.Author;
import mk.ukim.finki.emt.lab.model.Book;
import mk.ukim.finki.emt.lab.model.enumerations.Category;
import mk.ukim.finki.emt.lab.model.exceptions.BookNotFoundException;
import mk.ukim.finki.emt.lab.service.AuthorService;
import mk.ukim.finki.emt.lab.service.BookService;
import mk.ukim.finki.emt.lab.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(path ={"/","/books"})
public class BookController {

    private final AuthorService authorService;
    private final BookService bookService;
    private final CountryService countryService;


    public BookController(AuthorService authorService, BookService bookService, CountryService countryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.countryService = countryService;
    }

    @GetMapping
    public List<Book> findAll(){
        return this.bookService.listAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id){
        return this.bookService.findById(id);
    }

    @PostMapping("/add")
    public Book save(String name, Category category,Long authorId,Integer availableCopies) {
        return this.bookService.save(name,category,authorId,availableCopies);
    }

    @PutMapping("/edit/{id}")
    public Book save(@PathVariable Long id,String name, Category category,Long authorId,Integer availableCopies) {
        return this.bookService.edit(id,name,category,authorId,availableCopies);
    }

    @DeleteMapping("/delete/{id}")
    public Book deleteById(@PathVariable Long id) {
        return this.bookService.deleteById(id);
    }

    @PostMapping("/taken/{id}")
    public Book markAsTaken(@PathVariable Long id,Integer availableCopies) {
        return this.bookService.markAsTaken(id,availableCopies);
    }

}
