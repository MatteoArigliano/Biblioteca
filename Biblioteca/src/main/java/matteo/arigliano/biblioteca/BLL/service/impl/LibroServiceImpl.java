package matteo.arigliano.biblioteca.BLL.service.impl;

import lombok.RequiredArgsConstructor;
import matteo.arigliano.biblioteca.BLL.mapper.dto.LibroDTO;
import matteo.arigliano.biblioteca.BLL.mapper.impl.LibroDTOMapper;
import matteo.arigliano.biblioteca.BLL.service.abstracts.LibroService;
import matteo.arigliano.biblioteca.DAL.repository.LibroRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.nio.file.FileAlreadyExistsException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;
    private final LibroDTOMapper libroDTOMapper;

    @Override
    public LibroDTO insert(LibroDTO dto) throws FileAlreadyExistsException {
        if(libroRepository.existsById(dto.getId()))
            throw new FileAlreadyExistsException("Libro already exists");
        return libroDTOMapper.toDTO(libroRepository.save(libroDTOMapper.toEntity(dto)));
    }

    @Override
    public LibroDTO getById(Integer id) throws NotFoundException {
        if(!libroRepository.existsById(id))
            throw new NotFoundException("Libro not found in DB");
        return libroDTOMapper.toDTO(libroRepository.findLibroEntityById(id));
    }

    @Override
    public List<LibroDTO> getAll() {
        return libroDTOMapper.toDTOList(libroRepository.findAll());
    }

    @Override
    public LibroDTO update(LibroDTO dto) throws NotFoundException {
        if(!libroRepository.existsById(dto.getId()))
            throw new NotFoundException("Libro not found in DB");
        return libroDTOMapper.toDTO(libroRepository.save(libroDTOMapper.toEntity(dto)));
    }

    @Override
    public void delete(Integer id) throws NotFoundException {
        if(!libroRepository.existsById(id))
            throw new NotFoundException("Libro not found in DB");
        libroRepository.deleteById(id);
    }
}
