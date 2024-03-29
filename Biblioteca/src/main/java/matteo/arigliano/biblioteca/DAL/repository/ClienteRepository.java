package matteo.arigliano.biblioteca.DAL.repository;

import matteo.arigliano.biblioteca.DAL.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {

    ClienteEntity findClienteEntityById(Integer id);
}
