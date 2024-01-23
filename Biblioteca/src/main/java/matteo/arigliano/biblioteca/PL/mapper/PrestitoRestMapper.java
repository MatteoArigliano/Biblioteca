package matteo.arigliano.biblioteca.PL.mapper;

import matteo.arigliano.biblioteca.BLL.mapper.dto.PrestitoDTO;
import matteo.arigliano.biblioteca.PL.rest.PrestitoRest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PrestitoRestMapper extends GenericRestMapper<PrestitoDTO, PrestitoRest>{
}
