package mk.ukim.finki.emt.lab.model;


import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String continent;

    public Country(long id, String name, String continent) {
        this.id = id;
        this.name = name;
        this.continent = continent;
    }

    public Country() {
    }

    public Country(String name, String continent) {
    }
}