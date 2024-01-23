package matteo.arigliano.biblioteca.DAL.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "prestito")
@Getter
@Setter
public class PrestitoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "libro_id")
    private LibroEntity libro;

    @Column(nullable = false)
    private LocalDate dataScadenza;

}
