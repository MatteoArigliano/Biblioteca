package matteo.arigliano.biblioteca.BLL.service.impl;

import lombok.RequiredArgsConstructor;
import matteo.arigliano.biblioteca.BLL.mapper.dto.PrestitoDTO;
import matteo.arigliano.biblioteca.BLL.mapper.impl.PrestitoDTOMapper;
import matteo.arigliano.biblioteca.BLL.service.abstracts.PrestitoService;
import matteo.arigliano.biblioteca.DAL.repository.PrestitoRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.nio.file.FileAlreadyExistsException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PrestitoServiceImpl implements PrestitoService {

    private final PrestitoRepository prestitoRepository;
    private final PrestitoDTOMapper prestitoDTOMapper;

    @Override
    public PrestitoDTO insert(PrestitoDTO dto) throws FileAlreadyExistsException {
        if(prestitoRepository.existsById(dto.getId()))
            throw new FileAlreadyExistsException("Prestito already exists");
        return prestitoDTOMapper.toDTO(prestitoRepository.save(prestitoDTOMapper.toEntity(dto)));
    }

    @Override
    public PrestitoDTO getById(Integer id) throws NotFoundException {
        if(!prestitoRepository.existsById(id))
            throw new NotFoundException("Prestito not found in DB");
        return prestitoDTOMapper.toDTO(prestitoRepository.findPrestitoEntityById(id));
    }

    @Override
    public List<PrestitoDTO> getAll() {
        return prestitoDTOMapper.toDTOList(prestitoRepository.findAll());
    }

    @Override
    public PrestitoDTO update(PrestitoDTO dto) throws NotFoundException {
        if(!prestitoRepository.existsById(dto.getId()))
            throw new NotFoundException("Prestito not found in DB");
        return prestitoDTOMapper.toDTO(prestitoRepository.save(prestitoDTOMapper.toEntity(dto)));
    }

    @Override
    public void delete(Integer id) throws NotFoundException {
        if(!prestitoRepository.existsById(id))
            throw new NotFoundException("Prestito not found in DB");
        prestitoRepository.deleteById(id);
    }
}
