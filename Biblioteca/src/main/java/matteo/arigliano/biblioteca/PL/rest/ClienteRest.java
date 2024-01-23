package matteo.arigliano.biblioteca.PL.rest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class ClienteRest {

    private Integer id;
    private String nome;
    private String cognome;
    @JsonIgnore
    List<PrestitoRest> prestiti;
}
