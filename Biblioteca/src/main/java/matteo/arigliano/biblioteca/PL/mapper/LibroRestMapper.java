package matteo.arigliano.biblioteca.PL.mapper;

import matteo.arigliano.biblioteca.BLL.mapper.dto.LibroDTO;
import matteo.arigliano.biblioteca.PL.rest.LibroRest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LibroRestMapper extends GenericRestMapper<LibroDTO, LibroRest> {
}
