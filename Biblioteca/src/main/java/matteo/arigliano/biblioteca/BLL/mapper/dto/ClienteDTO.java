package matteo.arigliano.biblioteca.BLL.mapper.dto;

import lombok.Data;

import java.util.List;

@Data
public class ClienteDTO {

    private Integer id;
    private String nome;
    private String cognome;
    List<PrestitoDTO> prestiti;
}
