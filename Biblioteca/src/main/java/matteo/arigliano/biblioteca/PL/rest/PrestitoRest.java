package matteo.arigliano.biblioteca.PL.rest;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PrestitoRest {

    private Integer id;
    private ClienteRest cliente;
    private LibroRest libro;
    private LocalDate dataScadenza;
}
