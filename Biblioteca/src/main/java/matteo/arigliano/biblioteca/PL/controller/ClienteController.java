package matteo.arigliano.biblioteca.PL.controller;

import lombok.RequiredArgsConstructor;
import matteo.arigliano.biblioteca.BLL.service.abstracts.ClienteService;
import matteo.arigliano.biblioteca.PL.mapper.ClienteRestMapper;
import matteo.arigliano.biblioteca.PL.rest.ClienteRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import java.nio.file.FileAlreadyExistsException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;
    private final ClienteRestMapper clienteRestMapper;

    @GetMapping
    private ResponseEntity<List<ClienteRest>> getAllClients(){
        return new ResponseEntity<>(clienteRestMapper.toRestList(clienteService.getAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<ClienteRest> findById(@PathVariable("id") Integer id){
        try {
            return new ResponseEntity<>(clienteRestMapper.toRest(clienteService.getById(id)), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    private ResponseEntity<ClienteRest> insertAuthor(@RequestBody ClienteRest cliente){
        try {
            return new ResponseEntity<>(clienteRestMapper.toRest(clienteService.insert(clienteRestMapper.toDto(cliente))), HttpStatus.CREATED);
        } catch (FileAlreadyExistsException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    private ResponseEntity<ClienteRest> updateAuthor(@RequestBody ClienteRest cliente){
        try {
            return new ResponseEntity<>(clienteRestMapper.toRest(clienteService.update(clienteRestMapper.toDto(cliente))), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteAuthorById(@PathVariable Integer id){
        try {
            clienteService.getById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
