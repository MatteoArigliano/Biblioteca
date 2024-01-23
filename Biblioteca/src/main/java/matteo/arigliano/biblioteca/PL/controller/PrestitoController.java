package matteo.arigliano.biblioteca.PL.controller;

import lombok.RequiredArgsConstructor;
import matteo.arigliano.biblioteca.BLL.service.abstracts.PrestitoService;
import matteo.arigliano.biblioteca.PL.mapper.PrestitoRestMapper;
import matteo.arigliano.biblioteca.PL.rest.PrestitoRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import java.nio.file.FileAlreadyExistsException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/prestito")
public class PrestitoController {

    private final PrestitoService prestitoService;
    private final PrestitoRestMapper prestitoRestMapper;

    @GetMapping
    private ResponseEntity<List<PrestitoRest>> getAllPrestitos(){
        return new ResponseEntity<>(prestitoRestMapper.toRestList(prestitoService.getAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<PrestitoRest> findById(@PathVariable("id") Integer id){
        try {
            return new ResponseEntity<>(prestitoRestMapper.toRest(prestitoService.getById(id)), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    private ResponseEntity<PrestitoRest> insertAuthor(@RequestBody PrestitoRest prestito){
        try {
            return new ResponseEntity<>(prestitoRestMapper.toRest(prestitoService.insert(prestitoRestMapper.toDto(prestito))), HttpStatus.CREATED);
        } catch (FileAlreadyExistsException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    private ResponseEntity<PrestitoRest> updateAuthor(@RequestBody PrestitoRest prestito){
        try {
            return new ResponseEntity<>(prestitoRestMapper.toRest(prestitoService.update(prestitoRestMapper.toDto(prestito))), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteAuthorById(@PathVariable Integer id){
        try {
            prestitoService.getById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
