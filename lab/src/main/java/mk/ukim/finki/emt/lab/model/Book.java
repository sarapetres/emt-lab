package mk.ukim.finki.emt.lab.model;

import javax.persistence.*;
import lombok.Data;
import mk.ukim.finki.emt.lab.model.enumerations.Category;


@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    private Author author;

    private Integer availableCopies;

    public Book(Long id, String name, Category category, Author author, Integer availableCopies) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public Book() {
    }

    public Book(String name) {
    }

    public Book(String name, Category category, Author author, Integer availableCopies) {
    }
}
