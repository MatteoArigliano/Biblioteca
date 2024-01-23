package matteo.arigliano.biblioteca.PL.mapper;

import java.util.List;

public interface GenericRestMapper<D, R> {

    R toRest(D dto);
    D toDto(R rest);
    List<R> toRestList(List<D> dtos);

}
