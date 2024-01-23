package matteo.arigliano.biblioteca.DAL.repository;

import matteo.arigliano.biblioteca.DAL.entity.LibroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<LibroEntity, Integer> {

    LibroEntity findLibroEntityById(Integer id);

}
