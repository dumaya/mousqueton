package dumaya.dev.repository;

import dumaya.dev.model.Topo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MousquetonRepository extends JpaRepository<Topo, Long> {

}
