package matteo.arigliano.biblioteca.PL.rest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class LibroRest {

    private Integer id;
    private String titolo;
    private String autore;
    private String ristampa;
    private boolean prestato;
    private Integer ISBN;
    @JsonIgnore
    List<PrestitoRest> prestiti;
}
