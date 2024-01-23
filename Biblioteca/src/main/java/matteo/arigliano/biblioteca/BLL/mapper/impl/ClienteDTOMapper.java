package matteo.arigliano.biblioteca.BLL.mapper.impl;

import matteo.arigliano.biblioteca.BLL.mapper.dto.ClienteDTO;
import matteo.arigliano.biblioteca.BLL.mapper.generic.GenericDTOMapper;
import matteo.arigliano.biblioteca.DAL.entity.ClienteEntity;

public interface ClienteDTOMapper extends GenericDTOMapper<ClienteEntity, ClienteDTO> {
    /*
    @Override
    AuthorDTO toDTO(AuthorEntity entity);

    @Override
    AuthorEntity toEntity(AuthorDTO dto);

    @Override
    List<AuthorDTO> toDTOList(List<AuthorEntity> entityList);

    @Override
    List<AuthorEntity> toEntityList(List<AuthorDTO> dtos);

 */
}
