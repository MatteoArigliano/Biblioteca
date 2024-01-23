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
public class PrestitoRestMapperImpl implements PrestitoRestMapper {

    @Override
    public PrestitoRest toRest(PrestitoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        PrestitoRest prestitoRest = new PrestitoRest();

        prestitoRest.setId( dto.getId() );
        prestitoRest.setCliente( clienteDTOToClienteRest( dto.getCliente() ) );
        prestitoRest.setLibro( libroDTOToLibroRest( dto.getLibro() ) );
        prestitoRest.setDataScadenza( dto.getDataScadenza() );

        return prestitoRest;
    }

    @Override
    public PrestitoDTO toDto(PrestitoRest rest) {
        if ( rest == null ) {
            return null;
        }

        PrestitoDTO prestitoDTO = new PrestitoDTO();

        prestitoDTO.setId( rest.getId() );
        prestitoDTO.setCliente( clienteRestToClienteDTO( rest.getCliente() ) );
        prestitoDTO.setLibro( libroRestToLibroDTO( rest.getLibro() ) );
        prestitoDTO.setDataScadenza( rest.getDataScadenza() );

        return prestitoDTO;
    }

    @Override
    public List<PrestitoRest> toRestList(List<PrestitoDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<PrestitoRest> list = new ArrayList<PrestitoRest>( dtos.size() );
        for ( PrestitoDTO prestitoDTO : dtos ) {
            list.add( toRest( prestitoDTO ) );
        }

        return list;
    }

    protected ClienteRest clienteDTOToClienteRest(ClienteDTO clienteDTO) {
        if ( clienteDTO == null ) {
            return null;
        }

        ClienteRest clienteRest = new ClienteRest();

        clienteRest.setId( clienteDTO.getId() );
        clienteRest.setNome( clienteDTO.getNome() );
        clienteRest.setCognome( clienteDTO.getCognome() );
        clienteRest.setPrestiti( toRestList( clienteDTO.getPrestiti() ) );

        return clienteRest;
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
        libroRest.setPrestiti( toRestList( libroDTO.getPrestiti() ) );

        return libroRest;
    }

    protected List<PrestitoDTO> prestitoRestListToPrestitoDTOList(List<PrestitoRest> list) {
        if ( list == null ) {
            return null;
        }

        List<PrestitoDTO> list1 = new ArrayList<PrestitoDTO>( list.size() );
        for ( PrestitoRest prestitoRest : list ) {
            list1.add( toDto( prestitoRest ) );
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
}
