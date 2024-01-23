package matteo.arigliano.biblioteca.BLL.service.impl;

import lombok.RequiredArgsConstructor;
import matteo.arigliano.biblioteca.BLL.mapper.dto.ClienteDTO;
import matteo.arigliano.biblioteca.BLL.mapper.impl.ClienteDTOMapper;
import matteo.arigliano.biblioteca.BLL.service.abstracts.ClienteService;
import matteo.arigliano.biblioteca.DAL.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.nio.file.FileAlreadyExistsException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteDTOMapper clienteDTOMapper;

    @Override
    public ClienteDTO insert(ClienteDTO dto) throws FileAlreadyExistsException {
        if(clienteRepository.existsById(dto.getId()))
            throw new FileAlreadyExistsException("Cliente already exists");
        return clienteDTOMapper.toDTO(clienteRepository.save(clienteDTOMapper.toEntity(dto)));
    }

    @Override
    public ClienteDTO getById(Integer id) throws NotFoundException {
        if(!clienteRepository.existsById(id))
            throw new NotFoundException("Cliente not found in DB");
        return clienteDTOMapper.toDTO(clienteRepository.findClienteEntityById(id));
    }

    @Override
    public List<ClienteDTO> getAll() {
        return clienteDTOMapper.toDTOList(clienteRepository.findAll());
    }

    @Override
    public ClienteDTO update(ClienteDTO dto) throws NotFoundException {
        if(!clienteRepository.existsById(dto.getId()))
            throw new NotFoundException("Cliente not found in DB");
        return clienteDTOMapper.toDTO(clienteRepository.save(clienteDTOMapper.toEntity(dto)));
    }

    @Override
    public void delete(Integer id) throws NotFoundException {
        if(!clienteRepository.existsById(id))
            throw new NotFoundException("Cliente not found in DB");
        clienteRepository.deleteById(id);
    }
}
