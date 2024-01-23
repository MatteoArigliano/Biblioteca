package matteo.arigliano.biblioteca.BLL.mapper.generic;

import java.util.List;

public interface GenericDTOMapper<E, D> {
    D toDTO(E entity);
    E toEntity(D dto);
    List<D> toDTOList(List<E> entityList);
    List<E> toEntityList(List<D> dtos);
}
