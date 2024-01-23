package matteo.arigliano.biblioteca.PL.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import matteo.arigliano.biblioteca.BLL.mapper.dto.ClienteDTO;
import matteo.arigliano.biblioteca.BLL.mapper.dto.LibroDTO;
import matteo.arigliano.biblioteca.BLL.mapper.dto.PrestitoDTO;
import matteo.arigliano.biblioteca.PL.rest.ClienteRest;
import matteo.arigliano.biblioteca.PL.rest.LibroRest;
import matteo.arigliano.biblioteca.PL.rest.PrestitoRest;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-23T14:23:08+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class LibroRestMapperImpl implements LibroRestMapper {

    @Override
    public LibroRest toRest(LibroDTO dto) {
        if ( dto == null ) {
            return null;
        }

        LibroRest libroRest = new LibroRest();

        libroRest.setId( dto.getId() );
        libroRest.setTitolo( dto.getTitolo() );
        libroRest.setAutore( dto.getAutore() );
        libroRest.setRistampa( dto.getRistampa() );
        libroRest.setPrestato( dto.isPrestato() );
        libroRest.setISBN( dto.getISBN() );
        libroRest.setPrestiti( prestitoDTOListToPrestitoRestList( dto.getPrestiti() ) );

        return libroRest;
    }

    @Override
    public LibroDTO toDto(LibroRest rest) {
        if ( rest == null ) {
            return null;
        }

        LibroDTO libroDTO = new LibroDTO();

        libroDTO.setId( rest.getId() );
        libroDTO.setTitolo( rest.getTitolo() );
        libroDTO.setAutore( rest.getAutore() );
        libroDTO.setRistampa( rest.getRistampa() );
        libroDTO.setPrestato( rest.isPrestato() );
        libroDTO.setISBN( rest.getISBN() );
        libroDTO.setPrestiti( prestitoRestListToPrestitoDTOList( rest.getPrestiti() ) );

        return libroDTO;
    }

    @Override
    public List<LibroRest> toRestList(List<LibroDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<LibroRest> list = new ArrayList<LibroRest>( dtos.size() );
        for ( LibroDTO libroDTO : dtos ) {
            list.add( toRest( libroDTO ) );
        }

        return list;
    }

    protected List<PrestitoRest> prestitoDTOListToPrestitoRestList(List<PrestitoDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<PrestitoRest> list1 = new ArrayList<PrestitoRest>( list.size() );
        for ( PrestitoDTO prestitoDTO : list ) {
            list1.add( prestitoDTOToPrestitoRest( prestitoDTO ) );
        }

        return list1;
    }

    protected ClienteRest clienteDTOToClienteRest(ClienteDTO clienteDTO) {
        if ( clienteDTO == null ) {
            return null;
        }

        ClienteRest clienteRest = new ClienteRest();

        clienteRest.setId( clienteDTO.getId() );
        clienteRest.setNome( clienteDTO.getNome() );
        clienteRest.setCognome( clienteDTO.getCognome() );
        clienteRest.setPrestiti( prestitoDTOListToPrestitoRestList( clienteDTO.getPrestiti() ) );

        return clienteRest;
    }

    protected PrestitoRest prestitoDTOToPrestitoRest(PrestitoDTO prestitoDTO) {
        if ( prestitoDTO == null ) {
            return null;
        }

        PrestitoRest prestitoRest = new PrestitoRest();

        prestitoRest.setId( prestitoDTO.getId() );
        prestitoRest.setCliente( clienteDTOToClienteRest( prestitoDTO.getCliente() ) );
        prestitoRest.setLibro( toRest( prestitoDTO.getLibro() ) );
        prestitoRest.setDataScadenza( prestitoDTO.getDataScadenza() );

        return prestitoRest;
    }

    protected List<PrestitoDTO> prestitoRestListToPrestitoDTOList(List<PrestitoRest> list) {
        if ( list == null ) {
            return null;
        }

        List<PrestitoDTO> list1 = new ArrayList<PrestitoDTO>( list.size() );
        for ( PrestitoRest prestitoRest : list ) {
            list1.add( prestitoRestToPrestitoDTO( prestitoRest ) );
        }

        return list1;
    }

    protected ClienteDTO clienteRestToClienteDTO(ClienteRest clienteRest) {
        if ( clienteRest == null ) {
            return null;
        }

        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setId( clienteRest.getId() );
        clienteDTO.setNome( clienteRest.getNome() );
        clienteDTO.setCognome( clienteRest.getCognome() );
        clienteDTO.setPrestiti( prestitoRestListToPrestitoDTOList( clienteRest.getPrestiti() ) );

        return clienteDTO;
    }

    protected PrestitoDTO prestitoRestToPrestitoDTO(PrestitoRest prestitoRest) {
        if ( prestitoRest == null ) {
            return null;
        }

        PrestitoDTO prestitoDTO = new PrestitoDTO();

        prestitoDTO.setId( prestitoRest.getId() );
        prestitoDTO.setCliente( clienteRestToClienteDTO( prestitoRest.getCliente() ) );
        prestitoDTO.setLibro( toDto( prestitoRest.getLibro() ) );
        prestitoDTO.setDataScadenza( prestitoRest.getDataScadenza() );

        return prestitoDTO;
    }
}
