package matteo.arigliano.biblioteca.PL.controller;

import lombok.RequiredArgsConstructor;
import matteo.arigliano.biblioteca.BLL.service.abstracts.LibroService;
import matteo.arigliano.biblioteca.PL.mapper.LibroRestMapper;
import matteo.arigliano.biblioteca.PL.rest.LibroRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import java.nio.file.FileAlreadyExistsException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/libro")
public class LibroController {

    private final LibroService authorService;
    private final LibroRestMapper authorRestMapper;

    @GetMapping
    private ResponseEntity<List<LibroRest>> getAllLibros(){
        return new ResponseEntity<>(authorRestMapper.toRestList(authorService.getAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<LibroRest> findById(@PathVariable("id") Integer id){
        try {
            return new ResponseEntity<>(authorRestMapper.toRest(authorService.getById(id)), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    private ResponseEntity<LibroRest> insertAuthor(@RequestBody LibroRest libro){
        try {
            return new ResponseEntity<>(authorRestMapper.toRest(authorService.insert(authorRestMapper.toDto(libro))), HttpStatus.CREATED);
        } catch (FileAlreadyExistsException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    private ResponseEntity<LibroRest> updateAuthor(@RequestBody LibroRest libro){
        try {
            return new ResponseEntity<>(authorRestMapper.toRest(authorService.update(authorRestMapper.toDto(libro))), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteAuthorById(@PathVariable Integer id){
        try {
            authorService.getById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
