package matteo.arigliano.biblioteca.DAL.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "libro")
@Getter
@Setter
public class LibroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String titolo;

    private String autore;

    private String ristampa;

    private boolean prestato;

    private Integer ISBN;

    @OneToMany(mappedBy = "libro")
    List<PrestitoEntity> prestiti;
}
