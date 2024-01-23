package matteo.arigliano.biblioteca.BLL.mapper.dto;

import lombok.Data;

import java.util.List;

@Data
public class LibroDTO {

    private Integer id;
    private String titolo;
    private String autore;
    private String ristampa;
    private boolean prestato;
    private Integer ISBN;
    List<PrestitoDTO> prestiti;
}
