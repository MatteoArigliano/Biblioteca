package matteo.arigliano.biblioteca.BLL.mapper.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PrestitoDTO {

    private Integer id;
    private ClienteDTO cliente;
    private LibroDTO libro;
    private LocalDate dataScadenza;
}
