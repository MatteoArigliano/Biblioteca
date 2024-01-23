package matteo.arigliano.biblioteca.DAL.repository;

import matteo.arigliano.biblioteca.DAL.entity.PrestitoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestitoRepository extends JpaRepository<PrestitoEntity, Integer> {

    PrestitoEntity findPrestitoEntityById(Integer id);
}
