package matteo.arigliano.biblioteca.PL.mapper;

import matteo.arigliano.biblioteca.BLL.mapper.dto.ClienteDTO;
import matteo.arigliano.biblioteca.PL.rest.ClienteRest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteRestMapper extends GenericRestMapper<ClienteDTO, ClienteRest>{
}
