package matteo.arigliano.biblioteca.DAL.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "cliente")
@Getter
@Setter
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cognome;

    @OneToMany(mappedBy = "cliente")
    List<PrestitoEntity> prestiti;
}
