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
    date = "2024-01-23T14:23:07+0100",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class ClienteRestMapperImpl implements ClienteRestMapper {

    @Override
    public ClienteRest toRest(ClienteDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ClienteRest clienteRest = new ClienteRest();

        clienteRest.setId( dto.getId() );
        clienteRest.setNome( dto.getNome() );
        clienteRest.setCognome( dto.getCognome() );
        clienteRest.setPrestiti( prestitoDTOListToPrestitoRestList( dto.getPrestiti() ) );

        return clienteRest;
    }

    @Override
    public ClienteDTO toDto(ClienteRest rest) {
        if ( rest == null ) {
            return null;
        }

        ClienteDTO clienteDTO = new ClienteDTO();

        clienteDTO.setId( rest.getId() );
        clienteDTO.setNome( rest.getNome() );
        clienteDTO.setCognome( rest.getCognome() );
        clienteDTO.setPrestiti( prestitoRestListToPrestitoDTOList( rest.getPrestiti() ) );

        return clienteDTO;
    }

    @Override
    public List<ClienteRest> toRestList(List<ClienteDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<ClienteRest> list = new ArrayList<ClienteRest>( dtos.size() );
        for ( ClienteDTO clienteDTO : dtos ) {
            list.add( toRest( clienteDTO ) );
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

    protected LibroRest libroDTOToLibroRest(LibroDTO libroDTO) {
        if ( libroDTO == null ) {
            return null;
        }

        LibroRest libroRest = new LibroRest();

        libroRest.setId( libroDTO.getId() );
        libroRest.setTitolo( libroDTO.getTitolo() );
        libroRest.setAutore( libroDTO.getAutore() );
        libroRest.setRistampa( libroDTO.getRistampa() );
        libroRest.setPrestato( libroDTO.isPrestato() );
        libroRest.setISBN( libroDTO.getISBN() );
        libroRest.setPrestiti( prestitoDTOListToPrestitoRestList( libroDTO.getPrestiti() ) );

        return libroRest;
    }

    protected PrestitoRest prestitoDTOToPrestitoRest(PrestitoDTO prestitoDTO) {
        if ( prestitoDTO == null ) {
            return null;
        }

        PrestitoRest prestitoRest = new PrestitoRest();

        prestitoRest.setId( prestitoDTO.getId() );
        prestitoRest.setCliente( toRest( prestitoDTO.getCliente() ) );
        prestitoRest.setLibro( libroDTOToLibroRest( prestitoDTO.getLibro() ) );
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

    protected LibroDTO libroRestToLibroDTO(LibroRest libroRest) {
        if ( libroRest == null ) {
            return null;
        }

        LibroDTO libroDTO = new LibroDTO();

        libroDTO.setId( libroRest.getId() );
        libroDTO.setTitolo( libroRest.getTitolo() );
        libroDTO.setAutore( libroRest.getAutore() );
        libroDTO.setRistampa( libroRest.getRistampa() );
        libroDTO.setPrestato( libroRest.isPrestato() );
        libroDTO.setISBN( libroRest.getISBN() );
        libroDTO.setPrestiti( prestitoRestListToPrestitoDTOList( libroRest.getPrestiti() ) );

        return libroDTO;
    }

    protected PrestitoDTO prestitoRestToPrestitoDTO(PrestitoRest prestitoRest) {
        if ( prestitoRest == null ) {
            return null;
        }

        PrestitoDTO prestitoDTO = new PrestitoDTO();

        prestitoDTO.setId( prestitoRest.getId() );
        prestitoDTO.setCliente( toDto( prestitoRest.getCliente() ) );
        prestitoDTO.setLibro( libroRestToLibroDTO( prestitoRest.getLibro() ) );
        prestitoDTO.setDataScadenza( prestitoRest.getDataScadenza() );

        return prestitoDTO;
    }
}
