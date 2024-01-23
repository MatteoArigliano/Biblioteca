package matteo.arigliano.biblioteca.BLL.service.abstracts;

import org.webjars.NotFoundException;

import java.nio.file.FileAlreadyExistsException;
import java.util.List;

public interface CRUDService<T> {
    T insert(T dto) throws FileAlreadyExistsException;
    T getById(Integer id) throws NotFoundException;
    List<T> getAll();
    T update(T dto) throws NotFoundException;
    void delete(Integer id) throws NotFoundException;
}
